//Questa funzione controlla che tutti i campi della registrazione siano compilati correttamente
var regex  = {
		nome:"^(?=.{3,25}$)^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$", cognome:"^(?=.{3,25}$)^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$", 
		codicefiscale:"[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$",citta:"^(?=.{3,25}$)^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$" ,provincia:"^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$" ,
		cap:"^[0-9]{5}$" , telefono:"(^[0|3]{1}[0-9]{5,10}$)" , email:"^[a-zA-Z0-9_.-]+@[a-zA-Z_]+?.[a-zA-Z]{2,3}$" ,
		username:"^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._-]+(?<![_.])$" ,
		password:"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9$@$!%*?&]{8,30}" , nomeSocieta:"^(?=.{3,25}$)^[A-Za-zèùàòé][a-zA-Z'èùàòé .]*$"
		,indirizzoSede:"^(?=.{3,25}$)^[A-Za-zèùàòéZ0-9\s\,\''\-.° ]*$" ,partitaIva:"^[0-9]{11}$"
		, codiceAutenticazione:"^[0-9]{1,24}$", ora:"^([01][0-9]|2[0-3]|[1-9])$", minuti:"^([0-5][0-9])$", numeroCarta:"^[0-9]{16}$", cvvCarta:"^[0-9]{4}$"
		, fascia:"^([01][0-9]|2[0-3]|[1-9])+-+([01][0-9]|2[0-3]|[1-9])$", prezzo:"^([0-9]|[0-9]+.+[0-9])$"
		}


function validateForm(){
	var nome = document.registrazioneUtente.nome.value;
	var cognome = document.registrazioneUtente.cognome.value;
	var codice = document.getElementsByName('codicefiscale')[0].value;
	var citta = document.registrazioneUtente.citta.value;
	var provincia = document.registrazioneUtente.activityProvince.value;
	var cap = document.registrazioneUtente.cap.value;
	var telefono = document.registrazioneUtente.telefono.value;
	var email = document.registrazioneUtente.email.value;
	var username = document.registrazioneUtente.username.value;
	var password = document.registrazioneUtente.password.value;
	var confpassword= document.registrazioneUtente.confpassword.value;
	var possiedisocietasportiva = document.registrazioneUtente.possiedisocietasportiva.value;
	if (isEmpty(nome,"nome")){
		return false;
	}
	if (!isAValidString(nome,regex.nome,"nome")){
		return false;
	}
	if (isEmpty(cognome,"cognome")){
		return false;
	}
	if (!isAValidString(cognome,regex.cognome,"cognome")){
		return false;
	}
	if (isEmpty(codice,"codicefiscale")){
		return false;
	}
	if (!isAValidString(codice,regex.codicefiscale,"codicefiscale")){
		return false;
	}
	if (isEmpty(citta,"citta")){
		return false;
	}
	if (!isAValidString(citta,regex.citta,"citta")){
		return false;
	}
	if (isEmpty(provincia,"provincia")){
		return false;
	}
	if (!isAValidString(provincia,regex.provincia,"provincia")){
		return false;
	}
	if (isEmpty(cap,"cap")){
		return false;
	}
	if (!isAValidString(cap,regex.cap,"cap")){
		return false;
	}
	if (isEmpty(telefono,"telefono")){
		return false;
	}
	if (!isAValidString(telefono,regex.telefono,"telefono")){
		return false;
	}
	if (isEmpty(email,"email")){
		return false;
	}
	if (!isAValidString(email,regex.email,"email")){
		return false;
	}
	if (isEmpty(username,"username")){
		return false;
	}
	if (!isAValidString(username,regex.usurname,"username")){
		return false;
	}
	if (isEmpty(password,"password")){
		return false;
	}
	if (!isAValidString(password,regex.password,"password")){
		return false;
	}
	if (isEmpty(confpassword,"conferma password")){
		return false;
	}
	if((password.localeCompare(confpassword))!= 0){
		alert("Password e conferma password non corrispondono");
		return false;
	}
		if(document.getElementById("si").checked==false && document.getElementById("no").checked==false ){
			scelta = false;
		}
		else{
			scelta=true;
		}
		if(scelta == false){
			alert("Errore: Per favore seleziona si se possiedi una Società e no altrimenti!");
			return false;
		}
		
		return true;
}

function validateSocieta(){
	var nomeSocieta = document.registrazioneSocieta.nomeSocieta.value;
	var indirizzoSede = document.registrazioneSocieta.indirizzoSede.value;
	var partitaIva = document.registrazioneSocieta.partitaIva.value;
	var telefonoSocieta = document.registrazioneSocieta.telefono.value;
	var codiceAutenticazione = document.registrazioneSocieta.codiceAutenticazione.value;
	
	
	if (isEmpty(nomeSocieta,"nomeSocieta"))
	{
		return false;
	}
	if (!isAValidString(nomeSocieta,regex.nomeSocieta,"Nome Societa"))
	{
		return false;
	}
	
	if (isEmpty(indirizzoSede,"indirizzoSede"))
	{
		return false;
	}
	if (!isAValidString(indirizzoSede,regex.indirizzoSede,"Indirizzo Sede"))
	{
		return false;
	}
	
	if (isEmpty(partitaIva,"partitaIva"))
	{
		return false;
	}
	if (!isAValidString(partitaIva,regex.partitaIva,"Partita Iva"))
	{
		return false;
	}
	if (isEmpty(telefonoSocieta,"telefono"))
	{
		return false;
	}
	if (!isAValidString(telefonoSocieta,regex.telefono,"Telefono"))
	{
		return false;
	}
	if (isEmpty(codiceAutenticazione,"codiceAutenticazione"))
	{
		return false;
	}
	if (!isAValidString(codiceAutenticazione,regex.codiceAutenticazione,"Codice di Autenticazione"))
	{
		return false;
	}
	return true;
}

