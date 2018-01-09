<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">

		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Found It! | Recupero Password</title>

		<!--Css document  -->
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
		
</head>
<body>
		<%@include file="header.jsp"%>	
		<div id="containerSuperiore">
		<div class="top">
				<h2><center>RECUPERO PASSWORD</center></h2>
		</div>
		<p><center>Se hai dimenticato la password del tuo account, quest'area ti permette di recuperarla</center></p>
		<br>
		<hr>
		<br>
		<div class="container ">
				<section>
				<b>Inserisci la tua email</b>
				<br>
				<br>
				<label>Inserisci l'indirizzo completo: </label>
				<br>
				<br>
				<input style="width:260px;"class="campi" type="email" name="email" placeholder="  name@exemple.com">
				<br>
				<br>
				<b>Verifica di sicurezza</b>
				<br>
				<br>
				Per la tutela, ti chiediamo di dimostrarci che questa operazione non è fatta da un sistema automatico.<br> Grazie!
				<br>
				<br>
				<br>
				      <div class="g-recaptcha" data-sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"></div>
				
					<br>
					<button style="margin-left: 50px; float: right; width:120px;" type="submit" id="submit" name="submit">Annulla</button>
					<button style="float: right;  width:120px;" type="submit" name="submit">Conferma</button>
					<br>
					<br>
				</section>
		</div>
		</div>	
		<%@include file="footer.jsp"%>	
</body>
</html>