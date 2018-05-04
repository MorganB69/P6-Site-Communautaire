# P6-Site-Communautaire

Le projet a pour objectif de partager des informations relatives aux spots d'escalade ainsi que d'avoir un système de partage de Topos
entre les membres. Le site web a les fonctionnalités suivantes : 

FONCTIONALITES

Général
- Système d'authentification et contrôle des accès sur certaines fonctionalités du site

Partage de sites d'escalade :
- Ajout d'un site d'escalade avec la possibilité de renseigner de multiples critères (altitude, orientation, cotation, situation géographique etc.)
- Possibilité de modifier un site d'escalade
- Possibilité de rajouter des voies et des secteurs avec des informations spécifiques à un site
- Possibilité de rajouter des commentaires à un site
- Système de recherche de sites d'escalade via un formulaire multicritères

Topo
- Ajout d'un Topo d'escalade
- Voir la liste des Topos et voir leur disponibilité
- Possibilité de faire une demande de réservation au propriétaire du topo
- Via un espace personnel, possibilité de gérer les réservations des topos (accepter la résa rend le topo indisponible 21 jours, refuser/annuler la résa)


DEVELOPPEMENT

Projet développé avec les technologies suivantes : 
- JAVA/JAVAEE
- MAVEN : Projet multi-modules/Gestion des dépendances/Packaging
- SPRING : utilisé principalement pour l'IoC mais aussi Spring AOP avec AspectJ pour un calcul de temps d'execution d'une fonction
- STRUTS2 : framework MVC utilisé pour la couche web-app
- HIBERNATE : pour la persistence des données. Configuré via les annotations. Utilisation du template Hibernate pour les requêtes simples ou de session personnalisée selon les besoins.

- HTML/CSS/BOOTSTRAP : pour les JSP
- Jquery : pour la création d'un formulaire dynamique (actualise les régions en fonction du pays sélectionné via récupération des données en Json)
- Log4J pour la gestion des Logs.

- SQL PowerArchitect : conception de la base de donnée
- PostgreSQL/PGAdmin : administration et gestion de la base de données)


CONFIGURATION

Base de donnée : Via PgAdmin : Créer une base de donnée et restaurer le fichier de backup P6 OCR db def
Logs : Modifier le fichier de paramétrage de log4j (log42.xml dans le module technical) et spécifier le dossier souhaité pour les fichiers de logs
Hibernate : Rajouter un fichier hibernate.properties dans les ressources spécifiant les paramètres de connexion à la base de donnée : 
	hibernate.connection.driver_class
	hibernate.connection.url
	hibernate.connection.username
	hibernate.connection.password

DEPLOIEMENT

L'application a été packagé via Maven et peut être déployée sur une serveur via le fichier web.war.
ex pour Tomcat, mettre le fichier war dans le dossier webapps de Tomcat.




