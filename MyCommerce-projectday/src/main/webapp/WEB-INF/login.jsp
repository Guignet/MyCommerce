<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="mt-5">
    <h1>Log in</h1>

    <form class="col-3 mt-5" action="login" method="post">

        <div class="mb-3">
            <label class="form-label" for="usernameInput">UserName</label>
            <input class="form-control" id="usernameInput" type="text" name="username">
        </div>

        <div class="mb-3">
            <label class="form-label" for="passwordInput">Password</label>
            <input class="form-control" id="passwordInput" type="text" name="password">
        </div>

        <button type="submit" class="btn btn-primary btn-lg mt-5 ">Log in</button>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
