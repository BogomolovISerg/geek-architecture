package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.config.ConfigFromProperties;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;

    private ConfigFromProperties config;

     public RequestHandler(SocketService socketService, RequestParser requestParser, ConfigFromProperties config) {
        this.socketService = socketService;
        this.requestParser = requestParser;
         this.config = config;
    }

    @Override
    public void run() {
        ConsoleLogger logger = new ConsoleLogger();
        Deque<String> raw = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parse(raw);

        StringBuilder response = new StringBuilder();
        if(httpRequest.getMethod().equals("GET")) {
            Path path = Paths.get(config.getWWW(), httpRequest.getUrl());

            if (!Files.exists(path)) {
                response.append("HTTP/1.1 404 NOT_FOUND\n");
                response.append("Content-Type: text/html; charset=utf-8\n");
                response.append("\n");
                response.append("<h1>Файл не найден!</h1>\n");
                socketService.writeResponse(response.toString());
                return;
            }

            response.append("HTTP/1.1 200 OK\n");
            response.append("Content-Type: text/html; charset=utf-8\n");
            response.append("\n");

            try {
                Files.readAllLines(path).forEach(response::append);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logger.info("Client disconnected!");
        }
    }
}
