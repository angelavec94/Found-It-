package model;

import java.sql.Date;

public class CartaBean implements Cloneable{
	
	//Variabili di istanza
	
	private String numeroCarta;
	private String intestatario;
	private Date scadenza;
	private int cvv;
	
	//Costruttore
	
	public CartaBean(){
		this.numeroCarta=null;
		this.intestatario=null;
		this.scadenza=null;
		this.cvv=0;
	}
	
	//Metodi d'accesso

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public int getCvv() {
		return cvv;
	}
	
	//Metodi modificatori

	public void setNumeroCarta(String unNumeroCarta) {
		numeroCarta = unNumeroCarta;
	}

	public void setIntestatario(String unIntestatario) {
		intestatario = unIntestatario;
	}

	public void setScadenza(Date unaScadenza) {
		scadenza = unaScadenza;
	}

	public void setCvv(int unCvv) {
		cvv = unCvv;
	}
	
	//Override toString di Object
	
	public String toString(){
		return getClass().getName()+" [Numero Carta="+numeroCarta+", Intestatario="+intestatario+", Scadenza="+scadenza.toString()+", CVV/CVV2="+cvv+"]";
	}
	
	//Override equals di Object
	
	public boolean equals(Object o){
		if(o==null) return false;
		if (getClass()!=o.getClass()) return false;
		CartaBean x=(CartaBean)o;
		return getNumeroCarta().equals(x.numeroCarta)&&getIntestatario().equals(x.intestatario)&&getScadenza().equals(x.scadenza)&&getCvv()==x.cvv;
	}
	
	//Override clone di Object
	
	public CartaBean clone(){
		CartaBean cloned;
		try{
			cloned=(CartaBean)super.clone();
			return cloned;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
}
