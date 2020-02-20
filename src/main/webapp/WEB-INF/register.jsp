<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 07.02.2020
  Time: 15:10
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
        position: absolute;
        top: 100px;
        left: 50px;
    }
</style>

<form class="one" method="post" action="/register">
    <h2>Fill in the fields</h2><br/>
    <label><input required type="text" name="name"></label>Name<br/><br/>
    <label><input required type="email" name="email"></label>Email<br/><br/>
    <label><input required type="password" name="password" minlength="=6"></label>Password<br/><br/>
    <label><input required type="password" name="password-repeat" minlength="6"></label>Password Confirmation<br/><br/>
    <label><input required type="text" name="phone"></label>Phone<br/><br/>
    <input type="submit" value="ok" name="ok"><br/><br/>
</form>

<script type="text/javascript">
    var Msg ='<%=(String)request.getAttribute("msg")%>';
    if (Msg!="null") {
        alert(Msg);
    }
</script>
</body>
</html>
