<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 10/9/2021
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Notes</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<h1 class="text-center mt-3">Add Your Notes</h1>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form action="AddNotesServlet" method="post" accept-charset="UTF-8">
                    <div class="form-group">

                        <input type="hidden" value="<%=user.getId()%>" name="uid">

                        <label for="title">Enter Title</label>
                        <input type="text" class="form-control" id="title" name="title" required="required">
                    </div>
                    <div class="form-group">
                        <label for="content">Enter Content</label>
                        <textarea rows="9" cols="" class="form-control" id="content" name="content"
                                  required="required"></textarea>
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
