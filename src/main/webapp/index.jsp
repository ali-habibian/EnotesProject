<%@ page import="java.sql.Connection" %>
<%@ page import="io.github.alihabibian.enotsproject.db.DbConnect" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .back-img {
            background-image: url("https://i.postimg.cc/NfngNyzs/background.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            width: 100%;
            height: 80vh;
        }
    </style>
    <title>Home Page</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>

<%
    Connection conn = DbConnect.getConn();
    System.out.println(conn);
%>

<div class="container-fluid back-img">
    <div class="text-center">
        <h1 class="text-white"><i class="fa fa-book" aria-hidden="true"></i> E-Notes Save Your Notes</h1>
        <a href="login.jsp" class="btn btn-light"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Login</a>
        <a href="register.jsp" class="btn btn-light"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a>
    </div>
</div>

<%@include file="all_component/footer.jsp" %>
</body>
</html>