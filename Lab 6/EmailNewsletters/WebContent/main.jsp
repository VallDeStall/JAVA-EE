<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<style>
.container {
	border: 2px solid black;
	padding: 10px;
	margin: auto;
	width: 400px;
}

body {
	text-align: center;
	font-size: 20px;
}
.SendLetter {
	background: MediumBlue;
	color: white;
	border: solid 1px #004F72;
}
.Exit {
	background: red;
	color: white;
	border: solid 1px #004F72;
}
</style>
</head>
<body>
	<br>
	<br><br> <br><br> <br>
	<div class="container">
		<p>Choose one action from possible.</p>
		<br> <br>

		<form action="ReaderIndex" method="get" style="display: inline;">
			<input type="submit" class="myButton" value="Readers">
		</form>
		<form action="BookDatasIndex" method="get" style="display: inline;">
			<input type="submit" class="myButton" value="Books">
		</form>

		<br><br>
		<button class="SendLetter" onClick="location.href='Email/email.jsp'">Send email</button>
		<form action="Exit" style="display: inline;">
			<input class="Exit" type="submit" class="myButton" value="Exit">
		</form>
	</div>

</body>
</html>
