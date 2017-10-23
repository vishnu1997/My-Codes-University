import java.io.*;
import java.net.*;
import java.util.*;

public class netws{
    public static void main(String ar[]){
        try{
            ServerSocket ss = new ServerSocket(4444);
            
            
            Scanner in = new Scanner(System.in);
            System.out.println("enter the string");
            String str = in.nextLine();
            System.out.println("enter the key < 9");
            int key = in.nextInt();
           // System.out.println(str);
            String str1= "";
            String str2= "";
            int c=0;
            for(int i=0;i<str.length();i++){
                char d = str.charAt(i);
                if(d=='1'){
                    c++;
                    str2+=(""+1);
                }else{
                    c=0;
                    str2+=(""+0);
                }
                if(c/5==1){
                    str2+=(""+0);
                    c=0;
                }
            }
            System.out.println(str2);
            String str3= "01111110"+str2+"01111110";

            
            for(int i=0;i<str3.length();i++){
                int cd = str3.charAt(i)+key;
                str1 +=(char)cd;
            }
            String str4 = str1+" "+key;
            System.out.println(str4);
            Socket s = ss.accept();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(str4);
        }catch(Exception e){
            System.out.println("error "+e);
        }
    }
}
