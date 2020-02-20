<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 15.02.2020
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workout manager</title>
</head>
<body>


<style>
    body {
        background: #c7b39b url(https://evofitness.ch/wp-content/uploads/2017/02/14A.jpg); /* Цвет фона и путь к файлу */
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
        background-size: cover;
    }
    li{
        width:300px;
    }
    table{
        width: 300px;
    }
    .one{
        left:30px;
        width: 80px;
        height: 35px;
    }
</style>
<h2>Your previous data</h2>
<c:forEach var="data" items="${requestScope.datas}">
    <ul>
        <li>Weight: <c:out value="${data.weigh}"/></li>
        <li>Height: <c:out value="${data.height}"/></li>
        <li>Percent of fat: <c:out value="${data.percentOfFat}"/> %</li>
        <li>Percent of muscle: <c:out value="${data.percentOfMuscle}"/> %</li>
        <li>Date record: <c:out value="${data.createData}"/></li>
        <form method="post" action="<c:url value='/user/myschedule'/>">
            <input type="number" hidden name="id" value="${data.id}" />
            <input type="submit" name="delete" value="Delete"/>
        </form>
    </ul>
    <hr/>
</c:forEach>

<h2>All workout schedules</h2><br/>
<table>
<c:forEach var="schedule" items="${requestScope.schedules}">
    <ul>
        <li>Date: <c:out value="${schedule.date}"/></li>
        <li>Comment: <c:out value="${schedule.comment}"/></li>
            <form method="post" action="<c:url value='/user/deleteschedule'/>">
            <input type="number" hidden name="id" value="${schedule.id}" />
            <input type="submit" name="delete" value="Delete"/>
            </form>
    </ul>
    <hr/>
</c:forEach>
</table>
<form class="one" action="/logout" method="get">
    <input class="one" type="submit" value="Logout"/>
</form>
</body>
</html>
