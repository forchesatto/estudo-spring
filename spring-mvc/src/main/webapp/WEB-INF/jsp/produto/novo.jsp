<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="layout" uri="http://utfpr.edu/jsp/layout"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<layout:template>
	<jsp:attribute name="scriptsEspecificos">
		<script src="<c:url value="/static/js/tipoProduto.js"/>"></script>

		<script type="text/javascript">
			autoCompleteTipoProduto();
		</script>
	</jsp:attribute>
	<jsp:body>
	<form class="form-horizontal" action="<c:url value="/produto/"/>"
			method="post">
		<input type="hidden" name="codigo" value="${produto.codigo}">
		<fieldset>

			<legend>
				<spring:message code="produto.title" />
			</legend>

			<div class="form-group">
				<label class="col-md-4 control-label" for="nome">Nome</label>
				<div class="col-md-4">
					<input id="nome" name="nome" type="text" placeholder=""
							class="form-control input-md" value="${produto.nome}">
					<form:errors path="produto.nome" cssClass="alert-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="valor">Valor
					mí­nimo</label>
				<div class="col-md-2">
					<input id="valor" name="valor" type="text" placeholder=""
							class="form-control input-md" value="${produto.valor}">
					<form:errors path="produto.valor" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="tipoProdutoAutoComplete">Tipo
					produto</label>
				<div class="col-md-2">
					<input type="text" id="tipoProdutoAutoComplete"
							value="${produto.tipoProduto.nome }" /> <input type="hidden"
							id="tipoProduto-codigo" name="tipoProduto.codigo"
							value="${produto.tipoProduto.codigo}" />
					<form:errors path="produto.tipoProduto" />
				</div>
			</div>


<!-- 						<div class="form-group"> -->
<!-- 							<label class="col-md-4 control-label" for="tipoProdutoSelect">Tipo produto</label> -->
<!-- 							<div class="col-md-2"> -->
<%-- 								<form:select path="tipoProduto.codigo" items="${tiposProdutos}" itemLabel="nome" itemValue="codigo"> --%>
<%-- 								</form:select> --%>
			
<!-- 							</div> -->
<!-- 						</div> -->



			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" name="singlebutton"
							class="btn btn-primary">Salvar</button>
				</div>
			</div>


		</fieldset>
	</form>
	</jsp:body>
</layout:template>