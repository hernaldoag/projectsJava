package com.herny.javatests.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assetPassword("a4et$d"));
    }

    @Test
    public void weak_when_has_only_letters(){
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assetPassword("awedftdqw"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assetPassword("awedf12tdqw"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_simbols(){
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assetPassword("#awedf12tdqw$"));
    }

}