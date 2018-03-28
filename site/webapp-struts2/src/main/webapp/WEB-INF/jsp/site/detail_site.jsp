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
	
	    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1><s:property value="site.nom"/>
      </h1>


      <!-- Portfolio Item Row -->
      <div class="row">

        <div class="col-md-8">
          <img class="img-fluid" src="image/site/<s:property value="site.image"/>"alt="Site image">
        </div>
        
        <div class="card ">
        	
            <h3 class="card-header">Situation géographique</h3>
            
            <div class="card-body bg-light">
              	<div class="row">
                <div>
                	<h5>Localisation</h5>
                  <ul class="list-unstyled mb-0">        
           				 <li>Pays: <s:property value="site.situation.pays"/></li>
           				 <li>Département : <s:property value="site.situation.departement"/></li>
           				 <li>Type de site : <s:property value="site.situation.type"/></li>
                  </ul>
                </div>
                </div>
                <div class="row">
                <div>
                	<h5>Coordonnées</h5>
                  		<ul class="list-unstyled mb-0">
                    
                      	<li>Latitude : <s:property value="site.coordonnee.x"/></li>
                      	<li>Longitude : <s:property value="site.coordonnee.y"/></li>
                 
                  		</ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          

       	<div class="row">
       	<div class="col-md-12 bg-light ">
        	
            <h3>Informations techniques</h3>
            
            
              	<div class="col-md-4">
                
                	<h3>Altitude</h3>
                  <ul class="list-unstyled mb-0">        
           		<s:iterator value="site.listeAltitude">
  						<li> <s:property value="typeAlt" /> : <s:property value="alt" /></li>
				</s:iterator>
                  </ul>
                
                </div>
                <div class="col-md-4">
                	<h3>Orientation</h3>
                  		<ul class="list-unstyled mb-0">                  
                 <s:iterator value="site.listeOrientation">
  						<li><s:property value="orientation" /></li>
				</s:iterator>                
                  		</ul>
           
                </div>
                
                <div class="col-md-4">
                	<h3>Difficulté</h3>
                  		<ul class="list-unstyled mb-0">                  
				<s:iterator value="site.listeCotation">
  						<li> <s:property value="typeCot" /> : <s:property value="cot.cot" /></li>
				</s:iterator>               
                  		</ul>
           
                </div>
              </div>
            </div>
          

    
	
		
		
	<h3 class="md-12">Description</h3> <br>
	
	<p><s:property value="site.description"/></p><br>
	
	<h3 class="md-12">Accès au spot</h3><br>
	
	<p> <s:property value="site.acces"/></p><br>
	
	<h3 class="md-12">Autres infos</h3><br>
	Site iD : <s:property value="site.id"/>  <br/>

	Nombre de voies : <s:property value="site.nbVoie"/>  <br/>
	Nombre de secteurs: <s:property value="site.nbSecteur"/>  <br/>
	
	</div>
	
	
	<footer> <%@ include file="../include/footer.jsp"%> </footer>
</body>
</html>