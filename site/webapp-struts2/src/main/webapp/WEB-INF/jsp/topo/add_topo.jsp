<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un Topo</title>
</head>


<body>
	<header> <%@ include file="../include/menu.jsp"%>  </header>
	<s:actionerror/>
	
	<div class="container">
	
		<section class="row justify-content-center"> 
	
			<h1> PARTAGE D'UN TOPO</h1>
			
			</section>
			<section class="row justify-content-center">
			
			<br>Veuillez saisir le formulaire ci-dessous 
			pour renseigner les différents
			éléments du Topo
			<br>
			* Champ obligatoire
	
		</section>
	
		<section class="row justify-content-center"> 
		
			
	
			<s:form action="add_topo" method="post" cssClass="well form-vertical bg-light m-3 p-4" theme="bootstrap" enctype="multipart/form-data">
	
	
			
	

		<s:textfield
			class="form-control col-9"
            label="Titre du topo" 
            name="topo.titre" 
            requiredLabel="true"
            />
            
        <s:textfield
			class="form-control col-9"
            label="Auteur du topo" 
            name="topo.auteur" 
            requiredLabel="true"
            />
            
        <s:textfield
			class="form-control col-9"
            label="Lien vers un éventuel site présentant le topo" 
            name="topo.lien" 
            requiredLabel="false"
            />
               
        <s:textarea 
        	class="form-control" 
        	rows="5" 
        	name="topo.description" 
        	label="Ajouter une description au topo" 
        	 
        	/>
        
        
	

	
		<s:file name="file" label="Ajouter une image au Topo"/>
		
	
		<div class="row justify-content-center">
        <s:submit class="btn btn-primary" value="Validation"/>
		</div>
        
    </s:form>
    
    </section>
    </div>
	
	<footer> <%@ include file="../include/footer.jsp"%> </footer>
	
	
</body>

</html>