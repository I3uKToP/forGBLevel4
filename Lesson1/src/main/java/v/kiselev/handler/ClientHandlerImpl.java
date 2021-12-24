package v.kiselev.handler;

import v.kiselev.service.FileService;
import v.kiselev.service.SocketService;
import v.kiselev.utils.HttpRequest;
import v.kiselev.utils.RequestParser;

import java.io.IOException;
import java.util.Deque;

public class ClientHandlerImpl implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final FileService fileService;
    private final MethodHandler methodHandler;

    public ClientHandlerImpl(SocketService socketService,
                             RequestParser requestParser,
                             FileService fileService,
                             MethodHandler methodHandler) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.fileService = fileService;
        this.methodHandler = methodHandler;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);

        methodHandler.handle(httpRequest);

        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");
    }
}