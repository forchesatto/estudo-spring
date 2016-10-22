<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Cadastro de tipo de produto</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">

	<link href="<c:url value="/static/css/jquery-ui.min.css"/>"
		rel="stylesheet">
	<link href="<c:url value="/static/css/jquery-ui.structure.min.css"/>"
		rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<form class="form-horizontal" action="<c:url value="/produto/"/>" method="post">
		<input type="hidden" name="codigo" value="${produto.codigo}">
		<fieldset>

			<legend><spring:message code="produto.title"/></legend>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="nome">Nome</label>
				<div class="col-md-4">
					<input id="nome" name="nome" type="text" placeholder=""
						class="form-control input-md" value="${produto.nome}">
					<form:errors path="produto.nome" cssClass="alert-danger"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="valor">Valor
					mí­nimo</label>
				<div class="col-md-2">
					<input id="valor" name="valor" type="text"
						placeholder="" class="form-control input-md" value="${produto.valor}">
					<form:errors path="produto.valor" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="tipoProdutoAutoComplete">Tipo produto</label>
				<div class="col-md-2">
					<input type="text" id="tipoProdutoAutoComplete" 
							value="${produto.tipoProduto.nome }" />
					<input type="hidden" id="tipoProduto-codigo" 
										name="tipoProduto.codigo"
										value="${produto.tipoProduto.codigo}"/>
					<form:errors path="produto.tipoProduto" />
				</div>
			</div>
			

<!-- 			<div class="form-group"> -->
<!-- 				<label class="col-md-4 control-label" for="tipoProdutoSelect">Tipo produto</label> -->
<!-- 				<div class="col-md-2"> -->
<%-- 					<form:select path="tipoProduto.codigo" --%>
<%-- 						items="${tiposProdutos}"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
			
			
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-primary">Salvar</button>
				</div>
			</div>
			
			
		</fieldset>
	</form>
	
	<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
	<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/static/js/jquery-ui.min.js"/>"></script>
    
    <script src="<c:url value="/static/js/tipoProduto.js"/>"></script>

	<script type="text/javascript">
		autoCompleteTipoProduto();
	</script>
    
</body>
</html>