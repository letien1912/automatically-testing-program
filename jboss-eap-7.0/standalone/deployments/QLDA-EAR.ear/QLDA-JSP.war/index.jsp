<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddressSvl" >
		sonha: <input type="text" name="sonha"></br>
		phuong: <input type="text" name="phuong"></br>
		quan: <input type="text" name="quan"></br>
		msdc: <input type="text" name="msdc"></br>
		duong: <input type="text" name="duong"></br>
		<input type="submit"/>
	</form>
	
	<form action="EmployeeSvl" method="get">
		msnv: <input type="text" name="msnv"></br>
		ngaysinh: <input type="text" name="ngaysinh"></br>
		hoten: <input type="text" name="hoten"></br>
		sdt: <input type="text" name="sdt"></br>
		addressid: <input type="text" name="address"></br>
		<input type="submit"/>
	</form>
</body>
</html>