<%// Check user credentials
Boolean moderatorRoles = (Boolean) session.getAttribute("moderatorRoles");
if ((moderatorRoles == null) || (!moderatorRoles.booleanValue()))
{	
    response.sendRedirect(request.getContextPath()+"/jsp/home.jsp");
    return;
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*,model.UtenteModel,model.UtenteModelDM"%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Found It! | PaginaModeratore</title>
	<style type="text/css">
		* {box-sizing: border-box}
		body {font-family: "Lato", sans-serif;}

		/* Style the tab */
		div.Tab {
    	float: left;
    	border: 1px solid #ccc;
    	background-color: #f1f1f1;
    	width: 20%;
    	height: 300px;
		}

		/* Style the buttons inside the tab */
			div.Tab button {
    		display: block;
    		background-color: inherit;
    		color: black;
    		padding: 22px 16px;
    		width: 100%;
    		border: none;
    		outline: none;
    		text-align: left;
    		cursor: pointer;
    		transition: 0.3s;
   	 		font-size: 17px;
			}

		/* Change background color of buttons on hover */
			div.Tab button:hover {
    		background-color: #ddd;
			}

		/* Create an active/current "tab button" class */
			div.Tab button.active {
    		background-color: #ccc;
			}

		/* Style the tab content */
			.tabContent {
    		float: left;
    		padding: 0px 12px;
    		border: 1px solid #ccc;
    		width: 80%;
    		height: 300px;
		  }
		  
		   .centrato{
		  padding:10px;    
   		  width:85%; 
    	  margin: auto;
		  }
</style>
		
</head>
<body>
	<%@include file="header.jsp"%>
	<%if(utente == null || utente.getUsername() == null || !(utente.getTipo().equals("moderatore"))){
		    ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/jsp/home.jsp");
			message = "Pagina protetta, effettuare il login come moderatore!";
			request.getSession().setAttribute("message", message);
			rd.forward(request, response);
	   };
	%>
	<div id="containerSuperiore" style="overflow:auto;">
		<div class="top">
			<h2><center> OPZIONI MODERATORE</center></h2>
		</div>
		<hr style= "margin-left:1%; margin-right:1%">
		<br><br>
		<div class="container" >
					<div class="centrato">
					<div class="Tab">
  						<button class="tabLinks" onclick="openCity(event, 'UtentiRegistrati')" id="defaultOpen">Utenti registrati</button>
  						<button class="tabLinks" onclick="openCity(event, 'UtentiBannati')">Utenti Bannati</button>
  						</div>

			<div style="overflow:auto;" id="UtentiRegistrati" class="tabContent">
  				<h3><center>UTENTI REGISTRATI</center></h3>
  				<p><% 	final UtenteModel modelUt= new UtenteModelDM();
  				Collection<UtenteBean> utenti= modelUt.doRetrieveAll("nome"); 
  				%>
  				</p>  				
  				<table style="width:20% " border="2"  cellpadding="5">
					<tr>
						<th>Nome </th>
						<th>Cognome </th>
						<th>Username </th>
						<th>Tipo</th>
						<th>Partita Iva</th>
						
					</tr>
		<%
			if(utenti!=null && utenti.size()!=0){
				Iterator<?> it = utenti.iterator();
				while (it.hasNext()) {
					UtenteBean bean = (UtenteBean) it.next();
		%>
		<tr>
				<% if(bean.getTipo().equals("utenteSemplice") || bean.getTipo().equals("partnerSportivo")){ %>
				    <td><%=bean.getNome()%></td>
					<td><%=bean.getCognome()%></td>
					<td><%=bean.getUsername()%></td>
					<td><%=bean.getTipo()%></td>
					<td><%=bean.getSocietaSportiva_PartitaIva()%></td>
     				<td  style="border: 0px;">
     					<form action="<%=request.getContextPath()%>/GestioneModeratoreController" method="GET">
     						<input type="hidden" name="codiceFiscale" value="<%=bean.getCodiceFiscale()%>"/>
     						<input type="hidden" name="action" value="bannare"/>
     						<input type="submit" value="Banna">
     					</form>
     				</td>
					<td  style="border: 0px;">
						<form action="<%=request.getContextPath()%>/GestioneModeratoreController" method="GET">
     						<input type="hidden" name="codiceFiscale" value="<%=bean.getCodiceFiscale()%>"/>
     						<input type="hidden" name="action" value="eliminare"/>
     						<input type="submit" value="Elimina">
     					</form>			
					</td>
					
		 </tr>
				
			<%
				}
				}
			} %>
	</table>

	
			</div>

			<div style="overflow:auto;" id="UtentiBannati" class="tabContent">
  			<h3><center>Utenti Bannati</center></h3>
  			<table style="width:20% " border="2"  cellpadding="5">
  				<tr>
			<th>Nome </th>
			<th>Cognome </th>
			<th>Username </th>
		</tr>
		<%
			if ( utenti != null && utenti.size() != 0) {
				Iterator<?> ite = utenti.iterator();
				while (ite.hasNext()) {
					UtenteBean bean = (UtenteBean) ite.next();
		%>
		<tr>
			<% if(bean.getTipo().equals("bannato")){ %>
			<td><%=bean.getNome()%></td>
			<td><%=bean.getCognome()%></td>
			<td><%=bean.getUsername()%></td>
			<td  style="border: 0px;">
     			<form action="<%=request.getContextPath()%>/GestioneModeratoreController" method="GET">
     				<input type="hidden" name="codiceFiscale" value="<%=bean.getCodiceFiscale() %>"/>
     				<input type="hidden" name="action" value="sbannare"/>
     				<input type="submit" value="Sbanna">
     				</form>
     		</td>
		 </tr>
				
			<%
			}
				}
			} %>
	</table>
	

			</div>
		</div>
	
	
	
	<%@include file="footer.jsp"%>	
<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabContent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tabLinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>

</body>
</html>