package v.kiselev.service;

import java.net.Socket;

public interface ClientHandler {

    void handleRequest(Socket socket);
}
