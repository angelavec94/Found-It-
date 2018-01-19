package util;

public class ValidationUtil {

public static final String REGEX_NOME = "^(?=.{3,25}$)^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$";
public static final String REGEX_GENERALE = "^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$";
public static final String REGEX_CAP = "^[0-9]{5}$";
public static final String REGEX_TELEFONO = "(^[0|3]{1}[0-9]{5,10}$)";
public static final String REGEX_EMAIL = "^[a-zA-Z0-9_.-]+@[a-zA-Z_]+?.[a-zA-Z]{2,3}$";
public static final String REGEX_USERNAME = "^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9$@$!%*?&]{8,30}";
public static final String REGEX_CODICE_FISCALE= "/[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]/";
	
public static boolean isEmpty(String aString){
	if (aString == null || aString == "" || aString.trim() == ""){
		return true;
	    
	}
		return false;
}

public static boolean isAValidString(String aString,String aRegex){ 
	if(!aString.matches(aRegex)){
		return false;
	}
	
	return true;
	}
}