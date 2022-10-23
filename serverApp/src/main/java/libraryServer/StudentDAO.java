/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryServer;
import ModelClasses.Student;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ismaa
 */
public class StudentDAO {
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
     private ObjectInputStream input;
    
           public void openFile() {
           
           try{input = new ObjectInputStream (new FileInputStream("Students.ser"));
               }
           catch(IOException ioe){ 
           System.out.println("Error has occurrred.Cannot open file");
           }
           
          }
 public void readRecords() throws ClassNotFoundException{
          Student c;
          try{
          
          while(true){
          
          c =(Student)input.readObject();
          saveStudent(c);
          System.out.println(c.toString());
          
              } 
          }catch(EOFException io){
          return;
          
          }catch(IOException a){
          
              a.printStackTrace();
          }
          }
            
           public void closeFile(){
           
           try{
               
           input.close();
           
           }catch(IOException ioe){
           
           System.out.print("Error: Cannot close file");
           
           }
           
           } 

         
         
           
            
}
