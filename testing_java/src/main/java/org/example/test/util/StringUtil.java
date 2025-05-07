package org.example.test.util;

public class StringUtil {
    public static  String repeat(String input,int times){
        if (times < 0) {
            throw new IllegalArgumentException("Times must be non-negative");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(input);
        }
        return result.toString();
    }

    public static boolean isEmpty(String input) {
        return  input == null || input.trim().length() == 0;
    }
}
