<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" ng-app="myApp">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SISTEMA CLIENTE</title>
<!-- BOOTSTRAP STYLES-->
<link rel="stylesheet" href="../../resources/bootstrap/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- FONTAWESOME STYLES-->
<link href="../../resources/assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<!-- link href="../../resources/assets/css/custom.css" rel="stylesheet" / -->
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

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#/!">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu" style="background: black; color: white;">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> <sec:authentication property="principal.username"/></a></li>
        <li><a  href='<c:url value="/j_spring_security_logout"/>'><span class="glyphicon glyphicon-log-out"></span> Cerrar</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
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
    <!--script src="../../resources/assets/js/custom.js"></script -->
      <!-- ANGULAR SCRIPTS -->
    <script src="../../resources/angular/angularjs/1.6.4/angular.min.js"></script>
    <script src="../../resources/angular/angularjs/1.6.4/angular-route.js"></script>
    <script src="../../resources/js/user/mainangular.js"></script>
</body>
</html>