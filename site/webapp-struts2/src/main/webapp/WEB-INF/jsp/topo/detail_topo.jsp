<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="topo.titre"/></title>
</head>
<body>
	<header> 
	<%@ include file="../include/menu.jsp"%>  


	</header>
	
	    <!-- Page Content -->
    <div class="container" id="detail-cont">
    
    	<section>

      <!-- Page Heading/Breadcrumbs -->

      
      <div class="row">
             <div class="col-xs-12 col-md-8 col-lg-9" id="left-column">
             <h1 class="text-center text-uppercase"><s:property value="topo.titre"/>
      		</h1>

        
        <s:if test="%{topo.description!=''}">
        <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-desc" aria-expanded="true" aria-controls="associated-desc">
      	   		<i class="fa fa-leanpub"></i> Description du Topo <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-desc" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     				<p><s:property value="topo.description"/></p><br>
		
       		</div>
    
  </div>
  		</s:if>
  
  		
         <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-site" aria-expanded="true" aria-controls="associated-site">
      	   		<i class="fa fa-tree"></i> Sites associés au topo <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-site" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     		     	
				 <s:iterator value="topo.listeSite">
				 		<h6>
						<s:a action="detail_site">
						<s:param name="id" value="id"></s:param>
						<s:property value="nom" /></s:a>
						</h6>
						<ul>
							<li>Pays : <s:property value="pays.name"/> </li>
							<li>Région : <s:property value="state.name"/> </li>
						</ul>
  						
				</s:iterator> 
				
		
       		</div>
       		</div>

	

        	
        	<s:a class="btn btn-primary btn-md m3" action="add_site">Créer un site</s:a>

			        	
			<s:a class="btn btn-primary btn-md m3" action="recherche_site">Ajouter un site existant</s:a>
  			
			
			

			


        
      
     
        
      </div>
      <div class="col-xs-12 col-md-4 col-lg-3" id="right-column">
      
             <div class="row">
       	 <figure class="figure" id="detailImgTopo">
          <img class="figure-img img-fluid rounded" src="image/topo/<s:property value="topo.image"/>"alt="Topo image">
        </figure>
       </div>
      
      <h5 class="mt-3" data-toggle="collapse" href="#associated-situ" aria-expanded="true" aria-controls="associated-situ">
      	   		<i class="fa fa-info-circle"></i> Informations <i class="fa fa-arrow-down pull-right" ></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-situ" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     	<ul>
						 <li><b>Auteur : </b><s:property value="topo.auteur"/></li>
           				 <li><a  href="<s:property value="topo.lien"/>"><b>Lien</b> </a></li>
           				 <li><b>Statut : </b><s:property value="topo.statut"/></li>
           				 <li><b>Propriétaire du Topo : </b><s:property value="topo.proprietaire.pseudo"/></li>
           				 
           				    
		</ul>

		
			<s:if test="topoEmprunt==true">
			Vous avez une demande de réservation en cours sur ce Topo.
			</s:if>
			<s:else>
			<s:a action="resa_topo"  class="btn btn-primary btn-md m3">Demander une réservation
			<s:param name="id" value="topo.id"></s:param>
	
			</s:a>
			Une demande sera envoyée au propriétaire qui obtiendra vos coordonnées et qui vous recontactera pour les modalités d'envoie en cas d'acceptation.
			</s:else>
		
		
    
  </div>
  <s:actionmessage/>
      	    
      </div>
      

      </div>

	</section>
	</div>
	
	
      
      
	
	
	<footer> <%@ include file="../include/footer.jsp"%> </footer>
</body>
</html>