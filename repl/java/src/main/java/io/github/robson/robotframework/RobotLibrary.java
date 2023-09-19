package io.github.robson.robotframework;


import io.github.robson.jsonrpc.JsonError;
import io.github.robson.jsonrpc.Request;
import io.github.robson.jsonrpc.IRequestHandler;
import io.github.robson.jsonrpc.Response;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;


/**
 * <a href="https://robotframework.org/robotframework/latest/RobotFrameworkUserGuide.html#dynamic-library-api">
 * Dynamic Library API
 * </a>
 */
public class RobotLibrary implements IRequestHandler {
    private final Map<String, String> pythonTypes = new HashMap<String, String>(){{
        put("int", "int");
        put("boolean", "bool");
        put("double", "float");
        put("String", "str");
    }};

    private boolean isValidKeyword(Method method) {
        return method.isAnnotationPresent(Keyword.class) &&
                method.isAnnotationPresent(Doc.class) &&
                method.getReturnType().getName().equals(RobotResult.class.getName());
    }

    private final Supplier<String> introDoc = () -> {
        if (this.getClass().isAnnotationPresent(Doc.class))
            return this.getClass().getAnnotation(Doc.class).doc();
        else
            return "The library has no documentation";
    };

    private final Map<String, RobotKeyword> keywords =
            Arrays.stream(this.getClass().getDeclaredMethods())
                    .filter(this::isValidKeyword)
                    .collect(Collectors.toMap(
                            (method -> method.getAnnotation(Keyword.class).name()),
                            (method -> new RobotKeyword(
                                    method,
                                    method.getAnnotation(Keyword.class).name(),
                                    method.getAnnotation(Doc.class).doc(),
                                    Arrays.stream(method.getParameters()).map(Parameter::getName).collect(Collectors.toList()),
                                    Arrays.stream(method.getParameterTypes()).map(type -> pythonTypes.get(type.getSimpleName())).collect(Collectors.toList())
                            ))
            ));

    public String[] getKeywordArguments(String keyword) {
        return keywords.get(keyword).args.toArray(new String[0]);
    }

    public String getKeywordDocumentation(String keyword) {
        switch (keyword) {
            case "__intro__":
                return introDoc.get();
            case "__init__":
                return "Library has no init documentation.";
            default:
                return keywords.get(keyword).doc;
        }
    }

    public String[] getKeywordNames() {
        return keywords.keySet().toArray(new String[0]);
    }

    public String[] getKeywordTypes(String keyword) {
        return keywords.get(keyword).types.toArray(new String[0]);
    }

    public RobotResult runKeyword(String keyword, Object[] args) throws InvocationTargetException, IllegalAccessException {
        return (RobotResult) keywords.get(keyword).method.invoke(this, args);
    }

    @Override
    public Response handle(Request request) {
        switch (request.method) {
            case "get_keyword_arguments": {
                String keyword = request.params[0].toString();
                return new Response(request.id, null, getKeywordArguments(keyword));
            }

            case "get_keyword_documentation": {
                String keyword = request.params[0].toString();
                return new Response(request.id, null, getKeywordDocumentation(keyword));
            }

            case "get_keyword_names":
                return new Response(request.id, null, getKeywordNames());

            case "get_keyword_types": {
                String keyword = request.params[0].toString();
                return new Response(request.id, null, getKeywordTypes(keyword));
            }

            case "run_keyword": {
                String keyword = request.params[0].toString();
                Object[] args = Arrays.stream(request.params).skip(1).toArray();

                try {
                    RobotResult robotResult = runKeyword(keyword, args);
                    return new Response(request.id, null, robotResult);
                }
                catch (Exception e) {
                    StringWriter sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    String traceback = sw.toString();

                    return new Response(
                            request.id,
                            JsonError.applicationError(e.getMessage(), traceback),
                            null
                    );
                }
            }

            default:
                return new Response(
                        request.id,
                        JsonError.applicationError("Unknown method", request.method),
                        null
                );
        }
    }

    public static String getStacktrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
