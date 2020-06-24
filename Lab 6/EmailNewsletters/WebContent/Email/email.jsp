<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/indexstyle.css">
<title>email</title>
<style>
   .container {
    border: 2px solid black;
    padding: 10px;
    margin: auto;
    width: 400px;
   }
   body{
    text-align: center;
    font-size: 20px;'
   }
   .SendLetter {
	background: MediumBlue;
	color: white;
	border: solid 1px #004F72;
}
.Exit {
	background: red;
	color: white;
	border: solid 1px #004F72;
}
  </style>
</head>
<body >
<br><br>
<div class="container">
	<button onClick="location.href='../main.jsp'">Go back to the
		main page</button>
	

			<form action="../XML" method="post" style="display: inline;">
				<p>Email</p>
				<input type="email" class="myButton" name="email" size=50><br>

				<p>Topic</p>
				<input type="text" class="myButton" name="topic" size=50><br>

				<p>Text</p>
				<input type="text" class="myButton" name="text" size=50>

				<p>
					Attach data set <br> <br>
					<input type="radio" id="caseChoice1" name="rb" value="1">
					<label for="caseChoice1">Readers data</label> 
					<input type="radio" id="caseChoice1" name="rb" value="2">
					<label for="caseChoice2">Books data</label> 
					<input type="radio" id="caseChoice1" name="rb" value="3"> 
					<label for="caseChoice3">Nothing</label>
				</p>

				<input class="SendLetter" type="submit" class="myButton" value="Send email">
			</form>

			<form action="../Exit" style="display: inline;">
				<input class="Exit" type="submit" class="myButton" value="Exit">
			</form>

		</div>

</body>
</html>
