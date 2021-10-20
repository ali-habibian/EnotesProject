package io.github.alihabibian.enotsproject.servlet;

import io.github.alihabibian.enotsproject.dao.PostDao;
import io.github.alihabibian.enotsproject.db.DbConnect;
import io.github.alihabibian.enotsproject.model.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddNotesServlet", value = "/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int uid = Integer.parseInt(request.getParameter("uid"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        PostDao dao = new PostDao(DbConnect.getConn());
        boolean isAdded = dao.addNote(title, content, uid);

        if (isAdded) {
            System.out.println("Data is Added");
            response.sendRedirect("showNotes.jsp");
        } else
            System.out.println("Data not added");
    }
}
