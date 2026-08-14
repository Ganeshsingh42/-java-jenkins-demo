package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for greeting functionality
 */
public class GreetingService {
    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    /**
     * Generate a greeting message
     * @param name the name to greet
     * @return greeting message
     */
    public String greet(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        String greeting = "Hello, " + name + "!";
        logger.debug("Generated greeting: {}", greeting);
        return greeting;
    }

    /**
     * Generate a farewell message
     * @param name the name to say goodbye to
     * @return farewell message
     */
    public String goodbye(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        String farewell = "Goodbye, " + name + "!";
        logger.debug("Generated farewell: {}", farewell);
        return farewell;
    }
}
