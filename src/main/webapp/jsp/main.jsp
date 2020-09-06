<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.servlets.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    <%@include file="/css/styles.css"%>
</style>
<html>
<head>
    <title>My Servlet Site</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            Please send text!
        </div>
        <form method="post" action="/">
            <label for="firstName">FirstName
                <input class="input-field" type="text" id="firstName" name="firstName">
            </label>
            <label for="lastName">LastName
                <input class="input-field" type="text" id="lastName" name="lastName">
<%--                <textarea rows="10" cols="45" type="text" id="lastName" name="lastName" class="input-field"></textarea>--%>
            </label>
            <input type="submit" value="Sign Up">
        </form>
    </div>
    <div class="form-style-2">
        <table>
            <tr>
                <td>User first name</td>
                <td>User last name</td>
            </tr>
            <c:forEach var="user" items="${usersFromServer}">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>
                            <a href="delete/id=${user}">delete
                                <img src=""/>
                            </a>
                        </td>
                    </tr>
            </c:forEach>
        </table>
    </div>




</body>
</html>
