<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"><!-- Font Awesome JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">


<title>Jugadores</title>
<style>
            body {font-family: Segoe UI Light;}
            input {width: 100%;}       
            .row-divider {margin: 10px; border-bottom: 1px solid gray;}
</style>
 <jsp:include page="navbar.jsp" />
</head>
<body>

<h1 align="center"> <c:out value="${equipo.nombre}"/></h1> <br><br>
<h3 align="center">JUGADORES </h3> <br>
  



<div class="table-responsive-sm">

        <table class="table table-striped">
            <thead class="bg-light">
    <tr>
        <th>NOMBRE</th>
        <th>PUESTO</th>
        <th>FECHA NACIMIENTO</th>
        <th>LUGAR NACIMIENTO</th>
        <th>EMAIL</th>
        <th>EDITAR</th>
        <th>BORRA</th>
        <th>ver jugador</th>
    </tr>
     </thead>
    <c:forEach items="${jugadores}" var="jugador">

    <tr>
        <td>
            <c:out value="${jugador.nombre}" />
        </td>
        <td>
            <c:out value="${jugador.puesto}" />
        </td>
         <td>
            <c:out value="${jugador.fechaNacimiento}" />
        </td>
        <td>
            <c:out value="${jugador.lugarNacimiento}" />
        </td>
        <td>
            <c:out value="${jugador.email}" />
        </td>
         
        <td>
           <a href='<c:url value="/jugadores/${jugador.idJug}/update" />'>  <i class="far fa-edit"></i></a>
        </td>
        <td>
             <a href='<c:url value="/jugadores/${jugador.idJug}/delete" />'>  <i class="fas fa-trash-alt"></i></a>
        </td>
          <td>
             <a href='<c:url value="/jugador/${jugador.idJug}" />'>  <i class="fas fa-eye"></i></a>
        </td>
    </tr>
    </c:forEach>
    <tbody>
</table>
<br>
<br>
</div>
	<sf:form action="${pageContext.request.contextPath}/jugadores/save"
		method="post" modelAttribute="jugador">
		<table width="50%" border="0" align="center">
			<c:if test="${jugador.idJug ne 0}">
				<sf:input path="idJug" type="hidden" />
			</c:if>
			<tr>
			<tr>
				<td>ID</td>
				<td><c:out value="${jugador.idJug}"></c:out></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><sf:input path="nombre" type="text" /></td>
			</tr>
			<tr>
				<td>Puesto</td>
				<td><sf:select path="puesto">
						<sf:option value="Portero" />
						<sf:option value="Defensa" />
						<sf:option value="Centrocampista" />
						<sf:option value="Delantero" />
					</sf:select></td>
			</tr>
			<tr>
				<td>Lugar Nacimiento</td>
				<td><sf:input path="lugarNacimiento" type="text" /></td>
			</tr>
			<!-- 			<tr> -->
			<!-- 				<td>Fecha Nacimiento</td> -->
			<%-- 				<td><sf:input path="fechaNacimiento" type="text" /></td> --%>
			<!-- 			</tr> -->
			<tr>
				<td>email</td>
				<td><sf:input path="email" type="text" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input
					onclick="alert('Va realizar cambios en el jugador con ID: <c:out value="${jugador.idJug}"></c:out>' )"
					type="submit" value="Guardar cambios" /></td>
			</tr>
		</table>
	</sf:form>



		
</body>
</html>