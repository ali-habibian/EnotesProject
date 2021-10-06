<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/6/2021
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<div class="container-fluid div-color">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card mt-4 mb-3">
                <div class="card-header text-center text-white bg-custom">
                    <i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
                    <h4>Registration</h4>
                </div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="InputFullName">Enter Your Full Name</label>
                            <input type="text" class="form-control" id="InputFullName"
                                   aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                            <label for="InputEmail">Enter Your Email</label>
                            <input type="email" class="form-control" id="InputEmail"
                                   aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                            <label for="InputPassword">Enter Your Password</label>
                            <input type="password" class="form-control" id="InputPassword">
                        </div>

                        <button type="submit" class="btn btn-primary badge-pill btn-block">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>
