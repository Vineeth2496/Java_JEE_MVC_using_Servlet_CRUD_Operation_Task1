<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
body {
       
	background-image: url('https://image.shutterstock.com/image-photo/double-exposure-graph-rows-coins-260nw-531998662.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body>
<!-- 
<style>
form{
	background-color:lime;
	border: solid;
	width: 300px;
	height: 450px;
	border-color: black;
	color: navy;
}
</style>
 -->
<center>
	<form action="Register_Action">
	</br></br>
	<marquee><h1>Student Registeration</h1></marquee>
	<table border="1">
	<tr><th>First Name:</th><td><input type="text" name="fn" required="true" placeholder="Enter Firstname" ></td></tr>
	<tr><th>Last Name:</th><td><input type="text" name="ln" required="true" placeholder="Enter Lastname" ></td></tr>
	<tr><th>Email:</th><td><input type="email" name="em" required="true" placeholder="example@example.com" ></td></tr>
	<tr><th>User Id:</th><td><input type="text" name="uid" required="true" placeholder="User Id" ></td></tr>
	<tr><th>Password:</th><td><input type="password" name="pa" required="true" placeholder="**********" maxlength="10"></td></tr>
	<tr><th>Phone No:</th>
	<td>
	<select name="std">
		<option>+91</option>
		<option>+92</option>
		<option>+420</option>
		<option>+20</option>
		<option>+33</option>
		<option>+49</option>
		<option>+36</option>
		<option>+98</option>
		<option>+39</option>
	</select>
	<input type="text" name="ph" required="true" placeholder="9999999999" maxlength="10"></td></tr>
	</td></tr>
	<tr><th>Gender:</th><td>Male:<input type="radio" name="gn" value="male"> Female:<input type="radio" name="gn" value="female"> Others:<input type="radio" name="gn" value="others"></td></tr>
	<tr><th colspan="2"><input type="submit" value="Regiser"></th></tr>
	</table>
	</form>
</center>
</body>
</html>