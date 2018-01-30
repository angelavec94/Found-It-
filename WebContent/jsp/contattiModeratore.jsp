<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*,model.UtenteModel,model.UtenteModelDM"%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Found It! | Contatti Moderatore</title>
	<style>
		table {
    	border: 1px solid black;
		}
	</style>
</head>
<body>
<%@include file="header.jsp"%>
	<% if(utente==null || utente.getUsername() == null){
		ServletContext sc = getServletContext();
		RequestDispatcher rd= sc.getRequestDispatcher("/jsp/home.jsp");
		message = "Effettuare il login prima di accedere ai contatti del Moderatore!";
		request.getSession().setAttribute("message", message);
		rd.forward(request, response);
	}
	%>

		<div id="containerSuperiore">
		<div class="top">
				<h2><center>CONTATTI MODERATORE</center></h2>
		</div>
		<hr style= "margin-left:1%; margin-right:1%">
			<div class="container">
				<br><br>
				<p><% 	final UtenteModel model = new UtenteModelDM(); 
				Collection<UtenteBean> utenti= model.doRetrieveAll("tipo");%>
  				</p>
			  	<table  style="width:50%" align="center" border="2"  cellpadding="10">
					<tr>
						<th style="width:20%"> Nome </th>
						<th style="width:25%"> Cognome </th>
						<th style="width:25%"> Telefono </th>
						<th style="width:30%"> Email </th>
						
					</tr>
				<%
					if ( utenti != null && utenti.size() != 0){
					Iterator<?> it = utenti.iterator();
					while (it.hasNext()){
					UtenteBean bean = (UtenteBean) it.next();
		        %>
					<tr>
			<% if(bean.getTipo().equals("moderatore")){ %>
			<td><%=bean.getNome()%></td>
			<td><%=bean.getCognome()%></td>
			<td><%=bean.getTelefono()%></td>
			<td><%=bean.getEmail()%></td>
			
			<%} %>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="4">Non ci sono Moderatori!</td>
		</tr>
		<%
			}
		%>
				</table>
				<br><br><br>		
			</div>
		</div>
	
	
	<%@include file="footer.jsp"%>
	

</body>
</html>