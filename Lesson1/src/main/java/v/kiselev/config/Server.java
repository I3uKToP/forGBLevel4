package v.kiselev.config;

import lombok.extern.slf4j.Slf4j;
import v.kiselev.handler.ClientHandlerImpl;
import v.kiselev.handler.MethodHandlerFactory;
import v.kiselev.service.FileService;
import v.kiselev.service.SocketService;
import v.kiselev.service.SocketServiceFactory;
import v.kiselev.utils.RequestParser;
import v.kiselev.utils.RequestParserFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {
    ServerSocket serverSocket;

    public Server() {
        try {
            this.serverSocket = new ServerSocket(Init.getPORT());
            log.info("Server started on port : " + Init.getPORT());
            while (true) {
                Socket socket = serverSocket.accept();
                FileService fileService = new FileService();
                SocketService socketService = SocketServiceFactory.createSocketService(socket);
                RequestParser requestParser = RequestParserFactory.createRequestParser();
                log.info("New client connected!");
                new Thread(new ClientHandlerImpl(
                        socketService,
                        requestParser,
                        fileService,
                        MethodHandlerFactory.create(socketService, fileService)))
                        .start();
            }
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
    }
}
