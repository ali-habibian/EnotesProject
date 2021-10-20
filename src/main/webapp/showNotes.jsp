<%--
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

<div class="container">
    <h2 class="text-center">All Notes:</h2>
    <div class="row">
        <div class="col-md-12">
            <div class="card mt-3">
                <img src="img/paper.png" class="card card-img-top mt-2 mx-auto" style="max-width: 100px;" alt="">

                <div class="card-body p-4">
                    <h5 class="card-title">What is java?</h5>
                    <p>Java is awesome language</p>

                    <p>
                        <b class="text-success">Published By: </b><br><b class="text-primary">Ali Habibian</b>
                    </p>
                    <p>
                        <b class="text-success">Published Date: </b><br><b class="text-success">2021/06/03</b>
                    </p>

                    <div class="container text-center mt-2">
                        <a href="DeleteServlet?note_id=" class="btn btn-danger">Delete</a>
                        <a href="edit.jsp?note_id=" class="btn btn-primary">Edit</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
