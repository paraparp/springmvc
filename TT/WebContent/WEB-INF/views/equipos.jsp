<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">


<title>Equipos</title>
<style>
body {
	font-family: Segoe UI Light;
}

input {
	width: 100%;
}

.row-divider {
	margin: 10px;
	border-bottom: 1px solid gray;
}
-
</style>
 <jsp:include page="navbar.jsp" />
</head>
<body>
	<h1 align="center">Equipos</h1>

	<div class="table-responsive-sm">

		<table class="table table-striped">
			<thead>

				<tr>
					<th>NOMBRE</th>
					<th>DIVISION</th>
					<th>JUGADORES</th>
					<th>ACTUALIZAR</th>
					<th>BORRAR</th>
				</tr>
			</thead>

			<c:forEach items="${lequipos}" var="equipo">
				<tbody>
					<tr>
						<td><c:out value="${equipo.nombre}" /></td>
						<td><c:out value="${equipo.division}" /></td>
						<td><a href='<c:url value="/jugadores/${equipo.idEq}" />'>
								<i class="fas fa-list-ul"></i>
						</a></td>
						<td><a
							href='<c:url value="/equipos/${equipo.idEq}/update" />'> <i
								class="far fa-edit"></i></a></td>
						<td><a 
							href='<c:url value="/equipos/${equipo.idEq}/delete" />'> <i
								class="fas fa-trash-alt"></i></a></td>
					</tr>
			</c:forEach>


			<tbody>
		</table>
	</div>
	<br>
	<br>
	<div >
	<sf:form action="${pageContext.request.contextPath}/equipos/save"
		 method="post" modelAttribute="equipo">
		<table  width="30%" border="0" align="center">

			<c:if test="${equipo.idEq ne 0}">
				<sf:input class="form-control" path="idEq" type="hidden"/>
			
			</c:if>
			<tr>
				<td>Nombre</td>
				<td><sf:input class="form-control" path="nombre" type="text" /></td>
			</tr>
			<tr>
				<td>Division</td>
				<td><sf:input class="form-control" path="division" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-primary"type="submit" value="Guardar cambios" /></td>
			</tr>
		</table>
	</sf:form>
</div>
	
</body>
</html>