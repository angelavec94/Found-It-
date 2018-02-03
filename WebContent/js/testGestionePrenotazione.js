var regex={data:"^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$"};

function validateAggiungiPrenotazione(){
	alert("partita");
	var dateString=document.formCalcolaOra.data.value;
	alert("controllo 1");
	if (isEmpty(dateString,"data")){
		return false;
	}
	alert("controllo 2");
	var regEx = /^\d{4}-\d{2}-\d{2}$/;
	  if(!dateString.match(regEx)){
		  alert("Errore: data non valida!");
		  return false;
	  }
	  var d = new Date(dateString);
	  if(!d.getTime() && d.getTime() !== 0){
		  alert("Errore: data non valida!");
		  return false;
	  }
	  return d.toISOString().slice(0,10) === dateString;
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
	alert("partitaaaaaa");
	alert(aString);
	alert(aRegex);
	if(!aString.match(aRegex)){
		alert("Errore: "+nomeCampo+" non valido!");
		return false;
	}
	else{
	alert("sono qua");
	return true;
	}
	alert("boh")
	return false;
}