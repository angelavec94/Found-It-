<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Found It! | Home</title>
<style type="text/css">
	table{
		width: 100%;
		height: auto;
	}
	
	td{ 
		text-align: center;
		padding-bottom: 10px;
	}
	
	form.form-di-ricerca-home{
		text-align: center;
	}
</style>
</head>
<body>
<%@include file="header.jsp"%>
	
	<div id="containerSuperiore">
		<h1 align="center">Benvenuto in Found It !</h1>
		<h3 align="center">Trova anche tu la struttura sportiva adatta a te con una
			semplice ricerca.</h3>
		<hr></hr>

		<div class="container">
			<form class="form-di-ricerca-home" name="formRicerca" method="GET" action="<%=request.getContextPath()%>/RicercaController">
				<div class="container-form-di-ricerca-home">
					<table>
						<tr>
							<td>Quale sport vuoi praticare?</td>
							<td>Dove?</td>
							<td>Quando?</td>
							<td>A che ora?</td>
						</tr>
						<tr>
							<td>
								<select name="tipo">
									<option value="calcio">calcio</option>
									<option value="calcio a 5">calcio a 5</option>
									<option value="pallavolo">pallavolo</option>
									<option value="basket">basket</option>
								</select>
							</td>
							<td><input name="luogo" id="geocomplete" type="text" size="40" /></td>
							<td><input name="data" type="date" size="30"></td>					
							<td>
								<input name="ora" type="number" name="ora" min="0" max="23">:
								<input name="minuti" type="number" name="minuti" min="0" max="59">
							</td>	
						</tr>
					</table>
				</div>
				<br>
				<br>
				<hr>
				<br>
				<input style="width:15%;" id="cerca" type="submit" value="cerca!">
			</form>
			<br>
		</div>
	</div> 
	<%@include file="footer.jsp"%>
    <script src="../js/logger.js"></script>
</body>
</html>