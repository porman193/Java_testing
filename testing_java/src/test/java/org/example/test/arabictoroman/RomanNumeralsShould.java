package org.example.test.arabictoroman;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsShould {

    @Test
    public void roman_numbers_when_1_2_3() {

        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));

    }

    @Test
    public void roman_numbers_when_5_6_7() {

        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));

    }

    @Test
    public void roman_numbers_when_10_11_15_16() {

        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
        assertThat(RomanNumerals.arabicToRoman(15), is("XV"));
        assertThat(RomanNumerals.arabicToRoman(16), is("XVI"));

    }

    @Test
    public void roman_numbers_when_50_51_55_56() {

        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
        assertThat(RomanNumerals.arabicToRoman(51), is("LI"));
        assertThat(RomanNumerals.arabicToRoman(55), is("LV"));
        assertThat(RomanNumerals.arabicToRoman(56), is("LVI"));

    }

    @Test
    public void roman_numbers_when_60_70() {

        assertThat(RomanNumerals.arabicToRoman(60), is("LX"));
        assertThat(RomanNumerals.arabicToRoman(70), is("LXX"));

    }

    @Test
    public void roman_numbers_when_80_81_85_86() {

        assertThat(RomanNumerals.arabicToRoman(80), is("LXXX"));
        assertThat(RomanNumerals.arabicToRoman(81), is("LXXXI"));
        assertThat(RomanNumerals.arabicToRoman(85), is("LXXXV"));
        assertThat(RomanNumerals.arabicToRoman(86), is("LXXXVI"));

    }

    @Test
    public void roman_numbers_when_126() {

        assertThat(RomanNumerals.arabicToRoman(126), is("CXXVI"));
    }

    @Test
    public void roman_numbers_when_2507() {

        assertThat(RomanNumerals.arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void roman_numbers_when_4_14_24() {

        assertThat(RomanNumerals.arabicToRoman(4), is("IV"));
        assertThat(RomanNumerals.arabicToRoman(14), is("XIV"));
        assertThat(RomanNumerals.arabicToRoman(24), is("XXIV"));

    }

    @Test
    public void roman_numbers_when_40() {

        assertThat(RomanNumerals.arabicToRoman(40), is("XL"));
        assertThat(RomanNumerals.arabicToRoman(44), is("XLIV"));

    }

    @Test
    public void roman_numbers_when_400() {

        assertThat(RomanNumerals.arabicToRoman(400), is("CD"));

    }

    @Test
    public void roman_numbers_when_9_19_49() {

        assertThat(RomanNumerals.arabicToRoman(9), is("IX"));
        assertThat(RomanNumerals.arabicToRoman(19), is("XIX"));
        assertThat(RomanNumerals.arabicToRoman(49), is("XLIX"));

    }

    @Test
    public void roman_numbers_when_90_99() {

        assertThat(RomanNumerals.arabicToRoman(90), is("XC"));
        assertThat(RomanNumerals.arabicToRoman(99), is("XCIX"));

    }

    @Test
    public void roman_numbers_when_900() {

        assertThat(RomanNumerals.arabicToRoman(900), is("CM"));

    }
}