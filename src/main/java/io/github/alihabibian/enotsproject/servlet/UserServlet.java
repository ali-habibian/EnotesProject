package io.github.alihabibian.enotsproject.servlet;

import io.github.alihabibian.enotsproject.dao.UserDao;
import io.github.alihabibian.enotsproject.db.DbConnect;
import io.github.alihabibian.enotsproject.user.UserDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fName");
        String email = request.getParameter("uEmail");
        String password = request.getParameter("uPassword");

        UserDetails userDetails = new UserDetails();
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setPassword(password);

        UserDao dao = new UserDao(DbConnect.getConn());
        boolean isAdded = dao.addUser(userDetails);

        HttpSession session;
        if (isAdded){
            session = request.getSession();
            session.setAttribute("reg-success", "Registration Successfully...");
            response.sendRedirect("register.jsp");
        }else {
            session = request.getSession();
            session.setAttribute("reg-failed", "Something went wrong on server...");
            response.sendRedirect("register.jsp");
        }
    }
}
