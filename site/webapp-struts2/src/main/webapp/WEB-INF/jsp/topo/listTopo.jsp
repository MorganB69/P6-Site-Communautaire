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

<div class="container">

<div class="row justify-content-center m-3">

<h1>Liste des Topos</h1>

</div>

<div class="row">
      		


<div class="col-lg-12 col-md-12">
<div class="row">
<s:iterator value="session.listTopo">

<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header"><s:a action="detail_topo">
						<s:param name="id" value="id"></s:param>
						<s:property value="titre" /></s:a></h4>
					<div class="card-body">
								<div class="row">
								<ul class="col-5 m-1">
						 			<li><b>Auteur : </b><s:property value="auteur"/></li>
						 			<li><b>Statut :</b> <s:property value="statut"/></li>
						 			<li><b>Propriétaire :</b> <s:property value="proprietaire.pseudo"/></li>
						 		
								</ul>
								
								<img class="img-fluid col-6" id="img-card" src="image/topo/<s:property value="image"/>" alt="">
								</div>
								

					</div>
					<div class="card-footer">
						<s:a action="detail_topo" class="btn btn-primary">
						<s:param name="id" value="id"></s:param>
						En savoir plus</s:a>
						
					</div>
				</div>
				
			</div>
</s:iterator>  
</div>
</div>
</div>



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