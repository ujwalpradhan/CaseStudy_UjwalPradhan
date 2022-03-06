<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<jsp:include page="../include/header.jsp" />

<head>
    <link rel="stylesheet" href="pub/css/signup.css" type="text/css" />
</head>

<%--&lt;%&ndash;<div class="createProduct-container">&ndash;%&gt;--%>
<%--    <h3>Create Product</h3>--%>
<%--    <p>Please fill in this form to add a new product.</p>--%>

    <c:choose>
        <c:when test="${empty formBeanKey.id}">
            <h1>Create New Product</h1>
        </c:when>
        <c:otherwise>
            <h1>Edit Product</h1>
        </c:otherwise>
    </c:choose>

    <form method="POST" action="/createSubmit">
        <input type="hidden" name="id" value="${formBeanKey.id}">
        <label for="category"><b>Category</b></label>
        <input type="text" placeholder="Enter Category" name="category" id="category" required value="${formBeanKey.category}">

        <label for="imageUrl"><b>Image Url</b></label>
        <input type="text" placeholder="Enter Image Url" name="imageUrl" id="imageurl"  value="${formBeanKey.imageUrl}">

        <label for="productName"><b>Product Name</b></label>
        <input type="text" placeholder="Product Name" name="productName" id="productname" required value="${formBeanKey.productName}">

        <label for="price"><b>Price</b></label>
        <input type="text" placeholder="Enter Price" name="price" id="price" required value="${formBeanKey.price}">


        <button type="submit" class="registerbtn">Add Product</button>


        <div class="container signin">
            <p>Already have an account? <a href="login.html">Sign in</a>.</p>
        </div>
    </form>
<%--</div>--%>

<jsp:include page="../include/footer.jsp" />