package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Calculator class.
 */
@DisplayName("Calculator Tests")
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Should add two positive numbers correctly")
    public void testAddPositiveNumbers() {
        int result = calculator.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    @DisplayName("Should subtract two numbers correctly")
    public void testSubtract() {
        int result = calculator.subtract(10, 3);
        assertEquals(7, result);
    }

    @Test
    @DisplayName("Should multiply two numbers correctly")
    public void testMultiply() {
        int result = calculator.multiply(4, 5);
        assertEquals(20, result);
    }

    @Test
    @DisplayName("Should divide two numbers correctly")
    public void testDivide() {
        int result = calculator.divide(20, 4);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Should throw exception when dividing by zero")
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}