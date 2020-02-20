<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 07.02.2020
  Time: 15:55
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
    h1{
        position:absolute;
        top:20px;
        left:30px;
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-weight: 600;
    }
    a {
        text-decoration: none;
        outline: none;
        display: inline-block;
        width: 140px;
        height: 45px;
        line-height: 45px;
        border-radius: 15px;
        margin: 10px 20px;
        font-family: 'Montserrat', sans-serif;
        font-size: 11px;
        text-transform: uppercase;
        vertical-align: center;
        text-align: center;
        letter-spacing: 3px;
        font-weight: 600;
        color: #524f4e;
        background: lightgrey;
        box-shadow: 0 8px 15px rgba(0,0,0,.1);
        transition: .3s;
    }
    a:hover {
        background: #5F9EA0;
        box-shadow: 0 15px 20px #008B8B;
        color: white;
        transform: translateY(-7px);
    }
    .one{
        position:absolute;
        top:90px;
        left:100px;
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-weight: 600;
    }
    .two{
        position:absolute;
        top:130px;
        left:100px;
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-weight: 600;
    }
    .three{
        position:absolute;
        top:170px;
        left:100px;
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-weight: 600;
    }
    .four{
        position:absolute;
        bottom:60px;
        left:70px;
    }
    .five{
        position:absolute;
        top:250px;
        left:100px;
    }

</style>

<h1>Welcome to your workout manager</h1>
<h3 class="one">Your workouts</h3>
<h3 class="two">Your data</h3>
<h3 class=three>Your progress</h3>

<a class="five" href="/register">Registration</a><br/>



<form class ="four"  method="post" action="/login">
    <label><input  required type="text" name="name"></label>Name
    <label><input  required type="password" name="password"></label>Password
    <input type="submit" value="ok" name="ok"></a><br/>
</form>


<script type="text/javascript">
    var Msg ='<%=(String)request.getAttribute("msg")%>';
    if (Msg!="null") {
        alert(Msg);
    }
</script>
</body>
</html>
