﻿<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">

<head>
<title>Menu</title>
<link
	href="<s:url value='webjars/bootstrap/4.0.0-1/css/bootstrap.min.css'/>"
	rel="stylesheet" />
<link href="<s:url value='css/layout.css'/>" rel="stylesheet" />

</head>

<body>
	
	<div class="container">
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-light bg-light" >
	
		<a class="navbar-brand" href="index.action">
			<img id='logo' class='img-responsive' alt="Climber" src="image/logo5.png">
			
		</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">

			
				<li class="nav-item">
					<a class="nav-link" href="#">ACCUEIL</a>
				</li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownPortfolio" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> SPOTS </a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdownPortfolio">
						<a class="dropdown-item" href="#">Recherche d'un spot</a>
						<a class="dropdown-item" href="#">Proposer un spot</a>
						<a class="dropdown-item" href="#">Les meilleurs spots</a>

					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownBlog" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> TOPOS </a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdownBlog">
						<a class="dropdown-item" href="#">Trouver un TOPO</a>
						<a class="dropdown-item" href="#">Proposer un TOPO</a>
						
					</div>
				</li>

				<a href="saisir.action" class="btn btn-outline-primary my-2 my-sm-0">Identification</a>
				
			</ul>
		</div>
	
	
	</nav>
	
	</div>
	



</body>
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0-1/js/bootstrap.min.js"></script>

</html>
