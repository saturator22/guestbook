package com.codecool.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Hello implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "Hello World!";
        String alert = "<script>alert('OWOWOW')</script>";
        httpExchange.sendResponseHeaders(200, alert.length());
//        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(alert.getBytes());
//        os.write(response.getBytes());
        os.close();
    }
}
