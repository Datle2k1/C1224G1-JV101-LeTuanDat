package org.example.casestudymodule3.controller;

import org.example.casestudymodule3.model.Order;
import org.example.casestudymodule3.model.Skin;
import org.example.casestudymodule3.service.CustomerDao;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SkinServlet", urlPatterns = "/home")
public class SkinServlet extends HttpServlet {
    private CustomerDao customerDao;
    private final String CHAMPION_IMAGE_PATH = "resources/img_skin";

    @Override
    public void init() throws ServletException {
        customerDao = new CustomerDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add-to-cart":
                int skinId = Integer.parseInt(req.getParameter("skin_id"));
                Order order = customerDao.getCartNotPaid();
                if (order == null) {
                    order = customerDao.addCart();
                    customerDao.addToCart();
                }
                break;
            case "skin-detail":
                break;
            default:
                getAllSkin(req, resp);
        }
    }

    private void getAllSkin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Skin> skins = customerDao.getAllSkin();
        req.setAttribute("skins", skins);
        req.setAttribute("CHAMPION_IMAGE_PATH", CHAMPION_IMAGE_PATH);
        req.getRequestDispatcher("view/home.jsp").forward(req, resp);
    }
}