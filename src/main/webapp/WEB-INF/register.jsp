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
    <title>Title</title>
</head>
<body>

<form method="post" action="/register">
    <label><input required type="text" name="name"></label>Name<br/>
    <label><input required type="email" name="email"></label>Email<br/>
    <label><input required type="password" name="password" minlength="=6"></label>Password<br/>
    <label><input required type="password" name="password-repeat" minlength="6"></label>Password<br/>
    <label><input required type="text" name="phone"></label>Phone<br/>
    <input type="submit" value="ok" name="ok"><br/>
</form>

<script type="text/javascript">
    var Msg ='<%=(String)request.getAttribute("msg")%>';
    if (Msg!="null") {
        alert(Msg);
    }
</script>
</body>
</html>
