/**
 * 
 */
$(document).ready(function(){
 
    $("#formPays").change(function(e){
       
 
        $.getJSON(
            'list_json.action', // Action JSON
            {
            	paysIdOut : $("#formPays").val()
            },
 
            function(data){
            	
            	$('#formState').empty();
            	$.each(JSON.parse(data), function(i,value) {
            		
            		// pour chaque noeud JSON
            		// on ajoute l option dans la liste
            		$('#formState').append('<option value="'+ value.id+'">'+ value.name+'</option>');

            		});
         
            },
            'json'
         );
    });
});
