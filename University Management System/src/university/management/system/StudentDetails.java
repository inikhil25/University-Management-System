package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails  extends JFrame implements ActionListener {
    
    Choice crollno;
    JTable table;
    JButton search , print ,update , add ,cancel;
    
     
    StudentDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        crollno=new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try {
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10,100,900,600);
        add(jsp);
        
        search =  new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print =  new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        update =  new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        add =  new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);
        
        cancel =  new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(700,600);
        setLocation(300,100);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==search){
            String query = "select * from student where rollno ='"+crollno.getSelectedItem()+"'";
            try {
                Conn c=new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e) {
               e.printStackTrace();
            }
        }else if (ae.getSource()==print){
            try {
                 table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==add){
            setVisible(false);
            new AddStudent();
        }else if (ae.getSource()==update){
            setVisible(false);
 //           new UpdateStudent();
        }else {
         setVisible(false);   
        }
    }
    
    public static void main(String[] args){
        new StudentDetails();
    }
}
