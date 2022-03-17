<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<c:if test="${ERROR_TYPE_ID_PRODUCT}">
    <p>product id must be an integer</p>
</c:if>

<c:if test="${ERROR_UNKNOWN_PRODUCT}">
    <p>Product does not exist</p>
</c:if>

<c:if test="${not empty product}">
    <table  class="table mt-5 table-light table-striped table-hover caption-top align-middle">
        <thead class="table-dark">
            <tr>
                <th class="col-1">ID</th>
                <th class="col-2">NAME</th>
                <th class="col-4">CONTENT</th>
                <th class="col-1">PRICE</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">${product.id}</th>
                <td>${product.name}</td>
                <td>${product.content}</td>
                <td>${product.price}</td>
            </tr>
        </tbody>
    </table>
</c:if>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
