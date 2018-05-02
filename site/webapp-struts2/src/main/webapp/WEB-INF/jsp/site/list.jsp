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

<div class="row justify-content-center m-3">

<h1>Recherche d'un site</h1>

</div>

<div class="row">   		

<div class="col-lg-3 col-md-3">
<div class="row">
<div class="card card-body bg-light text-dark rounded m-3 ">
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
        	headerKey="1"
       	 	listKey="id"
        	listValue="cot"
        	value="id"
        	
        	  
        /> 
        </div>
        <div class="form-group col-6">
        		<s:select
			class="col-6"
        label="Maximale"
		required="false"
        name="recherche.rCotMax"
        list="session.listeCotation"
        headerKey="37"
        headerValue="9c+"
        listKey="id"
        listValue="cot"
        value="id"
            
        /> 
        </div>
        </div>
        
                <h5>Orientation</h5>
		<div class="row">
		<div class="form-group col-6">
		<s:select
			class="col-12"
			label="Orientation du site"
			required="false"
        	name="recherche.rOrient"
        	headerKey="10000"
        	headerValue="TOUS"
        	list="session.listeOrientation"
       	 	listKey="orientationId"
        	listValue="orientation"
 
        	   
        /> 
        </div>

        </div>
        
           <h5>Situation géographique</h5>

        	<s:select 
        	
		id="formPaysList"
		label="Pays"
		required="true"
        name="recherche.rPays"
        headerKey="10000"
        headerValue="TOUS"
        list="session.listePays"
        listKey="id"
        listValue="name"
        value="%{session.listePays.{id}}"
               
 		/>
			

			
		<s:select 
		id="formStateList"
		label="Région"
		required="true"
		headerKey="10000"
        headerValue="TOUS"
        name="recherche.rDepartement"
        list="listeState"

 		/>
 		
 		
 		<s:select
			class="form-control" 
			name="recherche.rType" 
			list="listType"
			label="Type de spot"
			headerKey="ALL"
        	headerValue="TOUS"
			
		/>
		
		
       
       <s:submit class="btn btn-primary" value="Recherche" />
       

	
</s:form>

</div>
</div>
</div>
<div class="col-lg-9 col-md-9">
<div class="row">
<s:if test="%{session.listSiteOffSet.isEmpty()==false}">
<s:iterator value="session.listSiteOffSet">

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
						 			
						 		<s:if test="%{pays!=null}">
						 			<li><b>Pays :</b> <s:property value="pays.name"/></li>
						 		</s:if>
						 		<s:if test="%{state!=null}">
           							<li><b>Région/Département :</b> <s:property value="state.name"/></li>
           				        </s:if>
           				        
           				         <s:if test="%{type!=null}">
										<li><b>Type de site :</b> <s:property value="type"/></li>
								</s:if>
								<li><b>Orientation : </b>
									<s:iterator value="listeOrientation">
  											|<s:property value="orientation" />| 
									</s:iterator> 
									</li>
								</ul>
				</div>
			</div>
		</div>
</s:iterator> 
</s:if>
<s:else>Aucun site d'escalade correspondant à vos critères n'a été trouvé</s:else> 
</div>
</div>
</div>



<div class="row justify-content-md-center">
<nav aria-label="...">
	
  <ul class="pagination">
  
  <s:iterator status="incr" begin="1" end="%{session.lastPage}">  
    <li class="page-item">
       <s:a class="page-link" action="recherche_site">
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