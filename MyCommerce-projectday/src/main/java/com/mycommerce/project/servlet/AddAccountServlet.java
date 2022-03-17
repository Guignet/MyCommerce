package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.AdminDao;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.UserDao;
import com.mycommerce.project.model.Admin;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-account")
public class AddAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ef = req.getParameter("ef");
        if(ef!=null){
            req.setAttribute("message","Already exist");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addAccount.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User user = new User(username,password);
        boolean existflag = false;
        UserDao userDao = DaoFactory.getUserDao();
        AdminDao adminDao = DaoFactory.getAdminDao();
        for (User c:userDao.findAll()) {
            if(c.getUsername().equals(username)){
                existflag = true;
            }
        }
        for (Admin c:adminDao.findAll()) {
            if(c.getUsername().equals(username)){
                existflag = true;
            }
        }
        if(existflag){
            resp.sendRedirect("/add-account?ef=true");
        }else{
            int id = userDao.add(user);
            if(req.getSession().getAttribute("admin")!=null)
                resp.sendRedirect(ListAccountServlet.URL);
            else
            resp.sendRedirect("/login");

        }
    }
}
