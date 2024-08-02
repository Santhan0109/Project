package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.net.Socket;

public class MainTest {

    @Test
    public void testDeviceHandler() throws IOException {
        // Mock the Socket and streams
        Socket mockSocket = mock(Socket.class);
        InputStream mockInputStream = mock(InputStream.class);
        OutputStream mockOutputStream = mock(OutputStream.class);
        PrintWriter mockWriter = mock(PrintWriter.class);

        // Set up the mocks
        when(mockSocket.getInputStream()).thenReturn(mockInputStream);
        when(mockSocket.getOutputStream()).thenReturn(mockOutputStream);

        // Create a DeviceHandler instance with the mocked socket
        DeviceHandler deviceHandler = new DeviceHandler(mockSocket);

        // Run the device handler logic
        deviceHandler.run();

        // Verify interactions with mocks
        verify(mockWriter).println("Expected Output");
    }
}
