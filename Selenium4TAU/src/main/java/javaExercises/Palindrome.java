package javaExercises;

import java.util.Locale;

public class Palindrome {
    public static void main (String [] args){
        //String str = "Anitalavalatina", reverseString = "";
        String str = "nano", reverseString = "";

        int strLength = str.length();

        for(int i = (strLength - 1); i >=0; --i){
            reverseString = reverseString + str.charAt(i);
        }

        if (str.toLowerCase().equals(reverseString.toLowerCase())){
            System.out.println(str + " is a palindrome string.");
        }
        else {
            System.out.println(str + " is not a palindrome string");
        }


    }
}
