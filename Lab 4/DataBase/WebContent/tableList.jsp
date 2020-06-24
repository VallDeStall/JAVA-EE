<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">

<title>tableList</title>
<style>
body {
	margin-right: 40px;
	margin-left: 40px;
}

.DeleteButton {
	color: white;
	background: red;
	-webkit-border-radius: 8px;
	border: solid 1px #004F72;
	background: red;
}

table {
	width: 100%;
}

.EditButton {
	background: yellow;
	-webkit-border-radius: 8px;
	border: solid 1px #004F72;
}

table, th, td {
	border-collapse: collapse;
	border: 2px solid black;
	border-collapse: collapse;
	padding: 15px;
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
	<form action="Search">
		<p>
			Search by card number <input name="card" />
			<button>Search</button>
		</p>
	</form>

	<table>
		<tr>
			<th>Author</th>
			<th>Title</th>
			<th>Year edition</th>
			<th>Full name</th>
			<th>Card number</th>
			<th>Phone number</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="reader" items="${reader}">
			<tr>
				<td>${reader.getAuthorOfBook()}</td>
				<td>${reader.getTitleOfBook()}</td>
				<td>${reader.getYearOfEdition()}</td>
				<td>${reader.getFullName()}</td>
				<td>${reader.getCardNumber()}</td>
				<td>${reader.getPhoneNumber()}</td>
				<td>
					<form action='editObject'>
						<input type="hidden" name="id" value="${reader.getId()}">
						
						<input type="hidden" name="authorOfBook" value="${reader.getAuthorOfBook()}">
						<input type="hidden" name="titleOfBook" value="${reader.getTitleOfBook()}">
						<input type="hidden" name="yearOfEdition" value="${reader.getYearOfEdition()}">
						<input type="hidden" name="fullName" value="${reader.getFullName()}">
						<input type="hidden" name="cardNumber" value="${reader.getCardNumber()}">
						<input type="hidden" name="phoneNumber" value="${reader.getPhoneNumber()}"> <input
							class='EditButton' type='submit' value='Edit' />
					</form>
					<form action='deleteObject' method = 'GET'>
						<input type="hidden" name="id" value="${reader.getId()}"> <input
							class='DeleteButton' type='submit' value='Delete' />
					</form>
			</tr>
		</c:forEach>
	</table>

	<button class='AddButton' onClick="location.href='newObject.jsp'">Create
		new +</button>
</body>
</html>