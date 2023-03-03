package com.herny.javatests.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    @Test
    public  void repeat_string_multiple_times() {
        assertEquals("Hello ThereHello ThereHello There", StringUtil.repeat("Hello There", 3));
        assertEquals("Hello There",StringUtil.repeat("Hello There",1 ));
    }

    @Test
    public  void repeat_string_once() {
        assertEquals("Hello There",StringUtil.repeat("Hello There",1 ));
    }

    @Test
    public  void repeat_string_zero_times() {
        assertEquals("",StringUtil.repeat("Hello There",0 ));
    }

    @Test(expected = IllegalArgumentException.class)
    public  void repeat_string_negative_times() {
        StringUtil.repeat("Hello There",-1 );
    }

/*+
    private static void assertEquals(String actual, String expected) {

        if(!actual.equals(expected)){
            throw  new RuntimeException(actual + " is not equal than expected " + expected);
        }
    }
*/
}