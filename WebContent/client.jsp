<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Client</title>
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
			<form method="get" action="ClientServlet">
			  <div class="mb-3">
			    <label for="exampleInputnom1" class="form-label">Nom </label>
			    <input type="text" pattern="[a-z A-Z]{4,30}" required name="nom" class="form-control" id="exampleInputnom1" >
			  </div>
			  <div class="mb-3">
			    <label for="prenom" class="form-label">Prénom</label>
			    <input type="text" pattern="[a-z A-Z]{4,30}" required name="prenom" class="form-control" id="prenom">
			  </div>
			  <div class="mb-3">
			    <label for="email" class="form-label">Email</label>
			    <input type="email" required name="email" class="form-control" id="email">
			  </div>
			  <div class="mb-3">
			    <label for="tel" class="form-label">Téléphone</label>
			    <input type="text" pattern="[+0-9]{8,}" required name="telephone" class="form-control" id="telephone">
			  </div>
			   <div class="mb-3">
			    <label for="adresse" class="form-label">Adresse</label>
			    <textarea  required name="adresse" class="form-control" id="adresse"></textarea>
			  </div>
			  <div class="mb-3">
			    <label for="tel" class="form-label">Code application</label>
			    <input type="text" pattern="[0-9]{8,12}" required name="code" class="form-control" id="code">
			  </div>
			  <button type="submit" class="btn btn-primary">Ajouter</button>
			</form>    
		</div>
		
	    <div class="col">	      
	    </div>
	  </div>
	</div>
</body>
</html>