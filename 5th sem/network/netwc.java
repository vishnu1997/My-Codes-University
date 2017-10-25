import java.io.*;
import java.net.*;
import java.util.*;

public class netwc{
    public static void main(String ar[]){
        try{
            Socket s = new Socket(InetAddress.getLocalHost(),4444);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            String t[] = str.split(" ");
            int key = Integer.parseInt(t[1]);
            String str2 = t[0].substring(8,t[0].length()-8);
            System.out.println(str2+"-------"+key);
            String str1="";
            for(int i=0;i<str2.length();i++){
                int cd = str2.charAt(i)-key;
                str1 +=(char)cd;
            }
            //System.out.println(str1+"--");
            String str4="";
            int c=0;
            for(int i=0;i<str1.length();i++){
                char d = str1.charAt(i);
                if(d=='1'){
                    c++;
                    str4+=(""+1);
                }else{
                    c=0;
                    str4+=(""+0);
                }
                if(c/5==1){
                    i++;
                    c=0;
                }
            }
            System.out.println(str4);

            s.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}