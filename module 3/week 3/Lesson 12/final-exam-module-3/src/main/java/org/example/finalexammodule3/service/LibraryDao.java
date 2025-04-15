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

    private static final String SELECT_ALL_CARD = "select card.id as idCard,card.status,card.dateBorrowed,card.dateReturn, book.id as idBook, book.name as nameBook, book.author, book.description, book.quantity, student.id as idStudent, student.name as nameStudent, student.classes from card inner join book on card.idBook = book.id inner join student on card.idStudent = student.id";
    private static final String UPDATE_QUANTITY_BOOK = "update book set quantity = quantity - 1 where id = ?";
    private static final String SELECT_ALL_BOOK = "select * from book";
    private static final String SELECT_BOOK_BY_ID_AVAILABLE = "select * from book where id = ? and quantity > 0";
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String BORROW_BOOK = "insert into card value(?, ?, ? , ? , ? , ?)";
    private static final String SELECT_BOOK_BY_ID = "select * from book where id = ?";
    private static final String LAST_CARD = "select card.id as idCard,,card.status,card.dateBorrowed,card.dateReturn, book.id as idBook, book.name as nameBook, book.author, book.description, book.quantity, student.id as idStudent, student.name as nameStudent, student.classes from card order by id desc limit 1 inner join book on card.idBook = book.id inner join student on card.idStudent = student.id";
    private static final String SEARCH_BOOK = "select * from book inner join card on book.id = card.idBook where card.status = 1 and book.name like ? and card.idStudent like ?";
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
            boolean result1 = preparedStatement1.executeUpdate() > 0;

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY_BOOK);
            preparedStatement.setString(1, idBook);
            boolean result2 = preparedStatement.executeUpdate() > 0;

            return result1 && result2;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return true;
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

            if (resultSet.next()) {
                card = getCard(resultSet);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return card;
    }

    public Card getCard(ResultSet re) throws SQLException {
        String id = re.getString("idCard");
        boolean status = re.getBoolean("status");
        LocalDate dayBorrowed = re.getDate("dateBorrowed").toLocalDate();
        LocalDate dateReturn = re.getDate("dateReturn").toLocalDate();

        String idBook = re.getString("idBook");
        String nameBook = re.getString("nameBook");
        String author = re.getString("author");
        String description = re.getString("description");
        int quantity = re.getInt("quantity");
        Book book = new Book(idBook, nameBook, author, description, quantity);

        String idStudent = re.getString("idStudent");
        String nameStudent = re.getString("nameStudent");
        String classes = re.getString("classes");
        Student student = new Student(idStudent, nameStudent, classes);

        return new Card(id, book, student, status, dayBorrowed, dateReturn);
    }

    public List<Card> getAllCard() {
        List<Card> cards = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARD)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cards.add(getCard(resultSet));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cards;
    }

    public void returnBook(String idCard, String idBook) {

    }
}
