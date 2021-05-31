<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client</title>
</head>
<body>
	<div class="container">
	  <div class="row">
	    <div class="col">
	    </div>
	    
	    <div class="col">
			<form method="get" action="ClientServlet">
			  <div class="mb-3">
			    <label for="exampleInputnom1" class="form-label">nom </label>
			    <input type="text" pattern="[a-z A-Z]{4,30}" required name="nom" class="form-control" id="exampleInputnom1" >
			  </div>
			  <div class="mb-3">
			    <label for="prenom" class="form-label">Prenom</label>
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