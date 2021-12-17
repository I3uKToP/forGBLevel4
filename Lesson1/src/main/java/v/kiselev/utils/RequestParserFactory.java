package v.kiselev.utils;

public class RequestParserFactory {

    public static RequestParser createRequestParser() {
        return  new RequestParserImpl();
    }
}
