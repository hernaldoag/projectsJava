package javaExercises;

public class FibonacciWhile {
    public static void main(String [] args){
        int i=1,n = 11, firstTerm = 0, secondTerm = 1;
        System.out.println("Fibonacci Series till " + n + " terms:" );

        while( i <= n){
            System.out.println(firstTerm + ",");

            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
            i++;
        }


    }
}
