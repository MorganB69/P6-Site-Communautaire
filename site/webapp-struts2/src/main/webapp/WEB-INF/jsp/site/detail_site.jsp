<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail d'un spot</title>
</head>
<body>
	<header> <%@ include file="../include/menu.jsp"%>  </header>
	
	
	<h2><s:property value="site.nom"/>	</h2>
	<br/>
	<img src="image/site/<s:property value="site.image"/>" alt="Site image">
	
	Site iD : <s:property value="site.id"/>  <br/>
	Description site: <s:property value="site.description"/>  <br/>
	Acces: <s:property value="site.acces"/>  <br/>
	Nombre de voies : <s:property value="site.nbVoie"/>  <br/>
	Nombre de secteurs: <s:property value="site.nbSecteur"/>  <br/>
	
	<h3>Situation géographique</h3>

	pays: <s:property value="site.situation.pays"/>  <br/>
	


	<footer> <%@ include file="../include/footer.jsp"%> </footer>
</body>
</html>