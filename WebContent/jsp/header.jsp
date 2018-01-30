<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Import external css file -->
<link href="<%=request.getContextPath()%>/style/css/browser.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/css/browser.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/css/style.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
<script src="<%=request.getContextPath()%>/js/login.js"></script>

<% String messaggio=(String)request.getSession().getAttribute("message");
			if(messaggio==null || messaggio.equals("") ){
				messaggio=(String)request.getAttribute("message");
			}
	%>
</head>
<body <% if(messaggio!=null && !messaggio.equals("") ) { %>onload="showMessage()" <%}%>>
    <%@page import="model.UtenteBean"
            import="model.SocietaSportivaBean"%>
	<% String message="";
	   UtenteBean utente= (UtenteBean) request.getSession().getAttribute("login");
	   SocietaSportivaBean societa= (SocietaSportivaBean) request.getSession().getAttribute("societa");%>
	<header>
	<div class="logo">
		<a href="<%=request.getContextPath()%>/jsp/home.jsp"> <img alt="logo sito"
			src="<%=request.getContextPath()%>/images/logoFoundIt!.png"
			height="80px" width="180px">
		</a>
	</div>
	<% if(utente==null || utente.getUsername()==null){  %>
	<div class="menu" id="MenuResponsive">
		<nav>
		<ul>
			<li>
				<div id="loginContainer">
					<a href="#" id="loginButton"><i class="fa fa-sign-in" aria-hidden="true"> Login</i></a>
					<div style="clear: both"></div>
					<div id="loginBox">
						<form id="loginForm" action="<%=request.getContextPath()%>/UserController" method="post">
							<fieldset id="body">
								<fieldset>
								<input type="text" name="action" id="action" value="login" style="display: none;" />
									<label for="email">Username</label> 
									<input type="text" name="username" id="username" />
								</fieldset>
								<fieldset>
									<label for="password">Password</label> 
									<input type="password" name="password" id="password" />
								</fieldset>
				
								<input type="submit" id="login" value="Conferma" style="display: block; margin-left: 25%; width: 100px;"/> 
							</fieldset>
							<span><a href="<%=request.getContextPath()%>/jsp/recuperoPassword.jsp">Hai dimenticato la password?</a></span>
						</form>
					</div>
				</div>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/jsp/registrazioneUtente.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i> Registrazione</a>
			</li>
		</ul>
		</nav>
	</div>
	<% }else{ %>
		<div class="menu" id="MenuResponsive" >
			<nav>
				<ul>
					<li>
						<div id="loginContainer">
               				<a href="<%=request.getContextPath()%>/UserController?action=logout" id="logoutButton"><i class="fa fa-sign-out" aria-hidden="true"> Logout</i></a>
                			
                			
                			<div style="clear:both"></div>
           				</div>
					</li>
					<li><a href="<%=request.getContextPath()%>/jsp/profiloUtente.jsp"><i class="fa fa-user" aria-hidden="true"></i> <%=utente.getUsername()%></a></li>
					<li><a href="<%=request.getContextPath()%>/jsp/contattiModeratore.jsp"><i class="fa fa-phone" aria-hidden="true"></i> Contatti Moderatore</a></li>
					
					<% if(utente.getTipo().equals("moderatore")){%>
					<li><a href="<%=request.getContextPath()%>/jsp/paginaModeratore.jsp"><i class="fa fa-info-circle" aria-hidden="true"></i> Opzioni Moderatore</a></li>
					<%}%>
					<% if(utente.getTipo().equals("partnerSportivo")){%>
					<li><a href="<%=request.getContextPath()%>/jsp/gestioneCampi.jsp"><i class="fa fa-futbol-o" aria-hidden="true"></i> Gestione Campi</a></li>
					
					<%}%>

				</ul>
			</nav>
		</div>	
		<% } %>
	</header>
	<script>
	
		function showMessage() {
	    // Get the snackbar DIV
	    	var x = document.getElementById("snackbar")
			
	    // Add the "show" class to DIV
	    x.className = "show";

	    // After 3 seconds, remove the show class from DIV
	    	setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
		}
		</script>
	<div id="snackbar"><%= messaggio%></div>
</body>
<% messaggio= "";%>
</html>