<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="mt-5">
    <h1>Add Product</h1>

    <form class="col-3 mt-5" action="/admin/add-product" method="post">
        <div class="mb-3">
            <label class="form-label" for="name">Product Name</label>
            <input class="form-control" id="name" type="text" name="pName">
        </div>

        <div class="mb-3">
            <label class="form-label" for="content">Product Content</label>
            <textarea class="form-control" id="content" type="text" name="pContent" rows="3"></textarea>
        </div>

        <div class="mb-3">
            <label class="form-label" for="price">Product Price</label>
            <input class="form-control" id="price" type="number" name="pPrice">
        </div>

        <div class="mb-3">
            <label class="form-label" for="price">Product Category</label>
            <input class="form-control" id="category" type="text" name="pCategory">
        </div>

        <button class="btn btn-primary btn-lg mt-5" type="submit">Add Product</button>
    </form>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
