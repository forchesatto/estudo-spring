function listarTiposProdutos() {
	$.ajax({
		url : 'http://localhost:8080/tiposProduto/',
		type : 'GET',
		contentType : 'application/json',
		success : function(data) {
			var tiposProdutos = data['_embedded']['tipoProduto'];
			for ( var i = 0; i < tiposProdutos.length; i++) {
				alert(tiposProdutos[i].nome);	
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('An error has occured!! :-(')
		}
	})
}