<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body  {
	background: darkblue;
    background: url(https://www.desktopbackground.org/p/2014/06/16/778839_1920x1080-football-american-football-denver-broncos-stadium_1920x1080_h.jpg) no-repeat center center fixed;
	background-size: cover;
}
form {
	text-align: center;
	color:white;
	font-weight: bold;
	font-size: 125%;
	text-shadow: 2px 2px #FF0000;
}
p {
	text-align: center;
	font-size: 150%;
	text-shadow: 2px 2px #00008B;
}
/* unvisited link */
a:link {
    color: orange;
    font-weight: bold;
    text-decoration: none;
}

/* visited link */
a:visited {
    color: orange;
    font-weight: bold;
    text-decoration: none;
}

/* mouse over link */
a:hover {
    color: white;
    font-weight: bold;
    text-decoration: none;
}

/* selected link */
a:active {
    color: white;
    font-weight: bold;
    text-decoration: none;
}
</style>
<script>
function validateForm() {
    var w = document.forms["edit-players"]["team"].value;
    var x = document.forms["edit-players"]["name"].value;
    var y = document.forms["edit-players"]["owner"].value;
    if (w == "") {
        alert("Team must be filled out");
        return false;
    }
    else if (x == "") {
        alert("Name must be filled out");
        return false;
    }
    else if (y == "") {
        alert("Owner must be filled out");
        return false;
    }
} 
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Player</title>
</head>
<body>
<form name="edit-players" action = "editPlayersServlet" method="post" onsubmit="return validateForm()">
Team: <input type ="text" name = "team" value= "${playerToEdit.team}">
Name: <input type = "text" name = "name" value= "${playerToEdit.name}">
Owner: <input type = "text" name = "owner" value= "${playerToEdit.owner}">
<input type = "hidden" name = "id" value = "${playerToEdit.id}">
<input type = "submit" value="Save Edited Player">
</form>
<p>
<a href = "viewAllPlayersServlet">View complete list</a><br />
<a href = "index.html">Back to main menu</a><br />
</p>
</body>
</html>