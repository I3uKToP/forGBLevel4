package v.kiselev;

import v.kiselev.config.Init;
import v.kiselev.config.Server;

public class WebServer {

    public static void main(String[] args) {
        new Init(args);
        new Server();
    }
}