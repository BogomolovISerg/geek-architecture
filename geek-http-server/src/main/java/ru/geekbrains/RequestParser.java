package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser{

    public HttpRequest parse(Deque<String> raw){
        String[] tmp = raw.pollFirst().split(" ");
        String m = tmp[0];
        String url = tmp[1];

        Map<String, String > headers = new HashMap<>();
        while (!raw.isEmpty()){
            String s = raw.pollFirst();
            if(s.isBlank()){
                break;
            }
            String[] header = s.split(": ");
            headers.put(header[0], header[1]);
        }
        StringBuilder body = new StringBuilder();
        while(!raw.isEmpty()){
            body.append(raw.pollFirst());
        }
        HttpRequest httpRequest = new HttpRequest.BuilderHttpRequest()
                .setMetod(m)
                .setHeaders(headers)
                .setBody(body.toString())
                .build();

        return httpRequest;
    }
}
