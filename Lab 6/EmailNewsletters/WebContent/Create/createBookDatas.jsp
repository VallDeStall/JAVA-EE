<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new book</title>
<style>
.container {
	border: 2px solid black;
	padding: 10px;
	margin: auto;
	width: 300px;
}

body {
	text-align: center;
	font-size: 20px;
}
.AddButton {
	background: green;
	-webkit-border-radius: 8px;
	color: #edf2ee;
	border: solid 1px #004F72;
	width: 100%;
	text-align: center;
}
</style>
</head>

<body>
	<br>
	<br>
	<div class="container">
		<p>Adding Reader</p>
		<form action="CreateBookDatas" method="post" style="display: inline;">
			<p>Full name reader</p>
			<select name="index">
				<c:forEach var="reader" items="${reader}">
					<option value="${reader.id}">${reader.fullName}</option>
				</c:forEach>
			</select>
			
			<p>Author of the book</p>
			<input name="authorOfBook" required
				oninvalid="this.setCustomValidity('Enter author of the book in English')"
				oninput="setCustomValidity('')" pattern="^[a-zA-Z\s]+$" />
				
			<p>Title</p>
			<input name="titleOfBook" required
				oninvalid="this.setCustomValidity('Enter a title in English')"
				oninput="setCustomValidity('')"
				pattern="^[a-zA-Z][a-zA-Z0-9\s.,!?()-]+$" />
				
			<p>Year edition</p>
			<input name="yearOfEdition" required
				oninvalid="this.setCustomValidity('Enter a legacy year edittion')"
				oninput="setCustomValidity('')" pattern="^[0-9]+$" /> <br>
			<br> 
			<input type="submit" class="myButton" value="Save" />
		</form>
		<a href="./BookDatasIndex"><button>Cancel</button></a>
<br>
		<button class = "AddButton" onClick="location.href='./CreateReader'">Create new
			reader</button>
	</div>
</body>
</html>