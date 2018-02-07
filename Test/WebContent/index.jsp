<!Doctyoe htmL>
<html>
<head>
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="index.css">

</head>
<body>

	<div class="navbar">
		<a href="#home">Home</a>
		<div class="dropdown">
			<button class="dropbtn">
				Add Test <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="addByEmail.jsp">Fetch By Email-Id</a>
       			<a href="addByPhone.jsp">Fetch By Phone-Number</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Generate Report <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="generateByEmail.jsp">Fetch By Email-ID</a>
				<a href="generateByPhone.jsp">Fetch By Phone-Number</a>
			</div>
		</div>
		<a href="#news" style="float: right">Exit</a>
	</div>


</body>
</html>