function validateHome(){
	var luogo=document.formRicerca.luogo.value;
	var ora=document.formRicerca.ora.value;
	var minuti=document.formRicerca.minuti.value;
	var data=document.formRicerca.data.value;
	
	if (isEmpty(luogo,"luogo")){
		return false;
	}
	if (!isAValidString(luogo,regex.citta,"luogo")){
		return false;
	}
	if (isEmpty(data,"data")){
		return false;
	}
	if (isEmpty(ora,"ora")){
		return false;
	}
	if (!isAValidString(ora,regex.ora,"ora")){
		return false;
	}
	if (isEmpty(minuti,"minuti")){
		return false;
	}
	if (!isAValidString(minuti,regex.minuti,"minuti")){
		return false;
	}
	return true;
}

function validateCarta(){
	var numero=document.formRegistraCarta.numeroCarta.value;
	var intestatario=document.formRegistraCarta.intestatarioCarta.value;
	var scadenza=document.formRegistraCarta.scadenzaCarta.value;
	var cvv=document.formRegistraCarta.cvvCarta.value;
	
	if (isEmpty(numero,"numero")){
		return false;
	}
	if (!isAValidString(numero,regex.numeroCarta,"numero")){
		return false;
	}
	if (isEmpty(intestatario,"intestatario")){
		return false;
	}
	if (!isAValidString(intestatario,regex.nome,"intestatario")){
		return false;
	}
	if (isEmpty(scadenza,"scadenza")){
		return false;
	}
	if (isEmpty(cvv,"cvv")){
		return false;
	}
	if (!isAValidString(cvv,regex.cvvCarta,"cvv")){
		return false;
	}
	return true;
}

function validateAggiungiCampo(){
	var nome=document.aggiungiCampo.nomeCampo.value;
	var fascia=document.aggiungiCampo.fasciaOraria.value;
	var luogo=document.aggiungiCampo.luogo.value;
	var prezzoOnline=document.aggiungiCampo.prezzoOnline.value;
	var prezzoSulCampo=document.aggiungiCampo.prezzoSulCampo.value;
	
	if (isEmpty(nome,"nome")){
		return false;
	}
	if (!isAValidString(nome,regex.nome,"nome")){
		return false;
	}
	if (isEmpty(fascia,"fascia")){
		return false;
	}
	if (!isAValidString(fascia,regex.fascia,"fascia")){
		return false;
	}
	if (isEmpty(luogo,"luogo")){
		return false;
	}
	if (!isAValidString(luogo,regex.citta,"luogo")){
		return false;
	}
	if (isEmpty(prezzoOnline,"prezzoOnline")){
		return false;
	}
	if (!isAValidString(prezzoOnline,regex.prezzo,"prezzoOnline")){
		return false;
	}
	if (isEmpty(prezzoSulCampo,"prezzoSulCampo")){
		return false;
	}
	if (!isAValidString(prezzoSulCampo,regex.prezzo,"prezzoSulCampo")){
		return false;
	}
	return true;
}

function validateModificaCampo(){
	var nome=document.ModificaCampo.nomeCampo.value;
	var fascia=document.ModificaCampo.fasciaOraria.value;
	var luogo=document.ModificaCampo.luogo.value;
	var prezzoOnline=document.ModificaCampo.prezzoOnline.value;
	var prezzoSulCampo=document.ModificaCampo.prezzoSulCampo.value;
	
	if (isEmpty(nome,"nome")){
		return false;
	}
	if (!isAValidString(nome,regex.nome,"nome")){
		return false;
	}
	if (isEmpty(fascia,"fascia")){
		return false;
	}
	if (!isAValidString(fascia,regex.fascia,"fascia")){
		return false;
	}
	if (isEmpty(luogo,"luogo")){
		return false;
	}
	if (!isAValidString(luogo,regex.citta,"luogo")){
		return false;
	}
	if (isEmpty(prezzoOnline,"prezzoOnline")){
		return false;
	}
	if (!isAValidString(prezzoOnline,regex.prezzo,"prezzoOnline")){
		return false;
	}
	if (isEmpty(prezzoSulCampo,"prezzoSulCampo")){
		return false;
	}
	if (!isAValidString(prezzoSulCampo,regex.prezzo,"prezzoSulCampo")){
		return false;
	}
	return true;
}

function isEmpty(aString,nomeCampo){
	if (aString == null || aString == "" || aString.trim() == "" || aString == undefined) 
	{
        alert("Errore: Campo "+nomeCampo+" vuoto!");
        return true;
    }
	return false;

}

function isAValidString(aString, aRegex, nomeCampo){
	if(!aString.match(aRegex)){
		alert("Errore: "+nomeCampo+" non valido!");
		return false;
	}
	return true;
}