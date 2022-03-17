package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/removeFromCart")
public class RemoveFromCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("productId");
        try {
            Long id = Long.parseLong(idStr);
            User user = (User)req.getSession().getAttribute("user");
            user.seeCart().remove(DaoFactory.getProductDao().findProductById(id));

            resp.sendRedirect("/user/show-cart");

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
