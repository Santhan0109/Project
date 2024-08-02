package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPProtocol implements Protocol {
    private Socket socket;

    public TCPProtocol(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String read() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // Read data from the socket
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void write(String data) {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            // Write data to the socket
            out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
