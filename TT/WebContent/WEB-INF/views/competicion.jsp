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
	<h1 align="center" >Division - ${division}</h1>

	<div class="table-responsive-sm">

		<table class="table table-striped" >
			<thead>

				<tr>
					<th>NOMBRE</th>
					<th>VER</th>
				</tr>
			</thead>

			<c:forEach items="${equiposDiv}" var="equipo">
				<tbody>
					<tr>
						<td><c:out value="${equipo.nombre}" /></td>

						<td><a href='<c:url value="/jugadores/${equipo.idEq}" />'>
								<i class="fas fa-list-ul"></i>
						</a></td>

					</tr>
			</c:forEach>

			</tbody>
		</table>
	</div>


</body>
</html>