package tests;

import junit.framework.*;

public class TestGestioneCampi extends TestCase{
	private String nome;
	private String fasciaOraria;
	private String luogo;
	private Double prezzoOnline;
	private Double prezzoSulCampo;
	
	protected void setUp() throws Exception {
		nome="Palladoro";
		fasciaOraria="7-23";
		luogo="Nola";
		prezzoOnline=5.0;
		prezzoSulCampo=7.5;
	}
	
	protected void tearDown() throws Exception {
		nome="";
		fasciaOraria="";
		luogo="";
		prezzoOnline=-1.0;
		prezzoSulCampo=-1.0;
	}
	
	public void testNome(){
		assertTrue(nome.length()>=3);
		assertTrue(nome.length()<=25);
		assertTrue(nome.matches("^(?=.{3,25}$)^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$"));
	}
	
	public void testFasciaOraria(){
		String[] fasce=fasciaOraria.split("-");
		assertTrue(Integer.parseInt(fasce[0])>=0);
		assertTrue(Integer.parseInt(fasce[0])<24);
		assertTrue(Integer.parseInt(fasce[1])>=0);
		assertTrue(Integer.parseInt(fasce[1])<24);
		assertTrue(fasciaOraria.matches("^([01][0-9]|2[0-3]|[1-9])+-+([01][0-9]|2[0-3]|[1-9])$"));
	}
	
	public void testLuogo(){
		assertTrue(luogo.length()>=3);
		assertTrue(luogo.length()<=25);
		assertTrue(luogo.matches("^(?=.{3,25}$)^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$"));
	}
	
	public void testPrezzoOnline(){
		assertTrue(prezzoOnline>=0.0);
		assertTrue((""+prezzoOnline).matches("^([0-9]+.+[0-9])$"));
	}
	
	public void testPrezzoSulCampo(){
		assertTrue(prezzoSulCampo>=0.0);
		assertTrue((""+prezzoSulCampo).matches("^([0-9]+.+[0-9])$"));
	}
	
	public static Test suite(){
		return new TestSuite(TestGestioneCampi.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
