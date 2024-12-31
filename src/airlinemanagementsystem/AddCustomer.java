package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField tfname,tfphone,tfaadhar,tfnationality,tfaddress,tfemail;
    JRadioButton rbmale,rbfemale,rbother;
   public AddCustomer(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        
        //name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60,80,150,25);
        lblName.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblName);
        
        tfname = new JTextField();
        tfname.setBounds(220,80,150,25);
        add(tfname);
        
        //nationality
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,130,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220,130,150,25);
        add(tfnationality);
        
        //aadhar 
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60,180,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220,180,150,25);
        add( tfaadhar );
        
        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,230,150,25);
        add( tfaddress );
        
        
        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        rbother = new JRadioButton("Other");
        rbother.setBounds(380,280,70,25);
        rbother.setBackground(Color.WHITE);
        add(rbother);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        gendergroup.add(rbother);
        
        
        //PhoneNumber
        JLabel lblphonenumber = new JLabel("Phone Number");
        lblphonenumber.setBounds(60,330,150,25);
        lblphonenumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphonenumber);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        
        //Email
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(60,380,150,25);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220,380,150,25);
        add( tfemail );
        
        
        //save button
        JButton save = new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(280,430 ,150,30);
        save.addActionListener(this);
        add(save);
        
      ImageIcon image = new ImageIcon(getClass().getResource("/airlinemanagementsystem/icons/emp.png"));
JLabel lblimage = new JLabel(image);
lblimage.setBounds(450, 80, 280, 400);
add(lblimage);


        
        
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String email = tfemail.getText();
        String gender = null;
        
        if (rbmale.isSelected()) gender = "Male";
        else if (rbfemale.isSelected()) gender = "Female";
        else if (rbother.isSelected()) gender = "Other";
        
        try{
            Conn conn=new Conn();
            
           String query = "insert into passenger values('"+name+"' , '"+nationality+"' ,'"+phone+"','"+address+"','"+aadhar+"','"+gender+"','"+email+"')";
            
           conn.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null, "Customer Details Added Sucessfully");
           setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
    
    public static void main(String[]args){
        new AddCustomer();
        
    }
}
