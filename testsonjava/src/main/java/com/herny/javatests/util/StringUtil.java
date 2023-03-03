package com.herny.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times){
        String result = "";
        if (times < 0){
            throw new IllegalArgumentException("Negatives Values are not allowed");
        }
        for (int i = 0; i < times ; i++) {
            result += str;
        }
        return result;
    }
}
