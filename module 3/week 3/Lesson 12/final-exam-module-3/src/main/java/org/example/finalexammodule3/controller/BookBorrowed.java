package org.example.finalexammodule3.controller;

import org.example.finalexammodule3.model.Book;
import org.example.finalexammodule3.model.Card;
import org.example.finalexammodule3.service.LibraryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookBorrowed", value = "/book-borrowed")
public class BookBorrowed extends HttpServlet {
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
            getBookBorrowed(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        if (action.equals("confirm")) {
            String idBook = req.getParameter("idBook");
            session.setAttribute("idCard",req.getParameter("idCard"));
            session.setAttribute("idBook",idBook);
            req.setAttribute("nameBookReturn", libraryDao.getBookById(idBook).getName());
            req.setAttribute("confirm", true);

            List<Card> cards = libraryDao.getAllCard();
            req.setAttribute("cards", cards);
            req.getRequestDispatcher("view/bookborrowed.jsp").forward(req, resp);
        } else if (action.equals("return")) {
            returnBook(req, resp);
            session.removeAttribute("idCard");
            session.removeAttribute("idBook");
        }
    }

    private void returnBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idCard = session.getAttribute("idCard").toString();
        String idBook = session.getAttribute("idBook").toString();
        libraryDao.returnBook(idCard, idBook);
        resp.sendRedirect("book-borrowed");
    }

    private void getBookBorrowed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Card> cards = libraryDao.getAllCard();
        req.setAttribute("cards", cards);
        req.getRequestDispatcher("view/bookborrowed.jsp").forward(req, resp);
    }
}
