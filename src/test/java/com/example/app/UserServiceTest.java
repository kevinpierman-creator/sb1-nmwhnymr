package com.example.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService Tests")
public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    @DisplayName("Should validate correct email format")
    public void testValidEmailFormat() {
        assertTrue(userService.validateUserEmail("user@example.com"));
        assertTrue(userService.validateUserEmail("test.user@domain.co.uk"));
    }

    @Test
    @DisplayName("Should reject invalid email format")
    public void testInvalidEmailFormat() {
        assertFalse(userService.validateUserEmail("invalid.email"));
        assertFalse(userService.validateUserEmail("@example.com"));
        assertFalse(userService.validateUserEmail(""));
        assertFalse(userService.validateUserEmail(null));
    }

    @Test
    @DisplayName("Should validate strong password")
    public void testValidPassword() {
        assertTrue(userService.validatePasswordStrength("SecurePass123"));
        assertTrue(userService.validatePasswordStrength("MyPassword2024"));
    }

    @Test
    @DisplayName("Should reject weak password")
    public void testWeakPassword() {
        assertFalse(userService.validatePasswordStrength("weak"));
        assertFalse(userService.validatePasswordStrength("12345678"));
        assertFalse(userService.validatePasswordStrength("abcdefgh"));
    }

    @Test
    @DisplayName("Should validate correct username format")
    public void testValidUsername() {
        assertTrue(userService.validateUsername("john_doe"));
        assertTrue(userService.validateUsername("user123"));
    }

    @Test
    @DisplayName("Should reject invalid username format")
    public void testInvalidUsername() {
        assertFalse(userService.validateUsername("ab"));
        assertFalse(userService.validateUsername("user@name"));
        assertFalse(userService.validateUsername(""));
    }

    @Test
    @DisplayName("Should create user with valid inputs")
    public void testCreateUserSuccess() {
        String result = userService.createUser("john_doe", "john@example.com");
        assertNotNull(result);
        assertTrue(result.contains("john_doe"));
        assertTrue(result.contains("john@example.com"));
    }

    @Test
    @DisplayName("Should throw exception with invalid inputs")
    public void testCreateUserFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser("ab", "john@example.com");
        });
    }
}