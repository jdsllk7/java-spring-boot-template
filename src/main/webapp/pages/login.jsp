<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="<c:url value="/img/logo.png" />" type="image/x-icon">
    <title>Login</title>

    <%--css--%>
    <link rel="stylesheet" href="<c:url value="/sweetalert/css/sweetalert.css"/>">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

</head>

<body>

<div>

    <h1>Login</h1>

    <form id="LoginForm">

        <input type="username" name="username" placeholder="Email / Phone Number"><br>

        <input type="password" name="password" placeholder="Password"><br>

        <button type="submit">Login</button>

    </form>

    <br>
    <br>
    <a href="home">Home</a> <a href="signup">Signup</a>

</div>

</body>

<script src="<c:url value="/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/sweetalert/js/sweetalert.min.js"/>"></script>
<script src="<c:url value="/js/login.js"/>"></script>

</html>