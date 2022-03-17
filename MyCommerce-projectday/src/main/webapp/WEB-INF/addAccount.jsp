<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Account</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="mt-5">

    <h1>Create an Account</h1>

    <c:if test="${not empty message}">
    <div class="alert alert-danger" role="alert">
        <h3><c:out value="${message}"></c:out></h3>
    </div>
    </c:if>

    <form class="col-3 mt-5" action="/add-account" method="post">
        <div class="mb-3">
            <label class="form-label" for="name">Username</label>
            <input class="form-control" id="name" type="text" name="username">
        </div>

        <div class="mb-3">
            <label class="form-label" for="price">Password</label>
            <input class="form-control" id="price" type="text" name="password">
        </div>



        <button class="btn btn-primary btn-lg mt-5" type="submit">Create Account</button>
    </form>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
