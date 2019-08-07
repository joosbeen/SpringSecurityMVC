<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" ng-app="myApp">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SISTEMA ADMINISTRATIVO</title>
<!-- BOOTSTRAP STYLES-->
<link rel="stylesheet" href="../../resources/bootstrap/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- FONTAWESOME STYLES-->
<link href="../../resources/assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="../../resources/assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

<style type="text/css">
	.nameuser{
		color: rgb(0,120,215);
		font-size: 15;
	}
</style>
</head>
<body>


	<div id="wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> 
						<img src="assets/img/logo.png" />
						
					<strong class="text-center nameuser" id="nameuser"><sec:authentication property="principal.username" /></strong>
					</a>

				</div>
				<span class="logout-spn">
					<a href="<c:url value="/j_spring_security_logout"/>"  style="color: #fff;">Cerrar
				sesión</a>
				</span>
			</div>
		</div>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li class="active-link">
					<a href="#/!"> <i class="fa fa-desktop "></i>Bienvenido</a>
				</li>
				<li>
					<a href="#!users"> <i class="fa fa-user "></i> Usuarios </a>
				</li>
				<li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="">
		          	<i class="fa fa-bar-chart" aria-hidden="true"></i> Reportes </a>
		          <ul class="dropdown-menu">
		            <li><a href="#!reportusers"><i class="fa fa-user" aria-hidden="true"></i> Usuarios</a></li>
		            <li><a href="#">Page 1-2</a></li>
		            <li><a href="#">Page 1-3</a></li>
		          </ul>
		        </li>
				<li>
					<a href="blank.html">
						<i class="fa fa-edit "> </i>
						Blank Page 
					</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-qrcode "></i>
					My Link One
					</a>
				</li>
				<li>
					<a href="#"><i class="fa fa-bar-chart-o"></i>
						My Link Two
					</a>
				</li>
				<li>
					<a href="#">
						<i class="fa fa-edit "></i>
					My Link Three 
					</a>
				</li>
				<li>
					<a href="#">
						<i class="fa fa-table "></i>
					My Link Four
					</a>
				</li>
				<li>
					<a href="#">
						<i class="fa fa-edit "></i>
					My Link Five 
					</a>
				</li>

			</ul>
		</div>

		</nav>

		<div id="page-wrapper">
		<!-- Aqui va todo el contenido -->
			<div ng-view></div>			
		</div>
	</div>
	
	  <!-- JQUERY SCRIPTS -->
  <script src="../../resources/jquery/3.3.1/jquery.min.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
  <script src="../../resources/bootstrap/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="../../resources/assets/js/custom.js"></script>
      <!-- ANGULAR SCRIPTS -->
    <script src="../../resources/angular/angularjs/1.6.4/angular.min.js"></script>
    <script src="../../resources/angular/angularjs/1.6.4/angular-route.js"></script>
    <script src="../../resources/js/mainangular.js"></script>
    <script src="../../resources/js/usersAdminCtrl.js"></script>
    <script src="../../resources/js/admin/reporteUsersCtrl.js"></script>
</body>
</html>