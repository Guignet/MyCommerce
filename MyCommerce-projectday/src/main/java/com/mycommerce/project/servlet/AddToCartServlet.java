package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Product;
import com.mycommerce.project.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/addToCart")
public class AddToCartServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("productId");
        User user = (User)req.getSession().getAttribute("user");
        try {
            Long id = Long.parseLong(idStr);
            ProductDao dao = DaoFactory.getProductDao();
            Product p = dao.findProductById(id);
            user.addToCart(p);
            resp.sendRedirect(ListProductServlet.URL);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
