package org.example.demos.emailvalidator;

import org.example.emailvalidator.EmailValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    @Test
    void testIsValidEmail() {
        EmailValidator validator = new EmailValidator();

        // Test case 1: Valid email
        assertTrue(validator.isValidEmail("user@example.com"));

        // Test case 2: Invalid email
        assertFalse(validator.isValidEmail("invalid_email"));

        // Use assertNotEquals for negative testing
        assertNotEquals(true, validator.isValidEmail("invalid_email"));

        // Use assertAll for multiple assertions
        assertAll(
                () -> assertTrue(validator.isValidEmail("user@example.com"), "Valid email failed"),
                () -> assertFalse(validator.isValidEmail("invalid_email"), "Invalid email passed"),
                () -> assertTrue(validator.isValidEmail("user123.%+-@example.co.uk"), "Valid email with special characters failed")
        );
    }

    @Test
    void testIsCorporateEmail() {
        EmailValidator validator = new EmailValidator();

        // Test case 1: Corporate email
        assertTrue(validator.isCorporateEmail("employee@company.com"));

        // Test case 2: Non-corporate email
        assertFalse(validator.isCorporateEmail("user@example.com"));

        // Use assertArrayEquals for array comparisons
        assertArrayEquals(new boolean[]{true, false, true, false},
                new boolean[]{validator.isCorporateEmail("employee@company.com"),
                        validator.isCorporateEmail("user@example.com"),
                        validator.isCorporateEmail("admin@sub.company.com"),
                        validator.isCorporateEmail("user@corporate.com")},
                "Array comparison failed");
    }
}
