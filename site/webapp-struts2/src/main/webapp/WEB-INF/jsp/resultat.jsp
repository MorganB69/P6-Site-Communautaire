<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Résultat</title>
</head>
<body>
	Nombre de sites :  <s:property value="nbSite"/>  <br/>
	
	Site iD : <s:property value="idSite"/>  <br/>
	
	Description site: <s:property value="description"/>  <br/>
	
</body>
</html>