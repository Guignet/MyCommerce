package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.AdminDao;
import com.mycommerce.project.dao.base.UserDao;
import com.mycommerce.project.model.Admin;
import com.mycommerce.project.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(LoginServlet.URL)
public class LoginServlet extends HttpServlet {

    public final static String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = DaoFactory.getUserDao();
        AdminDao adminDao = DaoFactory.getAdminDao();

        int resIdAdmin=adminDao.findByUsername(username);
        int resIdUser=userDao.findByUsername(username);
        System.out.println(resIdUser + " " + resIdAdmin);
        if (resIdAdmin==-1) {
            if(resIdUser==-1){
                resp.sendRedirect(LoginServlet.URL);
            }else{
                User user = userDao.findOne(resIdUser);
                if(password.equals(user.getPassword())){
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("user", user);

                    resp.sendRedirect("/home");
                }
                else{
                    resp.sendRedirect(LoginServlet.URL);
                }
            }
        } else {
            Admin admin = adminDao.findOne(resIdAdmin);
            if(password.equals(admin.getPassword())){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("admin", admin);

                resp.sendRedirect("/home");
            }else
                resp.sendRedirect(LoginServlet.URL);
        }


    }
}
