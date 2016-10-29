
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ attribute name="scriptsEspecificos"	fragment="true"		required="false" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Sistema utfpr</title>

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

	<sec:authentication property="principal.nome" />
	
	<!-- conteúdo principal -->
	<div class="">
		<jsp:doBody />
	</div>

	<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
	<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/static/js/jquery-ui.min.js"/>"></script>
	
	<jsp:invoke fragment="scriptsEspecificos"></jsp:invoke>
</body>
</html>