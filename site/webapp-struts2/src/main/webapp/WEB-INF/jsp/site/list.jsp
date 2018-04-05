<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<header> <%@ include file="../include/menu.jsp"%>  </header>

<div class="container-fluid">

<div class="row justify-content-center">

<h1>Recherche d'un site</h1>

</div>

<div class="row">
      		

<div class="col-lg-3 col-md-3">
<div class="row">
<div class="card card-body bg-light text-dark rounded ">
<s:form action="recherche_site" method="post" cssClass="form-vertical well" theme="bootstrap" enctype="multipart/form-data">
	<h3 class="text-center">Formulaire de recherche </h3>
	
		<h5>Altitude</h5>
		<div class="row">
		<div class="form-group col-6">
		<s:textfield
			class="col-6"
            label="Minimale" 
            name="recherche.rAltMin"     
        /> 
        </div>
        <div class="form-group col-6">
        		<s:textfield
			class="col-6"
            label="Maximale" 
            name="recherche.rAltMax"     
        /> 
        </div>
        </div>
        
        <h5>Cotation</h5>
		<div class="row">
		<div class="form-group col-6">
		<s:select
			class="col-6"
			label="Minimale"
			required="false"
        	name="recherche.rCotMin"
        	list="session.listeCotation"
       	 	listKey="id"
        	listValue="cot"
        	value="%{listeCotation.{id}}"    
        /> 
        </div>
        <div class="form-group col-6">
        		<s:select
			class="col-6"
            		label="maximale"
		required="false"
        name="recherche.rCotMax"
        list="session.listeCotation"
        listKey="id"
        listValue="cot"
        value="%{listeCotation.{id}}"     
        /> 
        </div>
        </div>
        
       <s:submit class="btn btn-primary" value="Recherche"/>
	
</s:form>

</div>
</div>
</div>
<div class="col-lg-9 col-md-9">
<div class="row">
<s:iterator value="session.listSite">

<div class="col-lg-4 col-md-6 col-sm-6 portfolio-item" >
			<div class="card bg-light border-dark h-100" id="card-list">
				<s:a action="detail_site">
				<s:param name="id" value="id"></s:param>
					<img class="img-fluid card-img-top" id="img-card" src="image/site/<s:property value="image"/>" alt="">
				</s:a>
				<div class="card-body">
					<h4 class="card-title">
						<s:a action="detail_site">
						<s:param name="id" value="id"></s:param>
						<s:property value="nom" /></s:a>
					</h4>
					       
     							<ul>
						 			<li>ID: <s:property value="id"/></li>
						 			<li>Pays: <s:property value="situation.pays"/></li>
           							<li>Département : <s:property value="situation.departement"/></li>
           				         <s:if test="%{situation.type!=''}">
										<li>Type de site : <s:property value="situation.type"/></li>
								</s:if>
								<li>Orientation : 
									<s:iterator value="listeOrientation">
  											|<s:property value="orientation" />| 
									</s:iterator> 
									</li>
								</ul>
				</div>
			</div>
		</div>
</s:iterator>  
</div>
</div>
</div>

<s:property value="session.lastPage"/>

<div class="row justify-content-md-center">
<nav aria-label="...">
	
  <ul class="pagination">
  
  <s:iterator status="incr" begin="1" end="%{session.lastPage}">  
    <li class="page-item">
       <s:a class="page-link" action="site_list">
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


</html>