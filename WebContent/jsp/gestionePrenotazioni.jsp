<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="../style/css/browser.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Found It! | Gestione Prenotazioni</title>
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
<%@page import="model.PrenotazioneBean,java.util.*,model.PrenotazioneModel,model.PrenotazioneModelDM"%>
<div id="containerSuperiore">
			<div class="containerRisultati">
				<% 
					PrenotazioneModel model=new PrenotazioneModelDM();
					Collection<PrenotazioneBean> prenotazioni=model.doRetrieveByIDCampo((int)request.getAttribute("idCampo"));
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
						Effettuata da: <%=bean.getCodiceFiscaleUtente()%>
						</p>
						<form name="formRimuoviPrenotazione" method="GET" action="<%=request.getContextPath()%>/RimuoviPrenotazioneController">
							<input name="idPrenotazione" value="<%=bean.getIdPrenotazione()%>" type="hidden"/>
							<input name="idCampo" value="<%=request.getAttribute("idCampo")%>" type="hidden"/>
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
<%@include file="footer.jsp"%>
</body>
</html>