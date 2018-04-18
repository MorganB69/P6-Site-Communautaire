/**
 * 
 */
$(document).ready(function(){
 
    $("#formPaysList").change(function(e){
       
 
        $.getJSON(
            'list_jsonDb.action', // Action JSON
            {
            	paysIdOut : $("#formPaysList").val()
            },
 
            function(data){
            	var defId=10000;
            	var defName="TOUS";
            	$('#formStateList').empty();
            	$('#formStateList').append('<option value="'+ defId+'">'+ defName+'</option>');
            	$.each(JSON.parse(data), function(i,value) {
            		
            		// pour chaque noeud JSON
            		// on ajoute l option dans la liste
            		$('#formStateList').append('<option value="'+ value.id+'">'+ value.name+'</option>');

            		});
         
            },
            'json'
         );
    });
});
