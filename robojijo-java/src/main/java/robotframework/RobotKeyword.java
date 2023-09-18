package robotframework;

import java.lang.reflect.Method;
import java.util.List;

public class RobotKeyword {
    String name;
    String doc;
    List<String> args;
    List<String> types;
    Method method;

    public RobotKeyword(Method method, String name, String doc, List<String> args, List<String> types) {
        this.name = name;
        this.types = types;
        this.doc = doc;
        this.args = args;
        this.method = method;
    }
}
