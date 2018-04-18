<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<head>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">

<title>Menu</title>

<link
	href="<s:url value='webjars/bootstrap/4.0.0-1/css/bootstrap.css'/>"
	rel="stylesheet" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

<link href="<s:url value='css/layout.css'/>" rel="stylesheet" />

</head>

<body>
	
	<div class="container">
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg  navbar-light bg-light" >
	
		<a class="navbar-brand" href="index.action">
			<img id='logo' class='img-responsive' alt="Climber" src="image/logo5.png">			
		</a>
		
		<button class="navbar-toggler" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-md-center" id="navbarResponsive">
			<ul class="navbar-nav justify-content-center">

			
				<li class="nav-item">
					<a class="nav-link" href="#">ACCUEIL</a>
				</li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownPortfolio" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> SPOTS </a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdownPortfolio">
						<s:a class="dropdown-item" action="add_site">PARTAGER UN SPOT</s:a>
						<s:a class="dropdown-item" action="recherche_site">RECHERCHE D'UN SPOT</s:a>
						

					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownBlog" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> TOPOS </a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdownBlog">
						<s:a class="dropdown-item" action="add_topo">PROPOSER UN TOPO</s:a>
						<a class="dropdown-item" href="#">TROUVER UN TOPO</a>
						
						
					</div>
				</li>

				
				
			</ul>
		</div>
						<s:if test="#session.user">
            Utilisateur connecté :
            
            <s:property value="#session.user.nom" />

            <s:a action="logout" class="btn btn-outline-primary my-2 my-sm-0 justify-content-right">Deconnexion</s:a>
    		</s:if>
    			<s:else>
       				 <s:a action="login" class="btn btn-outline-primary my-2 my-sm-0 justify-content-right">Connexion</s:a>
    			</s:else>
	
	</nav>
	
	</div>
	



</body>
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/popper.js/1.12.9-1/umd/popper.min.js"></script>
<script src="webjars/bootstrap/4.0.0-1/js/bootstrap.js"></script>



</html>
