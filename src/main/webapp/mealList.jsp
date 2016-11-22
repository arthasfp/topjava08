<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %><%--
  Created by IntelliJ IDEA.
  User: Sergii
  Date: 27.09.2016
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>

<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>Meal list</h3>
    <a href="userMeal?action=create">Add meal</a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="userMeal">
            <jsp:useBean id="userMeal" scope="page" type="ru.javawebinar.topjava.model.UserMealWithExceed"/>
            <tr class="${userMeal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        <%--${userMeal.dateTime.toLocalDate()} ${userMeal.dateTime.toLocalTime()}--%>
                    <%=TimeUtil.toString(userMeal.getDateTime())%>
                        <%--${fn:formatDateTime(userMeal.dateTime)}--%>
                </td>
                <td>${userMeal.description}</td>
                <td>${userMeal.calories}</td>
                <td><a href="userMeal?action=update&id=${userMeal.id}">Update</a></td>
                <td><a href="userMeal?action=delete&id=${userMeal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>