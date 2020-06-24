<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete object</title>
</head>
<body style='text-align: center; font-size: 20px;'>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<label>Do you really want to delete this object??</label>
	<br>
	<form action="deleteObject" method="POST">
		<input type="submit" value="Yes" />
		<input type="hidden" name="id" value=<%out.println(request.getParameter("id"));%>>
	</form>
	<button onClick = "location.href='tableList.jsp'">Cancel</button>
</body>
</html>