<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">

<title>books</title>
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
<button onClick="location.href='./main.jsp'"> Go back to the main page</button>
<form action="ReaderIndex" method="get" style="display:inline;">
				<input type="submit" class="myButton" value="Readers">
			</form>
	<form action="BookDatasSearch">
		<p>
			Search by year edition <input name="year" />
			<button>Search</button>
		</p>
	</form>

	<table>
		<tr>
			<th>Author</th>
			<th>Title</th>
			<th>Year</th>
			<th>Reader name</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="book" items="${book}">
			<tr>
				<td>${book.getAuthorOfBook()}</td>
				<td>${book.getTitleOfBook()}</td>
				<td>${book.getYearOfEdition()}</td>
				<td>${book.getReader().getFullName()}</td>
				<td>
					<form action='BookDatasEdit' method = 'GET'>
						<input type="hidden" name="id" value="${book.getIde()}">
						
						<input type="hidden" name="authorOfBook" value="${book.getAuthorOfBook()}">
						<input type="hidden" name="titleOfBook" value="${book.getTitleOfBook()}">
						<input type="hidden" name="yearOfEdition" value="${book.getYearOfEdition()}">
					 <input
							class='EditButton' type='submit' value='Edit' />
					</form>
					<form action='BookDatasDelete' method = 'GET'>
						<input type="hidden" name="id" value="${book.getIde()}"> <input
							class='DeleteButton' type='submit' value='Delete' />
					</form>
			</tr>
		</c:forEach>
	</table>

	<button class='AddButton' onClick="location.href='CreateBookDatas'">Create
		new +</button>
</body>
</html>