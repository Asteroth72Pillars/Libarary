/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author ismaa
 */
import ModelClasses.Book;
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

public class AddBookGUI extends JFrame implements ActionListener{
    
    private JPanel panelNorth,panelCenter,panelSouth;
           
            private JLabel lblPic,lblHeading;
            
            private JLabel lblIsbNumber;
            private JTextField txtIsbNumber; 
            private JLabel lblBlank;
             
            private JLabel  lblTitle;
            private JTextField txtTitle;
            private JLabel lblBlank1;
             
            private JLabel lblCategory; 
            private JComboBox cboCategory;
            private JLabel lblBlank2;
            
            private JLabel lblAuthor;
            private JTextField txtAuthor;
            private JLabel lblBlank3;    
            
            private JLabel lblShelveNum;
            private JTextField txtShelveNum;
            private JLabel lblBlank4;
            
            private JLabel lblAvailable;        
            private ButtonGroup GroupAvailable;
            private JRadioButton radAvailYes;
            private JRadioButton radAvailNo;
           
            private JButton btnReset, btnExit,btnAddBook;
          
            private Font ft1,ft2;
            
            public AddBookGUI () {
        super("Library Management App.");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        
        lblPic = new JLabel(new ImageIcon(""));
        lblHeading = new JLabel("Book");
         
        lblIsbNumber= new JLabel("ISBN: ");
        txtIsbNumber = new JTextField();
        lblBlank = new JLabel(" ");
      
        lblTitle= new JLabel("Title: ");
        txtTitle = new JTextField();
        lblBlank1 = new JLabel(" ");
        
        lblCategory= new JLabel("Category: ");
        cboCategory= new JComboBox();
        cboCategory .addItem("Horror");
        cboCategory.addItem("sci-f");
        cboCategory.addItem("drama");
        cboCategory.addItem("romance");
        cboCategory.addItem("Fiction");
        cboCategory.addItem("War");
        lblBlank2 = new JLabel(" ");
       
        lblAuthor= new JLabel("Author: ");
        txtAuthor = new JTextField();
        lblBlank3 = new JLabel(" ");
        
        lblShelveNum = new JLabel("Shelve Number: ");
        txtShelveNum = new JTextField();
        lblBlank4= new JLabel("");
                
        lblAvailable= new JLabel("Availibility: ");
        radAvailYes = new JRadioButton("Yes");
        radAvailNo = new JRadioButton("No");
        GroupAvailable = new ButtonGroup();
       
        btnAddBook = new JButton("Add Book");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");
        
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.BOLD, 15);
        }
            
           public void reset(){
         
        txtIsbNumber.setText("  ");
        txtTitle.setText("  ");
        cboCategory.setSelectedIndex(0);
        txtAuthor.setText("  ");
        txtShelveNum.setText("   ");
        radAvailYes.setSelected(true);       
         }
           
           public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(7, 3));
        panelSouth.setLayout(new GridLayout(1, 4));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(30,0,20,0));
         
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.LIGHT_GRAY);
         
        panelNorth.setBackground(Color.CYAN);
        panelCenter.setBackground(Color.LIGHT_GRAY);
      
        radAvailYes.setBackground(Color.ORANGE);
        radAvailNo.setBackground(Color.ORANGE);
        btnAddBook.setBackground(Color.RED);
        btnAddBook.setForeground(Color.WHITE);
        btnReset.setBackground(Color.BLACK);
        btnReset.setForeground(Color.WHITE);
        radAvailYes.setSelected(true);
        
        panelNorth.add(lblPic);
        panelNorth.add(lblHeading);
           
        panelCenter.add(lblIsbNumber);
        panelCenter.add(txtIsbNumber);
        panelCenter.add(lblBlank);
          
        panelCenter.add(lblTitle);
        panelCenter.add(txtTitle);
        panelCenter.add(lblBlank1);
         
        panelCenter.add(lblCategory);
        panelCenter.add(cboCategory);
        panelCenter.add(lblBlank2);
       
        panelCenter.add(lblAuthor);
        panelCenter.add(txtAuthor);
        panelCenter.add(lblBlank3);
        
        panelCenter.add (lblShelveNum);
        panelCenter.add (txtShelveNum);
        panelCenter.add(lblBlank4);
        
        panelCenter.add(lblAvailable);
        GroupAvailable.add(radAvailYes);
        GroupAvailable.add(radAvailNo);
        panelCenter.add(radAvailYes);
        panelCenter.add(radAvailNo);
       
        panelSouth.add(btnAddBook);
        panelSouth.add(btnReset);
        panelSouth.add(btnExit);
        
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     
        btnAddBook.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
        
        this.setSize(600, 600);
        this.pack(); 
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         }
           
           
           public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Book")) {
            {
             
                  try {
            // Open your connection to a server, at port 5432
            // localhost used here
            Socket s2 = new Socket("localhost", 5437);
            System.out.println("Connection established at port 5437");
            
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
          
                     reset();
        }   
      
        else if (e.getActionCommand().equals("Exit")) { 
            
            this.dispose();
           new MainMenuGUI().setGUI();
            
            
        }
    }  
         
    
    
}

