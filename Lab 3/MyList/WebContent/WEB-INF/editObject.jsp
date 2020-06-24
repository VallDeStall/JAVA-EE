<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student name</title>
</head>
<body style='text-align: center; font-size: 20px;'>
	<br>
	
	<form action="editObject" method="POST">
	Enter book's author: <input type="text" name="authorOfBook"><br><br>
	Title: <input type="text" name="titleOfBook"><br><br>
    Year edition: <input type="number" name="yearOfEdition"><br><br>
	Full name reader: <input type="text" name="fullName"><br><br>
	Card number: <input type="number" name="cardNumber"><br><br>
	Phone number: <input type="number" name="phoneNumber"><br><br>
			<input type="submit" value="Enter"/>
	</form>

</body>
</html>