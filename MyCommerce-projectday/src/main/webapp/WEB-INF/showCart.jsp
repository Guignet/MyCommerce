<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

    <c:if test="${ empty cart}">
    <div class="alert alert-info" role="alert">
        <h2>Your Cart is empty</h2>
    </div>
    </c:if>



<c:if test="${not empty cart}">
    <table  class="table mt-5 table-light table-striped table-hover caption-top align-middle">
        <thead class="table-dark">
            <tr>
                <th class="col-1">ID</th>
                <th class="col-2">NAME</th>
                <th class="col-3">CONTENT</th>
                <th class="col-2">PRICE</th>
                <th class="col-2">ACTION</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${cart}" var="product">
            <tr>
                <th scope="row">${product.id}</th>
                <td>${product.name}</td>
                <td>${product.content}</td>
                <td>${product.price}</td>
                <c:if test="${not empty sessionScope.user}">
                <td>
                    <form class="col-12" action="/user/removeFromCart" method="post">
                        <input hidden name="productId" value="${product.id}">
                        <button class="btn btn-danger m-1 p-0 col-7" type="submit">Remove From Cart</button>
                    </form>
                </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot class="table-dark">
            <tr>
                <th class="col-1"></th>
                <th class="col-2"></th>
                <th class="col-3">TOTAL PRICE</th>
                <th class="col-2"><c:out value="${total}"></c:out></th>
                <th class="col-2"><a class="btn btn-success btn-lg m-1 col-9" href="">Pay Cart</a></th>
            </tr>
        </tfoot>
    </table>
</c:if>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
