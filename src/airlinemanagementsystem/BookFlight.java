package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener{
    JTextField tfaadhar;
    JLabel tfname,tfnationality,tfaddress,labelgender,labelfname,labelfcode;
    
    JButton bookflight,fetchButton,flight;
    
    Choice source,destination;
    
    JDateChooser dcdate;
    
   public BookFlight(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
         //aadhar 
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60,80,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220,80,150,25);
        add( tfaadhar );
        
        //fetchbutton
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
         fetchButton.addActionListener(this);

        fetchButton.setBounds(380,80,120,25);
        add(fetchButton);
        
        
        //name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60,130,150,25);
        lblName.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblName);
        
        tfname = new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        //nationality
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
       
        
        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220,230,150,25);
        add( tfaddress );
        
        
        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220,280,150,25);
        add(labelgender);
        
         
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220,330,120,25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60,380,150,25);
        lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220,380,120,25);
        add(destination);
        
        
        try{
            
            Conn c=new Conn();
            String query ="select* from flight";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        //fetch flight button
        flight = new JButton("Fetch Flight");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
         flight.setBounds(380,380 ,150,30);
        flight.addActionListener(this);
        add( flight);
        
        //
        JLabel lblname = new JLabel("Flight Name");
        lblname.setBounds(60,430,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,430,150,25);
        add( labelfname);
        
        
        //
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60,480,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add( lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220,480,150,25);
        add(labelfcode);
        
        
        //
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate .setBounds(60,530,150,25);
        lbldate .setFont(new Font("Tahoma",Font.PLAIN,16));
        add( lbldate );
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220,530,150,25);
        add( dcdate);
        
        
        
        
        
      ImageIcon i1 = new ImageIcon(getClass().getResource("/airlinemanagementsystem/icons/details.jpg"));
      Image i2=i1.getImage().getScaledInstance(450, 320,Image.SCALE_DEFAULT);
      ImageIcon image=new ImageIcon(i2);
      JLabel lblimage = new JLabel(image);
      lblimage.setBounds(550, 80, 500, 410);
      add(lblimage);

      //book button
        bookflight = new JButton("Book Flight");
         bookflight.setBackground(Color.BLACK);
         bookflight.setForeground(Color.WHITE);
         bookflight.setBounds(220,580 ,150,25);
         bookflight.addActionListener(this);
         add(  bookflight);
        
        
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton){
            String aadhar = tfaadhar.getText();
       
        
        
       try{
            Conn conn=new Conn();
            
           String query = "select* from passenger where aadhar='"+aadhar+"'";
            
           ResultSet rs=conn.s.executeQuery(query);
           
           if(rs.next()){
               
               tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
               
           }else{
               
               JOptionPane.showMessageDialog(null, "Please enter correct aadhar number!!");
               
           }
           
           
          
        }catch(Exception e){
            e.printStackTrace();
            
        }
       
       }
        
        
        else if(ae.getSource()==flight){
            
            String src = source.getSelectedItem();

            String dest = destination.getSelectedItem();
       
        
        
       try{
            Conn conn=new Conn();
            
           String query = "select* from flight where source='"+src+"' and destination='"+dest+"'";
            
           ResultSet rs=conn.s.executeQuery(query);
           
           if(rs.next()){
               
               labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));
               
               
           }else{
               
               JOptionPane.showMessageDialog(null, "No Flights Found!!");
               
           }
           
           
          
        }catch(Exception e){
            e.printStackTrace();
            
        }
       
       }else{
            
            String aadhar=tfaadhar.getText();
            String name=tfname.getText();
            String nationality=tfnationality.getText();
            String flightname=labelfname.getText();
            
        }
        }
    
    
    
    public static void main(String[]args){
        new BookFlight();
        
    }
}
