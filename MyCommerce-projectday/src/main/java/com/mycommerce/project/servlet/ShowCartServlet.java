package com.mycommerce.project.servlet;

import com.mycommerce.project.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show-cart")
public class ShowCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        req.setAttribute("cart",user.seeCart());
        req.setAttribute("total",user.getTotal());
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/showCart.jsp");
        rd.forward(req, resp);
    }
}
