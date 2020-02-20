<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 11.02.2020
  Time: 12:35
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
    .one{
        left:30px;
        width: 80px;
        height: 35px;

    }
</style>
    <h2>All users</h2><br/>
    <c:forEach var="user" items="${requestScope.users}">
        <ul>
            <li>ID: <c:out value="${user.id}"/></li>
            <li>Name: <c:out value="${user.name}"/></li>
            <li>Phone: <c:out value="${user.phone}"/></li>
            <li>email: <c:out value="${user.email}"/></li>


            <form method="post" action="<c:url value='/admin/delete-user'/>">
                <input type="number" hidden name="id" value="${user.id}" />
                <input type="submit" name="delete" value="Delete"/>
            </form>

            <form method="get" action="<c:url value='/admin/update-user'/>">
                <input type="number" hidden name="id" value="${user.id}" />
                <input type="submit" value="Edit"/>
            </form>
        </ul>
        <hr/>
    </c:forEach>



</form>


<form class="one" action="/logout" method="get">
    <input class="one" type="submit" value="Logout"/>
</form>



<script type="text/javascript">
    var Msg ='<%=(String)request.getAttribute("msg")%>';
    if (Msg!="null") {
        alert(Msg);
    }
</script>
</body>
</html>
