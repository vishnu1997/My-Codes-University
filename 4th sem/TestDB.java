 import java.sql.*;
public class TestDB
{  
   public static void main (String args[])
   { 
          Connection conn;
          try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    //  String url = "jdbc:derby://localhost:1527/Secondcse";
String url = "jdbc:derby:secondcse;create=true";

       //String username = "xx";
      // String password = "xx";
     //  conn = DriverManager.getConnection(url, username, password);
 conn = DriverManager.getConnection(url);
       Statement stat = conn.createStatement();
        
     //  stat.execute("CREATE TABLE Greet (Message CHAR(20))");
stat.execute("CREATE TABLE FIRSTTABLE(ID INT ,NAME VARCHAR(12))");

       //stat.execute("INSERT INTO Greet VALUES ('Hello, World!')");
stat.execute("INSERT INTO FIRSTTABLE VALUES  (10,'TEN'),(20,'TWENTY'),(30,'THIRTY')");
       ResultSet result = stat.executeQuery("SELECT * FROM FIRSTTABLE ");
       while (result.next())
       {System.out.println(result.getString(1)+" "+result.getString(2));
         }
       stat.execute("DROP TABLE FIRSTTABLE");      
       conn.close();
      }
      catch (Exception ex)
      {  
         ex.printStackTrace();
      }
   }
}



