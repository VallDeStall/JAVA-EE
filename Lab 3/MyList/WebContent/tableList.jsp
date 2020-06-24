<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="vlad.fedash.KeyById"%>
<%@ page import="vlad.fedash.Library"%>
<%@ page import="vlad.fedash.Reader"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myList</title>
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
		<%
			Library library;
			library = (Library) getServletContext().getAttribute("library");
			for (Map.Entry<KeyById, Reader> o : library.getBooks()) {
				out.println("					            				<tr>\r\n"
						+ "					            					<td> " + o.getValue().getAuthorOfBook()
						+ "</td>\r\n" + "					            					<td>"
						+ o.getValue().getTitleOfBook() + "</td>\r\n"
						+ "					            					<td>" + o.getValue().getYearOfEdition()
						+ "</td>\r\n" + "					            					<td>"
						+ o.getValue().getFullName() + "</td>\r\n"
						+ "					            					<td>" + o.getValue().getCardNumber()
						+ "</td>\r\n" + "					            					<td>"
						+ o.getValue().getPhoneNumber() + "</td>\r\n" + "	<td>"
						+ "<form  action='editObject.jsp' > <input type='hidden' name='id' value="+ o.getKey().getId()+"> <input class = 'EditButton' type='submit' value='Edit'/>"
						+ "</form>"
						+ "<form  action='deleteMsg.jsp' > <input type='hidden' name='id' value="+ o.getKey().getId()+"> <input class = 'DeleteButton' type='submit' value='Delete'/>"
						+ "</form>");
			}
		%>
	</table>
	<button class='AddButton' onClick="location.href='newObject.jsp'">Create
		new +</button>
</body>
</html>