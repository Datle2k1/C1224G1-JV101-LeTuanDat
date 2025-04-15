package org.example.finalexammodule3.model;

import java.time.LocalDate;

public class Card {
    private String id;
    private Book book;
    private Student student;
    private boolean status;
    private LocalDate dayBorrowed;
    private LocalDate dateReturn;

    public Card() {
    }

    public Card(Book book, Student student, boolean status, LocalDate dayBorrowed, LocalDate dateReturn) {
        this.book = book;
        this.student = student;
        this.status = status;
        this.dayBorrowed = dayBorrowed;
        this.dateReturn = dateReturn;
    }

    public Card(String id, Book book, Student student, boolean status, LocalDate dayBorrowed, LocalDate dateReturn) {
        this.id = id;
        this.book = book;
        this.student = student;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
