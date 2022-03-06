<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin Details</title>
</head>


</form>

<h3>User Details</h3>

<form method="get" action="/admin/admin">

<table class= "table-striped table" border="1" cellpadding="2" cellspacing="2">
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>First Name</th>
        <th>Last name</th>
        <th>Password</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
    <form method="get" action="/admin/admin">

<jsp:include page="../include/footer.jsp" />