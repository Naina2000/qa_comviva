package org.example.demos.stringutils;

import org.example.stringutils.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    void testReverse() {
        StringUtils utils = new StringUtils();

        // Test case 1: Reverse a string
        System.out.println(utils.reverse("hello"));
        assertEquals("olleh", utils.reverse("hello"));

        // Test case 2: Reverse an empty string
        System.out.println(utils.reverse(""));
        assertEquals("", utils.reverse(""));
    }

    @Test
    void testIsPalindrome() {
        StringUtils utils = new StringUtils();

        // Test case 1: Check palindrome string
        System.out.println(utils.isPalindrome("radar"));
        assertTrue(utils.isPalindrome("radar"));

        // Test case 2: Check non-palindrome string
        System.out.println(utils.isPalindrome("hello"));
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    void testConcatenate() {
        StringUtils utils = new StringUtils();

        // Test case 1: Concatenate two strings
        System.out.println(utils.concatenate("Hello", "World"));
        assertEquals("HelloWorld", utils.concatenate("Hello", "World"));

        // Test case 2: Concatenate with an empty string
        System.out.println(utils.concatenate("Hello", ""));
        assertEquals("Hello", utils.concatenate("Hello", ""));
    }

    @Test
    void testCountOccurrences() {
        StringUtils utils = new StringUtils();

        // Test case 1: Count occurrences of a character
        System.out.println(utils.countOccurrences("hello", 'l'));
        assertEquals(2, utils.countOccurrences("hello", 'l'));

        // Test case 2: Count occurrences of a character in an empty string
        System.out.println(utils.countOccurrences("", 'a'));
        assertEquals(0, utils.countOccurrences("", 'a'));
    }
}

