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
	
	<h2> Partage d'un Spot</h2>
	
	</section>
	
	<section class="row justify-content-center"> 
	
	    <s:form action="add_site" class="form-group">
        <s:textfield class="form-control" name="site.nom" label="Nom du site" requiredLabel="true" />
       	
       
        <s:textfield class="form-control" name="site.description" label="Description du site" requiredLabel="true" />
        <s:textfield class="form-control" name="site.image" label="Lien image" requiredLabel="true" />
        <s:textfield class="form-control" name="site.acces" label="Accès au site" requiredLabel="true"/>
        <s:textfield class="form-control" name="site.nbVoie" label="Nombre de voies" requiredLabel="true" />
        <s:textfield class="form-control" name="site.nbSecteur" label="Nombre de secteurs" requiredLabel="true"/>
        
        
        
        
		<s:textfield class="form-control" name="situation.pays" label="Pays" requiredLabel="true"/>
		<s:textfield class="form-control" name="situation.departement" label="Departement" requiredLabel="true"/>
		<s:textfield class="form-control" name="situation.type" label="Type de spot" requiredLabel="true"/>
		
		<s:textfield class="form-control" name="coordonnee.x" label="latitude" requiredLabel="true"/>
		<s:textfield class="form-control" name="coordonnee.y" label="longitude" requiredLabel="true"/>
		
		
        <s:submit class="btn btn-primary" value="Validation"/>
    </s:form>
    </section>
    </div>
	
	<footer> <%@ include file="../include/footer.jsp"%> </footer>
</body>
</html>