import java.io.*;
import java.util.*;
public class PangramChecker {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
                                     String s=sc.nextLine();
        System.out.println("Is pangram : " + isPangram(s));
    }

    private static boolean isPangram(String s) {

        if (s.length() < 26
) {
            return false;
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (s.indexOf(ch) < 0
                    && s.indexOf (ch + 32) < 0) {
                return false;
            }
        }

        return true;
    }
}