package com.example;

import java.io.*;
import java.net.Socket;

public class DeviceHandler implements Runnable {
    private Socket socket;

    public DeviceHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
             
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String response = processInput(inputLine);
                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Change visibility to protected or public
    protected String processInput(String input) {
        // Basic processing logic. This can be extended for protocol handling.
        return "Echo: " + input;
    }
}
