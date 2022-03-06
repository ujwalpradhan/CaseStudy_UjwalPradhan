<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<table class="table striped table" cellpadding="2" cellspacing="2" border="1">
    <tr>
        <th>Option</th>
        <th>Id</th>
        <th>Name</th>
        <th>Product Image</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Sub Total</th>
    </tr>
    <c:set var="total" value="0"></c:set>
    <c:forEach var="item" items="${cart}">
        <c:set var="total" value="${total + item.product.price * item.quantity }"></c:set>
        <tr>
<%--            <td align="center">--%>
<%--                <a href="${pageContext.request.contextPath }/cart?action=remove&id=${item.product.id }"--%>
<%--                   onclick="return confirm('Are you sure?')">Remove</a>--%>
<%--            </td>--%>
            <td>${item.product.id }</td>
            <td>${item.product.productName }</td>
            <td>
                <img style="width: 200px" src="<c:url value='${item.product.imageUrl}'/>">
            </td>
            <td>${item.product.price }</td>
            <td>${item.quantity }</td>
            <td>${item.product.price * item.quantity }</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" align="right">Total</td>
        <td>${total }</td>
    </tr>
</table>
<br>
<a href="${pageContext.request.contextPath }/product">Checkout</a>

<jsp:include page="../include/footer.jsp" />