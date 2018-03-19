/*
---Code for checking if a string is a pangram.
--Pangram is a string which contains all the alphabets from a-z at least once.
-Example-"the quick brown fox jumped over the lazy dog"
By Vishnu
*/

import java.io.*;
import java.util.*;

public class pangram {
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        //Take input string with only lower case letter with spaces
        String str = sc.nextLine();
        
        //create a array for storing no. of character
        int[] array = new int[26];

        boolean flag = true;

        //initialize the array with zeros
        for(int i=0;i<26;i++){
            array[i] = 0; 
        }

        //iterate over the string and increment corresponding array value
        for(int i=0;i<str.length();i++){

            //this if condition to check that the character is not space or
            //  special characters
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                array[(str.charAt(i)-'a')]++;
            }

        }

        //check if any value in array is 0 if yes then set flag to false.
        for(int i=0;i<26;i++){
            if(array[i]==0){
                flag = false;
                break;
            }
        }

        //if flag is true then pangram else not a pangram
        if(flag){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
    }
}

