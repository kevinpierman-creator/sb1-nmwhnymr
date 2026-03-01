package com.example.app;

import java.util.regex.Pattern;

/**
 * UserService class demonstrating secure coding practices.
 * Includes input validation and secure operations.
 */
public class UserService {
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");

    /**
     * Validates user email format.
     *
     * @param email the email to validate
     * @return true if email is valid, false otherwise
     */
    public boolean validateUserEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates password strength.
     * Password must be at least 8 characters with uppercase, lowercase, and digit.
     *
     * @param password the password to validate
     * @return true if password meets strength requirements
     */
    public boolean validatePasswordStrength(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        
        return hasUppercase && hasLowercase && hasDigit;
    }

    /**
     * Validates username format.
     * Username must be 3-20 characters, alphanumeric and underscore only.
     *
     * @param username the username to validate
     * @return true if username format is valid
     */
    public boolean validateUsername(String username) {
        if (username == null || username.length() < 3 || username.length() > 20) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9_]+$");
    }

    /**
     * Creates a secure user representation.
     * Note: In production, use proper hashing (bcrypt, argon2) for passwords.
     *
     * @param username validated username
     * @param email validated email
     * @return user information string (without sensitive data)
     */
    public String createUser(String username, String email) {
        if (!validateUsername(username) || !validateUserEmail(email)) {
            throw new IllegalArgumentException("Invalid username or email");
        }
        return String.format("User{username='%s', email='%s'}", username, email);
    }
}