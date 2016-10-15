<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-Boot-MVC</title>
</head>
<body>
	Funcionou ${valor} teste
	
	Nome: ${novoNome}
	
	<form action="salvar" method="post">
		<input type="text" name="codigo">
		<input type="text" name="nome">
		<button type="submit"> Salvar </button>
	</form>
	<c:if test="${ not empty produto.codigo}">
		Produto ${produto.nome} Salvo com sucesso.
	</c:if>
	
	
	
	
	
	
	
	
	
	
</body>
</html>