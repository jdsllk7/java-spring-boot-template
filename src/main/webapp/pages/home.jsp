<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<jsp:include page="header.jsp"/>

<h1>Home</h1>

<c:if test="${empty user}">
    <br>
    <a href="login">Login</a>
    <br>
    <a href="signup">Sign up</a>
</c:if>

<c:if test="${not empty user}">
    <br>
    <a href="about-us">About us</a>
    <br>
    <a href="logout">Logout</a>
</c:if>

<jsp:include page="footer.jsp"/>