package v.kiselev.handler;

import v.kiselev.service.FileService;
import v.kiselev.service.SocketService;
import v.kiselev.utils.HttpRequest;
import v.kiselev.utils.HttpResponse;

@Handler
public class GetMethodHandler extends MethodHandler{

    public GetMethodHandler(String method, MethodHandler next, SocketService socketService, FileService fileService) {
        super(method, next, socketService, fileService);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        if (!fileService.fileIsExist(request.getUrl())) {
            return HttpResponse.HttpResponseBuilder()
                    .code("404")
                    .answer("NOT_FOUND")
                    .body("<h1>Файл не найден!</h1>")
                    .build();
        }

        return HttpResponse.HttpResponseBuilder()
                .code("200")
                .answer("OK")
                .body(fileService.getFile(request.getUrl()))
                .build();
    }

}
