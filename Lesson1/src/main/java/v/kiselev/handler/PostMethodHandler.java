package v.kiselev.handler;

import v.kiselev.service.FileService;
import v.kiselev.service.SocketService;
import v.kiselev.utils.HttpRequest;
import v.kiselev.utils.HttpResponse;

@Handler
public class PostMethodHandler extends MethodHandler{
    public PostMethodHandler(String method, MethodHandler next, SocketService socketService, FileService fileService) {
        super(method, next, socketService, fileService);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        fileService.createFileAndWriteBody(request.getUrl(), request.getBody());
        return HttpResponse.HttpResponseBuilder()
                .code("200")
                .answer("OK")
                .build();
    }
}
