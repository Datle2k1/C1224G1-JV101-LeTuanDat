package org.example.finalexammodule3.model;

import java.time.LocalDate;

public class Card {
    private String id;
    private String idBook;
    private String idStudent;
    private boolean status;
    private LocalDate dayBorrowed;
    private LocalDate dateReturn;

    public Card() {
    }

    public Card(String idBook, String idStudent, boolean status, LocalDate dayBorrowed, LocalDate dateReturn) {
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.dayBorrowed = dayBorrowed;
        this.dateReturn = dateReturn;
    }

    public Card(String id, String idBook, String idStudent, boolean status, LocalDate dayBorrowed, LocalDate dateReturn) {
        this.id = id;
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.dayBorrowed = dayBorrowed;
        this.dateReturn = dateReturn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDayBorrowed() {
        return dayBorrowed;
    }

    public void setDayBorrowed(LocalDate dayBorrowed) {
        this.dayBorrowed = dayBorrowed;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }
}
