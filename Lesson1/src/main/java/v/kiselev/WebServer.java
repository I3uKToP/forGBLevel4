package v.kiselev;

import v.kiselev.config.Server;
import v.kiselev.service.ClientHandler;
import v.kiselev.service.ClientHandlerImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        Server server = new Server();
        ServerSocket serverSocket = server.getServerSocket();
        ClientHandler clientHandler = new ClientHandlerImpl();
        Socket socket;

        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println("New client connected! " + socket.getInetAddress());
                Socket finalSocket = socket;
                new Thread(() -> clientHandler.handleRequest(finalSocket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}