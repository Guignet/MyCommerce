<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<table class="table mt-5 table-light table-striped table-hover caption-top align-middle">

    <thead class="table-dark">
    <tr>
        <th class="col-12">
            PRODUCTS
        </th>
    </tr>
    </thead>


    <tbody>
    <tr>
        <td class="d-flex flex-row ">
            <a class="btn btn-primary m-1 btn-lg col-2" href="/list-product">See Products</a>
            <c:if test="${not empty sessionScope.admin}">
                <a class="btn btn-primary m-1 btn-lg col-2" href="/admin/add-product">Add Product</a>
            </c:if>
        </td>
    </tr>

    </tbody>

</table>

<table class="table mt-5 table-light table-striped table-hover caption-top align-middle">

    <thead class="table-dark">
    <tr>
        <th class="col-12">
            CATEGORIES
        </th>
    </tr>
    </thead>


    <tbody>
    <tr>
        <td class="d-flex flex-row ">
            <a class="btn btn-primary m-1 btn-lg col-2" href="/list-category">See Categories</a>
            <c:if test="${not empty sessionScope.admin}">
                <a class="btn btn-primary m-1 btn-lg col-2" href="/admin/addCategory">Add Category</a>
            </c:if>
        </td>
    </tr>

    </tbody>

</table>
<c:if test="${not empty sessionScope.admin}">
    <table class="table mt-5 table-light table-striped table-hover caption-top align-middle">

        <thead class="table-dark">
        <tr>
            <th class="col-12">
                ACCOUNTS
            </th>
        </tr>
        </thead>


        <tbody>
        <tr>
            <td class="d-flex flex-row ">
                <a class="btn btn-primary m-1 btn-lg col-2" href="/admin/list-account">Manage Accounts</a>
            </td>
        </tr>

        </tbody>

    </table>
</c:if>
