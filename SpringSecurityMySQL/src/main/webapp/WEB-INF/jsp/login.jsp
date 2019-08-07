<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>INICIAR SESSION</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resources/bootstrap/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body {
	margin-top: 80px;
	background: #BBA9BB;
}
</style>
</head>
<body>

	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="text-center">INICIAR SESSION</h3>
					<%
						if (session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null) {
							
					%>
					<label class="error">Error en proceso login</label>
					<%
					out.println(session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")); 
						}
						session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
					%>
				</div>
				<div class="panel-body">
					<form class="form" name="f" method="post"
						action="<%=request.getContextPath()%>/j_spring_security_check">
						<div class="form-group">
							<label for="j_username">USUARIO:</label> 
							<input type="text" class="form-control" id="j_username" name="j_username" />
						</div>
						<div class="form-group">
							<label for="j_password">CONTRASEÑA:</label> 
							<input type="password" class="form-control" name="j_password">
						</div>
						<button type="submit" class="btn btn-success btn-block">Entra!</button>
						<a href="index.htm" class="btn btn-danger btn-block" role="button">Cancelar</a>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>