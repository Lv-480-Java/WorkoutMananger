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
    <title>Title</title>
</head>
<body>


<a href="/register"><input type="button" value="register" name="register"></a><br/>

<h1>Fill the form</h1>

<form method="post" action="/login">
    <label><input required type="text" name="name"></label>Name<br/>
    <label><input required type="password" name="password"></label>Password<br/>
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
