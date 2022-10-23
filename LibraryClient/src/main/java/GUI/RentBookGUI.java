/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import ModelClasses.Student;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author ismaa
 */
public class RentBookGUI extends JFrame implements ActionListener{
    
    private JPanel panelNorth,panelCenter,panelSouth;
           
            private JLabel lblPic,lblHeading;
            
            private JLabel lblSelectStudent; 
            private JComboBox cboSelectStudent;
           
            private JLabel lblBook; 
            private JComboBox cboBook;
           
            private JButton btnReset, btnExit,btnUpdateStudent,btnUpdateBook;
         
            private Font ft1,ft2;
            
            public RentBookGUI () {
        super("Library Management App.");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        
        lblPic = new JLabel(new ImageIcon(""));
        lblHeading = new JLabel("RENT Book");
         
        lblSelectStudent = new JLabel("Select Student: ");
      
        ArrayList<Integer> list = AddStudentGUI.getStudentNo();
        for (int i = 0; i < list.size(); i++) {
            cboSelectStudent.addItem(list.get(i));
        }
        cboSelectStudent.setSelectedIndex(-1);
 
        lblBook = new JLabel("Book Category: ");
        cboBook= new JComboBox();
         
        btnUpdateStudent = new JButton("Update Student");
        btnUpdateBook = new JButton("Update Book");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");
        
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.BOLD, 15);
        }
            
    public void reset(){
         
        cboSelectStudent.setSelectedIndex(0);
        cboBook.setSelectedIndex(0);
        
         }
    
    public void setGUI() {
         panelNorth.setLayout(new FlowLayout());
         panelCenter.setLayout(new GridLayout(2, 2));
         panelSouth.setLayout(new GridLayout(1, 4));
         panelCenter.setBorder(BorderFactory.createEmptyBorder(100,0,100,50));
         
         lblHeading.setFont(ft1);
         lblHeading.setForeground(Color.LIGHT_GRAY);
         
         panelNorth.setBackground(Color.CYAN);
         panelCenter.setBackground(Color.LIGHT_GRAY);
         btnUpdateStudent.setBackground(Color.BLUE);
         btnUpdateStudent.setForeground(Color.WHITE);
         btnUpdateBook.setBackground(Color.RED);
         btnUpdateBook.setForeground(Color.WHITE);
         btnReset.setBackground(Color.BLACK);
         btnReset.setForeground(Color.WHITE);
        
         panelNorth.add(lblPic);
         panelNorth.add(lblHeading);
       
         panelCenter.add(lblSelectStudent);
         panelCenter.add(cboSelectStudent);
          
         panelCenter.add(lblBook);
         panelCenter.add(cboBook);
           
         panelSouth.add(btnUpdateStudent);
         panelSouth.add(btnUpdateBook);
         panelSouth.add(btnReset);
         panelSouth.add(btnExit);
         
         this.add(panelNorth, BorderLayout.NORTH);
         this.add(panelCenter, BorderLayout.CENTER);
         this.add(panelSouth, BorderLayout.SOUTH);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         btnUpdateStudent.addActionListener(this);
         btnUpdateBook.addActionListener(this);
         btnReset.addActionListener(this);
         btnExit.addActionListener(this);
       
         cboSelectStudent.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String studentNumber = cboSelectStudent.getSelectedItem().toString();
                   AddStudentGUI ev = new AddStudentGUI();
                   Student r = new Student();
                 
                    hideControls();
                            
                  ev.unhideControls();  
                   
                }
               
            }
            
        });
         
         this.setSize(600, 600);
         this.pack();
         this.setVisible(true);
         this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         }
    
     public void hideControls() {
        //lblStudentNumber.setEnabled(true);
        lblSelectStudent.setVisible(true);
        cboSelectStudent.setEnabled(true);
        lblBook.setVisible(false);
        cboBook.setVisible(false);
         
    }
     
     public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Update Student")) {
            {
                
                
                  try {
            // Open your connection to a server, at port 5432
            // localhost used here
            Socket s2 = new Socket("localhost", 5437);
            System.out.println("Connection established at port 5436");
            
             InputStream is = s2.getInputStream();
             DataInputStream dis = new DataInputStream(is);
             
             JOptionPane.showMessageDialog(null,dis.readUTF());
             
           
            dis.close();
            s2.close();
            System.out.println("Connection closed.");
        }
        catch (ConnectException connExcep) {
            System.out.println("Error: " + connExcep.getMessage());
        }
        catch (IOException ioExcep) {
            System.out.println("Error: " + ioExcep.getMessage());    
        }
      
            }
        }else if(e.getActionCommand().equals("Update Book")) {
            
          
        }   
      
        else if (e.getActionCommand().equals("Reset")) {
            reset();
        }   
        else if (e.getActionCommand().equals("Exit")) {
            this.dispose();
            new MainMenuGUI().setGUI();
            
         
        }
    }  
         
   
}
