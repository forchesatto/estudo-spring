<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	${error}
	<form action="login" method="POST">
	
		<label for="username">Usuario:</label>
		<input type="text" name="username">
		<label for="password">Senha:</label>
		<input type="password" name="password">
	
		<input name="submit" type="submit" value="Login">
	</form>

	<a href="usuario/">Novo usuário</a>
</body>
</html>