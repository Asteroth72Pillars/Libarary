/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClasses;

import java.io.Serializable;

/**
 *
 * @author ismaa
 */
public class Student implements Serializable {
    private int studentNo;
    private String firstName;
    private String surname;
    private String grade;
    private boolean canLoan;
    
    public Student()
    {
    
    }

    public Student(int studentNo, String fName, String lName, String standard, boolean canBorrow) {
        this.studentNo = studentNo;
        this.firstName = fName;
        this.surname = lName;
        this.grade = standard;
        this.canLoan = canBorrow;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getGrade() {
        return grade;
    }

    public boolean isCanLoan() {
        return canLoan;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCanLoan(boolean canLoan) {
        this.canLoan = canLoan;
    }

    @Override
    public String toString() {
        return "Student{" + "studentNo=" + studentNo + ", firstName=" + firstName + ", surname=" + surname + ", grade=" + grade + ", canLoan=" + canLoan + '}';
    }
    
    
    
    
}
