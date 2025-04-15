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

@WebServlet(name = "LibraryServlet", value = "/all-book")
public class LibraryServlet extends HttpServlet {
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
            List<Book> books = libraryDao.getAllBook();
            req.setAttribute("books", books);
            req.getRequestDispatcher("view/library.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        if (action.equals("borrow")) {
            isBookAvailable(req, resp);
        }
    }

    private void isBookAvailable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idBook = req.getParameter("idBook");
        boolean isAvailable = libraryDao.isBookAvailable(idBook);
        if (!isAvailable) {
            req.setAttribute("notAvailable",true);
            req.getRequestDispatcher("view/library.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("card&idBook=" + idBook);
        }
    }
}
