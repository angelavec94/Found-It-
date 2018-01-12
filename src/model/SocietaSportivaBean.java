package model;

public class SocietaSportivaBean implements Cloneable {
	/*
	 * dichiarazioni variabili di instanza
	 */
	private String nomeSocieta;
	private String indirizzoSede;
	private String partitaIva;
	private String telefono;
	private String CodiceAutenticazione;
	/*
	 * Costruttore
	 */
	public SocietaSportivaBean() {
		this.nomeSocieta = null;
		this.indirizzoSede = null;
		this.partitaIva= null;
		this.telefono = null;
		this.CodiceAutenticazione = null;
	}
	/*
	 * metodi di accesso
	 */
	public String getNomeSocieta() {
		return nomeSocieta;
	}
	public String getIndirizzoSede() {
		return indirizzoSede;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getCodiceAutenticazione() {
		return CodiceAutenticazione;
	}
	/*
	 * metodi modificatori
	 */
	public void setNomeSocieta(String nomeSocieta) {
		this.nomeSocieta = nomeSocieta;
	}
	public void setIndirizzoSede(String indirizzoSede) {
		this.indirizzoSede = indirizzoSede;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setCodiceAutenticazione(String codiceAutenticazione) {
		CodiceAutenticazione = codiceAutenticazione;
	}
	/*
	 * Override toString di Object
	 */
	public String toString() {
		return getClass().getName()+"[nomeSocieta=" + nomeSocieta + ", indirizzoSede=" + indirizzoSede + ", partitaIva="
				+ partitaIva + ", telefono=" + telefono + ", CodiceAutenticazione=" + CodiceAutenticazione + "]";
	}
	/*
	 * Override equals di Object
	 */
	public boolean equals(Object o){
		if (o == null) return false;
		if (getClass() != o.getClass())return false;
		SocietaSportivaBean so = (SocietaSportivaBean) o;
		return getNomeSocieta().equals(so.nomeSocieta)&& getIndirizzoSede().equals(so.indirizzoSede)&& getPartitaIva()==so.partitaIva &&
			   getTelefono().equals(so.telefono)&& getCodiceAutenticazione().equals(so.CodiceAutenticazione);
	}
	/*
	 * Override clone di Object
	 */
		public SocietaSportivaBean clone(){
			SocietaSportivaBean cloned;
			try{
				cloned= (SocietaSportivaBean)super.clone();
				return cloned;
			}catch(CloneNotSupportedException e){
				return null;
			}
		}
	
	
}
