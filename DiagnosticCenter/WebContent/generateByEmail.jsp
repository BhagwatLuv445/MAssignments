<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="index.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
form {
	padding: 150px;
	float: right;
	color: #1287A8;
	font-size: 25px;
}

.inputBox {
	padding: 5px;
	align: auto;
}

body {
	background-repeat: no-repeat;
	background-size: cover;
}

#subtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color:blue;
}
</style>
</head>
<body background="virtual.jpg">
<div class="navbar">
		<a href="index.html">Home</a>
		<div class="dropdown">
			<button class="dropbtn">
				Add Test <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="addByEmail.html">Fetch By Email-Id</a>
       			<a href="addByPhone.html">Fetch By Phone-Number</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Generate Report <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="generateByEmail.html">Fetch By Email-ID</a>
				<a href="generateByPhone.html">Fetch By Phone-Number</a>
			</div>
		</div>
		<a href="#news" style="float: right">Exit</a>
	</div>
		<form action="GenerateByEmail" method="get">
		Enter Your Email: <input type="text" name="email" required><br>
		Enter Date: <input type="text" name="date"> <input
			type="submit" value="Submit">
	</form>
	<!-- <form action="InsertByEmail" method="post">
  <fieldset>
  <p>Enter Your Email: <input type="text" name="email"  required="required" autofocus></p><br>
    <p>
      <input type="checkbox" id="ecg" name="testname" value="ECG">
      <label for="ecg">ECG</label>
    </p>
    <p>
      <input type="checkbox" id="hba1c" name="testname" value="HBA1c">
      <label for="hba1c">HBA1c</label>
    </p>
    <p>
      <input type="checkbox" id="blood" name="testname" value="Blood Group">
      <label for="third">I like strawberry</label>
    </p>
  </fieldset>
</form> -->
</body>
</html>
