package rf.robson.jsonrpc;


public interface IRequestHandler {
    Response handle(Request request);
}
