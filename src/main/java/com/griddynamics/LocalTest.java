package com.griddynamics;

import java.io.IOException;
import java.io.InputStream;

public class LocalTest {
    public static void main(String[] args) throws IOException {
        System.setProperty("env", "local");
        LambdaHandler lambdaHandler = new LambdaHandler();
        InputStream is = LocalTest.class.getClassLoader().getResourceAsStream("input.json");
        lambdaHandler.handleRequest(null, null);
    }
}
