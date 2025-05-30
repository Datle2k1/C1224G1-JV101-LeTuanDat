package org.example.finalexammodule3.controller;

import org.example.finalexammodule3.model.Book;
import org.example.finalexammodule3.service.LibraryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LibraryServlet", value = "/all-book")
public class LibraryServlet extends HttpServlet {
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
            List<Book> books = libraryDao.getAllBook();
            req.setAttribute("books", books);
            req.getRequestDispatcher("view/library.jsp").forward(req, resp);
            session.removeAttribute("IsBorrowed");
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
        HttpSession session = req.getSession();
        String idBook = req.getParameter("idBook");
        boolean isAvailable = libraryDao.isBookAvailable(idBook);
        if (!isAvailable) {
            req.setAttribute("notAvailable", true);
            req.getRequestDispatcher("view/library.jsp").forward(req, resp);
        } else {
            session.setAttribute("idBook", idBook);
            resp.sendRedirect("card");
        }
    }
}
