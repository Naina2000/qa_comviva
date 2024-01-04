package org.example.stringutils;

public class StringUtils {
    public String reverse(String input) {
        // Reverses the characters in the input string
        // Example: "hello" -> "olleh"
        return new StringBuilder(input).reverse().toString();
    }
    public boolean isPalindrome(String input) {
        // Checks if the input string is a palindrome
        // Example: "radar" -> true, "hello" -> false
        String reversed = reverse(input);
        return input.equals(reversed);
    }
    public String concatenate(String str1, String str2) {
        // Concatenates two strings
        // Example: concatenate("Hello", "World") -> "HelloWorld"
        return str1 + str2;
    }
    public int countOccurrences(String input, char target) {
        // Counts the occurrences of a specific character in the input string
        // Example: countOccurrences("hello", 'l') -> 2
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }
}
