import java.net.*;
import java.io.*;

public class comPing{
    public static void main(String ar[]){
        try{
            Runtime r = Runtime.getRuntime();
            Process p = r.exec("ping www.fb.com");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String result;
            while((result = br.readLine())!=null){
                System.out.println(result);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}