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
		             <h1 class="text-center text-uppercase"><s:property value="site.nom"/>
      		</h1>
      
      <div class="row">
             <div class="col-xs-12 col-md-8 col-lg-9" id="left-column">

       <div class="row">
       	 <figure class="figure" id="detailImg">
          <img class="figure-img img-fluid rounded" src="image/site/<s:property value="site.image"/>"alt="Site image">
        </figure>
       </div>
        
        <s:if test="%{site.description!=''}">
        <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-desc" aria-expanded="true" aria-controls="associated-desc">
      	   		<i class="fa fa-leanpub"></i> Description du site <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-desc" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     				<p><s:property value="site.description"/></p><br>
		
       		</div>
    
  </div>
  		</s:if>
  
  		 <s:if test="%{site.acces!=''}">
  		       <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-acces" aria-expanded="true" aria-controls="associated-acces">
      	   		<i class="fa fa-car"></i> Accès au site <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-acces" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     				<p> <s:property value="site.acces"/></p><br>
		
       		</div>
    
  </div>
        
        </s:if>
         <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-secteur" aria-expanded="true" aria-controls="associated-secteur">
      	   		<i class="fa fa-tree"></i> Secteurs <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-secteur" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     		     	
				 <s:iterator value="site.listeSecteur">
				 		<h5><s:property value="Nom du secteur" /> <s:property value="nom" /></h5>
  						<p><s:property value="description" /></p>
				</s:iterator> 
				
		
       		</div>
       		</div>



        	<button class="btn btn-primary btn-md m3"  data-toggle="modal" data-target="#myModal">
  Ajouter un secteur
			</button>
			

			
			<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

</div>

<div class="modal-body">
<h5 class="modal-title text-left"  id="myModalLabel">
Ajout d'un secteur
</h5>
<s:form action="add_secteur" method="post" cssClass="well form-vertical " theme="bootstrap" enctype="multipart/form-data">
		    
		    <s:textfield
			class="form-control col-9"
            label="Nom du secteur" 
            name="secteur.nom" 
            requiredLabel="true"
            />
		       
       	 	<s:textarea 
        	class="form-control" 
        	rows="5" 
        	name="secteur.description" 
        	label="Description du secteur" 	
        	requiredLabel="true" 
        	/>
        	
        	<s:hidden  value="%{site.id}" name="site.id"></s:hidden>
        	
        	
        	
        	<s:submit class="btn btn-primary mb-3" value="Ajouter un secteur"/>
        	
        	</s:form>
</div>
</div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

         <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-voie" aria-expanded="true" aria-controls="associated-voie">
      	   		<i class="fa fa-line-chart"></i> Voies <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-voie" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     		     	
				 <s:iterator value="site.listeVoie">
				 
				 		<h5> <s:property value="nom" /> 				 		
				 		<button class="btn btn-secondary pull-right btn-sm m3"  data-toggle="modal" data-target="#<s:property value="voieId"/>">
 							 Description
						</button></h5> 
				 		<p>
				 		<b>Type :</b> <s:property value="typeVoie" /> 
				 		<b>Hauteur :</b> <s:property value="hauteur" /> 
				 		<b>Nombre de points :</b> <s:property value="nbPoint" />
				 		<b>Difficulté :</b> <s:property value="cotation.cot" /> </p>
				 		
				 					<div class="modal fade" id="<s:property value="voieId"/>" tabindex="-1" role="dialog" aria-labelledby="myModalDesc" aria-hidden="true">
									<div class="modal-dialog">
									<div class="modal-content">
									<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									
									</div>
									<div class="modal-body">
									<h5 class="modal-title text-left"  id="myModalDesc">
									Description
									</h5>
									
									<p><s:property value="description" /></p>
									
									</div>
									</div><!-- /.modal-content -->
									</div><!-- /.modal-dialog -->
									</div><!-- /.modal -->
									
									

						
				</s:iterator> 
				

       		</div>
       		</div>



        	<button class="btn btn-primary btn-md m3"  data-toggle="modal" data-target="#myModal2">
  Ajouter une voie
			</button>
			<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalVoie" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

</div>
<div class="modal-body">
<h5 class="modal-title text-left"  id="myModalVoie">
Ajout d'une voie
</h5>
<s:form action="add_voie" method="post" cssClass="well form-vertical " theme="bootstrap" enctype="multipart/form-data">
		    
		    <s:textfield
			class="form-control col-9"
            label="Nom de la voie" 
            name="voie.nom" 
            requiredLabel="true"
            />
            
            <s:textfield
			class="form-control col-9"
            label="Type de voie" 
            name="voie.typeVoie" 
            requiredLabel="true"
            />
            
            <s:textfield
			class="form-control col-9"
            label="Nombre de points" 
            name="voie.nbPoint" 
            requiredLabel="true"
            />
            
            <s:textfield
			class="form-control col-9"
            label="Hauteur" 
            name="voie.hauteur" 
            requiredLabel="true"
            />
            
            		<s:select 
			label="Cotation de la voie"
			required="true"
       		name="cotVoie"
       		list="session.listeCotation"
        	listKey="id"
       		listValue="cot"
       		value="%{listeCotation.{id}}"
 		/>
		       
       	 	<s:textarea 
        	class="form-control" 
        	rows="5" 
        	name="voie.description" 
        	label="Description de la voie" 	
        	requiredLabel="true" 
        	/>
        	
        	<s:hidden  value="%{site.id}" name="site.id"></s:hidden>
        	
        	
        	
        	<s:submit class="btn btn-primary mb-3" value="Ajouter une voie"/>
        	
        	</s:form>
