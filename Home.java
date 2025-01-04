package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    // Login components
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JLabel registerLabel;
    JPanel loginPanel;
    JMenuBar menubar;

    // Menu items
    JMenuItem flightDetails, customerDetails, bookFlight, journeyDetails, ticketCancellation, boardingPass;

    public Home() {
        setLayout(null);

        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/flight.jpg"));
        Image img = i1.getImage();
        Image scaledImg = img.getScaledInstance(1600, 800, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(scaledImg);

        // Add the scaled image to the JLabel
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800); // Set the bounds to cover the window
        add(image);

        // Add heading text with a modern font style
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(new Color(255, 255, 255));  // Light color for contrast
        heading.setFont(new Font("Segoe UI", Font.BOLD, 48));  // Stylish, bold font
        image.add(heading);

        // Create the menu bar
        menubar = new JMenuBar();
        setJMenuBar(menubar);

        // Set menu bar properties
        menubar.setBackground(new Color(30, 30, 30)); // Darker background for contrast

        // Define common styling for menu items
        Color menuItemBackground = new Color(70, 130, 180); // Steel blue background for visibility
        Color menuItemForeground = Color.WHITE; // White text for contrast
        Font menuItemFont = new Font("Arial", Font.BOLD, 18);

        // Add menu items directly to the menu bar with consistent styling
        flightDetails = createMenuItem("Flight Details", menuItemFont, menuItemForeground, menuItemBackground, false);
        menubar.add(flightDetails);

        customerDetails = createMenuItem("Add Customer Details", menuItemFont, menuItemForeground, menuItemBackground, false);
        menubar.add(customerDetails);

        bookFlight = createMenuItem("Book Flight", menuItemFont, menuItemForeground, menuItemBackground, false);
        menubar.add(bookFlight);

        journeyDetails = createMenuItem("Journey Details", menuItemFont, menuItemForeground, menuItemBackground, false);
        menubar.add(journeyDetails);

        ticketCancellation = createMenuItem("Cancel Ticket", menuItemFont, menuItemForeground, menuItemBackground, false);
        menubar.add(ticketCancellation);

        boardingPass = createMenuItem("Boarding Pass", menuItemFont, menuItemForeground, menuItemBackground, false);
        menubar.add(boardingPass);

        // Login panel
        loginPanel = new JPanel();
        loginPanel.setBounds(500, 200, 400, 300);  // Position of the login panel
        loginPanel.setBackground(new Color(255, 255, 255, 180));  // Semi-transparent background
        loginPanel.setLayout(null);  // Absolute layout for more flexibility
        image.add(loginPanel);

        // Username field and label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 40, 100, 30);
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 40, 200, 30);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        loginPanel.add(usernameField);

        // Password field and label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        loginPanel.add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 160, 150, 40);
        loginButton.setBackground(new Color(0, 102, 204));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);

        // Register label
        registerLabel = new JLabel("New user? Register here");
        registerLabel.setBounds(50, 210, 250, 30);
        registerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        registerLabel.setForeground(Color.BLUE);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new AddCustomer();
            }
        });
        loginPanel.add(registerLabel);

        // Set the frame properties
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private JMenuItem createMenuItem(String text, Font font, Color foreground, Color background, boolean enabled) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setFont(font);
        menuItem.setForeground(foreground);
        menuItem.setBackground(background);
        menuItem.setEnabled(enabled); // Initially disabled
        menuItem.addActionListener(this);
        return menuItem;
    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();

        if (text.equals("Login")) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Login Successful!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                loginPanel.setVisible(false);

                // Enable all menu items after successful login
                enableMenuItems(true);
            } else {
                JOptionPane.showMessageDialog(this, "User does not exist or incorrect password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        }
    }

    private void enableMenuItems(boolean enable) {
        flightDetails.setEnabled(enable);
        customerDetails.setEnabled(enable);
        bookFlight.setEnabled(enable);
        journeyDetails.setEnabled(enable);
        ticketCancellation.setEnabled(enable);
        boardingPass.setEnabled(enable);
    }

    public static void main(String[] args) {
        new Home();
    }
}
