package v.kiselev.handler;

import v.kiselev.service.FileService;
import v.kiselev.service.SocketService;
import v.kiselev.utils.HttpRequest;
import v.kiselev.utils.HttpResponse;

public abstract class MethodHandler {

    private final String method;

    private final MethodHandler next;

    protected final SocketService socketService;

    protected final FileService fileService;

    public MethodHandler(String method, MethodHandler next, SocketService socketService, FileService fileService) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.fileService = fileService;
    }

    public void handle(HttpRequest request) {
        HttpResponse response = null;
        if(method.equals(request.getMethod())) {
            response = handleInternal(request);
        } else if(next != null) {
            next.handle(request);
        } else {
            response = HttpResponse.HttpResponseBuilder()
                    .code("405")
                    .answer("METHOD_NOT_ALLOWED")
                    .body("<h1>Метод не поддерживается!</h1>")
                    .build();
        }
        socketService.writeResponse(response.toString());


    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
