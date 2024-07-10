package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener{
    
    project(){
        
        setSize(1380,768);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1340,660, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        JMenu newInformation =new JMenu("New Information");
        newInformation.setForeground(Color.BLACK);
        mb.add(newInformation);
        
        JMenuItem facultyInfo =new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo =new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        //Details
        JMenu details =new JMenu("New Details");
        details.setForeground(Color.BLACK);
        mb.add(details);
        
        JMenuItem facultydetails =new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        details.add(facultydetails);
        
        JMenuItem studentdetails =new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        details.add(studentdetails);
        
        //Leave
        JMenu leave =new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);
        
        JMenuItem facultyleave =new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        leave.add(facultyleave);
        
        JMenuItem studentleave =new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        leave.add(studentleave);
        
        //Leave Details
        JMenu leaveDetails =new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        mb.add(leaveDetails);
        
        JMenuItem facultyleavedetails =new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        leaveDetails.add(facultyleavedetails);
        
        JMenuItem studentleavedetails =new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        leaveDetails.add(studentleavedetails);
        
        //Exam
        JMenu exam =new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        mb.add(exam);
        
        JMenuItem examinationdetails =new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.WHITE);
        exam.add(examinationdetails);
        
        JMenuItem entermarks =new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        exam.add(entermarks);
        
        
        //Update Information
        JMenu updateInfo =new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);
        
        JMenuItem updatefacultyinfo =new JMenuItem("Update Faculty Details ");
        updatefacultyinfo.setBackground(Color.WHITE);
        updateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo =new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updateInfo.add(updatestudentinfo);
        
        //Fee 
        JMenu fee =new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        mb.add(fee);
        
        JMenuItem feestructure =new JMenuItem("Fee Structure ");
        feestructure.setBackground(Color.WHITE);
        fee.add(feestructure);
        
        JMenuItem feeform =new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        fee.add(feeform);
        
        //Utility 
        JMenu Utility =new JMenu("Utility");
        Utility.setForeground(Color.BLACK);
        mb.add(Utility);
        
        JMenuItem notepad =new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        Utility.add(notepad);
        
        JMenuItem calc =new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        Utility.add(calc);
        
        
        //Exit 
        JMenu exit =new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);
        
        JMenuItem ex =new JMenuItem("Exit");
        ex.setBackground(Color.RED);
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       String msg=ae.getActionCommand();
       
       if(msg.equals("Exit")) {
           setVisible(false);
       } else if(msg.equals("Calculator")){
           try{
               Runtime.getRuntime().exec("calc.exe");
           }catch (Exception e){
               
           }
       } else if(msg.equals("Notepad")){
           try{
               Runtime.getRuntime().exec("notepad.exe");
           }catch (Exception e){
               
           }
       }  else if (msg.equals("New Faculty Information")) {
           new AddTeacher();
       }  else if (msg.equals("New Student Information")) {
           new AddStudent();
       }
    }
    
    public static void main(String[] args){
        new project();
    }
}
