package v.kiselev.utils;

import java.util.Deque;

public interface RequestParser {

    HttpRequest parseRequest(Deque<String> rawRequest);

}
