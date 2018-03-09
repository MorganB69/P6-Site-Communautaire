<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib prefix="s" uri="/struts-tags" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire</title>
</head>
<body>

	<s:include value="menu.jsp"></s:include>

	
	<s:form action="saisir">
		<s:textfield label="Nom" name="nom" />
		<s:textfield label="Prénom" name="prenom" />
		<s:submit />
	</s:form>

</body>
</html>