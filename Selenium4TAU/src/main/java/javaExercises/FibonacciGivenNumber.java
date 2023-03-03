package javaExercises;

public class FibonacciGivenNumber {

    public static void main(String [] args){
        int n = 140, firstTerm = 10, secondTerm = 11;
        System.out.println("Fibonacci Series till " + n + " terms:" );

        while( firstTerm <= n){
            System.out.println(firstTerm + ",");

            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;

        }


    }
}
