package io.github.alihabibian.enotsproject.servlet;

import io.github.alihabibian.enotsproject.dao.UserDao;
import io.github.alihabibian.enotsproject.db.DbConnect;
import io.github.alihabibian.enotsproject.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("fName");
        String email = request.getParameter("uEmail");
        String password = request.getParameter("uPassword");

        User userDetails = new User();
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setPassword(password);

        UserDao dao = new UserDao(DbConnect.getConn());
        boolean isRegistered = dao.registerUser(userDetails);

        HttpSession session = request.getSession();
        if (isRegistered) {
            session.setAttribute("reg-success", "Registration Successfully...");
        } else {
            session.setAttribute("reg-failed", "Something went wrong on server...");
        }
        response.sendRedirect("register.jsp");
    }
}
