<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
		
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
	<title>Found It! | Profilo Utente</title>
		
	<style type="text/css">
		div.displayTab label.registra {
			min-width: 100px;
		}
		div.displayTab label.datiprofilo {
			min-width: 200px;
			font-weight: bold;
			
			
		}
	</style>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<div id="containerSuperiore">
		<div class="top">
			<h2><center> PROFILO UTENTE</center></h2>
		</div>
		<hr>
		<div class="container ">
			<br><br><br>	
			<div class="image-box">
				<center><b> nome utente</b> </center>
				<br>
            	<img src="<%=request.getContextPath()%>/images/userStandard.png" id="user" alt="fotoUser">
            	<br>
            	<button type="submit" name="submit">Cambia immagine del profilo</button>
 				<br><br>
 			</div>
 			
 		<div class="tabContainer">	
 			<div class="tab">
				<button style="width:25%;" class="tablinks" onclick="switchTab(event, 'Dati Societa Sportiva')" id="defaultOpen">Dati Società Sportiva</button> 			
  				<button style="width:25%;" class="tablinks" onclick="switchTab(event, 'Dati Personali')" id="defaultOpen">Dati Personali</button>
  				<button style="width:25%; border-left:1px solid black; border-right:1px solid black;" class="tablinks" onclick="switchTab(event, 'Dati Account')">Dati Account</button>
  				<button style="width:25%;" class="tablinks" onclick="switchTab(event, 'Privacy e Sicurezza')">Privacy e Sicurezza</button>
			</div>
			
			<div align="center" id="Dati Societa Sportiva" class="tabcontent">
			<h2>Dati Società Sportiva</h2>
  				<div>
  				<form name="datiSocietaSportiva" action="" method="POST">
        			<section style="width: 60%;">
        				<div class="displayTab">
							<label style="font-weight:600;width:39%;float:left;">Nome Società Sportiva</label>						
							<input type="text" name="nomeSocieta" value=""> 
						</div>
						
						<div class="displayTab">
							<label class="registra">Indirizzo sede</label>	
							<input type="text" name="indirizzoSede" value="">
						</div>
						<div class="displayTab">
							<label class="registra">Partita Iva</label>	
							<input type="text" name="partitaIva" value="">
						</div>
					</section>
							
					<section style="width: 40%;">
												 
					<div class="formelement">
					<label class="registra">Telefono</label>
				 	<input type="text" name="telefono" value="">
				    </div>

					<div class="formelement">
					<label class="registra">Codice di autenticazione</label>
				 	<input type="text" name="codiceAutenticazione" value="">				 
   					</div>	
					</section>
						
					<br><br>
					<button style="width:15%;"type="submit" name="cambiaDatiPersonali">Cambia</button>
					<br><br><br>	
					</form>	
        		</div>    		
			</div>



			<div align="center" id="Dati Personali" class="tabcontent">
			<h2>Dati Personali</h2>
  				<div>
  				<form name="datiPersonali" action="" method="POST">
        			<section style="width: 50%;">
        				<div class="displayTab">
							<label class="registra">Nome</label>						
							<input type="text" name="nome" value=""> 
						</div>
						
						<div class="displayTab">
							<label class="registra">Cognome</label>	
							<input type="text" name="cognome" value="">
						</div>
						<div class="displayTab">
							<label class="registra">Codice Fiscale</label>	
							<input type="text" name="codiceFiscale" value="">
						</div>
			
						<div class="displayTab"> 
							<label class="registra">Città</label>
							<input type="text" name="citta" value="">
						</div>
					</section>
							
					<section style="width: 50%;">
												 
						<div class="displayTab">	
							<label class="registra">Provincia</label>
							<input type="text" name="provincia" value="">
						</div>
											
						<div class="displayTab">
							<label  class="registra">Cap</label>
							<input type="text" name="cap" value="">
						</div>
											
						<div class="displayTab">
							<label class="registra">Telefono</label>
							<input type="text" name="telefono" value="">
	 					</div>
					</section>	
					<br><br>
					<button style="width:15%;"type="submit" name="cambiaDatiPersonali">Cambia</button>
					<br><br><br>	
					</form>	
        		</div>    		
			</div>

			<div align="center" id="Dati Account" class="tabcontent">
  				<h2>Dati Account</h2>
  				
  				<div style="width: 50%; margin-left: auto; margin-right: auto;">
  					<form name="datiAccount" action="" method="POST">
  					<div class="displayTab">
						<label  class="datiprofilo">Username</label>
				 		<input name="username" readonly="readonly" value=""> 
					</div>
				
					<div class="displayTab">
						<label  class="datiprofilo">Password</label>
				 		<input	type="password" name="password" value="">	 
					</div>
					
					<div class="displayTab">
						<label  class="datiprofilo">Conferma password</label>
				 		<input	type="password" name="confpassword" value="">	 
					</div>
				
					<div class="displayTab">
						<label  class="datiprofilo">Email<span style="color: #FF0000">*</span></label>
				 		<input type="email" name="email" value="">				 
   					</div>
   					<br><br>
					<button style="width:30%;" type="submit" name="cambiaDatiProfilo">Cambia</button>
					<br><br><br>
					</form>
   				</div>
   				
			</div>

			<div id="Privacy e Sicurezza" class="tabcontent">
  				<h2>Privacy e Sicurezza</h2>   
  				<h3>Informativa sul trattamento dei dati personali</h3>
  				<p>Found It rispetta e tutela la privacy dei propri utenti.<br>Al fine di rafforzare la fiducia dei nostri utenti, ed anche ai sensi dell&rsquo;art. 13 del Codice della Privacy (d.lgs. 196 del 30 giugno 2003), forniamo l&rsquo;informativa relativa al trattamento dei dati personali eventualmente forniti dagli utenti che interagiscono con i servizi web di Found It<br>
     				La presente informativa &egrave; relativa esclusivamente all&rsquo; eventuale trattamento di suoi dati personali da Lei comunicati o altrimenti ottenuti da Found It! per effetto del Suo utilizzo del Sito. Specifiche informative di privacy verranno riportate o visualizzate nelle pagine del sito predisposte alla fornitura di particolari servizi a richiesta.
  				</p>
			</div>
 		</div>
	</div>	
</div>

	<%@include file="footer.jsp"%>
	
	<script>
		
		function switchTab(evt, cityName) {
    		var i, tabcontent, tablinks;
    		tabcontent = document.getElementsByClassName("tabcontent");
    		for (i = 0; i < tabcontent.length; i++) {
        		tabcontent[i].style.display = "none";
   		 	}
    		tablinks = document.getElementsByClassName("tablinks");
    		for (i = 0; i < tablinks.length; i++) {
        		tablinks[i].className = tablinks[i].className.replace(" active", "");
    		}
    		document.getElementById(cityName).style.display = "block";
    		evt.currentTarget.className += " active";
		}
		document.getElementById("defaultOpen").click();
	</script>
     	
</body>
</html>