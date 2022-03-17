<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Account</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="mt-5">
    <h1>Admin Accounts</h1>

    <table class="table mt-5 table-light table-striped table-hover caption-top align-middle">
        <thead class="table-dark">
            <tr>
                <th class="col-2">ID</th>
                <th class="col-2">USERNAME</th>
                <th class="col-5">ACTION</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${adminList}" var="admin">
            <tr>
                <th scope="row">${admin.id}</th>
                <td>${admin.username}</td>
                <td>
<%--                    <form class="col-12" action="/admin/removeAccount" method="post">--%>
<%--                        <input hidden name="adminId" value="${admin.id}">--%>
<%--                        <button class="btn btn-danger m-1 p-0 col-5" type="submit">Delete Admin</button>--%>
<%--                    </form>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot class="table-dark">
            <tr>
                <th class="col-2">ID</th>
                <th class="col-2">USERNAME</th>
                <th class="col-5">ACTION</th>
            </tr>
        </tfoot>
    </table>
</div>


<div class="mt-5">
    <h1>User Accounts</h1>

    <table class="table mt-5 table-light table-striped table-hover caption-top align-middle">
        <thead class="table-dark">
            <tr>
                <th class="col-2">ID</th>
                <th class="col-2">USERNAME</th>
                <th class="col-5">ACTION</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.username}</td>
                <td>
                    <form class="col-12" action="/admin/removeUser" method="post">
                        <input hidden name="userId" value="${user.id}">
                        <button class="btn btn-danger m-1 p-0 col-5" type="submit">Delete User</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot class="table-dark">
            <tr>
                <th class="col-2">ID</th>
                <th class="col-2">USERNAME</th>
                <th class="col-5">ACTION</th>
            </tr>
        </tfoot>
    </table>
</div>

    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
