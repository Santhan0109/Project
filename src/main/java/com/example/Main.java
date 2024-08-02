package com.example;


import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out); // Or use a mock in tests
        DeviceHandler deviceHandler = new DeviceHandler(printWriter);
        
        Thread thread = new Thread(deviceHandler);
        thread.start(); // Start the thread
    }
}
