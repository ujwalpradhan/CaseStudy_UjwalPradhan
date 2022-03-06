<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<h1>Our Inventory List</h1>

<div class="container">

<table class="table-striped table-bordered table-hover">
    <tr>
        <td><b>Id</b></td>
        <td><b>Product Name</b></td>
        <td><b>Product Image</b></td>
        <td><b>Price</b></td>


    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td> ${product.id}  </td>
            <td> ${product.productName}  </td>
            <td>
                <c:if test="${not empty product.imageUrl}">
                    <a href="/product/detail?id=${product.id}"><img height="200px" src="${product.imageUrl}"/></a>
                </c:if>
            </td>
            <td> ${product.price}  </td>
            <td align="center">
                <a href="${pageContext.request.contextPath }/cart/buy/${product.id}">Buy Now</a>
            </td>
<%--            <td> <input type="submit" value ="Buy Now" class="btn btn-success"> </td>--%>
        </tr>
    </c:forEach>
</table>
</div>
<br class="mb-5">

<jsp:include page="../include/footer.jsp" />