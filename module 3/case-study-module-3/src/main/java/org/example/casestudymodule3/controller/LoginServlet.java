package org.example.casestudymodule3.controller;

import org.example.casestudymodule3.model.Customer;
import org.example.casestudymodule3.service.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private CustomerDao customerDao;

    @Override
    public void init() {
        customerDao = new CustomerDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Customer user = customerDao.loginUser(email, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", user.getName());
            session.setAttribute("userIngame", user.getIn_game());
            response.sendRedirect("welcome.jsp");
        } else {
            request.setAttribute("error", "Invalid email or password!");
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        }
    }
}
