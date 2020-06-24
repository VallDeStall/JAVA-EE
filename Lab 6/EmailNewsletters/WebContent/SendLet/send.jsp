<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>send</title>
<title>main</title>
<style>

body {
	text-align: center;
	font-size: 20px;
}
.Exit {
	background: red;
	color: white;
	border: solid 1px #004F72;
}
</style>

</head>
<body>
<br><br><br><br><br><br><br>
<p>Letter successfully sent</p>
	<button onClick="location.href='./main.jsp'"> Go back to the main page</button>
	<form action = "./Exit" >
		<input class = "Exit" type="submit" class="myButton" value="Exit">
		</form>
	
</body>
</html>