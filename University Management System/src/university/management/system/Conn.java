package university.management.system;


import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn()  {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Universitymanagementsystem","Nikhil","nikhil@123");
           s=c.createStatement();
                   
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
