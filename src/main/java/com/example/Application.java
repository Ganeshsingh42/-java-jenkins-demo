package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for the Java Jenkins Demo application
 */
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Starting Java Jenkins Demo Application");
        
        GreetingService greetingService = new GreetingService();
        String message = greetingService.greet("World");
        
        System.out.println(message);
        logger.info("Application completed successfully");
    }
}
