<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Cadastro de tipo de produto</title>

<!-- Bootstrap -->
<link href="<c:url value="/static/css/bootstrap.min.css"/>"
	rel="stylesheet">
	
	<link href="<c:url value="/static/css/style.css"/>"
	rel="stylesheet">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel='stylesheet' type='text/css'>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<div class="container">
		<div class="row">

			<div class="col-md-10 col-md-offset-1">

				<div class="panel panel-default panel-table">
					<div class="panel-heading">
						<div class="row">
							<div class="col col-xs-6">
								<h3 class="panel-title">Tipos de produto</h3>
							</div>
							<div class="col col-xs-6 text-right">
								<a class="btn btn-sm btn-primary btn-create"
									href="<c:url value="/tipoProduto/novo"/>"> Novo</a>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-bordered table-list">
							<thead>
								<tr>
									<th><i class="fa fa-cog"></i></th>
									<th class="hidden-xs">Código</th>
									<th>Name</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${tiposProduto}" var="tipoProduto">
									<tr>
										<td align="center">
											<a href="<c:url value="/tipoProduto/${tipoProduto.codigo}"/>" 
												class="btn btn-default">
												<i class="fa fa-pencil"></i> 
											</a> 
											<a href="<c:url value="/tipoProduto/${tipoProduto.codigo}/delete"/>" 
												class="btn btn-danger">
												<i class="fa fa-trash"></i>
											</a>
										</td>
										<td class="hidden-xs">${tipoProduto.codigo}</td>
										<td>${tipoProduto.nome}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col col-xs-4">Page 1 of 5</div>
							<div class="col col-xs-8">
								<ul class="pagination hidden-xs pull-right">
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
								</ul>
								<ul class="pagination visible-xs pull-right">
									<li><a href="#">«</a></li>
									<li><a href="#">»</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
	
<!-- exemplo com método delete <form:form method="delete"> -->
<!--     <p class="submit"><input type="submit" value="Delete Pet"/></p> -->
<!-- </form:form> -->
</body>
</html>