<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
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
<p> Change data, if you want</p>
	
		<form action="editObject" method="POST" style="display:inline;">
			<input type="hidden" value="${reader.getId()}" name="id" />
			<p>Book's author:<input type="text"  name="authorOfBook" value="${reader.getAuthorOfBook()}"></p>
			<p>Title Of Book <input type="text"  name="titleOfBook" value="${reader.getTitleOfBook()}"></p>
			<p>Year Of Edition <input type="text"  name="yearOfEdition" value="${reader.getYearOfEdition()}"></p>
			<p>Full name <input type="text"  name="fullName" value="${reader.getFullName()}"></p>
			<p>Card number <input type="text" name="cardNumber" value="${reader.getCardNumber()}"></p>
			<p>Phone number <input type="text" name="phoneNumber" value="${reader.getPhoneNumber()}"></p>
			<input type="submit"   value="Update" id="add" >
		</form>
		<a href="loadDatas"><button>Cancel</button></a>

</body>
</html>