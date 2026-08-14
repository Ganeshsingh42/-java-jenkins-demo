package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for StringUtil
 */
public class StringUtilTest {

    @Test
    public void testReverseString() {
        assertEquals("dlrow", StringUtil.reverse("world"));
        assertEquals("321", StringUtil.reverse("123"));
    }

    @Test
    public void testReverseEmptyString() {
        assertEquals("", StringUtil.reverse(""));
    }

    @Test
    public void testReverseNull() {
        assertNull(StringUtil.reverse(null));
    }

    @Test
    public void testIsPalindromTrue() {
        assertTrue(StringUtil.isPalindrome("racecar"));
        assertTrue(StringUtil.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(StringUtil.isPalindrome("madam"));
    }

    @Test
    public void testIsPalindromeFalse() {
        assertFalse(StringUtil.isPalindrome("hello"));
        assertFalse(StringUtil.isPalindrome("world"));
    }

    @Test
    public void testIsPalindromeEmpty() {
        assertFalse(StringUtil.isPalindrome(""));
        assertFalse(StringUtil.isPalindrome(null));
    }
}
