package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;
import com.offcn.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if ("register".equals(method)){
            register(request,response);
        }else if ("login".equals(method)){
            login(request,response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(username, password);
        if (user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("JSP/index.jsp");
        }else {
            response.sendRedirect("JSP/login.jsp?msg=loginerror");
        }

    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");

        User user = new User();

        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setSex(sex);
        user.setBirthday(DateUtils.stringToDate(birthday));

        int i = userService.AddUser(user);

        if (i>0){
            response.sendRedirect("JSP/login.jsp");
        }else{
            response.sendRedirect("JSP/register.jsp");
        }
    }
}
