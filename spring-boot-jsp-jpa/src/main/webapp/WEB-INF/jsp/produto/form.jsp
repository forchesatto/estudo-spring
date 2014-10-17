<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<body>
<form action="/produto/" method="post">
	<input type="hidden" name="codigo" id="codigo" value="${produto.codigo}">
	<input type="text" name="nome" id="nome" value="${produto.nome}">
	<input type="submit" value="Salvar"/>
</form>
</body>
</html>