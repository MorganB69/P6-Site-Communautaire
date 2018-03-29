<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="site.nom"/></title>
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
             <h1 class="text-center text-uppercase"><s:property value="site.nom"/>
      		</h1>
       <div class="row">
       	 <figure class="figure" id="detailImg">
          <img class="figure-img img-fluid rounded" src="image/site/<s:property value="site.image"/>"alt="Site image">
        </figure>
       </div>
        
        <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-desc" aria-expanded="true" aria-controls="associated-desc">
      	   		<i class="fa fa-leanpub"></i> Description du site <i class="fa fa-arrow-down"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-desc" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     				<p><s:property value="site.description"/></p><br>
		
       		</div>
    
  </div>
  
  		       <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-acces" aria-expanded="true" aria-controls="associated-acces">
      	   		<i class="fa fa-road"></i> Accès au site <i class="fa fa-arrow-down"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-acces" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     				<p> <s:property value="site.acces"/></p><br>
		
       		</div>
    
  </div>
        
        
        
      </div>
      <div class="col-xs-12 col-md-4 col-lg-3" id="right-column">
      
      <h5 class="mt-3" data-toggle="collapse" href="#associated-situ" aria-expanded="true" aria-controls="associated-situ">
      	   		<i class="fa fa-info-circle"></i> Informations <i class="fa fa-arrow-down" ></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-situ" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        <h6> <i class="fa fa-globe"></i> Situation géographique</h6>
     	<ul>
						 <li>Pays: <s:property value="site.situation.pays"/></li>
           				 <li>Département : <s:property value="site.situation.departement"/></li>
           				    
		</ul>
		
		<h6> <i class="fa fa-map-marker"></i> Coordonnées GPS </h6>
     	<ul>
						<li>Latitude : <s:property value="site.coordonnee.x"/></li>
                      	<li>Longitude : <s:property value="site.coordonnee.y"/></li>
           				    
		</ul>
		
	   	<h6> <i class="fa fa-flag-o"></i> Détail du site</h6>
     	<ul>
						<li>Type de site : <s:property value="site.situation.type"/></li>
                      	<li>Longitude : <s:property value="site.coordonnee.y"/></li>
           				<li>Nombre de voies : <s:property value="site.nbVoie"/>  </li>
						<li>Nombre de secteurs: <s:property value="site.nbSecteur"/>  </li>
		</ul>
		
		
		
       		</div>
    
  </div>
      
      
      		<h5 class="mt-3" data-toggle="collapse" href="#associated-alt" aria-expanded="true" aria-controls="associated-alt">
      	   		<i class="fa fa-arrows-v"></i> Altitude <i class="fa fa-arrow-down"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-alt" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     	<ul>
				<s:iterator value="site.listeAltitude">
  						<li><s:property value="typeAlt" /> : <s:property value="alt" /> mètres</li>
				</s:iterator>    
		</ul>
		
       		</div>
    
  </div>
  
  	<h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-ori" aria-expanded="true" aria-controls="associated-ori">
      	   		<i class="fa fa-compass"></i> Orientation du site <i class="fa fa-arrow-down"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-ori" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     	<ul>
				 <s:iterator value="site.listeOrientation">
  						<li><s:property value="orientation" /></li>
				</s:iterator> 
		</ul>
		
       		</div>
    
  </div>
  
  		<h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-cot" aria-expanded="true" aria-controls="associated-cot">
      	   		<i class="fa fa-area-chart"></i> Type de difficulté <i class="fa fa-arrow-down"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-cot" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     	<ul>
				
				<s:iterator value="site.listeCotation">
  						<li> Cotation <s:property value="typeCot" /> : <s:property value="cot.cot" /></li>
				</s:iterator> 
				 
		</ul>
		
       		</div>
    
  </div>
      	    
      </div>
      

      </div>

	</section>
	</div>
	
	
      
      
	
	
	<footer> <%@ include file="../include/footer.jsp"%> </footer>
</body>
</html>