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

    private HttpRequest() {
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public static class BuilderHttpRequest{

        private final HttpRequest httpRequest;
        public BuilderHttpRequest(){
            this.httpRequest = new HttpRequest();
        }

        public BuilderHttpRequest setMetod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public BuilderHttpRequest setUrl(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public BuilderHttpRequest setHeaders(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }

        public BuilderHttpRequest setBody(String  body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build(){
            return this.httpRequest;
        }
    }
}
