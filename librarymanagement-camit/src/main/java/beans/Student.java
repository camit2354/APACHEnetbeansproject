/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class Student extends Person{
    
    private String name;
    private String email;
    private String mobileNo;
    int fine;
    
    //first argument is bookId 
    //second argument is dateToBeReturned
    HashMap<String, Date> issuedBooks;
    int countBooksIssued;

    public int getCountBooksIssued() {
        return countBooksIssued;
    }

    public void setCountBooksIssued(int countBooksIssued) {
        this.countBooksIssued = countBooksIssued;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public HashMap<String, Date> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(HashMap<String, Date> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }
    
    
    
}
