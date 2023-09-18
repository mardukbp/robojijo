package io.github.robojijo.jsonrpc;


public interface IRequestHandler {
    Response handle(Request request);
}
