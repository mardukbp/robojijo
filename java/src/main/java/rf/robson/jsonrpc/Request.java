package rf.robson.jsonrpc;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Request {
    public int id;
    public String jsonrpc;
    public String method;
    public Object[] params;

    public Request (JSONObject json) {
        this.id = json.getInt("id");
        this.jsonrpc = json.getString("jsonrpc");
        this.method = json.getString("method");
        this.params = parseParams(json.getJSONArray("params"));
    }

    private Object[] parseParams(JSONArray jsonParams) {
        Object[] params = new Object[jsonParams.length()];

        for (int i = 0; i < jsonParams.length(); i++) {
            Object param = jsonParams.get(i);

            if (param instanceof JSONArray)
                params[i] = parseParams((JSONArray) param);
            else if (param instanceof JSONObject)
                params[i] = parseJsonObject((JSONObject) param);
            else
                params[i] = param;
        }

        return params;
    }

    private Map<String, Object> parseJsonObject(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();

        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);

            if (value instanceof JSONArray)
                map.put(key, parseParams((JSONArray) value));
            else if (value instanceof JSONObject)
                map.put(key, parseJsonObject((JSONObject) value));
            else
                map.put(key, value);
        }

        return map;
    }
}
