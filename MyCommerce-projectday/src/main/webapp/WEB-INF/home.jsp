<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>


</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>${titlePage}</h1>

<%--<a href="/list-product">List product</a>--%>
<%--<a href="/login">Login</a>--%>
<%--<a href="/auth/basic-insert">Add product</a>--%>


    <jsp:include page="admin.jsp"></jsp:include>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
