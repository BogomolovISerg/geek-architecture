package ru.geekbrains.domain;

import java.util.Map;

public class HttpResponse {

    private int statusCode;
    private Map<String, String> headers;
    private String body;

    public HttpResponse(int status) {
        this.statusCode = status;
    }

    public HttpResponse(int status, Map<String, String> headers, String body) {
        this.statusCode = status;
        this.headers = headers;
        this.body = body;
    }

    public int getStatus() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
