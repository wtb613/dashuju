package com.offcn.servlet;

import com.offcn.bean.Product;
import com.offcn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    @Autowired
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    private static Map<Product, Integer> cart = new HashMap<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if ("addCart".equals(method)){
            addProductToCart(request,response);
        }else if ("deleteCartById".equals(method)){
            deleteCartById(request,response);
        }
    }

    private void deleteCartById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession();
        Map<Product,Integer> cart = (Map<Product,Integer>)session.getAttribute("cart");
        String proId = request.getParameter("proId");

        int sum = (int)session.getAttribute("sum");
        Set<Product> products = cart.keySet();
        for (Product pro : products){
            if (pro.getPro_id() == Integer.parseInt(proId)){
                sum -=pro.getShop_price()*cart.get(pro);
                cart.remove(pro);
                break;
            }
        }
        session.setAttribute("sum",sum);
        response.sendRedirect("JSP/cart.jsp");
    }

    private void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productId = request.getParameter("productId");
        String count = request.getParameter("quantity");

        Product product = productService.selectById(productId);

        //要根据id判断是不是同一个product 不同的product对象地址不一样
        Set<Product> set = cart.keySet();
        boolean flag = false;
        for (Product pro : set){
            if (pro.getPro_id()==product.getPro_id()){
                flag = true;
                cart.put(pro,cart.get(pro)+Integer.parseInt(count));
                break;
            }
        }
        if (!flag){
            cart.put(product,Integer.parseInt(count));
        }

        //  获取购物车总钱数
        int sum = 0;
        for (Product pro : set){
            sum += pro.getShop_price()*cart.get(pro);
        }

        HttpSession session = request.getSession();
        session.setAttribute("cart",cart);
        session.setAttribute("sum",sum);

        response.sendRedirect("JSP/cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
