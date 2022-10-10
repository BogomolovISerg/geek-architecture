package ru.geekbrains.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigFromProperties {
    private final String www;
    private final int port;

    public ConfigFromProperties(String filenamr){
        Properties p = new Properties();
        try {
            p.load(getClass().getResourceAsStream("server.properties"));
        }catch (IOException e){
            throw new IllegalStateException(e);
        }
        this.www = p.getProperty("www");
        this.port = Integer.parseInt(p.getProperty("port"));
    }

    public String getWWW(){
        return this.www;
    }

    public int getPort(){
        return this.port;
    }
}
