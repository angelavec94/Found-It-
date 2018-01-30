<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../style/css/browser.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Found It! | Prenotazione Campo</title>
<style type="text/css">
	
		div#containerInferiore{
			height: inherit;
			border: 1px solid black;
		}
		input,select.inSideBar{
			margin-top: 5%;
		}
		div.riepilogo {
			
		}
		div#containerSuperiore {
			padding: 2%;
			height: 80%;
		}
		
		div.pagaOnline{
			text-align: center;
			border-right: 1px solid black;
			padding-top: 1%;
			width: 49%;
			height: inherit;
			float: left;
		}
		
		div.pagaSulCampo{
			text-align: center;
			padding-top: 1%;
			width: 50%;
			height: inherit;
			float: right;
		}
	</style>
</head>
<body>
<%@include file="header.jsp"%>
	<%@page import="model.CampoSportivoBean,java.util.*,model.SocietaSportivaBean,model.SocietaSportivaModel,model.SocietaSportivaModelDM,model.UtenteBean"%>
	<%@page import="model.CartaBean,model.CartaModel,model.CartaModelDM,model.UtenteModel,model.UtenteModelDM"%>
	<%CampoSportivoBean bean = (CampoSportivoBean)request.getSession().getAttribute("campoDaPrenotare");%>
	<%int ora=(int)request.getSession().getAttribute("oraPrenotazione");%>
	<div id="containerSuperiore">
		<div class="container">
			<div class=riepilogo>
				Riepilogo Prenotazione:
				<p>
					Stai prenotando il campo <%=bean.getNome()%> di <%=bean.getTipologia()%> sito a <%=bean.getLuogo()%> dalle ore <%=ora%>
					alle ore <%=ora+1%>.
				</p>
			</div>
			<div id=containerInferiore>
				<div class=pagaOnline>
					Promozione: Prenota online<br>Prezzo Scontato: <%=bean.getPrezzoOnline()%>
					<%
					UtenteBean utent=(UtenteBean)request.getSession().getAttribute("login");
					
					if(utent!=null){
						CartaModel carta=new CartaModelDM();
						CartaBean car=carta.doRetrieveByKey(utent.getNumeroCarta());
						if(car!=null){
							%>
							<form name="formPrenotaOnline" method="GET" action="<%=request.getContextPath()%>/ConfermaPrenotazioneController">
							<input name="cfUtente" value="<%=utent.getCodiceFiscale() %>" type="hidden"/>
							<input name="idCampo" value="<%=bean.getIdCampoSportivo() %>" type="hidden"/>
							<input name="oraPrenotazione" value="<%=request.getSession().getAttribute("oraPrenotazione") %>" type="hidden"/>
							<input name="dataPrenotazione" value="<%=request.getSession().getAttribute("dataPrenotazione") %>" type="hidden"/>
							<input name="saldata" value="<%="true" %>" type="hidden"/>
							<input name="tipo" value="<%="Online" %>" type="hidden"/>
							<input type="submit" value="Conferma Prenotazione">
							</form>
							<%
						} else {
							%>
							<h3>Per procedere al pagamento registrare una carta!</h3>
							<form name="formRegistraCarta" method="GET" action="<%=request.getContextPath()%>/CartaController">
							Numero Carta:
							<input name="numeroCarta" type="text"><br>
							Intestatario:
							<input name="intestatarioCarta" type="text"><br>
							Scadenza:
							<input name="scadenzaCarta" type="date"><br>
							CVV/CVV2:
							<input name="cvvCarta" type="number" ><br>
							<input name="cfUtente" value="<%=utent.getCodiceFiscale() %>" type="hidden"/>
							<input type="submit" value="Conferma Dati">
							</form>
							<%
						}
					} else {
						%>
						<h3>Utente non loggato!</h3>
						<%
					}
					
					%>
					
					
				</div>
				<div class=pagaSulCampo>
					Prenota sul campo<br>Prezzo: <%=bean.getPrezzoSulCampo()%><br><br><br>
					<%
					SocietaSportivaModel societaSportiva=new SocietaSportivaModelDM();
					SocietaSportivaBean soc=societaSportiva.doRetrieveByKey(bean.getPartitaIvaSocieta());
					String numTel=soc.getTelefono();
					%>
					Chiama al numero <%=numTel%>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>