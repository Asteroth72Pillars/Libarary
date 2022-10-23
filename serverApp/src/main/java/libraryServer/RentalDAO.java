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
import ModelClasses.Student;
import ModelClasses.Rental;
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
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RentalDAO {
    
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
    
    public boolean populateStudent(Student c) {
           Connection connection = null;   
           PreparedStatement statement = null;     
           ResultSet resultSet = null;     
           int ok;   
           boolean successful = false;
           String sql = "SELECT* FROM Student WHERE StudentNo = ?";
           
           try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryManagementDB", "administrator", "password");
            statement = connection.prepareStatement(sql);
            
           
               statement.setInt(1,c.getStudentNo());
                statement.setString(2,c.getFirstName());
               statement.setString(3,c.getSurname());
                  statement.setString(4,c.getGrade());
                  statement.setBoolean(5,c.isCanLoan());
                  
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
       return false;
    }    
    //get book isbn 
    public static ArrayList<Integer> getIsbn() {
        Connection connection = null;   
        Statement statement = null;     
        ResultSet resultSet = null;     
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryManagementDB", "administrator", "password");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT refferenceNumber FROM Rental");
            while (resultSet.next()) {
                list2.add(resultSet.getInt("Isbn"));
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
            
        return list2;
    }
    
    public boolean populateBook(Book d) {
           Connection connection = null;   
           PreparedStatement statement = null;     
           ResultSet resultSet = null;     
           int ok;   
           boolean successful = false;
           String sql = "SELECT* FROM Book WHERE isbn = ?";
           
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/LibraryManagementDB", "administrator", "password");
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1,d.getIsbn());
                statement.setString(2,d.getAuthorName());
               statement.setString(3,d.getTitle());
                  statement.setString(4,d.getCategory());
                  statement.setInt(5,d.getShelveNum());
                  statement.setBoolean(6,d.isAvailableForLoan());
                  
                  ok=statement.executeUpdate();
              
             if(ok>0){
                 
                  JOptionPane.showMessageDialog(null, " Your Dvd information has been successfully updated .");
                 
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
}
