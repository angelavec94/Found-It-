package model;

public class CampoSportivoBean implements Cloneable{
	
	//Variabili di istanza
	
	private int idCampoSportivo;
	private String nome;
	private String fasciaOraria;
	private String luogo;
	private String tipologia;
	private Double prezzoOnline;
	private Double prezzoSulCampo;
	private String partitaIvaSocieta;
	
	//Costruttore
	
	public CampoSportivoBean(){
		this.idCampoSportivo=0;
		this.nome=null;
		this.fasciaOraria=null;
		this.luogo=null;
		this.tipologia=null;
		this.prezzoOnline=0.0;
		this.prezzoSulCampo=0.0;
		this.partitaIvaSocieta=null;
	}
	
	//Metodi d'accesso
	
	public int getIdCampoSportivo() {
		return idCampoSportivo;
	}

	public String getNome() {
		return nome;
	}
	
	public String getFasciaOraria() {
		return fasciaOraria;
	}
	
	public String getLuogo() {
		return luogo;
	}
	
	public String getTipologia() {
		return tipologia;
	}
	
	public Double getPrezzoOnline() {
		return prezzoOnline;
	}
	
	public Double getPrezzoSulCampo() {
		return prezzoSulCampo;
	}
	
	public String getPartitaIvaSocieta() {
		return partitaIvaSocieta;
	}
	
	//Metodi modificatori
	
	public void setIdCampoSportivo(int unIdCampoSportivo) {
		idCampoSportivo = unIdCampoSportivo;
	}
	
	public void setNome(String unNome) {
		nome = unNome;
	}

	public void setFasciaOraria(String unaFasciaOraria) {
		fasciaOraria = unaFasciaOraria;
	}

	public void setLuogo(String unLuogo) {
		luogo = unLuogo;
	}

	public void setTipologia(String unaTipologia) {
		tipologia = unaTipologia;
	}

	public void setPrezzoOnline(Double unPrezzoOnline) {
		prezzoOnline = unPrezzoOnline;
	}
	
	public void setPrezzoSulCampo(Double unPrezzoSulCampo) {
		prezzoSulCampo = unPrezzoSulCampo;
	}
	
	public void setPartitaIvaSocieta(String unaPartitaIvaSocieta) {
		partitaIvaSocieta = unaPartitaIvaSocieta;
	}
	
	//Override toString di Object
	
	public String toString(){
		return getClass().getName()+" [ID Campo Sportivo="+idCampoSportivo+", Nome="+nome+", Fascia Oraria="+fasciaOraria+", Luogo="+luogo+", Tipologia="+tipologia+", Prezzo Online="+prezzoOnline+", Prezzo sul Campo="+prezzoSulCampo+", Partita IVA Società="+partitaIvaSocieta+"]";
	}
	
	//Override equals di Object
	
	public boolean equals(Object o){
		if(o==null) return false;
		if (getClass()!=o.getClass()) return false;
		CampoSportivoBean x=(CampoSportivoBean)o;
		return getIdCampoSportivo()==x.getIdCampoSportivo()&&getNome().equals(x.nome)&&getFasciaOraria().equals(x.fasciaOraria)&&getLuogo().equals(x.luogo)&&getTipologia().equals(x.tipologia)&&getPrezzoOnline()==x.prezzoOnline&&getPrezzoSulCampo()==x.prezzoSulCampo&&getPartitaIvaSocieta().equals(x.partitaIvaSocieta);
	}
	
	//Override clone di Object
	
	public CampoSportivoBean clone(){
		CampoSportivoBean cloned;
		try{
			cloned=(CampoSportivoBean)super.clone();
			return cloned;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
}
