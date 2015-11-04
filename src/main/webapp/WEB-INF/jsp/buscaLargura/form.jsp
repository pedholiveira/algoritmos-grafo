<html>
	<head>
		<title>Algoritmos de Grafo</title>
		
		<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<style>
			body {
				padding-top: 70px; 
			}
		</style>
	</head>	
	<body>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
			    <div class="navbar-header">
					<a class="navbar-brand" href="#">Brand</a>
			    </div>
			</div>
		</nav>
		<div class="container">
			<div class="alert alert-danger" role="alert">
	  			${erro}
			</div>
			<div class="panel panel-default">
			  	<div class="panel-heading">
			  		Algoritmo de busca em largura
			  	</div>
			  	<div class="panel-body">
			  		<form method="post" action="executar">
						<div class="form-group">
				    		<label for="vertices">Grafo</label>
					  		<input id="vertices" name="vertices" type="text" class="form-control" placeholder="(A,B)(A,C)(A,D)(B,E)">
						</div>
				    	<div class="form-group">
				    		<label for="verticeRaiz">Vértice raiz</label>
					  		<input id="verticeRaiz" name="verticeRaiz" type="text" class="form-control" placeholder="Vértice raiz" maxlength="1">
						</div>
						<button type="submit" class="btn btn-default">Executar</button>
			  		</form>
			  	</div>
			</div>
		</div>
	    <script src="/resources/js/jquery-2.1.4.js"></script>
	    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>
