package org.example.finalexammodule3.controller;

import org.example.finalexammodule3.model.Book;
import org.example.finalexammodule3.model.Student;
import org.example.finalexammodule3.service.LibraryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import static java.lang.String.valueOf;

@WebServlet(name = "CardServlet", value = "/card")
public class CardServlet extends HttpServlet {
    private LibraryDao libraryDao;

    @Override
    public void init() throws ServletException {
        libraryDao = new LibraryDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        if (action.isEmpty()) {
            getCard(req, resp);
        }
    }

    private void getCard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idBook = req.getParameter("idBook");
        List<Student> students = libraryDao.getAllStudent();
        Book book = libraryDao.getBookById(idBook);
        req.setAttribute("students", students);
        req.setAttribute("book", book);
        req.getRequestDispatcher("view/card.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        if (action.equals("borrow")) {
            borrowBook(req, resp);
        }
    }

    private void borrowBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idCard = genIdCard(libraryDao.lastCard().getId());
        String idBook = req.getParameter("idBook");
        String idStudent = req.getParameter("idStudent");
        LocalDate dayBorrowed = formatDate(req.getParameter("dateBorrowed"));
        LocalDate dateReturn = formatDate(req.getParameter("dateReturn"));
        libraryDao.borrowBook(idBook, idCard, idStudent, dayBorrowed, dateReturn);
        resp.sendRedirect("book-borrowed");
    }

    public String genIdCard(String idCard) {
        int number = Integer.parseInt(idCard.substring(3));
        number++;
        StringBuilder result = new StringBuilder("" + number);
        int size = 4 - ("" + number).length();
        for (int i = 0; i < size; i++) {
            result.insert(0, "0");
        }

        return "MS-" + result;
    }

    public LocalDate formatDate(String date) {
        LocalDate localDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            localDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " + e.getMessage());
        }
        return localDate;
    }
}
