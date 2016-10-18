function tiposProduto(){
	$.ajax({
		url:'http://localhost:8080/tipoProduto/rest/',
		contentType: 'application/json',
		type : 'GET',
		success: function(dados){
			for ( var i = 0; i < dados.length; i++) {
				$('#retorno').append(dados[i].nome+"<br \>");
			}
		}
			
	});
}

function autoCompleteTipoProduto(){
	$('#tipoProdutoAutoComplete').autocomplete({
	    source:'http://localhost:8080/tipoProduto/rest/autocomplete',
	    select: function( event, ui ) {
	    		$('#tipoProduto-codigo').val(ui.item.value);
	    		$('#tipoProdutoAutoComplete').val(ui.item.label);
	    		return false;
	    },
	    focus : function(event, ui) {
	    		$('#tipoProduto-codigo').val(ui.item.value);
	    		$('#tipoProdutoAutoComplete').val(ui.item.label);
			return false;
		},
		change : function(event, ui) {
			if(ui != null && ui.item != null){
				$('#tipoProduto-codigo').val(ui.item.value);
	    			$('#tipoProdutoAutoComplete').val(ui.item.label);
			}
		},
	});
}