package org.example.test.util;

import org.junit.Test;

import static org.example.test.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_lees_than_8_letters() {
         assertEquals(WEAK,PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(WEAK,PasswordUtil.assessPassword("abcdfghtui"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(MEDIUM,PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols() {
        assertEquals(STRONG,PasswordUtil.assessPassword("abcd1234?"));
    }
}