package io.github.alihabibian.enotsproject.servlet;

import io.github.alihabibian.enotsproject.dao.UserDao;
import io.github.alihabibian.enotsproject.db.DbConnect;
import io.github.alihabibian.enotsproject.user.UserDetails;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("uEmail");
        String password = request.getParameter("uPassword");

        UserDetails userDetails = new UserDetails();
        userDetails.setEmail(email);
        userDetails.setPassword(password);

        UserDao dao = new UserDao(DbConnect.getConn());
        UserDetails user = dao.loginUser(userDetails);

        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("userD", user);
            response.sendRedirect("home.jsp");
        } else {
            session.setAttribute("login-failed", "Invalid Email or Password...");
            response.sendRedirect("login.jsp");
        }
    }
}
