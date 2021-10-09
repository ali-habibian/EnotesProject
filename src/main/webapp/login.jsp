<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/6/2021
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<div class="container-fluid div-color">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card mt-4 mb-3">
                <div class="card-header text-center text-white bg-custom">
                    <i class="fa fa-user-circle-o fa-3x" aria-hidden="true"></i>
                    <h4>Login Page</h4>
                </div>

                <%
                    String loginFailedMsg = (String) session.getAttribute("login-failed");
                    if (loginFailedMsg != null) {%>
                <div class="alert alert-danger" role="alert">
                    <%=loginFailedMsg%>
                </div>
                <%
                        session.removeAttribute("login-failed");
                    }

                    String withoutLoginMsg = (String) session.getAttribute("login-error");
                    if (withoutLoginMsg != null) {%>
                <div class="alert alert-danger" role="alert"><%=withoutLoginMsg%>
                </div>
                <%
                        session.removeAttribute("login-error");
                    }

                    String logoutMsg = (String) session.getAttribute("logoutMsg");
                    if (logoutMsg != null) {%>
                <div class="alert alert-success" role="alert"><%=logoutMsg%>
                </div>
                <%
                        session.removeAttribute("logoutMsg");
                    }
                %>

                <div class="card-body">
                    <form action="LoginServlet" method="post" accept-charset="UTF-8">
                        <div class="form-group">
                            <label for="InputEmail">Enter Your Email</label>
                            <input type="email" class="form-control" id="InputEmail"
                                   aria-describedby="emailHelp" name="uEmail">
                        </div>
                        <div class="form-group">
                            <label for="InputPassword">Enter Your Password</label>
                            <input type="password" class="form-control" id="InputPassword" name="uPassword">
                        </div>

                        <button type="submit" class="btn btn-primary badge-pill btn-block">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="all_component/footer.jsp" %>

</body>
</html>
