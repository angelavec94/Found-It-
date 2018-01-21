<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../style/css/browser.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Found It! | Risultati Ricerca</title>
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
		div.container {
			margin-bottom: 0;
		}
		div#containerSuperiore {
			width: 90%;
		}
		
		div.sideBarDiRicerca{
			padding-top: 2%;
			width: 25%;
			min-height: 100%;
			height: inherit;
			text-align: center;
			float: left;
		}
		
		div.containerRisultati{
			padding: 2%;
			float:left;
			border-left: 1px solid black;
			min-height: 377.266px;
			width: 70%;
		}
	</style>
</head>
<body>
<%@include file="header.jsp"%>
	<%@page import="model.CampoSportivoBean,java.util.*,model.SocietaSportivaBean,model.SocietaSportivaModel,model.SocietaSportivaModelDM"%>
 	<%	Collection<CampoSportivoBean> risultatiRicerca = (Collection<CampoSportivoBean>) request.getSession().getAttribute("risultatiRicerca");%>
	<div id="containerSuperiore">
		<div class="container">
			<form class="form-di-ricerca-home" name="formRicerca" method="GET" action="<%=request.getContextPath()%>/RicercaController">
				<div class="sideBarDiRicerca">
					<label>Quale sport vuoi praticare?</label>
					<select name="tipo" class="inSideBar">	
						<option value="calcio">calcio</option>
						<option value="calcio a 5">calcio a 5</option>
						<option value="pallavolo">pallavolo</option>
						<option value="basket">basket</option>
					</select>
					<hr>
					<label>Dove?</label>
					<input  name="luogo" class="inSideBar" id="geocomplete" type="text" size="30" />
					<hr>
					<label>Quando?</label> 
					<br>
					<input name="data" class="inSideBar" type="date" size="30">
					<hr>
					<label>A che ora?</label>
					<br> 
					<input name="ora" class="inSideBar" type="number" name="ora" min="0" max="23">:
					<input name="minuti" class="inSideBar" type="number" name="minuti" min="0" max="59">
					<br><br>
					<input type="submit" value="Effettua nuova ricerca!">
					<br><br>
				</form>
			</div>
			<div class="containerRisultati">
				<% 
					if (risultatiRicerca != null && risultatiRicerca.size() != 0) {
						Iterator<?> it = risultatiRicerca.iterator();
						while (it.hasNext()) {
							CampoSportivoBean bean = (CampoSportivoBean) it.next();
				%>
				<div class="elementoDellaRicerca">
					<img alt="fotoCampo" src="../images/userStandard.png" style="height: 100px; width: 100px; float: left;">
					<div class="descrizioneRicerca">
						<h3 align="center"><%=bean.getNome()%></h3>
						<p>Il campo di gioco <%=bean.getNome()%> e' situato a <%=bean.getLuogo()%> ed il prezzo per accedere alla struttura è di <%=bean.getPrezzoSulCampo()%> euro(Prezzo scontato per prenotazioni online:<%=bean.getPrezzoOnline()%>).
						   La struttura è aperta dalle <%=Integer.parseInt(new Integer(bean.getFasciaOraria()).toString().substring(0, 2))%> alle 
						   <%=Integer.parseInt(new Integer(bean.getFasciaOraria()).toString().substring(2))%>.
						</p>
						<%
							Object isLogged=request.getSession().getAttribute("utenteLoggato");
						
						
							//DA RIMUOVERE////////////////////////////////////////////////////////////////
							isLogged=true;
							//DA RIMUOVERE////////////////////////////////////////////////////////////////
							
							
							if(isLogged!=null&&(boolean)isLogged){
						%>
								<form name="formPrenota" method="GET" action="<%=request.getContextPath()%>/PrenotazioneCampoController">
								<input name="idCampo" id="idCampo" value="<%=bean.getIdCampoSportivo()%>" type="hidden"/>
								<input type="submit" value="Prenota!" style="float: right;">
								</form>
						<%
							} else {
								SocietaSportivaModel societa=new SocietaSportivaModelDM();
								SocietaSportivaBean soc=societa.doRetrieveByKey(bean.getPartitaIvaSocieta());
								String numTel=soc.getTelefono();
						%>
								<h3 style="float: right;"> Per procedere alla prenotazione online effettua il login o chiama al numero <%=numTel%>!</h3>
						<%
							}
						%>
					</div>
				</div>
				
				<%
						}
					} else {
				%>
					<h1>Non ci sono campi che soddisfano i parametri richiesti! effettuare una nuova ricerca.</h1>
				
				<%
				}
				%>
			</div>
		</div>
	<%@include file="footer.jsp"%>
	
	<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCofJoxoB2qURli3Js_1iUFjixonLuqk-M&sensor=false&amp;libraries=places"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

    <script src="../js/jquery.geocomplete.js"></script>
    <script src="../js/logger.js"></script>
	
	<script>
      $(function(){
        
        $("#geocomplete").geocomplete()
          .bind("geocode:result", function(event, result){
            $.log("Result: " + result.formatted_address);
          })
          .bind("geocode:error", function(event, status){
            $.log("ERROR: " + status);
          })
          .bind("geocode:multiple", function(event, results){
            $.log("Multiple: " + results.length + " results found");
          });
        
        $("#find").click(function(){
          $("#geocomplete").trigger("geocode");
        });        
      });
	</script>
</body>
</html>