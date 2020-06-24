<%@page import="vlad.fedash.entity.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit book datas</title>
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
</style>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<p>Book change</p>

		<form action="BookDatasEdit" method="post" style="display: inline;">
			<p>Full name reader</p>
			<select name="index">
			
				<c:forEach var="reader" items="${reader}">
					<option value="${reader.id}">${reader.fullName}</option>
				</c:forEach>
			</select>
			<%
				int id = Integer.parseInt(request.getParameter("id"));
				String authorOfBook = request.getParameter("authorOfBook");
				String titleOfBook = request.getParameter("titleOfBook");
				int yearOfEdition = Integer.parseInt(request.getParameter("yearOfEdition"));
			%>
			
			<p>Author of the book</p>
			<input name="authorOfBook" value="<%=authorOfBook%>" required
				oninvalid="this.setCustomValidity('Enter author of the book in English')"
				oninput="setCustomValidity('')" pattern="^[a-zA-Z\s]+$" />
				
			<p>Title</p>
			<input name="titleOfBook" value="<%=titleOfBook%>" required
				oninvalid="this.setCustomValidity('Enter a title in English')"
				oninput="setCustomValidity('')"
				pattern="^[a-zA-Z][a-zA-Z0-9\s.,!?()-]+$" />
				
			<p>Year edition</p>
			<input name="yearOfEdition" value="<%=yearOfEdition%>" required
				oninvalid="this.setCustomValidity('Enter a legacy year edittion')"
				oninput="setCustomValidity('')" pattern="^[0-9]+$" /> <br> <input
				type='hidden' name="id" value="<%=(request.getParameter("id"))%>">
			<br> 
			<input type="submit" class="myButton" value="Update" />
		</form>
		<a href="BookDatasIndex"><button>Cancel</button></a>
	</div>
</body>
</html>