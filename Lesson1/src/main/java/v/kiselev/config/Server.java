package v.kiselev.config;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    ServerSocket serverSocket;


    public Server() {
        try {
            this.serverSocket = new ServerSocket(Config.SERVER_PORT);
            System.out.println("Server started!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
}
