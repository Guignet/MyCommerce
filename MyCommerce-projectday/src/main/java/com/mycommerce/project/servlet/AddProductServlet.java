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

@WebServlet("/admin/add-product")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("pName");
        String productContent = req.getParameter("pContent");
        String productPriceStr = req.getParameter("pPrice");
        String productCategory = req.getParameter("pCategory");

        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        ProductDao productDao = DaoFactory.getProductDao();

        try {
            Product newProduct = null;
            float productPrice = Float.parseFloat(productPriceStr);
            if(productCategory==null)
            newProduct = new Product(productName, productContent, productPrice);
            else{
                boolean flag = true;
                for(Category c : categoryDao.findAll()){
                    if(c.getName().equals(productCategory)){
                        newProduct = new Product(productName, productContent, productPrice,c);
                        flag =false;
                    }
                }
                if(flag){
                    newProduct = new Product(productName, productContent, productPrice,new Category(productCategory));
                    categoryDao.add(newProduct.getCategory());
                }
            }
            Long id=null;
            if(newProduct!=null)
            id = productDao.addProduct(newProduct);

            //.add(newProduct.getCategory());


            resp.sendRedirect(ShowProductServlet.URL + "?id=" + id);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
