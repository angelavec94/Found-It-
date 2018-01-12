package model;

public class UtenteBean implements Cloneable {
	/*
	 * dichiarazioni variabili di instanza
	 */
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String citta;
	private String provincia;
	private int cap;
	private String telefono;
	private String email;
	private String username;
	private String password;
	private String tipo;
	private String societaSportiva_PartitaIva;
	private String numeroCarta;
	/*
	 * Costruttore
	 */
	public UtenteBean() {
		this.nome = null;
		this.cognome = null;
		this.codiceFiscale= null;
		this.citta = null;
		this.provincia = null;
		this.cap = 0;
		this.telefono = null;
		this.email = null;
		this.username = null;
		this.password = null;
		this.tipo = null;
		this.societaSportiva_PartitaIva= null;
		this.numeroCarta= null;
	}
	/*
	 * metodi di accesso
	 */
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}

	public String getCodiceFiscale(){
		return codiceFiscale;
	}

	public String getCitta(){
		return citta;
	}

	public String getProvincia(){
		return provincia;
	}

	public int getCap(){
		return cap;
	}

	public String getTelefono(){
		return telefono;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public String getTipo(){
		return tipo;
	}
	
	public String getSocietaSportiva_PartitaIva() {
		return societaSportiva_PartitaIva;
	}
	public String getNumeroCarta() {
		return numeroCarta;
	}
	/*
	 * metodi modificatori
	 */
	public void setNome(String unNome){
		nome = unNome;
	}
	public void setCognome(String unCognome){
		cognome = unCognome;
	}
	public void setCodiceFiscale(String unCodiceFiscale){
		codiceFiscale = unCodiceFiscale;
	}
	public void setCitta(String unaCitta){
		citta = unaCitta;
	}
	public void setProvincia(String unaProvincia){
		provincia = unaProvincia;
	}
	public void setCap(int unCap){
		cap = unCap;
	}
	public void setTelefono(String unTelefono){
		telefono = unTelefono;
	}
	public void setEmail(String unaEmail){
		email = unaEmail;
	}
	public void setUsername(String unUsername){
		username = unUsername;
	}
	public void setPassword(String unaPassword){
		password = unaPassword;
	}
	public void setTipo(String unTipo){
		tipo = unTipo;
	}
	public void setSocietaSportiva_PartitaIva(String unaPartitaIva) {
		societaSportiva_PartitaIva = unaPartitaIva;
	}
	public void setNumeroCarta(String unNumeroCarta) {
		numeroCarta = unNumeroCarta;
	}
	/*
	 * Override toString di Object
	 */
	public String toString(){
		return getClass().getName()+" [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", citta="
				+ citta + ", provincia=" + provincia + ", cap=" + cap + ", telefono=" + telefono + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", tipo=" + tipo + ", societaSportiva_PartivaIva="+societaSportiva_PartitaIva+", numero carta="+numeroCarta+"]";
	}
	
	/*
	 * Override equals di Object
	 */
	public boolean equals(Object o){
		if (o == null) return false;
		if (getClass() != o.getClass())return false;
		UtenteBean ut = (UtenteBean) o;
		return getNome().equals(ut.nome)&& getCognome().equals(ut.cognome)&& getCodiceFiscale().equals(ut.codiceFiscale) &&
			   getCitta().equals(ut.citta)&& getProvincia().equals(ut.provincia)&& getCap()==ut.cap && getTelefono().equals(ut.telefono)
			   && getEmail().equals(ut.email)&& getUsername().equals(ut.username)&& getPassword().equals(ut.password) && getSocietaSportiva_PartitaIva().equals(ut.societaSportiva_PartitaIva)&& getNumeroCarta().equals(ut.numeroCarta);
	}
	/*
	 * Override clone di Object
	 */
		public UtenteBean clone(){
			UtenteBean cloned;
			try{
				cloned= (UtenteBean)super.clone();
				return cloned;
			}catch(CloneNotSupportedException e){
				return null;
			}
		}

}
