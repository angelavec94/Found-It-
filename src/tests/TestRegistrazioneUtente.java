package tests;
import junit.framework.*;
public class TestRegistrazioneUtente extends TestCase{
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String citta;
	private int cap;
	private String telefono;
	private String email;
	private String username;
	private String password;
	private String confPassword;

	protected void setUp() throws Exception {
		nome="Angela";
		cognome="Vecchione";
		codiceFiscale="VCCNGL94P50F924X";
		citta="Nola";
		cap=80035;
		telefono="3276178567";
		email="angelavecchione94@gmail.com";
		username="AngelaVec94";
		password="AngelaVec94";
		confPassword="AngelaVec94";
	}
	protected void tearDown() throws Exception {
		nome="";
		cognome="";
		codiceFiscale="";
		citta="";
		cap=0;
		telefono="";
		email="";
		username="";
		password="";
		confPassword="";
	}
	public void testNome(){
		assertTrue(nome.length()>=3);
		assertTrue(nome.length()<=25);
		assertTrue(nome.matches("^(?=.{3,25}$)^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$"));
	}
	public void testCognome(){
		assertTrue(cognome.length()>=3);
		assertTrue(cognome.length()<=25);
		assertTrue(cognome.matches("^(?=.{3,25}$)^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$"));
	}
	public void testCodiceFiscale(){
		assertTrue(codiceFiscale.length()==16);
		assertTrue(codiceFiscale.matches("[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$"));
	}
	public void testCitta(){
		assertTrue(citta.length()>=3);
		assertTrue(citta.length()<=25);
		assertTrue(citta.matches("^(?=.{3,25}$)^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$"));
	}
	public void testCap(){
		assertTrue((""+cap).length()==5);
		assertTrue((""+cap).matches("^[0-9]{5}$"));
	}
	public void testTelefono(){
		assertTrue(telefono.length()==10);
		assertTrue(telefono.matches("(^[0|3]{1}[0-9]{5,10}$)"));
	}
	public void testEmail(){
		assertTrue(email.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z_]+?.[a-zA-Z]{2,3}$"));
	}
	public void testUsername(){
		assertTrue(citta.length()>=3);
		assertTrue(citta.length()<=20);
		assertTrue(username.matches("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._-]+(?<![_.])$"));
	}
	public void testPassword(){
		assertTrue(password.length()>=8);
		assertTrue(password.length()<=30);
		assertTrue(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9$@$!%*?&]{8,30}"));
	}
	public void testConfPassword(){
		assertTrue(password.equals(confPassword));
	}
	public static Test suite(){
		return new TestSuite(TestRegistrazioneUtente.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
