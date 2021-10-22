package io.github.alihabibian.enotsproject.servlet;

import io.github.alihabibian.enotsproject.dao.PostDao;
import io.github.alihabibian.enotsproject.db.DbConnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noteId = Integer.parseInt(request.getParameter("note_id"));
        PostDao postDao = new PostDao(DbConnect.getConn());
        boolean isDeleted = postDao.deleteNote(noteId);

        HttpSession session = request.getSession();
        if (isDeleted) {
            session.setAttribute("updateMsg", "Note deleted successfully");
        } else {
            session.setAttribute("wrongMsg", "Something went wrong on server");
        }
        response.sendRedirect("showNotes.jsp");
    }
}
