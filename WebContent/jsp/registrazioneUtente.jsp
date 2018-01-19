<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>Found It! | Registrazione Utente</title>
	
		<style>
			.alert {
   				padding: 20px;
   	 			background-color: #f44336;
    			color: white;
    			display:none;
			}

			.closebtn {
    			margin-left: 15px;
    			color: white;
   			 	font-weight: bold;
    			float: right;
    			font-size: 22px;
    			line-height: 20px;
    			cursor: pointer;
    			transition: 0.3s;
			}

			.closebtn:hover {
    			color: black;
			}
</style>
		
</head>
<body>  
		<%@include file="header.jsp"%>	

		<div id="containerSuperiore">
		<div class="top">
				<h2><center>REGISTRAZIONE UTENTE</center></h2>
		</div>
		<hr style= "margin-left:1%; margin-right:1%">
		<div class="container">
			<form name="registrazioneUtente" action="<%=request.getContextPath()%>/UserController" method="POST" onsubmit="return validateForm()">
			<div style= "margin-left:4%; width:60%; float:left">
				<br><br>
				<div class="formelement">
					<label  class="registra">Nome<span style="color: #FF0000">*</span></label>
					<input class="campi" type="text" name="nome" placeholder=" inserisci nome">
                	<i class="fa fa-user"></i> 
				</div>

				<div class="formelement">
					<label  class="registra">Cognome<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="cognome" placeholder=" inserisci cognome">
				 	<i class="fa fa-user"></i>
				</div>
				
				<div class="formelement">
					<label  class="registra">Codice fiscale<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="codicefiscale" placeholder=" inserisci codice fiscale">
				 	<i class="fa fa-user"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Citta<span style="color: #FF0000">*</span></label> 
					<input id="geocomplete" class="campi" type="text" size="40" name="citta" placeholder=" inserisci una citta"/>
					<i class="fa fa-map-marker"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Provincia<span style="color: #FF0000">*</span></label> 
						<select
								class="campi" name="activityProvince">
								<%@include file="province.jsp" %>
						</select>
					<i class="fa fa-map-marker"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Cap<span style="color: #FF0000">*</span></label>
					<input class="campi" type="text" name="cap"  placeholder=" 80035">
				 	<i class="fa fa-user"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Telefono<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="telefono"  placeholder=" 0811234567">
				 	<i class="fa fa-phone"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Email<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="email" name="email" placeholder=" name@exemple.com">
                    <i class="fa fa-envelope"></i>				 
   				</div>

				<div class="formelement">
					<label  class="registra">Username<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="username" placeholder=" lunghezza minima 3 carateri">
				 	<i class="fa fa-user"></i> 
				</div>

				<div class="formelement">
					<label  class="registra">Password<span style="color: #FF0000">*</span></label>
				 	<input	class="campi" type="password" name="password" placeholder=" lunghezza minima 8(almeno 1 minuscolo e maiuscolo)">
				 	<i class="fa fa-lock"></i>	  
				</div>

				<div class="formelement">
					<label  class="registra" for="password">Conferma password<span style="color: #FF0000">*</span></label>
					<input class="campi" type="password" name="confpassword" placeholder=" inserisci password">
				 	<i class="fa fa-lock"></i>
				</div>
			
				<div class="formelement">
					<label  class="registra">Possiedi una Società Sportiva?<span style="color: #FF0000">*</span></label>
					<input type="radio" name="possiedisocietasportiva" value="si" id="si">si
					<input type=radio name="possiedisocietasportiva" value="no" id="no">no
				</div>
				<br>
				<div style="text-align:center;">
					<button class="buttonreg" type="submit" name="submit"><b>Registrati</b></button>
				</div>
				<br><br>
	</div>
	</form>
	<form  method="post" action="UploadServlet" enctype="multipart/form-data">	
	<div style= "width:35%; float:left;">
	
			<div class="image-box">
			             		<!--<h2>${requestScope.message}</h2>-->
			  
				<br>
				<label for="exampleInputFile"><b>Immagine personale</b></label>
				<br><br>
				 <img id="previewImage" src="<%=request.getContextPath()%>/images/userStandard.png" alt="Your Image" width="200" height="200" />
			<br><br>
			<input type="file" onchange="document.getElementById('previewImage').src = window.URL.createObjectURL(this.files[0])" accept="image/*" size="50">
             <br><br>
             <input type="submit" value="Carica">
             
            </div>
           
	</div>
	</form>				
	</div>
			<div style="text-align: left; padding-left: 0.8%;">
			I campi con <span style="color: #FF0000">*</span> sono obbligatori
	   		</div>
	</div>
	
	<%@include file="footer.jsp"%>
	
	<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCofJoxoB2qURli3Js_1iUFjixonLuqk-M&sensor=false&amp;libraries=places"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.geocomplete.js"></script>
    <script src="<%=request.getContextPath()%>/js/logger.js"></script>
	<script type="text/javascript" src ="<%=request.getContextPath()%>/js/testRegistrazioneUtente.js"></script>
		
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
      
  		function trovaCoordinate(){
  			var input_address = $("#geocomplete").val();
  			var geocoder = new google.maps.Geocoder();
  			geocoder.geocode( { address: input_address }, function(results, status) {
  				if (status == google.maps.GeocoderStatus.OK) {
  					var lat = results[0].geometry.location.lat();
  					var lng = results[0].geometry.location.lng();
  					$("latitude").val()=lat;
  					$("longitude").val()=lng;
  					return true
  					}
  				else {
  					alert("Indirizzo non valido!");
  					return false
  					}
  				});
  		}
      </script>
</body>
</html>