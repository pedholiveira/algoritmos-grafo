<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Busca em Profundidade</title>
		
		<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<style>
			body {
				padding-top: 70px; 
			}
		</style>
	</head>	
	<body>
		<c:import url="/WEB-INF/partials/_header.jsp" />
		
		<div class="container">
			<c:if test="${erro != null}">
				<div class="alert alert-danger" role="alert">
		  			${erro}
				</div>
			</c:if>
			<div class="panel panel-default">
			  	<div class="panel-heading">
			  		Algoritmo de Busca em Profundidade
			  	</div>
			  	
			  	<div class="panel-body">
					<form method="post" action="/buscaProfundidade/executar">
						<div class="form-group">
					   		<label for="vertices">Vértices</label>
					  		<input id="vertices" name="vertices" type="text" class="form-control" placeholder="A, B, C, D, E">
						</div>
						<div class="form-group">
					   		<label for="arestas">Arestas</label>
					  		<input id="arestas" name="arestas" type="text" class="form-control" placeholder="[A,B][A,C][A,D][B,E]">
						</div>
					   	<div class="form-group">
					   		<label for="verticeRaiz">Vértice inicial</label>
					  		<input id="verticeRaiz" name="verticeRaiz" type="text" class="form-control" placeholder="Vértice raiz" maxlength="1">
						</div>
						<button type="submit" class="btn btn-default">Executar</button>
					</form>
				</div>
			</div>
			<c:if test="${resultados != null  }">
				<div class="panel panel-default">
				  	<div class="panel-heading">
				  		Resultado do algoritmo
				  	</div>
				  	<div class="panel-body">
						<ul class="list-group">
							<c:forEach var="item" items="${resultados }">
						  		<li class="list-group-item">
						  			<c:out value="Vértice ${item.vertice }: Previsit = ${item.preVisit } e Posvisit = ${item.posVisit }"></c:out>
						  		</li>
							</c:forEach>
						</ul>
				  	</div>
				</div>
			</c:if>
		</div>
	    
	    <script src="/resources/js/jquery-2.1.4.js"></script>
	    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>
