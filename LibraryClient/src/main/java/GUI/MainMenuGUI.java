/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author ismaa
 */
public class MainMenuGUI extends JFrame implements ActionListener{

    private JPanel panelNorth;
    private JPanel panelCenter;
    private JPanel panelSouth;
    
    private JLabel lblEventLogo;
    private JLabel lblHeading;
    
    private JLabel  lblOption;
    private JComboBox cboOption;
    private JLabel lblStudentNumberErr;
    private String[] item ={"1:Add Students","2:Add Book","3:Rent Book","4:Return Book",
        "5:List all Books and Students","6:Reports"
    };
   
    private JButton btnExit;
    private Font ft1, ft2, ft3;
    
        public MainMenuGUI() {
        super("Library Management App.");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
      
        panelSouth = new JPanel();
        
        lblEventLogo = new JLabel(new ImageIcon(""));
        lblHeading = new JLabel("DVD Rental Store");
   
        lblOption = new JLabel("Select Any Option From Menu: ");   
    
        cboOption = new JComboBox(item);
        cboOption.setSelectedIndex(-1);
        
         
        btnExit = new JButton("Exit");
    
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 22);
        ft3 = new Font("Arial", Font.PLAIN, 24);
        panelCenter.setBorder(BorderFactory.createEmptyBorder(200,0,50,200));
            
    }
    
        public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new FlowLayout());
        panelSouth.setLayout(new GridLayout(1, 1));
       
        panelNorth.add(lblEventLogo);
        panelNorth.add(lblHeading);
        
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.LIGHT_GRAY);
        panelNorth.setBackground(Color.CYAN);
        lblOption.setFont(ft1);
        lblOption.setForeground(Color.red);
        lblOption.setHorizontalAlignment(JLabel.RIGHT);
        cboOption.setFont(ft1);
       
        panelCenter.add(lblOption);
        panelCenter.add(cboOption);
            
        panelCenter.setBackground(Color.LIGHT_GRAY);
          
        btnExit.setFont(ft3);
        panelSouth.add(btnExit);
      
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER); 
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        btnExit.addActionListener(this);
        
        cboOption.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                 {
                    String getItem= (String)cboOption.getSelectedItem();
                   
                   if(getItem.equals(item[0])){
                       dispose();
                      new AddStudentGUI().setGUI();
                       
                 }
                   else if(getItem.equals(item[1])){
                       dispose();
                       new AddBookGUI().setGUI();
                   }
                    else if(getItem.equals(item[2])){
                        dispose();
                       new RentBookGUI().setGUI();
                    }
                   else if(getItem.equals(item[3])){
                        dispose();
                       new ReturnBookGUI().setGUI();
                    }
                    else if(getItem.equals(item[4])){
                        dispose();
                       new ListBooksStudentsGUI().setGUI();
                    }
                    
                   else if(getItem.equals(item[5])){
                        dispose();
                       new Reports().setGUI();
                    }
                }
            }
        });
        
   
        
        this.setSize(600, 600);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getActionCommand().equals("Customer")) {
            {
                System.out.println("yes");
            }
        }
        else if (e.getActionCommand().equals("Reset")) {
           
        }   
        else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
       
        new MainMenuGUI().setGUI();
    }
}

