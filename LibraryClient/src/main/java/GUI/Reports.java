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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ismaa
 */
public class Reports extends JFrame implements ActionListener {
    
            private JPanel panelNorth,panelCenter,panelSouth;
           
            private JLabel lblPic,lblHeading;
            
        
            private JButton btnAllRentals;
        
            private JButton btnOutstandingRentals;
             
            private JButton btnDailyRentals;
            
            private JTextArea txtMessage;
            private JScrollPane scrollPane;
            private JButton btnReset, btnExit;
         
            private Font ft1,ft2;
           
        public Reports () {
        super("Library Management App.");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        
        lblPic = new JLabel(new ImageIcon(""));
        lblHeading = new JLabel("REPORTS");
         
        btnAllRentals = new JButton("Rentals");
        
        btnOutstandingRentals = new JButton("Outstanding Rentals");
         
        btnDailyRentals = new JButton("Daily Rentals");
        
        txtMessage = new JTextArea();
        scrollPane = new JScrollPane(txtMessage);
        
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");
        
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.BOLD, 15);
        }
        
       
         public void setGUI() {
         panelNorth.setLayout(new FlowLayout());
         panelCenter.setLayout(new GridLayout(1,1));
    
         panelSouth.setLayout(new GridLayout(1, 5));
    
         lblHeading.setFont(ft1);
         lblHeading.setForeground(Color.LIGHT_GRAY);
         
         panelNorth.setBackground(Color.CYAN);
         panelCenter.setBackground(Color.LIGHT_GRAY);
         
         btnReset.setBackground(Color.BLACK);
         btnReset.setForeground(Color.WHITE);
         
         txtMessage.setLineWrap(true);
         txtMessage.setWrapStyleWord(true);
             
         panelNorth.add(lblPic);
         panelNorth.add(lblHeading);
       
         panelCenter.add(scrollPane);
         panelCenter.add(btnAllRentals); 
         panelCenter.add(btnOutstandingRentals);
         panelCenter.add(btnDailyRentals);
         
         panelSouth.add(btnAllRentals);
         panelSouth.add(btnOutstandingRentals);
         panelSouth.add(btnDailyRentals);
         panelSouth.add(btnReset);
         panelSouth.add(btnExit);
         
         this.add(panelNorth, BorderLayout.NORTH);
         this.add(panelCenter, BorderLayout.CENTER);
         this.add(panelSouth, BorderLayout.SOUTH);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         btnReset.addActionListener(this);
         btnExit.addActionListener(this);
      
         this.setSize(600, 600);
         this.pack();
         this.setVisible(true);
         this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         }
      
        
        public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Student")) {
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
        }else if(e.getActionCommand().equals("Reset")) {
              txtMessage.setText("");
          
        }   
     
        else if (e.getActionCommand().equals("Exit")) {
            this.dispose();
           new MainMenuGUI().setGUI();
            
         
        }
    }  
         
   
}
