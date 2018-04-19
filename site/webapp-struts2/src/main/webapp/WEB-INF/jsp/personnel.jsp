<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="#session.user.pseudo"/></title>
</head>
<body>
	<header> 
	<%@ include file="include/menu.jsp"%>  


	</header>
	
	    <!-- Page Content -->
    <div class="container" id="detail-cont">
    
    	<section>

      <!-- Page Heading/Breadcrumbs -->

      
      <div class="row">
             <div class="col-xs-12 col-md-8 col-lg-9" id="left-column">
             <h1 class="text-center text-uppercase">Espace Personnel de <s:property value="#session.user.pseudo"/>
      		</h1>

        
       
        <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-topo" aria-expanded="true" aria-controls="associated-topo">
      	   		<i class="fa fa-leanpub"></i> Mes Topos <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-topo" aria-expanded="true">
      	    
      	    <div class="card card-body bg-light text-dark rounded">
      	
        
     		     	
				 <s:iterator value="#session.user.listeTopoPret">
				 		<h6>Titre :  <s:property value="titre" /></h6>
  						<p><b>Auteur :</b> <s:property value="auteur" /><br>
  							<b>Statut :</b> <s:property value="statut" /><br>
  						
  						</p>
				</s:iterator> 
				
		
       		</div>
       		</div>
       		
         <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-resa" aria-expanded="true" aria-controls="associated-resa">
      	   		<i class="fa fa-leanpub"></i> Mes demandes de réservation <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-resa" aria-expanded="true">
      	    
      	    <div class="card card-body bg-light text-dark rounded">
      	
        
     		     	
 
				
		
       		</div>
       		</div>
    
 
  		
  
  	
        
      </div>
      <div class="col-xs-12 col-md-4 col-lg-3" id="right-column">
      
      <h5 class="mt-3" data-toggle="collapse" href="#associated-situ" aria-expanded="true" aria-controls="associated-situ">
      	   		<i class="fa fa-info-circle"></i> Informations <i class="fa fa-arrow-down pull-right" ></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-situ" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        <h6> <i class="fa fa-globe"></i> Informations personnelles</h6>
     	<ul>
						 <li>Pseudo : <s:property value="#session.user.pseudo"/></li>
           				 <li>Nom : <s:property value="#session.user.nom"/></li>
           				 <li>Mail : <s:property value="#session.user.mail"/></li>
           				    
		</ul>
		
		
    
  </div>
      	    
      </div>
      

      </div>

	</section>
	</div>
	
	
      
      
	
	
	<footer> <%@ include file="include/footer.jsp"%> </footer>
</body>
</html>