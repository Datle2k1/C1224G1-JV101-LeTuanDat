package org.example.casestudymodule3.controller;

import org.example.casestudymodule3.model.Order;
import org.example.casestudymodule3.model.Skin;
import org.example.casestudymodule3.service.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private CustomerDao customerDao;
    private Integer customerId = null;
    private HttpSession session;
    private final String CHAMPION_IMAGE_PATH = "resources/img_skin";

    @Override
    public void init() throws ServletException {
        customerDao = new CustomerDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        String action = req.getParameter("action");

        if (action == null) action = "";

        if (action.isEmpty()) {
            getCart(req, resp);
            session.removeAttribute("isRemove");
            session.removeAttribute("IsPaid");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");

        if (action == null) action = "";

        if (action.equals("remove")) {
            removeSkin(req, resp);
        } else if (action.equals("pay")) {
            pay(req, resp);
        }
    }

    private void pay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerId = (Integer) req.getSession().getAttribute("customerId");
        int order_id = customerDao.getCartNotPaid(customerId).getOrder_id();
        List<Skin> skins = customerDao.getSkinOnCart();

        if (!skins.isEmpty()) {
            boolean isPaid;
            try {
                isPaid = customerDao.payForCart(order_id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            session.setAttribute("IsPaid",isPaid);
            resp.sendRedirect("cart");
        }
    }

    private void removeSkin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        customerId = (Integer) req.getSession().getAttribute("customerId");
        int skin_id = Integer.parseInt(req.getParameter("skin_id"));
        boolean isRemoved = customerDao.removeSkin(skin_id, customerId);
        session.setAttribute("isRemove", isRemoved);
        resp.sendRedirect("cart");
    }

    private void getCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerId = (Integer) req.getSession().getAttribute("customerId");
        if (customerId == null) {
            req.setAttribute("error", "Invalid email or password!");
            req.getRequestDispatcher("login").forward(req, resp);
        } else {
            Order order = customerDao.getCartNotPaid(customerId);
            if (order == null) {
                customerDao.addNewCart(customerId);
                order = customerDao.getCartNotPaid(customerId);
            }

            List<Skin> skins = customerDao.getSkinOnCart();
            int totalPrice = customerDao.totalPrice(order.getOrder_id());

            req.setAttribute("skins", skins);
            req.setAttribute("order", order);
            req.setAttribute("totalPrice", totalPrice);
            req.setAttribute("CHAMPION_IMAGE_PATH", CHAMPION_IMAGE_PATH);
            req.getRequestDispatcher(req.getContextPath() + "view/cart.jsp").forward(req, resp);
        }
    }
}
