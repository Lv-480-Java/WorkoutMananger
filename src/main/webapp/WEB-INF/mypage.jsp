<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 02.02.2020
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<h1>Fill the form</h1>
<form method="post" action="/data">
    <label><input type="text" name="weigh"></label>weigh
    <label><input type="text" name="height"></label>height
    <label><input type="text" name="percentOfFat"></label>percentOfFat
    <label><input type="text" name="percentOfMuscle"></label>percentOfMuscle
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
