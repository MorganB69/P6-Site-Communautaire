<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
</head>
<body>
	<header> 
		<s:include value="include/menu.jsp"></s:include> 
		 
	</header>
	
	
	<div class="container">
	
	<section class="row justify-content-center"> 
	
	<h2> Inscription</h2>
	
	</section>
	
	<section class="row justify-content-center"> 
	
	    <s:actionerror/>
	    <s:actionmessage/>
	    
	    <div>
	    <s:form action="add_user" cssClass="well form-vertical">
	    <div>
        <s:textfield class="form-control" name="user.pseudo" label="Identifiant" requiredLabel="true" />
       	</div>
       <div>
        <s:password class="form-control" name="user.mdp" label="Mot de passe" requiredLabel="true" />
       	</div>
       	<div>
        <s:textfield class="form-control" name="user.nom" label="Nom" requiredLabel="true" />
       	</div>
       	<div>
       	<s:textfield type="email" class="form-control" name="user.mail" label="E-mail" requiredLabel="true" /> 
      	</div>
       
		
		<div>
        <s:submit class="btn btn-primary" value="Validation"/>
        </div>
    </s:form>
    	</div>
    
    </section>
    

	
	</div>
	
	<footer> <%@ include file="./include/footer.jsp"%> </footer>
</body>
</html>