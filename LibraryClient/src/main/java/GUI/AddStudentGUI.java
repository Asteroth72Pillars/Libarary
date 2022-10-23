/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author ismaa
 */

import ModelClasses.Student;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AddStudentGUI extends JFrame implements ActionListener{
     private JPanel panelNorth,panelCenter,panelSouth;
           
            private JLabel lblPic,lblHeading;
            
            private JLabel lblStudNumber;
            private JTextField txtStudNumber; 
            private JLabel lblBlank;
             
            private JLabel  lblFirstName;
            private JTextField txtFirstName;
            private JLabel lblBlank1;
             
            private JLabel lblSurName;
            private JTextField txtSurName;
            private JLabel lblBlank2;
            
            private JLabel lblGrade;
            private JTextField txtGrade;
            private JLabel lblBlank3;
            
            private JLabel lblRent;
            private ButtonGroup RentGroup;
            private JRadioButton radRentYes;
            private JRadioButton radRentNo;
           
            private JButton btnReset, btnExit,btnAddStudent;
         
            private Font ft1,ft2;
            
            public AddStudentGUI () {
        super("Library Management System"); 
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        
        lblPic = new JLabel(new ImageIcon(""));
        lblHeading = new JLabel("Student");
        
        lblStudNumber= new JLabel("Student Number: ");
        txtStudNumber = new JTextField();
        lblBlank= new JLabel(" ");
      
        lblFirstName= new JLabel("First Name: ");
        txtFirstName = new JTextField();
        lblBlank1= new JLabel(" ");
        
        lblSurName= new JLabel("Surname: ");
        txtSurName = new JTextField();
        lblBlank2= new JLabel(" ");
      
        lblGrade= new JLabel("Grade: ");
        txtGrade = new JTextField();
        lblBlank3 = new JLabel(" ");
       
        lblRent= new JLabel("Can rent: ");
        radRentYes = new JRadioButton("Yes");
        radRentNo = new JRadioButton("No");
        RentGroup = new ButtonGroup();
      
        btnAddStudent = new JButton("Add Student");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");
        
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.BOLD, 15);
        }
         
        public void reset(){
        
        txtStudNumber.setText(" ");
        txtFirstName.setText(" ");
        txtSurName.setText(" ");
        txtGrade.setText(" ");
        radRentYes.setSelected(true);
        
        } 
        
        public void hideControls() {
        //lblStudentNumber.setEnabled(true);
       
        
        lblStudNumber.setVisible(false);
        txtStudNumber.setVisible(false);        
        lblFirstName.setVisible(false);
        txtFirstName.setVisible(false);
        lblGrade.setVisible(false);
        txtGrade.setVisible(false);
        lblRent.setVisible(false);
        radRentYes.setVisible(false);
        radRentNo.setVisible(false);
       
   }
         public void unhideControls() {
        //lblStudentNumber.setEnabled(false);
        
        lblStudNumber.setVisible(true);
        txtStudNumber.setVisible(true);        
        lblFirstName.setVisible(true);
        txtFirstName.setVisible(true);
        lblGrade.setVisible(true);
        txtGrade.setVisible(true);
        lblRent.setVisible(true);
        radRentYes.setVisible(true);
        radRentNo.setVisible(true);
        
 }
         static final String DATABASE_URL = "jdbc:derby://localhost:1527/LibraryManagementDB";
    private final String username = "Administrator";
    private final String password = "password";
    
         public boolean saveStudent(Student c){
     Connection connection = null;   
        PreparedStatement statement = null;     
        ResultSet resultSet = null;     
           int ok;   
           boolean successful = false;
           String sql = "INSERT INTO Student VALUES(?,?,?,?,?,)";
            try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            statement = connection.prepareStatement(sql);
            
           
               statement.setInt(1,c.getStudentNo());
                statement.setString(2,c.getFirstName());
               statement.setString(3,c.getSurname());
                  statement.setString(4,c.getGrade());
                  statement.setBoolean(5,c.isCanLoan());
                  
              ok=statement.executeUpdate();
              
             if(ok>0){
                 
                  JOptionPane.showMessageDialog(null, " Your information has been successfully inserted .");
                 
             }else {
                JOptionPane.showMessageDialog(null, "Error: information not inserted.");
            }
             }
        catch(SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error: " + sqlException);
        }
        finally {
            // Method 1
            try {
                if (resultSet != null)
                    resultSet.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (statement != null)
                    statement.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null)
                    connection.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            
        }  
       return false;
    }
             public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(6, 3));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(100,0,20,0));
         
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.LIGHT_GRAY);
          
        panelNorth.setBackground(Color.CYAN);
        panelCenter.setBackground(Color.LIGHT_GRAY);
        radRentYes.setBackground(Color.ORANGE);
        radRentNo.setBackground(Color.ORANGE);
        btnAddStudent.setBackground(Color.BLUE);
        btnAddStudent.setForeground(Color.WHITE);
        btnReset.setBackground(Color.BLACK);
        btnReset.setForeground(Color.WHITE);
        radRentYes.setSelected(true);
        
        panelNorth.add(lblPic);
        panelNorth.add(lblHeading);
        
        panelCenter.add(lblStudNumber);
        panelCenter.add(txtStudNumber);
        panelCenter.add(lblBlank);
          
        panelCenter.add(lblFirstName);
        panelCenter.add(txtFirstName);
        panelCenter.add(lblBlank1);
          
        panelCenter.add(lblSurName);
        panelCenter.add(txtSurName);
        panelCenter.add(lblBlank2);
         
        panelCenter.add(lblGrade);
        panelCenter.add(txtGrade);
        panelCenter.add(lblBlank3);
       
        panelCenter.add(lblRent);
        RentGroup.add(radRentYes);
        RentGroup.add(radRentNo);
        panelCenter.add(radRentYes);
        panelCenter.add(radRentNo);
         
        panelSouth.add(btnAddStudent);
        panelSouth.add(btnReset);
        panelSouth.add(btnExit);
        
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnAddStudent.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
        
        this.setSize(600, 600);
        this.pack();      
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         }
             
             
        public static ArrayList<Integer> getStudentNo() {
        Connection connection = null;   
        Statement statement = null;     
        ResultSet resultSet = null;     
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryManagementDB", "administrator", "password");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT StudentNo FROM Student");
            while (resultSet.next()) {
                list.add(resultSet.getInt("StudentNo"));
            }    
            }
        catch(SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error: " + sqlException);
        }
        finally {
            // Method 1
            try {
                if (resultSet != null)
                    resultSet.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (statement != null)
                    statement.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null)
                    connection.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
            
        return list;
    }
        public void populateStudent() {
           Connection connection = null;   
           PreparedStatement statement = null;     
           ResultSet resultSet = null;     
           int ok;   
           boolean successful = false;
           String sql = "SELECT* FROM Student WHERE StudentNo = ?";
           
           try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryManagementDB", "administrator", "password");
            statement = connection.prepareStatement(sql);
            
           
              statement.setString(2,getName());
             
                  
                  
              ok=statement.executeUpdate();
              
             if(ok>0){
                 
                  JOptionPane.showMessageDialog(null, " Your information has been successfully updated.");
                 
             }else {
                JOptionPane.showMessageDialog(null, "Error: information not inserted.");
            }
            
        }
            catch(SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error: " + sqlException);
        }
            finally {
            // Method 1
            try {
                if (resultSet != null)
                    resultSet.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (statement != null)
                    statement.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null)
                    connection.close();
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            
        }  
   
        }
     
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Student")) {
            {
           
          
      
            }
        }else if(e.getActionCommand().equals("Reset")) {
          
               reset();
        }   
    
        else if (e.getActionCommand().equals("Exit")) {
              this.dispose();
           new MainMenuGUI().setGUI();
            
        
        }
                  
}
}
