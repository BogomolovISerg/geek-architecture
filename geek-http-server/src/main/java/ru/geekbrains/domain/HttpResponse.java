package ru.geekbrains.domain;

import java.util.Map;

public class HttpResponse {

    private int statusCode;
    private Map<String, String> headers;
    private String body;

    private HttpResponse(){}

    public int getStatus() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public static class BuilderHttpResponse{
        private final HttpResponse httpResponse;

        public BuilderHttpResponse(){
            this.httpResponse = new HttpResponse();
        }

        public BuilderHttpResponse setStatus(int status) {
            this.httpResponse.statusCode = status;
            return this;
        }

        public BuilderHttpResponse setHeaders(Map<String, String> headers) {
            this.httpResponse.headers = headers;
            return this;
        }

        public BuilderHttpResponse setBody(String body) {
            this.httpResponse.body = body;
            return this;
        }

        public HttpResponse build(){
            return this.httpResponse;
        }
    }
}