</div>
</div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-topo" aria-expanded="true" aria-controls="associated-topo">
      	   		<i class="fa fa-tree"></i> Topos <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-topo" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     		     	
				 <s:iterator value="site.listeTopo">
				 		<h5>
						<s:a action="detail_topo">
						<s:param name="id" value="id"></s:param>
						<s:property value="Titre" /></s:a>
				 		</h5>
				 		<p>
				 		<b>Auteur :</b> <s:property value="auteur" /> 
				 		<b>Statut :</b> <s:property value="statut" /> 
				 		
				 		</p>
				 		
  						
				</s:iterator> 
				
		
       		</div>
       		</div>



        	<button class="btn btn-primary btn-md m3"  data-toggle="modal" data-target="#myModalTopo">
  Ajouter un topo
			</button>
			

			
			<!-- Modal -->
<div class="modal fade" id="myModalTopo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

</div>

<div class="modal-body">
<h5 class="modal-title text-left"  id="myModalLabel">
Liste des topos disponibles
</h5>
<s:form action="lier_topo" method="post" cssClass="well form-vertical " theme="bootstrap" enctype="multipart/form-data">
		    
		<s:select 
		
		label="Liste des Topos"
		required="true"
        name="topoIdOut"
        list="session.listTopo"
        listKey="id"
        listValue="%{titre +'  (' +auteur+')'}"
        value="%{session.listTopo.{id}}"
               
 		/>
        	
        <s:hidden  value="%{site.id}" name="site.id"></s:hidden>	
        	
        	
        	
        	<s:submit class="btn btn-primary mb-3" value="Ajouter ce topo au site"/>
        	
        	</s:form>
</div>
</div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
        
          <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-comment" aria-expanded="true" aria-controls="associated-comment">
      	   		<i class="fa fa-comment-o"></i> Commentaires <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-comment" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        			
        			<s:bean name="fr.mb.projet.converter.DateComp" var="DateComp"/>
     		     <s:sort comparator="#DateComp" source="site.listeComment">
				 <s:iterator >
				 		<h6>Posté le : <s:date  format="dd/MM/yyyy" name="date" /> par <s:property value="user.pseudo" /></h6>
  						<p><s:property value="message" /></p>
				</s:iterator> 
				</s:sort>
				
		
       		</div>
       		</div>
      
      <div class="row justify-content-center m-3">
      <h3 class="text-center">Ajouter un commentaire sur le site </h3>
      </div>
      
      <div>
      	<s:form action="add_comment" method="post" cssClass="well form-vertical " theme="bootstrap" enctype="multipart/form-data">
		
	
			
	
               
       	 <s:textarea 
        	class="form-control" 
        	rows="5" 
        	name="comment.message" 
        	label="Commentaire" 	 
        	/>
        	
        	<s:hidden  value="%{site.id}" name="site.id"></s:hidden>
        	
        	
        	
        	<s:submit class="btn btn-primary mb-3" value="Ajouter un commentaire"/>
        	
        	</s:form>
      
      
      </div>
        
      </div>
      <div class="col-xs-12 col-md-4 col-lg-3" id="right-column">
      
      <h5 class="mt-3" data-toggle="collapse" href="#associated-situ" aria-expanded="true" aria-controls="associated-situ">
      	   		<i class="fa fa-info-circle"></i> Informations <i class="fa fa-arrow-down pull-right" ></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-situ" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        <h6> <i class="fa fa-globe"></i> Situation géographique</h6>
     	<ul>
						 <li><b>Pays : </b> <s:property value="site.pays.name"/></li>
           				 <li><b>Région/département : </b><s:property value="site.state.name"/></li>
           				    
		</ul>
		
		<s:if test="%{site.coordonnee.x!=null||site.coordonnee.y!=null}">
		<h6> <i class="fa fa-map-marker"></i> Coordonnées GPS </h6>
     	<ul>
     					
						<li><b>Latitude :</b> <s:property value="site.coordonnee.x"/></li>
						
                      	<li><b>Longitude :</b> <s:property value="site.coordonnee.y"/></li>
           				
		</ul>
		</s:if>
		
	   	<h6> <i class="fa fa-flag-o"></i> Détail du site</h6>
     	<ul>
     					<s:if test="%{site.situation.type!=''}">
						<li><b>Type de site :</b> <s:property value="site.situation.type"/></li>
						</s:if>
          				<s:if test="%{site.nbVoie!=null}">
           				<li><b>Nombre de voies :</b> <s:property value="site.nbVoie"/>  </li>
						</s:if>
						<s:if test="%{site.nbSecteur!=null}">
						<li><b>Nombre de secteurs:</b> <s:property value="site.nbSecteur"/>  </li>
						</s:if>
		</ul>
		
		
		
       		</div>
    
  </div>
      
      
      		<h5 class="mt-3" data-toggle="collapse" href="#associated-alt" aria-expanded="true" aria-controls="associated-alt">
      	   		<i class="fa fa-arrows-v"></i> Altitude <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-alt" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     	<ul>
				<s:iterator value="site.listeAltitude">
  						<li><b>Altitude <s:property value="typeAlt" /> :</b> <s:property value="alt" /> mètres</li>
				</s:iterator>    
		</ul>
		
       		</div>
    
  </div>
  
  	<h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-ori" aria-expanded="true" aria-controls="associated-ori">
      	   		<i class="fa fa-compass"></i> Orientation du site <i class="fa fa-arrow-down pull-right"></i>
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
      	   		<i class="fa fa-area-chart"></i> Type de difficulté <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-cot" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     	<ul>
				
				<s:iterator value="site.listeCotation">
  						<li> <b>Cotation <s:property value="typeCot" /> :</b> <s:property value="cot.cot" /></li>
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