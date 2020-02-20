<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 13.02.2020
  Time: 20:01
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
</style>

<div class="main">
    <form method="post" action="/admin/update-user">

        <div class="field">
            <label>New user name:</label>
            <input type="text" name="name" value="${user.name}"/><br/>
        </div>
        <div class="field">
            <label>New user password:</label>
            <input type="text" name="password" value="${user.password}"/><br/>
        </div>
        <div class="field">
            <label>New user email:</label>
            <input type="text" name="email" value="${user.email}"/><br/>
        </div>
        <div class="field">
            <label>New user phone:</label>
            <input type="text" name="phone" value="${user.phone}"/><br/>
        </div>


        <label><input type="number" hidden name="id" value="${requestScope.user.id}"/></label><br/>
        <input type="submit" value="Ok" name="Ok"><br>
    </form>
    <div><a href="/admin/homepage"><u>Back to Panel Management</u></a><br></div>
</div>
</body>
</html>
