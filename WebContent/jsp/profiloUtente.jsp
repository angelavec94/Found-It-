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
		div.image-box {
   			 text-align: center;
    		margin-left: 35%;
    		display: block;
    		font-size: 20px;
    		width: 30%;
		}
	</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<%@page import="model.PrenotazioneBean,java.util.*,model.PrenotazioneModel,model.PrenotazioneModelDM"%>
	<% if(utente==null || utente.getUsername() == null){
		ServletContext sc = getServletContext();
		RequestDispatcher rd= sc.getRequestDispatcher("/jsp/home.jsp");
		message = "Effettuare il login prima di accedere al profilo utente!";
		request.getSession().setAttribute("message", message);
		rd.forward(request, response);
	}
	%>
	<div id="containerSuperiore" style="overflow:auto">
		<div class="top">
			<h2><center> PROFILO <label style="text-transform: uppercase;"><%= utente.getTipo() %></label></center></h2>
		</div>
		<hr>
		<div class="container ">
			<br><br><br>	
			<div class="image-box">
				<center><b> <%=utente.getNome() %> <%= utente.getCognome() %></b> </center>
				<br>
            	<img src="<%=request.getContextPath()%>/images/userStandard.png" id="user" alt="fotoUser">
            	<br>
            	<button type="submit" name="submit">Cambia immagine del profilo</button>
 				<br><br>
 			</div>
 			
 		<div class="tabContainer"  style="overflow:auto">	
 			<div class="tab">
 				<%if(utente.getTipo().equals("partnerSportivo")){%>
				<button  class="tablinks" onclick="switchTab(event, 'Dati Societa Sportiva')" id="defaultOpen">Dati Società Sportiva</button> 			
  				<%}%>
  				
  				<button  class="tablinks" onclick="switchTab(event, 'Dati Personali')" id="defaultOpen">Dati Personali</button>
  				<button  style="border-left:1px solid black; border-right:1px solid black;" class="tablinks" onclick="switchTab(event, 'Dati Account')">Dati Account</button>
  				
  				<%if(utente.getTipo().equals("utenteSemplice")){%>
				<button  style="border-right:1px solid black" class="tablinks" onclick="switchTab(event, 'Prenotazioni')" id="defaultOpen">Prenotazioni</button> 			
  				<%}%>
  				
  				<button  style="border-right:1px solid black" " class="tablinks" onclick="switchTab(event, 'Privacy e Sicurezza')">Privacy e Sicurezza</button>
			</div>
			
			<%if(utente.getTipo().equals("partnerSportivo")){%>
			<div align="center" id="Dati Societa Sportiva" class="tabcontent">
			<h2>Dati Società Sportiva</h2>
  				<div>
  				<form name="datiSocietaSportiva" action="" method="POST">
  				<input type="text" name="action" id="action" value="" style="display: none;" />
        			<section style="width: 60%;">
        				<div class="formelement">
							<label class="registra">Nome Società Sportiva</label>						
							<input type="text" name="nomeSocieta" value="<%=societa.getNomeSocieta() %>"> 
						</div>
						
						<div class="formelement">
							<label class="registra">Indirizzo sede</label>	
							<input type="text" name="indirizzoSede" value="<%=societa.getIndirizzoSede() %>">
						</div>
						<div class="formelement">
							<label class="registra">Partita Iva</label>	
							<input type="text" name="partitaIva" value="<%=societa.getPartitaIva() %>">
						</div>
					</section>
							
					<section style="width: 40%;">
												 
					<div class="formelement">
					<label class="registra">Telefono</label>
				 	<input type="text" name="telefono" value="<%=societa.getTelefono() %>">
				    </div>

					<div class="formelement">
					<label class="registra">Codice di autenticazione</label>
				 	<input type="text" name="codiceAutenticazione" value="<%=societa.getCodiceAutenticazione() %>">				 
   					</div>	
					</section>
						
					<br><br>
					<button style="width:20%;"type="submit" name="cambiaDatiPersonali">Cambia</button>
					<br><br><br><br><br>	
					</form>	
        		</div>    		
			</div>
			<%}%>


			<div align="center" id="Dati Personali" class="tabcontent">
			<h2>Dati Personali</h2>
  				<div>
  				<form name="datiPersonali" action="<%=request.getContextPath()%>/UserController" method="POST" onsubmit="return validateDatiPersonali()">
  				<input type="text" name="action" id="action" value="datiPersonali" style="display: none;" />
        			<section style="width: 50%;">
        				<div class="displayTab">
							<label class="registra">Nome</label>						
							<input type="text" name="nome" value="<%=utente.getNome() %>"> 
						</div>
						
						<div class="displayTab">
							<label class="registra">Cognome</label>	
							<input type="text" name="cognome" value="<%=utente.getCognome() %>">
						</div>
						<div class="displayTab">
							<label class="registra">Codice Fiscale</label>	
							<input type="text" name="codicefiscale" readonly="readonly" value="<%=utente.getCodiceFiscale() %>">
						</div>
			
						<div class="displayTab"> 
							<label class="registra">Città</label>
							<input type="text" name="citta" value="<%=utente.getCitta() %>">
						</div>
					</section>
							
					<section style="width: 50%;">
												 
						<div class="displayTab">	
							<label class="registra">Provincia</label>
							<input type="text" name="activityProvince" value="<%=utente.getProvincia() %>">
						</div>
											
						<div class="displayTab">
							<label  class="registra">Cap</label>
							<input type="text" name="cap" value="<%=utente.getCap() %>">
						</div>
											
						<div class="displayTab">
							<label class="registra">Telefono</label>
							<input type="text" name="telefono" value="<%=utente.getTelefono() %>">
	 					</div>
					</section>	
					<br><br>
					<button style="width:20%;"type="submit" name="cambiaDatiPersonali">Cambia</button>
					<br><br><br>	
					</form>	
        		</div>    		
			</div>

			<div align="center" id="Dati Account" class="tabcontent">
  				<h2>Dati Account</h2>
  				
  				<div style="width: 50%; margin-left: auto; margin-right: auto;">
  					<form name="datiAccount" action="<%=request.getContextPath()%>/UserController" method="POST">
  					<input type="text" name="action" id="action" value="datiAccount" style="display: none;" />
  					<div class="displayTab">
						<label  class="datiprofilo">Username</label>
				 		<input name="username" readonly="readonly" value="<%=utente.getUsername() %>"> 
					</div>
				
					<div class="displayTab">
						<label  class="datiprofilo">Password</label>
				 		<input	type="password" name="password" value="<%=utente.getPassword() %>">	 
					</div>
					
					<div class="displayTab">
						<label  class="datiprofilo">Conferma password</label>
				 		<input	type="password" name="confpassword" value="<%=utente.getPassword() %>">	 
					</div>
				
					<div class="displayTab">
						<label  class="datiprofilo">Email<span style="color: #FF0000">*</span></label>
				 		<input type="email" name="email" value="<%=utente.getEmail() %>">				 
   					</div>
   					<br><br>
					<button style="width:30%;" type="submit" name="cambiaDatiProfilo">Cambia</button>
					<br><br><br>
					</form>
   				</div>
   				
			</div>

	        <div align="center" id="Prenotazioni" class="tabcontent">
			<h2>Prenotazioni Effettuate</h2>
  				<div id="containerSuperiore" style="overflow:auto">
			<div class="containerRisultati">
				<% 
					PrenotazioneModel model=new PrenotazioneModelDM();
					
					Collection<PrenotazioneBean> prenotazioni=model.doRetrieveByCodiceFiscale(utente.getCodiceFiscale());
					if (prenotazioni != null && prenotazioni.size() != 0) {
						Iterator<PrenotazioneBean> it = prenotazioni.iterator();
						while (it.hasNext()) {
							PrenotazioneBean bean = (PrenotazioneBean) it.next();
				%>
				<div class="elementoDellaRicerca">
					<div class="descrizioneRicerca">
						<h3 align="center">Prenotazione del <%=bean.getData()%> alle <%=bean.getOra()%> </h3>
						<p>
						Saldata: <%if(bean.isSaldata()){%> Si <%} else {%> No <%}%>
						Tipo: <%=bean.getTipo()%>
						</p>
						<form name="formRimuoviPrenotazione" method="GET" action="<%=request.getContextPath()%>/RimuoviPrenotazioneController">
							<input name="idPrenotazione" value="<%=bean.getIdPrenotazione()%>" type="hidden"/>
							<input name="idCampo" value="<%=bean.getIdCampoSportivo() %>" type="hidden"/>
							<input name="action" value="deleteByUtente" type="hidden"/>
							<input type="submit" value="Rimuovi Prenotazione" style="">
						</form>
					</div>
				</div>
				
				<%
						}
					} else {
				%>
					
					<h1>Non ci sono prenotazioni registrate.</h1>
					
				<%
				}
				%>
			</div>
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
 		<br><br><br><br><br><br><br><br><br><br>
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
		
		
		function validateDatiProfilo(){
			var password = document.datiProfilo.password.value;
			var confpassword = document.datiProfilo.confpassword.value;
			var email = document.datiProfilo.email.value;
			
			if (isEmpty(password,"password")){
				return false;
			}
			if (!isAValidString(password,regex.password,"password")){
				return false;
			}
			if (isEmpty(confpassword,"confpassword")){
				return false;
			}
			if (!(confpassword == password)){
				alert("Errore: I campi password e conferma password devono corrispondere!")
				return false;
			}
			if (isEmpty(email,"email")){
				return false;
			}
			if (!isAValidString(email,regex.email,"email")){
				return false;
			}
		
			return true;
		}
	</script>
	<script type="text/javascript" src ="<%=request.getContextPath()%>/js/testRegistrazioneUtente.js"></script>
	
</body>
</html>