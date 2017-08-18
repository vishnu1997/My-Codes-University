import java.io.*;
import java.sql.*;

public class dbDemo {
    public static void main(String ar[]){
        Connection conn;
            try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String url = "jdbc:derby:/db1;create=true";
            conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.execute("create table vv (rno int,name varchar(20))");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}