package v.kiselev.handler;

import v.kiselev.service.FileService;
import v.kiselev.service.SocketService;
import v.kiselev.utils.HttpRequest;
import v.kiselev.utils.HttpResponse;

@Handler
public class PutMethodHandler extends MethodHandler {
    public PutMethodHandler(String method, MethodHandler next, SocketService socketService, FileService fileService) {
        super(method, next, socketService, fileService);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.HttpResponseBuilder()
                .code("200")
                .answer("OK")
                .body("<h1>PUT method handler</h1>")
                .build();
    }
}
