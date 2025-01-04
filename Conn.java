package airlinemanagementsystem;

import java.sql.*;

public class Conn {
    
    public Connection c;
    public Statement s;
    
    public Conn() {
        try {
            // Registering the JDBC driver and establishing the connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "123456");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
