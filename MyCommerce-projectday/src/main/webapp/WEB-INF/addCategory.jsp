<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="mt-5">
    <h1>Add Category</h1>

    <c:if test="${not empty message}">
        <div class="alert alert-danger" role="alert">
            <h3><c:out value="${message}"></c:out></h3>
        </div>
    </c:if>

    <form  class="col-3 mt-5" action="/admin/addCategory" method="post">

        <div class="mb-3">
            <label class="form-label" for="name">Category Name</label>

            <input class="form-control" id="name" type="text" name="pName">

        </div>

        <button type="submit" class="btn btn-primary btn-lg mt-5">Add Category</button>

    </form>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
