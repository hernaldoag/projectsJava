package javaExercises;

import java.util.Scanner;

public class EvenOdd {

    public static void main (String [] args){
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = reader.nextInt();

        //String evenOdd = (num % 2 == 0) ? "even": "odd";

        //System.out.println(num + " is " + evenOdd);
        System.out.println(evenOddTernary(num));
        System.out.println(evenOddMethod(num));

    }

    public static String evenOddMethod(int num){
        String value;
        if (num % 2 ==0){
            value = (num + " is even");
        }else
            value = (num + " is odd");
        return value;
    }

    public static String evenOddTernary(int num){
        String evenOdd = (num % 2 == 0) ? "even": "odd";
        return evenOdd;
    }
}
