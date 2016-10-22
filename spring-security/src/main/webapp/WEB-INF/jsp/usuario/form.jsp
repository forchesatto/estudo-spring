<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/usuario/" method="POST">
		<label for="nome">Nome usuário:</label>
		<input type="text" name="nome">
		<label for="username">Username:</label>
		<input type="text" name="username">
		<label for="password">Password:</label>
		<input type="password" name="password">
	
		<input name="submit" type="submit" value="Criar">
	</form>
</body>
</html>