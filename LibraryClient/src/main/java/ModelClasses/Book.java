/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClasses;
import java.io.*;
/**
 *
 * @author ismaa
 */
public class Book implements Serializable{
    private int isbn;
    private String authorName;
    private String Title;
    private String category;
    private int shelveNum;
    private boolean availableForLoan;

    public Book(int isbn, String author,String title, String category,int locate, boolean avail) {
        this.isbn = isbn;
        this.authorName = author;
        this.Title=title;
        this.category = category;
        this.shelveNum= locate;
        this.availableForLoan = avail;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    
    

    public void setCategory(int sCategory) {
        switch(sCategory)
        {
            case 1:
                category = "horror";
                break;
            case 2:
                category = "Sci-fi";
                break;
            case 3:
                category = "Drama";
                break;
            case 4:
                category = "Romance";
                break;
            case 5:
                category = "Fiction";
                break;
            case 6:
                category = "War";
                break;
            
        }
        
    }

    public void setShelveNum(int shelveNum) {
        this.shelveNum = shelveNum;
    }
    
    

    public void setAvailableForLoan(boolean available) {
        this.availableForLoan = available;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getTitle() {
        return Title;
    }
    
    

    public String getCategory() {
        return category;
    }

    public int getShelveNum() {
        return shelveNum;
    }
    
    

    public boolean isAvailableForLoan() {
        return availableForLoan;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", authorName=" + authorName + ", Title=" + Title + ", category=" + category + ", shelveNum=" + shelveNum + ", availableForLoan=" + availableForLoan + '}';
    }

    

    
    
    
}
