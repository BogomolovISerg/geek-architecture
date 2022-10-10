package ru.geekbrains;

import ru.geekbrains.config.ConfigFromProperties;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private static final Logger logger = new ConsoleLogger();

    public static void main(String[] args) {

        ConfigFromProperties config = new ConfigFromProperties("server.properties");

        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            logger.info("Server started!");

            RequestParser rpaster = new RequestParser();

            while (true) {
                Socket socket = serverSocket.accept();
                logger.info("New client connected!");

                new Thread(new RequestHandler(new SocketService(socket),rpaster, config)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
