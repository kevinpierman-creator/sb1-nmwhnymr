package com.example.app;

/**
 * Simple Calculator class demonstrating basic arithmetic operations
 * with input validation for secure coding practices.
 */
public class Calculator {

    /**
     * Adds two numbers.
     *
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts two numbers.
     *
     * @param a first number
     * @param b second number to subtract
     * @return difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides two numbers with validation.
     *
     * @param a dividend
     * @param b divisor (cannot be zero)
     * @return quotient of a and b
     * @throws IllegalArgumentException if divisor is zero
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a / b;
    }
}