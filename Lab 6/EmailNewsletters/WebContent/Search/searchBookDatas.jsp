<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<style>
body {
	margin-right: 40px;
	margin-left: 40px;
}

table {
	width: 100%;
}

table, th, td {
	border-collapse: collapse;
	border: 2px solid black;
	border-collapse: collapse;
	padding: 15px;
}
</style>
</head>
<body>

	<a href="BookDatasIndex"><button>Go into the book page</button></a><br><br>
	<table>
		<thead>
			<tr>
				<th>Author</th>
				<th>Title</th>
				<th>Year edition</th>
				<th>Full name</th>
				</tr>
		</thead>
		<tbody>
				<c:forEach var="book" items="${book}">
					<tr>
						<td>${book.getAuthorOfBook()}</td>
						<td>${book.getTitleOfBook()}</td>
						<td>${book.getYearOfEdition()}</td>
						<td>${book.getReader().getFullName()}</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
</body>
</html>