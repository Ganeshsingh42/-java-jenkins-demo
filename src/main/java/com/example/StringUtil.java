package com.example;

/**
 * Utility class for string operations
 */
public class StringUtil {

    /**
     * Reverse a string
     * @param str the string to reverse
     * @return reversed string
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Check if a string is a palindrome
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = reverse(cleaned);
        return cleaned.equals(reversed);
    }
}
