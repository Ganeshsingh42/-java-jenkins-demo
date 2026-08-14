package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for GreetingService
 */
public class GreetingServiceTest {
    
    private GreetingService greetingService;

    @Before
    public void setUp() {
        greetingService = new GreetingService();
    }

    @Test
    public void testGreetWithValidName() {
        String result = greetingService.greet("John");
        assertEquals("Hello, John!", result);
    }

    @Test
    public void testGreetWithDifferentNames() {
        assertEquals("Hello, Alice!", greetingService.greet("Alice"));
        assertEquals("Hello, Bob!", greetingService.greet("Bob"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGreetWithNullName() {
        greetingService.greet(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGreetWithEmptyName() {
        greetingService.greet("");
    }

    @Test
    public void testGoodbyeWithValidName() {
        String result = greetingService.goodbye("John");
        assertEquals("Goodbye, John!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGoodbyeWithNullName() {
        greetingService.goodbye(null);
    }
}
