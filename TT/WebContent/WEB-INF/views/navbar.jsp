<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <title>Gestor liga</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href='<c:url value= "/index" />'>Gestor Ligas</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href='<c:url value= "/equipos" />'>Equipos</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Ligas <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href='<c:url value= "/competicion/1" />'>1</a></li>
          <li><a href='<c:url value= "/competicion/2" />'>2</a></li>
          <li><a href='<c:url value= "/competicion/3" />'>3</a></li>
        </ul>
      </li>
        <li class="active"><a href='<c:url value= "/competicion" />'>Competiciones</a></li>    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>