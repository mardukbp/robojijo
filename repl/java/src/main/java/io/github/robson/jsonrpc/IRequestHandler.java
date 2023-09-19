package io.github.robson.jsonrpc;


public interface IRequestHandler {
    Response handle(Request request);
}
