package com.example;

import java.io.PrintWriter;


public class DeviceHandler implements Runnable {
    private final PrintWriter printWriter;

    public DeviceHandler(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    @Override
    public void run() {
        try {
            // Your logic here
            printWriter.println("Expected Output");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
