package com.offcn.servlet;

import com.offcn.bean.Product;
import com.offcn.service.ProductService;
import com.offcn.service.UserService;
import com.offcn.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Autowired
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if ("selectAllProduct".equals(method)) {
            selectAllProduct(request, response);
        }else if ("getProductById".equals(method)){
            getProductById(request,response);
        }
    }

    private void getProductById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productId = request.getParameter("productId");

        Product product = productService.selectById(productId);

        request.setAttribute("product",product);

        request.getRequestDispatcher("JSP/product_info.jsp").forward(request,response);


    }

    private void selectAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Product> hotList = productService.selectHotProductAll();
        List<Product> youxuanList = productService.selectYouxuanProductAll();


        request.setAttribute("hotList", hotList);
        request.setAttribute("youxuanList", youxuanList);

        request.getRequestDispatcher("JSP/reindex.jsp").forward(request,response);
    }
}
