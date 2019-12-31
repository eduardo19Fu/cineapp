<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Horarios</title>
  	<spring:url value="/resources" var="urlPublic" />
  	<spring:url value="/horarios" var="urlHorarios" />
  	<spring:url value="/horarios/edit" var="urlEdit" />
  	<spring:url value="/horarios/delete" var="urlDelete" />
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp" />

    <div class="container theme-showcase" role="main">

      <h3>Listado de Horarios</h3>
      
      <c:if test="${mensaje !=null }">        
        		<div class='alert alert-success' role='alert'>${mensaje}</div>
        </c:if>
      
      <a href="${urlHorarios}/create" class="btn btn-success" role="button" title="Nueva Horario" >Nuevo</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <thead>
	            <tr>
	                <th>Pelicula</th>
	                <th>Fecha</th>
	                <th>Hora</th>
	                <th>Sala</th>
	                <th>Precio</th>
	                <th>Opciones</th>
	            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${horarios.content}" var="horario">
		            <tr>
		                <td>${horario.pelicula.titulo}</td>
		                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${horario.fecha}"/></td>
		                <td>${horario.hora}</td>
		                <td>${horario.sala}</td>
		                <td>${horario.precio}</td>              
		                <td>
							<a href="${urlEdit}/${horario.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${urlDelete}/${horario.id}" onclick='return confirm("�Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Delete" ><span class="glyphicon glyphicon-trash"></span></a>
						</td>
		            </tr>
	            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="">
        	<ul class="pager">
        		<li><a href="${urlHorarios}/indexPaginate?page=${horarios.number - 1}">Anterior</a></li>
        		<li><a href="${urlHorarios}/indexPaginate?page=${horarios.number + 1}">Siguiente</a></li>
        	</ul>
        </nav>
      </div>
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp" />

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script> 

  </body>
</html>
