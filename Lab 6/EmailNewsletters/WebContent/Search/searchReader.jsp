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

	<a href="ReaderIndex"><button>Go into the reader page</button></a><br><br>
	<table>
		<thead>
			<tr>
				<th>Full name</th>
				<th>Card number</th>
				<th>Phone number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reader" items="${reader}">
				<tr>
					<td>${reader.getFullName()}</td>
					<td>${reader.getCardNumber()}</td>
					<td>${reader.getPhoneNumber()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>