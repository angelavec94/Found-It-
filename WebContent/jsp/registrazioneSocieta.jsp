<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Found It! | Registrazione Società</title>
</head>
<body>
<%@include file="header.jsp"%>	
<%if(utente == null || utente.getUsername() == null || !(utente.getTipo().equals("moderatore"))){
		    ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/jsp/home.jsp");
			message = "Attenzione! Pagina protetta, effettuare tutti i passaggi per accedervi";
			request.getSession().setAttribute("message", message);
			rd.forward(request, response);
	   };
	%>
		<div id="containerSuperiore">
		<div class="top">
				<h2><center>REGISTRAZIONE SOCIETA'</center></h2>
		</div>
		<hr style= "margin-left:1%; margin-right:1%">
		<div class="container">
			<form name="registrazioneSocieta" action="<%=request.getContextPath()%>/SocietaController" method="POST" onsubmit="return validateSocieta()">
			<div style="margin-left:25%;width:50%;height:300px">
				<br><br>
				<div class="formelement">
					<label  class="registra">Nome Società<span style="color: #FF0000">*</span></label>
					<input class="campi" type="text" name="nomeSocieta" placeholder=" inserisci nome società">
                	<i class="fa fa-user"></i> 
				</div>

				<div class="formelement">
					<label  class="registra">Indirizzo Sede<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="indirizzoSede" placeholder=" inserisci indirizzo della sede">
				 	<i class="fa fa-map-marker"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Partita Iva<span style="color: #FF0000">*</span></label> 
					<input class="campi" type="text" name="partitaIva" placeholder=" inserisci la Partita Iva"/>
					
				</div>

				<div class="formelement">
					<label  class="registra">Telefono<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="telefono"  placeholder=" 0811234567">
				 	<i class="fa fa-phone"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Codice di autenticazione<span style="color: #FF0000">*<br>(Servirà nel caso si voglia registrare un impiegato)</span></label>
				 	<input class="campi" type="text" name="codiceAutenticazione" placeholder=" inserisci il codice di Autenticazione">				 
   				</div>

				<br><br><br><br>
				<input name="CodiceFiscaleUtente" value="<%= request.getAttribute("CodiceFiscaleUtente")%>" type="hidden"/>
				<div style="text-align:center;">
					<button class="buttonreg" type="submit" name="submit"><b>Registra Società</b></button>
				</div>
	</div>
	</form>
				
	</div>
			<div style="text-align: left; padding-left: 0.8%;">
			I campi con <span style="color: #FF0000">*</span> sono obbligatori
	   		</div>
	</div>
	
	
	<%@include file="footer.jsp"%>
	<script type="text/javascript" src ="<%=request.getContextPath()%>/js/testRegistrazioneUtente.js"></script>

</body>
</html>