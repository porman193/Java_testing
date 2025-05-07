package org.example.test.util;


import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void  repeat_string_once() {
        assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void  repeat_string_multiple_times() {
        assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void  repeat_string_zero_times() {
        assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void  repeat_string_negative_numbers() {
        StringUtil.repeat("hola", -1);
    }

    @Test
    public void string_is_not_empty() {
        assertFalse(StringUtil.isEmpty("hola"));
    }

    @Test
    public void string_is_empty_with_blank_spaces() {
        assertTrue(StringUtil.isEmpty("  "));
    }

    @Test
    public void string_is_empty_when_is_null() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void string_is_empty_when_is_empty() {
        assertTrue(StringUtil.isEmpty(""));
    }
}