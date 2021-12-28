package v.kiselev.config;

public class Init {
    static private  String ROOT_PATH;
    static private  int PORT;
    static private String PATH_OF_HANDLER;

    public Init(String[] args) {
        ROOT_PATH = "/home/viktor";
        PORT = 8080;
//        PATH_OF_HANDLER ="/home/viktor/Architecture/Lesson1/src/main/java/v/kiselev/handler";
        PATH_OF_HANDLER ="./v/kiselev/handler";



        for (String arg : args) {
            if(arg.startsWith("path")) {
                ROOT_PATH = arg.split("=")[1];
            }
            if(arg.startsWith("port")) {
                PORT = Integer.parseInt(arg.split("=")[1]);
            }
            if(arg.startsWith("handler")) {
                PATH_OF_HANDLER = arg.split("=")[1];
            }

        }
    }

    static public String getROOT_PATH() {
        return ROOT_PATH;
    }

    static public int getPORT() {
        return PORT;
    }

    static public String getPATH_OF_HANDLER() {
        return PATH_OF_HANDLER;
    }

}
