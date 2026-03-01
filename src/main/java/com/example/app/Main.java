package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main application entry point.
 * Demonstrates basic application structure and logging.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started");

        // Example: Calculator usage
        Calculator calculator = new Calculator();
        int result = calculator.add(10, 20);
        logger.info("Calculation result: {}", result);

        // Example: UserService usage
        UserService userService = new UserService();
        boolean isValid = userService.validateUserEmail("user@example.com");
        logger.info("Email validation result: {}", isValid);

        logger.info("Application completed successfully");
    }
}