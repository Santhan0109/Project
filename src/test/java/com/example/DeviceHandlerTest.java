package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.Test;

public class DeviceHandlerTest {

    @Test
    void testDeviceHandler() {
        // Arrange
        PrintWriter printWriter = mock(PrintWriter.class);
        DeviceHandler deviceHandler = new DeviceHandler(printWriter);

        try {
            // Act
            deviceHandler.run(); // This should invoke printWriter.println() internally

            // Assert
            verify(printWriter).println("Expected Output");
        } catch (IOException e) {
            // Handle the exception or fail the test
            e.printStackTrace();
            fail("IOException should not be thrown");
        }
    }
}
