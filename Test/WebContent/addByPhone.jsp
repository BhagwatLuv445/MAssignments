<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="PatientDaoServlet" method="Post">
Enter Your Phone:
<input type="text" name="phone" required><br>
<input type="checkbox" name="testname" value="ECG" />ECG<br>
<input type="checkbox" name="testname" value="HBA1c" />HBA1c<br>
<input type="checkbox" name="testname" value="Blood Group" />BLOOD GROUP<br>
<input type="checkbox" name="testname" value="Bone Densitometry" />BONE DENSITOMETRY<br>
<input type="checkbox" name="testname" value="MRI Scanning" />MRI SCANNING<br>
<input type="submit" value="Submit">
</form>
</body>
</html>