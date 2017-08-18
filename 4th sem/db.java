import java.io.*;
import java.sql.*;

public class db {
    public static void main(String arg[]){
        Connection conn;
        Statemnt st;
        PreparedStatement ps;
        ResultSet rs;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby:trial;create=true;");
            st = conn.createStatement();
            tr = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            st.execute("create table t1(regno int,name char(20),gender char(10));");
            ps = conn.prepareStatement("insert into t1 values (?,?,?);");
            
            //three values
            ps.setInt(1,12);
            ps.setString(2,"maggi");
            ps.setString(3,"bias");
            ps.executeUpdate();

            ps.setInt(1,13);
            ps.setString(2,"king kong");
            ps.setString(3,"that");
            ps.executeUpdate();

            ps.setInt(1,14);
            ps.setString(2,"chocolate");
            ps.setString(3,"this");
            ps.executeUpdate();

            rs = tr.executeQuery("select * from t1");
            while(rs.next()){
                System.out.println("The data from db is "+rs.getInt(1)+" "+rs.getstring(2)+" "rs.getString(3));
            }

            
        }catch(Exception e){
            System.out.println("Error is "+e);
        }
    }
}