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
	<header> <s:include value="include/menu.jsp"></s:include> </header>
	<s:actionerror/>
	
	
	<h2> Partage d'un Spot</h2>
	
	    <s:form action="add_site">
        <s:textfield name="site.nom" label="Nom du site" requiredLabel="true" />
        <s:textfield name="site.description" label="Description du site" requiredLabel="true" />
        <s:textfield name="site.image" label="Lien image" requiredLabel="true" />
        <s:textfield name="site.acces" label="Accès au site" requiredLabel="true"/>
        <s:textfield name="site.nbVoie" label="Nombre de voies" requiredLabel="true" />
        <s:textfield name="site.nbSecteur" label="Nombre de secteurs" requiredLabel="true"/>
        
        


        <s:submit value="OK"/>
    </s:form>
	
	<footer> <s:include value="include/footer.jsp"></s:include> </footer>
</body>
</html>