<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/7/2021
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<div class="container-fluid">
    <div class="card py-5">
        <div class="card-body text-center">
            <img class="img-fluid mx-auto" src="https://i.postimg.cc/8PvtnMGR/paper.png" style="max-width: 350px;">
            <h1>START TAKING YOUR NOTES</h1>
            <a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
        </div>
    </div>
</div>
<%@include file="all_component/footer.jsp"%>
</body>
</html>
