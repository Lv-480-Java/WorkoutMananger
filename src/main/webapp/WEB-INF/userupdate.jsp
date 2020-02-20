<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 16.02.2020
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workout manager</title>
</head>
<body>

<div class="main">
    <form method="post" action="/user/update">

        <div class="field">
            <label>Weight:</label>
            <input type="text" name="weight" value="${data.weigh}"/><br/>
        </div>
        <div class="field">
            <label>Height:</label>
            <input type="text" name="height" value="${data.height}"/><br/>
        </div>
        <div class="field">
            <label>Percent of fat:</label>
            <input type="text" name="fat" value="${data.percentOfFat}"/><br/>
        </div>
        <div class="field">
            <label>Percent of muscle:</label>
            <input type="text" name="muscle" value="${data.percentOfMuscle}"/><br/>
        </div>


        <label><input type="number" hidden name="id" value="${requestScope.data.id}"/></label><br/>
        <input type="submit" value="Ok" name="Ok"><br>
    </form>
    <div><a href="/user/myschedule"><u>Back to Panel Management</u></a><br></div>
</div>
</body>
</html>
