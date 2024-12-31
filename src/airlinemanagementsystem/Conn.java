package airlinemanagementsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //1.registring the driver
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root","123456");
            s =c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
