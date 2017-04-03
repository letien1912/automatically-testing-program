<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="SinhViensvl" method="post">
		<label>mssv: </label> <input type="text" name="mssv"> <br/> <label>ten:
		</label> <input type="text" name="ten"> <br/> <label>diachi: </label> <input
			type="text" name="diachi"> <br/> <input type="submit" /><br/>
			<a href="ListSV">click</a>
	</form>
	<br/>
	<form action="MonHocsvl" method="post">
		<label>mamh: </label> <input type="text" name="mamh"> <br/> <label>tenmh:
		</label> <input type="text" name="ten"><br/> <input type="submit" />
		<br/>
		<a href="ListMH">click</a>
	</form>
	<br/>
	<form action="SVDKMHSvl" method="post">
		<label>mssv: </label> <input type="text" name="mssv">
		 <label>mamh:</label> <input type="text" name="mamh">
		  <label>diem: </label> <input type="text" name="diem"> 
		  <input type="submit" />
	</form>
</body>
</html>