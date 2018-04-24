<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un Spot</title>
</head>


<body>
	<header> <%@ include file="../include/menu.jsp"%>  </header>
	<s:actionerror/>
	<s:debug></s:debug>
	
	<div class="container">
	
		<section class="row justify-content-center"> 
	
			<h1> PARTAGE D'UN SPOT D'ESCALADE</h1>
			
			<br>Veuillez saisir le formulaire ci-dessous 
			pour renseigner les différents
			éléments du site d'escalade
			<br>
			* Champ obligatoire
	
		</section>
	
		<section class="row justify-content-center"> 
		
			
	
			<s:form action="update_site" method="post" cssClass="well form-vertical bg-light m-3 p-5" theme="bootstrap" enctype="multipart/form-data">
	
	
			<h3>Informations générales sur le site d'escalade </h3>
	

		<s:textfield
			class="form-control col-9"
            label="Nom du site" 
            name="site.nom" 
            requiredLabel="true"
            />
               
        <s:textarea 
        	class="form-control" 
        	rows="5" 
        	name="site.description"
        	label="Ajouter une description du site" 
        	 
        	/>
        
        <s:textarea 
        	class="form-control" 
        	rows="5" 
        	name="site.acces"
        	label="Description de l'accès au site" 
        	/>
        	
        <s:textfield
        	class="form-control col-sm-3" 
        	name="site.nbVoie" 
        	label="Nombre de voies" 
        	/>
        	
        	
        <s:textfield 
        	class="form-control col-sm-3" 
        	name="site.nbSecteur"
        	label="Nombre de secteurs" 
        	/>

        
     <h3>Situation géographique </h3>
       

			
			
		
			
		<s:select
			class="form-control" 
			name="site.type"
			list="%{#session.listeType}"
			label="Type de spot"
			
			/>
		
		<s:textfield 
			class="form-control" 
			name="site.coordonnee.x"

			label="Latitude" 

			/>
			
		<s:textfield 
			class="form-control"
			name="site.coordonnee.y"
			label="Longitude" 

			/>
	

	<h3>Détail du site</h3>	
	
     	
	<h5>Altitude </h5>
		
			<s:textfield 
			class="form-control" 
			name="altMax.alt" 
			label="Altitude maximum" 
			/>
			
			<s:textfield 
			class="form-control" 
			name="altMin.alt" 
			label="Altitude minimum" 
			/>
			
			<s:textfield 
			class="form-control" 
			name="altMoy.alt" 
			label="Altitude moyenne" 
			/>
			

			

 		

	
		<s:hidden name="modif" value="true"/>
		<s:hidden name="id" value="%{site.id}"/>
		<s:hidden name="site.id" value="%{site.id}"/>
		
	
		<div class="row justify-content-center">
        <s:submit class="btn btn-primary btn-lg" value="Modifier le site"/>
		</div>
        
    </s:form>
    
    </section>
    </div>
	
	<footer> <%@ include file="../include/footer.jsp"%> </footer>
	
	
</body>
<script src="form.js"></script>
</html>