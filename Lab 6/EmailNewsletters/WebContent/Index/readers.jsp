<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Readers</title>
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
.Exit {
	background: red;
	color: white;
	border: solid 1px #004F72;
	position: fixed;
    right: 40px; 
}
</style>
</head>
<body>
<button onClick="location.href='./main.jsp'"> Go back to the main page</button>
<form action="BookDatasIndex" method="get" style="display:inline;">
				<input type="submit" class="myButton" value="Books">
			</form>
			<form class = "Exit" action="./Exit" style="display: inline;">
				<input class="Exit" type="submit" class="myButton" value="Exit">
			</form>
	<form action="ReaderSearch">
		<p>
			Search by card number <input name="card" />
			<button>Search</button>
		</p>
	</form>

	<table>
		<tr>
			<th>Full name</th>
			<th>Card number</th>
			<th>Phone number</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="reader" items="${reader}">
			<tr>
				
				<td>${reader.getFullName()}</td>
				<td>${reader.getCardNumber()}</td>
				<td>${reader.getPhoneNumber()}</td>
				<td>
					<form action='ReaderEdit' method = 'GET'>
						<input type="hidden" name="id" value="${reader.getId()}">
						<input type="hidden" name="fullName" value="${reader.getFullName()}">
						<input type="hidden" name="cardNumber" value="${reader.getCardNumber()}">
						<input type="hidden" name="phoneNumber" value="${reader.getPhoneNumber()}"> 
						<input class='EditButton' type='submit' value='Edit' />
					</form>
					<form action='ReaderDelete' method = 'GET'>
						<input type="hidden" name="id" value="${reader.getId()}"> <input
							class='DeleteButton' type='submit' value='Delete' />
					</form>
			</tr>
		</c:forEach>
	</table>

	<button class='AddButton' onClick="location.href='CreateReader'">Create
		new +</button>
</body>
</html>