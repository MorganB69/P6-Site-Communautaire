<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Topos</title>
</head>
<body>

<header> <%@ include file="../include/menu.jsp"%>  </header>

<div class="container-fluid">

<div class="row justify-content-center">

<h1>Liste des Topos</h1>

</div>

<div class="row">
      		


<div class="col-lg-12 col-md-12">
<div class="row">
<s:iterator value="session.listTopo">

<div class="col-lg-2 col-md-3 col-sm-3 portfolio-item" >
			<div class="card bg-light border-dark h-100" id="card-list">
				<s:a action="detail_topo">
				<s:param name="id" value="id"></s:param>
					<img class="img-fluid card-img-top" id="img-card" src="image/topo/<s:property value="image"/>" alt="">
				</s:a>
				<div class="card-body">
					<h4 class="card-title">
						<s:a action="detail_topo">
						<s:param name="id" value="id"></s:param>
						<s:property value="titre" /></s:a>
					</h4>
					       
     							<ul>
						 			<li>Auteur : <s:property value="auteur"/></li>
						 			<li>Statut : <s:property value="statut"/></li>
						 			<li>Propriétaire : <s:property value="proprietaire.pseudo"/></li>
						 		
								</ul>
				</div>
			</div>
		</div>
</s:iterator>  
</div>
</div>
</div>

<s:property value="session.lastPageTopo"/>

<div class="row justify-content-md-center">
<nav aria-label="...">
	
  <ul class="pagination">
  
  <s:iterator status="incr" begin="1" end="%{session.lastPageTopo}">  
    <li class="page-item">
       <s:a class="page-link" action="liste_topo">
						<s:param name="start" value="%{#incr.count}"></s:param>
						<s:property value="%{#incr.count}"/>
		</s:a>
    </li>
    
   </s:iterator >
   
  </ul>
</nav>

</div>
</div>

<footer> <%@ include file="../include/footer.jsp"%> </footer>



</body>
<script src="formList.js"></script>

</html>