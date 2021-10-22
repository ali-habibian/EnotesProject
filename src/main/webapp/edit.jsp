<%@ page import="io.github.alihabibian.enotsproject.dao.PostDao" %>
<%@ page import="io.github.alihabibian.enotsproject.db.DbConnect" %>
<%@ page import="io.github.alihabibian.enotsproject.model.Post" %><%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/22/2021
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("userD");
    if (user == null) {
        response.sendRedirect("login.jsp");
        session.setAttribute("login-error", "Please login...");
    }
%>
<html>
<head>
    <title>Edit Note</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>

<%
    Integer noteId = Integer.parseInt(request.getParameter("note_id"));
    PostDao postDao = new PostDao(DbConnect.getConn());
    Post post = postDao.getDataById(noteId);
%>

<%@include file="all_component/navbar.jsp" %>
<h1 class="text-center mt-3">Edit Your Note</h1>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form action="NoteEditServlet" method="post" accept-charset="UTF-8">
                    <input type="hidden" value="<%=noteId%>" name="noteId">
                    <div class="form-group">
                        <label for="title">Enter Title</label>
                        <input type="text" class="form-control" id="title" name="title" value="<%=post.getTitle()%>"
                               required="required">
                    </div>
                    <div class="form-group">
                        <label for="content">Enter Content</label>
                        <textarea rows="9" cols="" class="form-control" id="content" name="content"
                                  required="required"><%=post.getContent()%></textarea>
                    </div>
                    <div class="container text-center">
                        <button type="submit" class="btn btn-primary">Add Note</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="all_component/footer.jsp" %>

</body>
</html>
