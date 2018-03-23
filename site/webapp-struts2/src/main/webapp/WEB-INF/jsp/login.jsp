<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>
</head>
<body>
	<header> 
		<s:include value="include/menu.jsp"></s:include> 
		 
	</header>
	
	
	<div class="container">
	
	<section class="row justify-content-center"> 
	
	<h2> Authentification</h2>
	
	</section>
	
	<section class="row justify-content-center"> 
		
		<s:actionmessage/>
		<s:actionerror/>
		
	    <s:form action="login" class="form-group">
        <s:textfield class="form-control" name="login" label="Identifiant" requiredLabel="true" />
       	
       
        <s:password class="form-control" name="password" label="Mot de passe" requiredLabel="true" />
      
       
		
		
        <s:submit class="btn btn-primary" value="Validation"/>
    </s:form>
    
    
    </section>
    
    <section class="row justify-content-center"> 
		<s:a class="btn btn-primary" label=" Créer un compte" action="add_user">Créer un compte</s:a>
	</section>
	
	</div>
	
	<footer> <%@ include file="./include/footer.jsp"%> </footer>
</body>
</html>