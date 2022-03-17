package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/addCategory")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ef = req.getParameter("ef");
        if(ef!=null){
            req.setAttribute("message","Already exist");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addCategory.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("pName");


        Category newCategory = new Category(categoryName);
        boolean existflag = false;
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        for (Category c:categoryDao.findAll()) {
            if(c.getName().equals(newCategory.getName())){
                existflag = true;
            }
        }
            if(existflag){
                resp.sendRedirect("/admin/addCategory?ef=true");
            }else{
                int id = categoryDao.add(newCategory);
                resp.sendRedirect(ListCategoryServlet.URL);

            }


    }
}
