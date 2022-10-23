/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryServer;

/**
 *
 * @author ismaa
 */
import ModelClasses.Book;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class BookDAO {
    
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/LibraryManagementDB";
    private final String username = "Administrator";
    private final String password = "password";
    
    public boolean saveBook(Book d){
         
     Connection connection = null;   
        PreparedStatement statement = null;     
        ResultSet resultSet = null;     
           int ok;   
           boolean successful = false;
           String sql = "INSERT INTO Book VALUES(?,?,?,?,?)";
           
            try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            statement = connection.prepareStatement(sql);
            
           
               statement.setInt(1,d.getIsbn());
                statement.setString(2,d.getAuthorName());
               statement.setString(3,d.getTitle());
                  statement.setString(4,d.getCategory());
                  statement.setInt(5,d.getShelveNum());
                  statement.setBoolean(6,d.isAvailableForLoan());
                  
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
           
           try{
           input = new ObjectInputStream (new FileInputStream("Books.ser"));
           
            }catch(IOException ioe){
           
           System.out.println("Error has occurrred.Cannot open file");
           
           }
           
          }
           
         public void readRecords() throws ClassNotFoundException{
          
          Book d;
          try{
          
          while(true){
          
          d =(Book)input.readObject();
          saveBook(d);
          System.out.println(d.toString());
          
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
