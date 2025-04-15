package org.example.finalexammodule3.controller;

import org.example.finalexammodule3.model.Book;
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

    private void getBookBorrowed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = libraryDao.getBookBorrowed();
        req.setAttribute("books", books);
        req.getRequestDispatcher("view/bookborrowed.jsp").forward(req, resp);
    }
}
