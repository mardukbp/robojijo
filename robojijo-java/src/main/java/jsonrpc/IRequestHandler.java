package jsonrpc;


public interface IRequestHandler {
    Response handle(Request request);
}
