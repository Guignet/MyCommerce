<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="mt-5">
    <h1>Categories</h1>


    <c:if test="${empty categoryList and not empty sessionScope.admin}">
        <p>no category yet.</p>
        <a href="/admin/addCategory">Add category</a>
    </c:if>

    <table  class="table mt-5 table-light table-striped table-hover caption-top align-middle">
        <thead class="table-dark">
            <tr>
                <th class="col-1">ID</th>
                <th class="col-1">NAME</th>
                <th  class="col-2">ACTIONS</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${categoryList}" var="category">
            <tr>
                <th scope="row">${category.id}</th>
                <td>${category.name}</td>
                <c:if test="${not empty sessionScope.admin}">
                    <td>
                        <form class="col-12" action="/admin/removeCategory" method="post">
                            <input hidden name="categoryId" value="${category.id}">
                            <button class="btn btn-danger m-1 p-0 col-5" type="submit">Delete Category</button>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot class="table-dark">
            <tr>
                <th class="col-1">ID</th>
                <th class="col-1">NAME</th>
                <th  class="col-2">ACTIONS</th>
            </tr>
        </tfoot>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
