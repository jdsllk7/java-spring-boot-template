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
    <title>java-spring-demo</title>

    <%--css--%>
    <link rel="stylesheet" href="<c:url value="/sweetalert/css/sweetalert.css"/>">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

</head>

<body>

<c:if test="${not empty user}">
Welcome ${user.email}
</c:if>

