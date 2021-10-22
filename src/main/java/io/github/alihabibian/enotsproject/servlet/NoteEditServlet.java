package io.github.alihabibian.enotsproject.servlet;

import io.github.alihabibian.enotsproject.dao.PostDao;
import io.github.alihabibian.enotsproject.db.DbConnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NoteEditServlet", value = "/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int noteId = Integer.parseInt(request.getParameter("noteId"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        PostDao postDao = new PostDao(DbConnect.getConn());
        boolean isUpdated = postDao.updatePost(noteId, title, content);
        if (isUpdated) {
            System.out.println("data updated successfully");
            HttpSession session = request.getSession();
            session.setAttribute("updateMsg", "Note update successfully");
            response.sendRedirect("showNotes.jsp");
        } else {
            System.out.println("data not updated");
        }
    }
}
