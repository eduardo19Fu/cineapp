<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
		<title>Listado de imagenes del banner</title>
		<spring:url value="/resources" var="urlPublic" />
		<spring:url value="/banners/create" var="urlNuevo" />
		<spring:url value="/banners/edit" var="urlEdit" />
		<spring:url value="/banners/delete" var="urlDelete" />
		<spring:url value="/banners" var="urlBanners" />
		<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	  
	</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../includes/menu.jsp" />
	
	<div class="container theme-showcase" role="main">
	
	  <h3>Listado de imagenes del Banner</h3>
	  
	  <c:if test="${mensaje != null }">
	  	<div class="alert alert-success" role='alert'>${mensaje }</div>
	  </c:if>
	  
	  <a href="${urlNuevo}" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>
	
	  <div class="table-responsive">
	    <table class="table table-hover table-striped table-bordered">
	        <thead>
		        <tr>
		            <th>Id</th>
		            <th>Titulo</th>                           
		            <th>Fecha Publicacion</th>              
		            <th>Nombre Archivo</th>
		            <th>Estatus</th>
		            <th>Opciones</th>              
		        </tr>
	        </thead>
	        <tbody>
		        <c:forEach items="${banners.content}" var="lista">
			        <tr>
			            <td>${lista.id}</td>
			            <td>${lista.titulo }</td>
			             <td><fmt:formatDate pattern="dd-MM-yyyy" value="${lista.fecha}"/></td>    
			            <td>${lista.archivo}</td>
			            <c:choose>              
			            	<c:when test="${lista.estatus eq 'Activo' }">
			            		<td><span class="label label-success">${lista.estatus}</span></td>
			            	</c:when>
			            	<c:otherwise>
			            		<td><span class="label label-danger">${lista.estatus}</span></td>
			            	</c:otherwise>
			            </c:choose>
			            <td>
			                <a href="${urlEdit}/${lista.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
			                <a href="${urlDelete}/${lista.id}" onclick='return confirm("¿Esta seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
			            </td>
			        </tr>
		        </c:forEach>
	        </tbody>
	    </table>
	    <nav aria-label="">
        	<ul class="pager">
        		<li><a href="${urlBanners}/indexPaginate?page=${banners.number - 1}">Anterior</a></li>
        		<li><a href="${urlBanners}/indexPaginate?page=${banners.number + 1}">Siguiente</a></li>
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
