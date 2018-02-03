<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="../style/css/browser.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Found It! | Gestione Campi</title>
	<style type="text/css">
	
		div.elementoDellaRicerca{
			margin-top: 2%;
			padding: 10px;
			border: 1px solid black;
			float: left;
			display: inline;
		}
		input,select.inSideBar{
			margin-top: 5%;
		}

		div#containerSuperiore {
			width: 90%;
			overflow: auto;
		}
		
		div.containerRisultati{
			padding: 2%;
			overflow: auto;
			width: 70%;
		}
	</style>
</head>
<body>
<%@include file="header.jsp"%>
<%@page import="model.CampoSportivoBean,java.util.*,model.CampoSportivoModel,model.CampoSportivoModelDM,model.UtenteBean"%>
<div id="containerSuperiore">
<% if(utente==null || utente.getUsername() == null){
		ServletContext sc = getServletContext();
		RequestDispatcher rd= sc.getRequestDispatcher("/jsp/home.jsp");
		message = "Effettuare il login prima di poter accedere a questa pagina!";
		request.getSession().setAttribute("message", message);
		rd.forward(request, response);
	}
%>
			<%
			UtenteBean partner = (UtenteBean)request.getSession().getAttribute("login");
			request.getSession().setAttribute("partitaIva", partner.getSocietaSportiva_PartitaIva());
			%>
			<a href="<%=request.getContextPath()%>/jsp/aggiungiCampo.jsp"><i class="fa fa-plus" style="margin-left: 2%; margin-top: 2%"></i> Aggiungi un campo</a>
			<div class="containerRisultati">
				<% 
					CampoSportivoModel model=new CampoSportivoModelDM();
					Collection<CampoSportivoBean> campi=model.doRetrieveByPartitaIvaSocieta(partner.getSocietaSportiva_PartitaIva());
					if (campi != null && campi.size() != 0) {
						Iterator<CampoSportivoBean> it = campi.iterator();
						while (it.hasNext()) {
							CampoSportivoBean bean = (CampoSportivoBean) it.next();
				%>
				<div class="elementoDellaRicerca">
					<img alt="fotoCampo" src="../images/userStandard.png" style="height: 100px; width: 100px; float: left;">
					<div class="descrizioneRicerca">
						<h3 align="center"><%=bean.getNome()%></h3>
						<%String[] fascia=bean.getFasciaOraria().split("-"); %>
						<p>Il campo di gioco <%=bean.getNome()%> e' situato a <%=bean.getLuogo()%> ed il prezzo per accedere alla struttura è di <%=bean.getPrezzoSulCampo()%> euro(Prezzo scontato per prenotazioni online:<%=bean.getPrezzoOnline()%>).
						   La struttura è aperta dalle <%=fascia[0]%> alle 
						   <%=fascia[1]%>.
						</p>
						<form name="formRimuoviCampo" method="GET" action="<%=request.getContextPath()%>/RimuoviCampoController">
							<input name="idCampo" value="<%=bean.getIdCampoSportivo()%>" type="hidden"/>
							<input type="submit" value="Rimuovi Campo" style="">
						</form>
						
						<form name="formModificaCampo" method="GET" action="<%=request.getContextPath()%>/ModificaCampoController">
							<input name="idCampo" value="<%=bean.getIdCampoSportivo()%>" type="hidden"/>
							<input name="modifica" value="<%="no"%>" type="hidden"/>
							<input type="submit" value="Modifica Campo" style="">
						</form>
						<form name="formGestisciPrenotazioni" method="GET" action="<%=request.getContextPath()%>/GestionePrenotazioniController">
							<input name="idCampo" value="<%=bean.getIdCampoSportivo()%>" type="hidden"/>
							<input type="submit" value="Gestisci Prenotazioni" style="">
						</form>
						<form name="formAggiungiPrenotazioni" method="GET" action="<%=request.getContextPath()%>/AggiungiPrenotazioneController">
							<input name="idCampo" value="<%=bean.getIdCampoSportivo()%>" type="hidden"/>
							<input name="codiceFiscalePartner" value="<%=partner.getCodiceFiscale()%>" type="hidden"/>
							<input name="aggiungi" value="<%="no"%>" type="hidden"/>
							<input type="submit" value="Aggiungi Prenotazioni" style="">
						</form>
					</div>
				</div>
				
				<%
						}
					} else {
				%>
					<h1>Non ci sono campi registrati.</h1>
				
				<%
				}
				%>
			</div>
		</div>
<%@include file="footer.jsp"%>
</body>
</html>