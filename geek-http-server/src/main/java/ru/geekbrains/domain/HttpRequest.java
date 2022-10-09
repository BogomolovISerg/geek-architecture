package ru.geekbrains.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {

    private String url;
    private String method;

    private String path;

    private Map<String, String> headers;

    private String body;

    public HttpRequest(String method, String url, Map<String, String> headers, String  body){
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

}
