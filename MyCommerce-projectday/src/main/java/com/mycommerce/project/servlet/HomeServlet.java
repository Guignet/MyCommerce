package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.model.Admin;
import com.mycommerce.project.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"", "/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        request.setAttribute("titlePage", "Home Page");

//        DaoFactory.getAdminDao().add(new Admin("sudo","sudo"));
//        DaoFactory.getAdminDao().add(new Admin("sudoku","sudoku"));
//        DaoFactory.getUserDao().add(new User("user","user"));
//        DaoFactory.getUserDao().add(new User("Copkorn",""));
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
        rd.forward(request, resp);
    }
}
