<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Servlet Information</h1>
	<h3> Request information</h3>
	<a href ="parameter?name=koko&pass=123">Send</a>
	<br/>
	
	<h3>Respond Information</h3>
	<form action="parameter"  method="post">
		<table>
			<tr>
				<td> Name:</td>
				<td>
					<input type=text name ="user" placeholder="Your UserName!">
				</td>
			</tr>
			<tr>
				<td>Password :</td>
				<td>
					<input type="password" name="pass" placeholder="Type password !">
					</td>
			</tr>
			<tr>
			<td></td>
			<td>
				<input type ="submit" value="Send">
		</table>
	</form>
</body>
</html>