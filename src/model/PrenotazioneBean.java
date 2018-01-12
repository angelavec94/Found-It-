package model;

import java.sql.Date;
import java.sql.Time;

public class PrenotazioneBean implements Cloneable{
	/*
	 * dichiarazioni variabili di instanza
	 */
	private Date data;
	private Time ora;
	private int idPrenotazione;
	private int idCampoSportivo;
	private boolean saldata;
	private String tipo;
	/*
	 * Costruttore
	 */
	public PrenotazioneBean(){
		this.idPrenotazione= 0;
		this.idCampoSportivo= 0;
		this.data=null;
		this.ora=null;
		this.saldata= false;
		this.tipo= null;
	}
	/*
	 * metodi di accesso
	 */
	public Date getData(){
		return data;
	}
	public Time getOra(){
		return ora;
	}
	public int getIdPrenotazione(){
		return idPrenotazione;
	}
	public int getIdCampoSportivo(){
		return idCampoSportivo;
	}
	public boolean isSaldata(){
		return saldata;
	}
	public String getTipo(){
		return tipo;
	}
	/*
	 * metodi modificatori
	 */
	public void setData(Date unaData){
		data = unaData;
	}
	public void setOra(Time unOra){
		ora = unOra;
	}
	public void setIdPrenotazione(int unIdPrenotazione){
		idPrenotazione = unIdPrenotazione;
	}
	public void setIdCampoSportivo(int unIdCampoSportivo){
		idCampoSportivo = unIdCampoSportivo;
	}
	public void setSaldata(boolean isSaldata){
		saldata = isSaldata;
	}
	public void setTipo(String unTipo){
		tipo = unTipo;
	}
	/*
	 * Override toString di Object
	 */
	public String toString() {
		return getClass().getName()+"[data=" + data + ", ora=" + ora + ", idPrenotazione=" + idPrenotazione
				+ ", idCampoSportivo=" + idCampoSportivo + ", saldata=" + saldata + ", tipo=" + tipo + "]";
	}
	/* 
	 * Override equals di Object
	 */
	public boolean equals(Object o){
		if (o == null) return false;
		if (getClass() != o.getClass())return false;
		PrenotazioneBean pre = (PrenotazioneBean) o;
		return getData().equals(pre.data)&& getOra().equals(pre.ora)&& getIdPrenotazione()==pre.idPrenotazione &&
			   getIdCampoSportivo()== pre.idCampoSportivo&& isSaldata()==pre.saldata && getTipo().equals(pre.tipo);
	}
	/*
	 * Override clone di Object
	 */
		public PrenotazioneBean clone(){
			PrenotazioneBean cloned;
			try{
				cloned= (PrenotazioneBean)super.clone();
				return cloned;
			}catch(CloneNotSupportedException e){
				return null;
			}
		}
	
}
