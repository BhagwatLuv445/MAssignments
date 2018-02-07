<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
        <style>
        body {   		
			background-image: url("virtual.jpg");
			background-repeat: no-repeat;
			background-size: cover;
		}
        ul {
	    list-style-type: none;
	    margin: 2px;
	    top-padding:100px;
	    overflow: hidden;
	    background-color:brown;

	}

	li {
	    float: right;
	}

	li a {
	    display: block;
	    color: white;
	    text-align: right;
	    padding: 14px 16px;
	    text-decoration: none;
	}

	li a:hover {
	    background-color: coral;	   
	}	
	h1{
	color:teal;
	margin-right:200px;
	margin-top:100px;
	padding-right250px;
	
	}	
      </style>
	</head>
<body>
<h1 align="right">Enter Test Details</h1>
<ul>
  <li><a href="addByEmail.jsp">Fetch Patient Detail By Email-Id</a></li>
  <li><a href="addByPhone.jsp">Fetch Patient Detail By Phone Number</a></li>
</li>
</ul>
</body>
</html>