<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Owner List</title>
<style>
/* CSS Coding */
h1 {
	color: white;
	text-shadow: 2px 2px #FF0000;
	font-size: 250%;
	text-align: center;
}
body  {
	background: darkblue;
    background: url(https://cdn.wallpapersafari.com/36/77/jN1Fpf.jpeg) no-repeat center center fixed;
    background-size: cover;
}
table {
	text-align: center;
    font-size: 125%;
    color:white;
    text-shadow: 2px 2px #000000;
}
form {
	text-align: center;
}
p {
    text-align: center;
    font-size: 125%;
    text-shadow: 2px 2px #FF0000;
}
/* unvisited link */
a:link {
    color: white;
    text-decoration: none;
}

/* visited link */
a:visited {
    color: white;
    text-decoration: none;
}

/* mouse over link */
a:hover {
    color: orange;
    text-decoration: none;
}

/* selected link */
a:active {
    color: orange;
    text-decoration: none;
}
</style>
</head>
<body>
<h1>Owners List:</h1>
 <form action = "searchOwnerServlet" method="post"></form>
<table align="center">
<c:forEach items="${requestScope.enteredOwner}" var="currentplayer">
 <tr>
   <td><input type="radio" name="owner" value="${currentplayer.owner}"></td>
   <td align="left">${currentplayer.team}</td>
   <td align="left">${currentplayer.name}</td>
   <td align="left">${currentplayer.owner}</td>
 </tr>
</c:forEach>
</table>
<p>
<a href = "index.html">Back to main menu</a><br />
<a href = "searchOwner.html">Search on player via owner</a><br />
</p>
</body>
</html>


