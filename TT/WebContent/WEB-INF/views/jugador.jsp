<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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


<title></title>
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
</style>
<jsp:include page="navbar.jsp" />
</head>
<body>

	<h1 align="center">
		<c:out value="${jugador.nombre}" />
	</h1>
	<br>
	<br>





	<div class="table-responsive-sm">

		<table class="table table-striped">
			<thead class="bg-light">
				<tr>
					<th>ID JUGADOR</th>
					<th>NOMBRE</th>
					<th>PUESTO</th>
					<th>FECHA NACIMIENTO</th>
					<th>LUGAR NACIMIENTO</th>
					<th>EMAIL</th>

				</tr>
			</thead>


			<tr>
				<td><c:out value="${jugador.idJug}" /></td>
				<td><c:out value="${jugador.nombre}" /></td>
				<td><c:out value="${jugador.puesto}" /></td>
				<td><c:out value="${jugador.fechaNacimiento}" /></td>
				<td><c:out value="${jugador.lugarNacimiento}" /></td>
				<td><c:out value="${jugador.email}" /></td>


			</tr>

			<tbody>
		</table>
		<br> <br>
	</div>
	
	<div>
	<sf:form action="${pageContext.request.contextPath}/jugadores/save"
		method="post" modelAttribute="jugador">
		<table width="30%"  align="center">
			
				<sf:input path="idJug" type="hidden" />
<%-- 				<sf:input path="fechaNacimiento" type="hidden" /> --%>
			
			<tr>
				<td>ID jugador</td>
				<td><c:out value="${jugador.idJug}"></c:out></td>
			</tr>
			<tr>
				<td>Equipo</td>
				<td>
				<sf:select class="form-control" path="equipo.idEq">
						<c:forEach items="${lequipos}" var="equipo">
					
							<option value="${equipo.idEq}">
							<c:out value=" ${equipo.nombre}" /></option>
						</c:forEach>
						
				</sf:select>
			


				</td>
			</tr>
			
			<tr>
				<td>Nombre</td>
				<td><sf:input class="form-control" path="nombre" type="text" /></td>
			</tr>
			<tr>
				<td>Puesto</td>
				<td><sf:select class="form-control" path="puesto">
						<sf:option value="Portero" />
						<sf:option value="Defensa" />
						<sf:option value="Centrocampista" />
						<sf:option value="Delantero" />
					</sf:select></td>
			</tr>
			<tr>
				<td>Lugar Nacimiento</td>
				<td><sf:input class="form-control" path="lugarNacimiento" type="text" /></td>
			</tr>
			<!-- 			<tr> -->
			<!-- 				<td>Fecha Nacimiento</td> -->
			<%-- 				<td><sf:input path="fechaNacimiento" type="text" /></td> --%>
			<!-- 			</tr> -->
			<tr>
				<td>email</td>
				<td><sf:input class="form-control" path="email" type="email" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input  class="btn btn-primary"
					onclick="alert('Va realizar cambios en el jugador con ID: <c:out value="${jugador.idJug}"></c:out>' )"
					type="submit" value="Guardar cambios" /></td>
			</tr>
		</table>
	</sf:form>

</div>

</body>
</html>