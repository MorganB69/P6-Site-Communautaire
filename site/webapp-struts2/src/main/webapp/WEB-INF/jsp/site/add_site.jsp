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
	
	<div class="container">
	
		<section class="row justify-content-center"> 
	
			<h1> PARTAGE D'UN SPOT D'ESCALADE</h1>
			
			<br>Veuillez saisir le formulaire ci-dessous 
			pour renseigner les différents
			éléments du site d'escalade
			<br>
	
		</section>
	
		<section class="row justify-content-center"> 
		
			
	
			<s:form action="add_site" method="post" cssClass="well form-vertical" theme="bootstrap" enctype="multipart/form-data">
	
	
			<h3>Informations générales sur le site d'escalade </h3>
	

		<s:textfield
			class="col-6"
            label="Nom du site" 
            name="site.nom" 
            requiredLabel="true"
            />
               
        <s:textarea 
        	class="form-control" 
        	rows="5" 
        	name="site.description" 
        	label="Ajouter une description du site" 
        	requiredLabel="true" 
        	/>
        
        <s:textarea 
        	class="form-control" 
        	rows="5" 
        	name="site.acces" 
        	label="Description de l'accès au site" 
        	requiredLabel="true"/>
        	
        <s:textfield
        	class="col-sm-3" 
        	name="site.nbVoie" 
        	label="Nombre de voies" 
        	requiredLabel="true" />
        	
        	
        <s:textfield 
        	class="col-sm-3" 
        	name="site.nbSecteur" 
        	label="Nombre de secteurs" 
        	requiredLabel="true"/>

        
     <h3>Situation géographique </h3>
       
		<s:textfield 
			class="form-control" 
			name="situation.pays" 
			label="Pays" 
			requiredLabel="true"/>
			
		<s:textfield 
			class="form-control" 
			name="situation.departement" 
			label="Departement" requiredLabel="true"/>
			
		<s:textfield 
			class="form-control" 
			name="situation.type" 
			label="Type de spot" 
			requiredLabel="true"/>
		
		<s:textfield 
			class="form-control" 
			name="coordonnee.x" 
			label="Latitude" 
			requiredLabel="true"/>
			
		<s:textfield 
			class="form-control" 
			name="coordonnee.y" 
			label="Longitude" 
			requiredLabel="true"/>
	

	<h3>Détail du site</h3>	
	
	<h5>Orientation </h5>
	
     	 <s:select 
        name="listeOrientationValues"
        list="listeOrientation"
        listKey="orientationId"
        listValue="orientation"
        multiple="true"
        required="true"
        value="%{listeOrientation.{id}}"
 		/>
     	
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
			
			<h5>Cotation </h5>
			
		<s:select 
		label="Cotation minimum"
        name="cotMinValue"
        list="listeCotation"
        listKey="id"
        listValue="cot"
        value="%{listeCotation.{id}}"
 		/>
 		
 				<s:select 
		label="Cotation maximum"
        name="cotMaxValue"
        list="listeCotation"
        listKey="id"
        listValue="cot"
        value="%{listeCotation.{id}}"
 		/>
 		
 		 <s:select 
		label="Cotation moyenne"
        name="cotMoyValue"
        list="listeCotation"
        listKey="id"
        listValue="cot"
        value="%{listeCotation.{id}}"
 		/>
	
		<s:file name="file" label="Ajouter une image du site"/>
		
	
		
        <s:submit class="btn btn-primary" value="Validation"/>

        
    </s:form>
    
    </section>
    </div>
	
	<footer> <%@ include file="../include/footer.jsp"%> </footer>
</body>
</html>