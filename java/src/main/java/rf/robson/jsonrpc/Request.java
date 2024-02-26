package rf.robson.jsonrpc;


import org.json.JSONArray;
import org.json.JSONObject;


public class Request {
    public int id;
    public String jsonrpc;
    public String method;
    public Object[] params;

    public Request (JSONObject json) {
        this.id = json.getInt("id");
        this.jsonrpc = json.getString("jsonrpc");
        this.method = json.getString("method");
        JSONArray jsonParams = json.getJSONArray("params");
        this.params = new Object[jsonParams.length()];
        for (int i = 0; i < params.length; i++)
            params[i] = jsonParams.get(i);
    }
}
