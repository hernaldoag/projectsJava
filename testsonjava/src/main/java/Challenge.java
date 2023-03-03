import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Challenge {
    public static void main(String[] args) {
        String someString = "constitution";
        char someChar = 't';
        int count = 0;

        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == someChar) {
                count++;
            }
        }
        System.out.println((count));
    }
}


