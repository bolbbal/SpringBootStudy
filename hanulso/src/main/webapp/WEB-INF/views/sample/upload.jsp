<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="/sample/ex08">
		<input type="file" name="files" multiple="multiple">
		<button type="submit">����</button>
	</form>
</body>
</html>