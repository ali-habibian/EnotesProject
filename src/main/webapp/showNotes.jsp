<%@ page import="io.github.alihabibian.enotsproject.dao.PostDao" %>
<%@ page import="io.github.alihabibian.enotsproject.db.DbConnect" %>
<%@ page import="io.github.alihabibian.enotsproject.model.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/21/2021
  Time: 12:10 AM
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
    <title>Show Notes</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<%
    String updateMsg = (String) session.getAttribute("updateMsg");
    if (updateMsg != null) {
%>
<div class="alert alert-success" role="alert"><%=updateMsg%></div>
<%
        session.removeAttribute("updateMsg");
    }
%>

<%
    String wrongMsg = (String) session.getAttribute("wrongMsg");
    if (wrongMsg != null) {
%>
<div class="alert alert-danger" role="alert"><%=wrongMsg%></div>
<%
        session.removeAttribute("wrongMsg");
    }
%>

<div class="container">
    <h2 class="text-center">All Notes:</h2>
    <div class="row">
        <div class="col-md-12">
            <%
                if (user != null) {
                    PostDao postDao = new PostDao(DbConnect.getConn());
                    List<Post> posts = postDao.getData(user.getId());
                    for (Post post : posts) {
            %>
            <div class="card mt-3">
                <img src="img/paper.png" class="card card-img-top mt-2 mx-auto" style="max-width: 100px;" alt="">

                <div class="card-body p-4">

                    <h5 class="card-title"><%=post.getTitle()%>
                    </h5>
                    <p><%=post.getContent()%>
                    </p>

                    <p>
                        <b class="text-success">Published By: </b><br><b class="text-primary"><%=user.getName()%>
                    </b>
                    </p>
                    <p>
                        <b class="text-success">Published Date: </b><br><b class="text-success"><%=post.getpDate()%>
                    </b>
                    </p>

                    <div class="container text-center mt-2">
                        <a href="DeleteServlet?note_id=<%=post.getId()%>" class="btn btn-danger">Delete</a>
                        <a href="edit.jsp?note_id=<%=post.getId()%>" class="btn btn-primary">Edit</a>
                    </div>

                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
