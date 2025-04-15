package org.example.finalexammodule3.controller;

import org.example.finalexammodule3.model.Book;
import org.example.finalexammodule3.model.Card;
import org.example.finalexammodule3.model.Student;
import org.example.finalexammodule3.service.LibraryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet(name = "CardServlet", urlPatterns = "/card")
public class CardServlet extends HttpServlet {
    private HttpSession session;
    private LibraryDao libraryDao;

    @Override
    public void init() throws ServletException {
        libraryDao = new LibraryDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        String action = req.getParameter("action");
        if (action == null) action = "";

        if (action.isEmpty()) {
            getCard(req, resp);
            session.removeAttribute("IsBorrowed");
        }
    }

    private void getCard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Card card = libraryDao.lastCard();
        String idCard = "";
        if (card == null) idCard = "MS-0001";
        else idCard = genIdCard(card.getId());
        String idBook = session.getAttribute("idBook").toString();

        List<Student> students = libraryDao.getAllStudent();
        Book book = libraryDao.getBookById(idBook);
        req.setAttribute("idCard", idCard);
        req.setAttribute("students", students);
        req.setAttribute("book", book);
        req.setAttribute("now",LocalDate.now());
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
        String idCard = req.getParameter("idCard");
        String idBook = req.getParameter("idBook");
        String idStudent = req.getParameter("idStudent");
        LocalDate dateReturn = formatDate(req.getParameter("dateReturn"));
        LocalDate dayBorrowed = formatDate(req.getParameter("dateBorrowed"));

        if (dayBorrowed.isBefore(dateReturn)) {
            boolean isBorrowed = libraryDao.borrowBook(idBook, idCard, idStudent, dayBorrowed, dateReturn);
            if (isBorrowed) {
                session.setAttribute("IsBorrowed", true);
                resp.sendRedirect("all-book");
            } else {
                session.setAttribute("IsBorrowed", false);
                resp.sendRedirect("card");
            }
        } else {
            resp.sendRedirect("card");
        }
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
