<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../css/style.css">

<div class="entete">

    <header class="row">
        <div class="col-6 ">
            <h1 class="ms-5">LevelUp! Store</h1>
        </div>
        <!-- <div class="col-4 tilt">
            <img class="" src="img/up_arrow2.png" alt="">
        </div> -->
    </header>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">

            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

                <li class="nav-item">
                    <a class="btn nav-link btn-grad" aria-current="page" href="/home">Home</a>
                </li>

                <li class="nav-item">
                    <a class="btn nav-link btn-grad" aria-current="page" href="/list-product">See products</a>
                </li>

                <li class="nav-item">
                    <a class="btn nav-link btn-grad" aria-current="page" href="/list-category">See categories</a>
                </li>


                <c:choose>
                    <c:when test="${empty sessionScope.user and empty sessionScope.admin}">
                        <li class="nav-item">
                            <a class="btn nav-link btn-grad" aria-current="page" href="/login">Login</a>
                        </li>

                        <li class="nav-item">
                            <a class="btn nav-link btn-grad" aria-current="page" href="/add-account">Create an Account</a>
                        </li>

                    </c:when>
                    <c:otherwise>

<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" aria-current="page" href="/auth/basic-insert">Basic Insert</a>--%>
<%--                    </li>--%>

                        <li class="nav-item">
                            <a class="btn nav-link btn-grad" aria-current="page" href="/logout">Logout</a>
                        </li>

                    </c:otherwise>
                </c:choose>

                <c:if test="${not empty sessionScope.admin}">

                    <li class="nav-item">
                        <a class="btn nav-link btn-grad" aria-current="page" href="/admin/add-product">Add product</a>
                    </li>

                    <li class="nav-item">
                        <a class="btn nav-link btn-grad" aria-current="page" href="/admin/addCategory">Add category</a>
                    </li>

                    <li class="nav-item">
                        <a class="btn nav-link btn-grad" aria-current="page" href="/add-account">Add Account</a>
                    </li>

                    <li class="nav-item">
                        <a class="btn nav-link btn-grad" aria-current="page" href="/admin/list-account">See Accounts</a>
                    </li>

                </c:if>
                <c:if test="${not empty sessionScope.user}">

<%--                    <button type="button" class="btn btn-primary position-relative">--%>
<%--                        Inbox--%>
<%--                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">--%>
<%--                            99--%>
<%--                        </span>--%>
<%--                    </button>--%>

                    <li class="nav-item">
                        <a class="btn nav-link btn-grad position-relative" aria-current="page" href="/user/show-cart">
                            Cart
                            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-primary">
                            <c:out value="${sessionScope.user.cart.size()}"></c:out>
                            </span>
                        </a>
                    </li>

                </c:if>

            </ul>
        </div>
    </nav>


</div>





