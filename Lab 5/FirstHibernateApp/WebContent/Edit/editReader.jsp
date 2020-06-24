<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit new object</title>
</head>
<body style='text-align: center; font-size: 20px;'>
	<br>
<p>Reader Change</p>
<div class="container">
<form action="ReaderEdit" method="POST" style="display:inline;">
<%
int id = Integer.parseInt(request.getParameter("id"));
String fullName = request.getParameter("fullName");
int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
String phoneNumber = request.getParameter("phoneNumber");
%>
<input type="hidden" value="<%=id%>"  name="id" />
<p>Full name </p>
<input name="fullName" value="<%=fullName%>"  required 
				oninvalid="this.setCustomValidity('Enter a full name in English')"
					oninput="setCustomValidity('')"
					pattern="^[a-zA-Z\s]+$"/>
<p>Card number </p>
<input name="cardNumber" value="<%=cardNumber%>" required 
						oninvalid="this.setCustomValidity('Enter a card number')" 
					oninput="setCustomValidity('')"
					pattern="\d{3,5}+$"/>
<p>Phone number </p>
<input name="phoneNumber" value="<%=phoneNumber%>" required 
				oninvalid="this.setCustomValidity('Enter a legacy phone number')" 
					oninput="setCustomValidity('')"
					pattern="^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$"/><br><br>
					<br>
<input type="submit" class="myButton" value="Update" />
</form>
<a href="ReaderIndex"><button>Cancel</button></a>
</div>
</body>
</html>