<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<h3>Product Search Page</h3>
<div class="searchbar">
<form method="get" action="/productList">
    <input type="text" name="search" placeholder="Product Name" value="${searchInput}">
    <button type="submit">Search</button>
</form>
</div>

<table class="table-striped table" border="1">
    <tr>
        <td><b>Id</b></td>
        <td><b>Category</b></td>
        <td><b>Product Name</b></td>
        <td><b>Image URL</b></td>
        <td><b>Price</b></td>
        <!-- <td><b>Edit</b></td> -->
        <!-- <td><b>Delete</b></td> -->
    </tr>
    <c:forEach items="${productListKey}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.category}</td>
            <td>${product.productName}</td>
            <td>${product.imageUrl}</td>
            <td>${product.price}</td>
            <td><a class="btn btn-primary"  role="button" href="/createProduct?id=${product.id}">Edit</a></td>
            <td><a class="btn btn-danger" role="button" href="/deleteProduct?id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />