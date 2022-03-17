package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.AdminDao;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.dao.base.UserDao;
import com.mycommerce.project.model.Admin;
import com.mycommerce.project.model.Product;
import com.mycommerce.project.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = ListAccountServlet.URL)
public class ListAccountServlet extends HttpServlet {
    public final static String URL = "/admin/list-account";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetching all Account
        AdminDao adminDao = DaoFactory.getAdminDao();
        List<Admin> adminList = adminDao.findAll();
        UserDao userDao = DaoFactory.getUserDao();
        List<User> userList = userDao.findAll();

        // Passing data in view
        req.setAttribute("adminList", adminList);
        req.setAttribute("userList", userList);

        // Forwarding/Displaying listProduct JSP
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listAccount.jsp");
        rd.forward(req, resp);
    }
}
