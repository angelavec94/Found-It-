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
	<%@page import="model.CampoSportivoBean,java.util.*"%>
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
					<form name="formPrenotaOnline" method="GET" action="">
						<input type="submit" value="Conferma Prenotazione">
					</form>
				</div>
				<div class=pagaSulCampo>
					Prenota sul campo<br>Prezzo: <%=bean.getPrezzoSulCampo()%>
					<form name="formPrenotaSulCampo" method="GET" action="">
						<input type="submit" value="Conferma Prenotazione">
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>