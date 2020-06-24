<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new Reader</title>
</head>
<body style='text-align: center; font-size: 20px;'>
	<p>Adding Readers</p>
	<div class="container">
<form action="CreateReader" method="POST" style="display:inline;">
<p>Full name </p>
<input name="fullName" required 
					oninvalid="this.setCustomValidity('Enter a full name in English')"
					oninput="setCustomValidity('')"
					pattern="^[a-zA-Z\s]+$"/>
<p>Card number </p>
<input name="cardNumber" required 
					oninvalid="this.setCustomValidity('Enter a card number')" 
					oninput="setCustomValidity('')"
					pattern="\d{3,5}+$"/>
<p>Phone number </p>
<input name="phoneNumber" required 
					oninvalid="this.setCustomValidity('Enter a legacy phone number')" 
					oninput="setCustomValidity('')"
					pattern="^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$"/><br><br>
<input type="submit" class="myButton" value="Save" />
</form>
<a href="./ReaderIndex"><button>Cancel</button></a>
</div>
</body>

</html>