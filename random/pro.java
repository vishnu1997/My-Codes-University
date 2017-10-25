import java.io.*;
import java.util.*;

public class pro{
    
    static void re(String str){
        
        if(str.indexOf('!')==-1){
            System.out.println(str);
        }else{
            re(str.replaceFirst("!","1"));
            re(str.replaceFirst("!","0"));
        }
    }

    public static void main(String ar[]){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        re(str);
    }

}