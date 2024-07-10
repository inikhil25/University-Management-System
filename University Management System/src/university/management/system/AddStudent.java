package university.management.system;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {
    
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfcourse,tfaadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    
    Random ran=new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000);
    
    AddStudent(){
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(900,700);
        setLocation(250,50);
       
        setLayout(null);
        
        JLabel heading =new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.red);
        add(heading);
        
        
        JLabel lblname =new JLabel("Name");
        lblname.setBounds(50,135,100,50);
        lblname.setFont(new Font("serif",Font.BOLD,25));
        add(lblname);
        
        tfname =new JTextField();
        tfname.setBounds(180,150,150,30);
        add(tfname);
        
        JLabel lblfname =new JLabel("Father's Name");
        lblfname.setBounds(400,135,200,50);
        lblfname.setFont(new Font("serif",Font.BOLD,25));
        add(lblfname);
        
        tffname =new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        
        JLabel lblrollno =new JLabel("Roll No.");
        lblrollno.setBounds(50,190,200,50);
        lblrollno.setFont(new Font("serif",Font.BOLD,25));
        add(lblrollno);
        
        labelrollno =new JLabel("231222"+first4);
        labelrollno.setBounds(180,190,200,50);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        labelrollno.setForeground(Color.magenta);
        add(labelrollno);
        
        JLabel lbldob =new JLabel("Date of Birth");
        lbldob.setBounds(400,190,190,50);
        lbldob.setFont(new Font("serif",Font.BOLD,25));
        add(lbldob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(600,200,200,30);
        add(dcdob);
        
        JLabel lbladdress =new JLabel("Address");
        lbladdress.setBounds(50,250,200,50);
        lbladdress.setFont(new Font("serif",Font.BOLD,25));
        add(lbladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(180,260,150,30);
        add(tfaddress);
        
        JLabel lblphone =new JLabel("Phone no.");
        lblphone.setBounds(400,250,200,50);
        lblphone.setFont(new Font("serif",Font.BOLD,25));
        add(lblphone);

        tfphone =new JTextField();
        tfphone.setBounds(600,260,150,30);
        add(tfphone);
        
        JLabel lblemail =new JLabel("Email Id");
        lblemail.setBounds(50,310,200,50);
        lblemail.setFont(new Font("serif",Font.BOLD,25));
        add(lblemail);
        
        tfemail =new JTextField();
        tfemail.setBounds(180,320,150,30);
        add(tfemail);
        
        JLabel lblcourse =new JLabel("Course");
        lblcourse.setBounds(50,380,200,50);
        lblcourse.setFont(new Font("serif",Font.BOLD,25));
        add(lblcourse);
        
        String course[]={"MCA","BCA","B.tech","B.Sc","BBA","MBA","BPharma"};
        cbcourse =new JComboBox(course);
        cbcourse.setBounds(180,390,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch =new JLabel("Branch");
        lblbranch.setBounds(400,380,200,50);
        lblbranch.setFont(new Font("serif",Font.BOLD,25));
        add(lblbranch);
        
        String branch[]={"Computer Application","Electrical & Communication","Mechnical","Chemical","Electrical","IT","CSE","Civil"};
        cbbranch =new JComboBox(branch);
        cbbranch.setBounds(600,390,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        JLabel lblaadhar =new JLabel("Aadhar No.");
        lblaadhar.setBounds(400,310,200,50);
        lblaadhar.setFont(new Font("serif",Font.BOLD,25));
        add(lblaadhar);
        
        tfaadhar =new JTextField();
        tfaadhar.setBounds(600,320,150,30);
        add(tfaadhar);
        
        submit = new JButton("Submit");
        submit.setBounds(270,580,120,30);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(460,580,120,30);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setVisible(true);
    }
            
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
        String name=tfname.getText();
        String fname=tffname.getText();
        String rollno=labelrollno.getText();
        String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();
        
        String course=(String)cbcourse.getSelectedItem();
        String branch=(String)cbbranch.getSelectedItem();
        
        try{
          String query ="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+aadhar+"','"+course+"','"+branch+"')";  
        
          Conn con=new Conn();
          con.s.executeUpdate(query);
          
          JOptionPane.showMessageDialog(null,"Student Detail Inserted Successfully");
          setVisible(false);
          
        }catch (Exception e){
            e.printStackTrace();
        }
      }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddStudent();
    }
            
           
}
