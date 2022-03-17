package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(RemoveCategoryServlet.URL)
public class RemoveCategoryServlet extends HttpServlet {
    public final static String URL = "/admin/removeCategory";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("categoryId");
        try {
            int id = Integer.parseInt(idStr);
            CategoryDao dao = DaoFactory.getCategoryDao();
            ProductDao pdao = DaoFactory.getProductDao();
            for (Product p : pdao.getAllProducts()){
                if(p.getCategory().getId()==id){
                    p.setCategory(null);
                }
            }
            dao.removeById(id);

            resp.sendRedirect(ListCategoryServlet.URL);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
