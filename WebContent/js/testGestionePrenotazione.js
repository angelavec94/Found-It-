var regex={data:"^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$"};

function validateAggiungiPrenotazione(){
	var dateString=document.formCalcolaOra.data.value;
	if (isEmpty(dateString,"data")){
		return false;
	}
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