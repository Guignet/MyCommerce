<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="mt-5">
    <h1>Products</h1>


    <c:if test="${empty productList and not empty sessionScope.admin}">
        <p>no product yet.</p>
        <a href="/admin/add-product">Add product</a>
    </c:if>

    <table class="table mt-5 table-light table-striped table-hover caption-top align-middle">
        <thead class="table-dark">
            <tr>
                <th class="col-1">ID</th>
                <th class="col-2">NAME</th>
                <th class="col-1">PRICE</th>
                <th class="col-2">CATEGORY</th>
                <th class="col-6">ACTIONS</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product">
            <tr>
                <th scope="row">${product.id}</th>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.category.name}</td>
                <td> <a class="btn btn-primary m-1 p-0 col-5" href="/product-details?id=${product.id}">Details</a>
<%--                    </td>--%>
                <c:if test="${not empty sessionScope.admin}">
<%--                        <td>--%>
                        <form class="col-12" action="/admin/removeProduct" method="post">
                            <input hidden name="productId" value="${product.id}">
                            <button class="btn btn-danger m-1 p-0 col-5" type="submit">Delete Product</button>
                        </form>
<%--                        </td>--%>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
<%--                        <td>--%>
                        <form class="col-12" action="/user/addToCart" method="post">
                            <input hidden name="productId" value="${product.id}">
                            <button class="btn btn-success m-1 p-0 col-5" type="submit">Add to Cart</button>
                        </form>

                </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot class="table-dark">
            <tr>
                <th class="col-1">ID</th>
                <th class="col-2">NAME</th>
                <th class="col-1">PRICE</th>
                <th class="col-2">CATEGORY</th>
                <th class="col-6">ACTIONS</th>
            </tr>
        </tfoot>
    </table>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
