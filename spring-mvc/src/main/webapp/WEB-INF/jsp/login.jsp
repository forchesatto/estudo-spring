<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Bootstrap -->
    <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">

	<link href="<c:url value="/static/css/jquery-ui.min.css"/>"
		rel="stylesheet">
	<link href="<c:url value="/static/css/jquery-ui.structure.min.css"/>"
		rel="stylesheet">
		
<title>Login</title>
</head>
<body>
	<form class="form-horizontal" action="login" method="post">
		${erroLogin}
		
		<c:if test="${not empty param.error}">
			<spring:message code="${param.error}"/>
		</c:if>
		<fieldset>
			<legend>Login</legend>
			<div class="form-group">
				<label class="col-md-4 control-label" for="nome">Usuário</label>
				<div class="col-md-4">
					<input type="text" name="username" class="form-control input-md" >
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="nome">Senha</label>
				<div class="col-md-4">
					<input type="password" name="password" class="form-control input-md" >
				</div>
			</div>
		
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-primary">Entrar</button>
				</div>
			</div>
		</fieldset>	
	</form>
	<a href="/usuario/" id="novoUsuario" class="btn btn-secundary">Novo usuário</a>
</body>
</html>