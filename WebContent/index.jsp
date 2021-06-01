<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
  		<div class="row">
    		<div class="col">      
    		</div>
		    <div class="col">
			      <form action="AuthServlet" method="get" class="row g-3">
					  <div class="col-auto">
					    <label for="login" class="visually-hidden">Login</label>
					    <input type="text" required pattern="[a-zA-Z0-9]+{4,30}" name="login" class="form-control" id="login" placeholder="Login">
					  </div>
					  <div class="col-auto">
						<label for="inputPassword2" class="visually-hidden">Password</label>
						<input type="password" required pattern="[a-zA-Z0-9]+{4,30}" name="mdp" class="form-control" id="inputPassword2" placeholder="Password">
					  </div>
					  <div class="col-auto">
					    <button type="submit" class="btn btn-primary mb-3">Se connecter</button>
					    <br>					    
					  </div>
					  
					  <!-- Afficher le message d'erreur -->
					  <div class="alert alert-danger" role="alert">
					  	<%	if(request.getAttribute("erreurAuthentification") != null) { %>
							<%=request.getAttribute("erreurAuthentification") %>
						<% } %>
					  </div>	
				  </form>
		    </div>
		    <div class="col">
		    </div>
  		</div>
	</div>	
</body>
</html>