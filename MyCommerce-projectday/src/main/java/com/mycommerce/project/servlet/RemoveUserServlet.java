package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.dao.base.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/removeUser")
public class RemoveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("userId");
        try {
            int id = Integer.parseInt(idStr);
            UserDao dao = DaoFactory.getUserDao();
            dao.removeById(id);

            resp.sendRedirect(ListAccountServlet.URL);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
