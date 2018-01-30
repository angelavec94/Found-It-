<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	public void calcolaOre(){
	System.out.println("Funonzia");
}
%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<title>Found It! | Aggiungi Prenotazione</title>
</head>
<body>
<%@page import="java.sql.Date,java.sql.Time,java.util.*" %>
<%@include file="header.jsp"%>
	<div id="containerSuperiore">
		<div  align="center" class="container">
			<form name="formCalcolaOra" method="GET" action="<%=request.getContextPath()%>/CalcolaOraController " style="margin-top:2%" >
			Data: 
			<input name="data" type="text" placeholder="yyyy-mm-dd" id="datepicker" onchange="javascript:document.formCalcolaOra.submit();">
			<input name="idCampo" value="<%=request.getAttribute("idCampo") %>" type="hidden"/>
			<input name="cfPartner" value="<%=request.getAttribute("cfPartner") %>" type="hidden"/>
			</form>
			<%
				if(request.getAttribute("calcola")!=null&&request.getAttribute("calcola").equals("si")){
					request.setAttribute("calcola", null);
					ArrayList<String> orari=(ArrayList<String>)request.getAttribute("risultati");
			%>
					<form name="formCalcolaOra" method="GET" action="<%=request.getContextPath()%>/AggiungiPrenotazioneController">
					<select name="orario">
						<% for(String s:orari){%>
							<option value=<%=s%>><%=s%></option>
						<%}%>
					</select>
					<input name="agg" value="si" type="hidden"/>
					<input name="idCampo" value="<%=request.getAttribute("idCampo") %>" type="hidden"/>
					<input name="cfPartner" value="<%=request.getAttribute("cfPartner") %>" type="hidden"/>
					<input name="idPrenotazione" value="<%=request.getAttribute("idPrenotazione") %>" type="hidden"/>
					<input name="data" value="<%=request.getAttribute("data") %>" type="hidden"/>
					<input type="submit" value="Aggiungi Prenotazione" style="margin-top:2%">
					</form>
			<%
				}
			%>
		</div>
	</div>
<%@include file="footer.jsp"%>
<!--<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
	$("#datepicker").datepicker();
	$("#datepicker").on("change",function(){
        var selected = $(this).val();
        alert(selected);
        calcolaOre(selected);
    });
});
</script>-->
</body>
</html>