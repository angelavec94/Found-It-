<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>Found It! | Aggiungi Campo</title>
</head>
<body>
<%@include file="header.jsp"%>	

		<div id="containerSuperiore">
		<div class="top">
				<h2><center>AGGIUNGI UN CAMPO</center></h2>
		</div>
		<hr style= "margin-left:1%; margin-right:1%">
		<div  align="center" class="container">
			<form name="aggiungiCampo" action="" method="POST">
			<div style= "width:50%;">
				<br><br>
				<div class="formelement">
					<label  class="registra">Nome</label>
					<input class="campi" type="text" name="nomeCampo" placeholder=" inserisci nome campo">
				</div>

				<div class="formelement">
					<label  class="registra">Fascia oraria</label>
				 	<input class="campi" type="text" name="fasciaOraria" placeholder=" inserisci fascia oraria">
				</div>

				<div class="formelement">
					<label  class="registra">Luogo</label> 
					<input id="geocomplete" class="campi" type="text" size="40" name="luogo" placeholder=" inserisci un luogo"/>
				</div>

				<div class="formelement">
					<label  class="registra">Tipologia</label>
					<input class="campi" type="text" name="tipologia"  placeholder=" inserisci la tipologia(es. calcio)">
				</div>

				<div class="formelement">
					<label  class="registra">Prezzo</label>
				 	<input class="campi" type="text" name="prezzo"  placeholder=" inserisci il prezzo">
				</div>

				<br>
				<div style="text-align:center;">
					<button class="buttonreg" type="submit" name="submit"><b>Conferma</b></button>
				</div>
				<br><br>
	</div>
	</form>
				
	</div>
			<div style="text-align: left; padding-left: 0.8%;">

	   		</div>
	</div>
	
	
	<%@include file="footer.jsp"%>
</body>
</html>