package org.example.casestudymodule3.controller;

import org.example.casestudymodule3.model.Customer;
import org.example.casestudymodule3.service.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private CustomerDao customerDao;

    @Override
    public void init() throws ServletException {
        customerDao = new CustomerDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String ingame = request.getParameter("ingame");

        Customer user = new Customer(name, email, password, ingame);
        if (customerDao.registerUser(user)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("error", "Email already exists!");
            request.getRequestDispatcher("view/register.jsp").forward(request, response);
        }
    }
}
