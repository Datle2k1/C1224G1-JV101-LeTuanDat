package org.example.finalexammodule3.controller;

import org.example.finalexammodule3.model.Book;
import org.example.finalexammodule3.model.Card;
import org.example.finalexammodule3.service.LibraryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookBorrowed", value = "/book-borrowed")
public class BookBorrowed extends HttpServlet {
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
            getBookBorrowed(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        if (action.equals("return")) {
            returnBook(req, resp);
        } else if (action.equals("confirm")) {
            req.setAttribute("confirm", true);
            req.getRequestDispatcher("view/bookborrowed.jsp").forward(req, resp);
        }
    }

    private void returnBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idCard = req.getParameter("idCard");
        String idBook = req.getParameter("idBook");
        libraryDao.returnBook(idCard, idBook);
        resp.sendRedirect("bookborrowed");
    }

    private void getBookBorrowed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Card> cards = libraryDao.getAllCard();
        req.setAttribute("cards", cards);
        req.getRequestDispatcher("view/bookborrowed.jsp").forward(req, resp);
    }
}
