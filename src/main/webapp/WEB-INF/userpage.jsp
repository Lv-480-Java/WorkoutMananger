<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        text-align: center;
        vertical-align: center;
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
    .two{
        margin: 10px;
    }
    .four{
        position: absolute;
        top: 250px;
        left: 210px;
    }
    textarea{
        position: absolute;
        top: 280px;
        left: 200px;
    }
    .six{
        position: absolute;
        top: 365px;
        left: 400px;
        width: 50px;
        height: 25px;
    }
    .b{
        position: absolute;
        bottom: 150px;
        left: 300px;
    }
    .c .one{
        position:absolute;
        bottom:70px;
        left:30px;
        width: 80px;
        height: 35px;
    }

</style>



<h2>Fill in the form your data</h2>



<form  method="post" action="/user/homepage">
    <label><input class="two" type="number" name="weigh"></label>Weigh
    <label><input class="two" type="number" name="height"></label>Height
    <label><input class="two" type="number" name="percentOfFat"></label>Percent of fat
    <label><input class="two" type="number" name="percentOfMuscle"></label>Percent of muscle
    <input type="submit" value="ok" name="ok"></a><br/>
</form>

<hr/>
<h2>Fill in the form your schedule</h2>
<form method="post" action="/user/schedule">
    <p>Choose your time:</p>

    <input type="date" id="start" name="time1"
       value="2020-02-01"
       min="2019-01-01" max="2100-12-31">
    <input type="time" id="appt" name="time2"
           min="00:00" max="23:59" required>


    <p>Choose your workout:</p>

    <div>
        <input type="checkbox" id="cardio" name="cardio">
        <label for="cardio">Cardio</label>
    </div>

    <div>
        <input type="checkbox" id="stretching" name="stretching">
        <label for="stretching">Stretching</label>
    </div>

    <div>
        <input type="checkbox" id="chest" name="chest">
        <label for="chest">Chest</label>
    </div>

    <div>
        <input type="checkbox" id="arms" name="arms">
        <label for="arms">Arms</label>
    </div>

    <div>
        <input type="checkbox" id="back" name="back">
        <label for="back">Back</label>
    </div>

    <div>
        <input type="checkbox" id="legs" name="legs">
        <label for="legs">Legs</label>
    </div>

    <div>
        <input type="checkbox" id="sholders" name="sholders">
        <label for="sholders">Sholders</label>
    </div>
    <br/>

    <label class="four" for="story">Write your workout schedule:</label>
    <br/>
    <br/>
    <textarea id="story" name="text"
              rows="5" cols="33">
       workout schedule
    </textarea>
    <br/>
    <input class="six" type="submit" value="ok" name="ok"></a><br/>


</form>
<a class="b" href="/user/myschedule">My Schedules</a>
<br/>
<form class="c" action="/logout" method="get">
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
