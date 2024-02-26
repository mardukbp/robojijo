package rf.robson.jsonrpc;

public class JsonError {
    private final int code;
    private final String message;
    private final Object data;

    private JsonError(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static JsonError parseError(String data) {
        return new JsonError(-32700, "An error occurred while parsing the JSON text.", data);
    }

    public static JsonError applicationError(String message, Object data) {
        return new JsonError(-1, message, data);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
