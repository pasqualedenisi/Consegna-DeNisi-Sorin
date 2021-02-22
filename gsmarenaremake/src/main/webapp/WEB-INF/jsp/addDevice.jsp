<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Nuovo dispositivo</title>
</head>
<body>

<form class="container" method="POST" action="writeDevice">
		<div class="form-group">
			<label for="" class="mr-sm-2">Nome:</label>
			<input class="form-control" type="text" id="name" name="name"></input>
		</div>
		
		<div class="form-group">	
			<label for="" class="mr-sm-2">Numero di serie:</label>
			<input class="form-control" type="text" id="serialnumber" name="serialnumber"></input>
		</div>
			
		<div class="form-group">
			<label for="" class="mr-sm-2">Brand:</label>
			<input class="form-control" type="text" id="brand" name="brand"></input>
		</div>
		
		<div class="form-group">
			<label for="" class="mr-sm-2">Tipo:</label>
			<input class="form-control" type="text" id="type" name="type"></input>
		</div>
			
		<div class="form-group">
			<label for="data" class="mr-sm-2">CPU:</label>
			<input class="form-control" type="text" id="cpu" name="cpu"></input>
		</div>
		<div class="form-group">
			<label for="data" class="mr-sm-2">RAM:</label>
			<input class="form-control" type="text" id="ram" name="ram"></input>
		</div>
		<div class="form-group">
			<label for="data" class="mr-sm-2">Data di rilascio:</label>
			<input class="form-control" type="text" id="releasedate" name="releasedate"></input>
		</div>
		<div class="form-group">
			<label for="data" class="mr-sm-2">ROM:</label>
			<input class="form-control" type="text" id="rom" name="rom"></input>
		</div>
		<div class="form-group">
			<label for="data" class="mr-sm-2">Display:</label>
			<input class="form-control" type="text" id="display" name="display"></input>
		</div>
		
		<button class="btn btn-warning">Verifica</button>
		
		<button class="btn btn-success" type="submit">Aggiungi</button>
	</form>

</body>
</html>