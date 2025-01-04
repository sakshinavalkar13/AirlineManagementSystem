package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername;
    JPasswordField tfpassword;
    JButton loginButton;
    JLabel usernameLabel, passwordLabel;
    
    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Airline Management System");
        heading.setBounds(150, 50, 400, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(60, 150, 150, 25);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(usernameLabel);
        
        tfusername = new JTextField();
        tfusername.setBounds(220, 150, 150, 25);
        add(tfusername);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(60, 200, 150, 25);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(passwordLabel);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(220, 200, 150, 25);
        add(tfpassword);
        
        loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(220, 250, 150, 30);
        loginButton.addActionListener(this);
        add(loginButton);
        
        setSize(600, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = tfusername.getText();
        String password = new String(tfpassword.getPassword());

        try {
            // Establishing the connection to the database
            Conn conn = new Conn();
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            
            // Use PreparedStatement to prevent SQL injection
            PreparedStatement ps = conn.c.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();

            // Checking if the login credentials are valid
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                setVisible(false);  // Close the login window
                new Home();  // Open the home or main page window after successful login
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
