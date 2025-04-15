package org.example.finalexammodule3.service;

import org.example.finalexammodule3.model.Book;
import org.example.finalexammodule3.model.Card;
import org.example.finalexammodule3.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryDao {
    private final Connection connection;

    private static final String SELECT_ALL_BOOK = "select * from book";
    private static final String SELECT_BOOK_BY_ID_AVAILABLE = "select * from book where id = ? and quantity > 0";
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String BORROW_BOOK = "insert into card value(?, ?, ? , ? , ? , ?)";
    private static final String SELECT_BOOK_BY_ID = "select * from book where id = ?";
    private static final String LAST_CARD = "select * from table_name order by id desc limit 1";
    private static final String SELECT_ALL_BOOK_BORROWED = "select * from book inner join card on book.id = card.idBook where card.status = 1";

    public LibraryDao() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                Book book = new Book(id, name, author, description, quantity);
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return books;
    }

    public boolean isBookAvailable(String idBook) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID_AVAILABLE);
            preparedStatement.setString(1, idBook);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) return false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    public boolean borrowBook(String idBook, String idCard, String idStudent, LocalDate dayBorrowed, LocalDate dateReturn) {
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(BORROW_BOOK);
            preparedStatement1.setString(1, idCard);
            preparedStatement1.setString(2, idBook);
            preparedStatement1.setString(3, idStudent);
            preparedStatement1.setBoolean(4,true);
            preparedStatement1.setDate(5, Date.valueOf(dayBorrowed));
            preparedStatement1.setDate(6, Date.valueOf(dateReturn));
            return preparedStatement1.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String classes = resultSet.getString("classes");
                Student student = new Student(id, name, classes);
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }

    public Book getBookById(String idBook) {
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setString(1, idBook);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                book = new Book(id, name, author, description, quantity);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return book;
    }

    public Card lastCard() {
        Card card = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(LAST_CARD)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String idBook = resultSet.getString("idBook");
                String idStudent = resultSet.getString("idStudent");
                boolean status = resultSet.getBoolean("status");
                LocalDate dayBorrowed = resultSet.getDate("dateBorrowed").toLocalDate();
                LocalDate dateReturn = resultSet.getDate("dateReturn").toLocalDate();
                card = new Card(id, idBook, idStudent, status, dayBorrowed, dateReturn);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return card;
    }

    public List<Book> getBookBorrowed() {
        List<Book> books = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK_BORROWED)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                Book book = new Book(id, name, author, description, quantity);
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return books;
    }
}
