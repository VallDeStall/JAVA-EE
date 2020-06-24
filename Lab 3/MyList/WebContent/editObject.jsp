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
<title>Edit new object</title>
</head>
<body style='text-align: center; font-size: 20px;'>
	<br>

	<form action="editObject" method="POST">
		<%
			Library library;
			library = (Library) getServletContext().getAttribute("library");
			String str = (String) request.getParameter("id");
			for (Map.Entry<KeyById, Reader> o : library.getBooks()) {
				if (String.valueOf(o.getKey().getId()).equals(str)) {
					out.println("<label>Change someone datas, if you want </label> <br>"
							+ "<input type='hidden' name='id' value='" + o.getKey().getId() + "'>"
							+ "<br>Book's author: <input type='text' name='authorOfBook' value = '"
							+ o.getValue().getAuthorOfBook() + "' ><br>"
							+ "<br> Title: <input type='text' name='titleOfBook' value= '"
							+ o.getValue().getTitleOfBook() + "'maxlength='100' size = '35'><br>"
							+ "<br> Year edition: <input type='number' name='yearOfEdition' value= '"
							+ o.getValue().getYearOfEdition() + "'><br>"
							+ "<br> Full name reader: <input type='text' name='fullName' value= '"
							+ o.getValue().getFullName() + "'size = '25'><br>"
							+ "<br> Card number: <input type='number' name='cardNumber' value= '"
							+ o.getValue().getCardNumber() + "'><br>"
							+ "<br> Phone number: <input type='number' name='phoneNumber' value= '"
							+ o.getValue().getPhoneNumber() + "'><br>" + "<br> <input type='hidden' name='id' value="
							+ o.getKey().getId() + "> <input type='hidden' name='authorOfBook' value='"
							+ o.getValue().getAuthorOfBook() + "'><input type='hidden' name='titleOfBook' value='"
							+ o.getValue().getTitleOfBook() + "'><input type='hidden' name='yearOfEdition' value='"
							+ o.getValue().getYearOfEdition() + "'><input type='hidden' name='fullName' value='"
							+ o.getValue().getFullName() + "'><input type='hidden' name='cardNumber' value='"
							+ o.getValue().getCardNumber() + "'><input type='hidden' name='phoneNumber' value='"
							+ o.getValue().getPhoneNumber() + "'><input type='submit' value='Enter' />");
				}
			}
		%>

	</form>
	<button onClick='location.href="tableList.jsp"'>Cancel</button>

</body>
</html>