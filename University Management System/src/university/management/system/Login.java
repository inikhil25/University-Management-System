package university.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
  
    JButton login,cancel;
    JTextField tfusername,tfpassword;

Login() {
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(70,20,100,20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(70,70,100,20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        
        login = new JButton("Login");
        login.setBounds(70,140,120,30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(210,140,120,30);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 240, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 100, 200);
        add(image);
        
        setSize(600,300);
        setLocation(350,250);
        setVisible(true);
        


}
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==login) {
          String username =tfusername.getText();
          String password =tfpassword.getText();
          String query ="Select * from login where username='"+username+"' and password='"+password+"'";          

          try {
              Conn c = new Conn();
             ResultSet rs = c.s.executeQuery(query);
             
             if (rs.next()) {
                setVisible(false);
                new project();
             } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
             }
             c.s.close();
          } catch (Exception e){
            e.printStackTrace();
          }
       } else if (ae.getSource() == cancel){
           setVisible(false);
       }
    }
    public static void main(String[] args)  {
        new Login();  
    }
}           

