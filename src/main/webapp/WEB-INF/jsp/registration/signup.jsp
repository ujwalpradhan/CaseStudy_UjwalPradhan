<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<head>
    <link rel="stylesheet" href="pub/css/signup.css" type="text/css" />
</head>

<div class="register-container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>

<%--    <c:choose>--%>
<%--        <c:when test="${empty formBeanKey.id}">--%>
<%--            <h1>Create New User</h1>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <h1>Edit User</h1>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>

<%--    <form method="GET" action="/signupSubmit">--%>
        <form method="POST" action="/signupSubmit">
            <input type="hidden" name="id" value="${formBeanKey.id}">
        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" id="email" required value="${formBeanKey.email}">

        <label for="firstname"><b>First Name</b></label>
        <input type="text" placeholder="Enter First Name" name="firstName" id="firstname" required value="${formBeanKey.firstName}">

        <label for="lastname"><b>Last Name</b></label>
        <input type="text" placeholder="Enter Last Name" name="lastName" id="lastname" required value="${formBeanKey.lastName}">

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" id="psw" required value="${formBeanKey.psw}">

        <label for="pswrepeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="pswrepeat" id="pswrepeat" required value="${formBeanKey.pswrepeat}">
        <hr>
        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

        <button type="submit" class="registerbtn">Register</button>


    <div class="container signin">
    <p>Already have an account? <a href="login.html">Sign in</a>.</p>
    </div>
    </form>
</div>

<jsp:include page="../include/footer.jsp" />