package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int port = 12345; // Port number
        int maxConnections = 10; // Maximum number of simultaneous connections

        ExecutorService executor = Executors.newFixedThreadPool(maxConnections);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                DeviceHandler deviceHandler = new DeviceHandler(clientSocket);
                executor.execute(deviceHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
