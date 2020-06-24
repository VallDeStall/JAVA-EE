<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new object</title>
</head>
<body style='text-align: center; font-size: 20px;'>
	<br>

	<form action="createNewObject" method="POST" style="display:inline;">
		Enter book's author: <input type="text"   class="authorOfBook" name="authorOfBook"><br>
		<br> Title: <input type="text"  class="titleOfBook" name="titleOfBook"><br>
		<br> Year edition: <input type="number" class="yearOfEdition" name="yearOfEdition"><br>
		<br> Full name reader: <input type="text" class="fullName" name="fullName"><br>
		<br> Card number: <input type="number" class="cardNumber" name="cardNumber"><br>
		<br> Phone number: <input type="text" class="phoneNumber"  name="phoneNumber"><br>
		<br> <input type="submit" value="Save" />
	</form>
	<a href="loadDatas"><button>Cancel</button></a>

</body>
</html>