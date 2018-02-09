package tests;

import junit.framework.*;

public class TestGestioneSocieta extends TestCase{
	private String nomeSocieta;
	private String indirizzoSede;
	private String partitaIva;
	private String numeroTelefono;
	
	protected void setUp() throws Exception {
		nomeSocieta="Palladoro S.p.a";
		indirizzoSede="via Roma";
		partitaIva="01234567654";
		numeroTelefono="0815123456";
	}
	
	
	protected void tearDown() throws Exception {
		nomeSocieta="";
		indirizzoSede="";
		partitaIva="";
		numeroTelefono="";
	}
	
	public void testNomeSocieta(){
		assertTrue(nomeSocieta.length()>=3);
		assertTrue(nomeSocieta.length()<=25);
		assertTrue(nomeSocieta.matches("^(?=.{3,25}$)^[A-Za-zèùàòé][a-zA-Z'èùàòé .]*$"));
	}
	
	public void testIndirizzoSede(){
		assertTrue(indirizzoSede.length()>=3);
		assertTrue(indirizzoSede.length()<=25);
		assertTrue(indirizzoSede.matches("^(?=.{3,25}$)^[A-Za-zèùàòéZ0-9,-.° ]*$"));
	}
	
	public void testPartitaIva(){
		assertTrue(partitaIva.length()==11);
		assertTrue(partitaIva.matches("^[0-9]{11}$"));
	}
	
	public void testNumeroTelefono(){
		assertTrue(numeroTelefono.length()==10);
		assertTrue(numeroTelefono.matches("^[0|3]{1}[0-9]{5,10}$"));
	}
	
	public static Test suite(){
		return new TestSuite(TestGestioneSocieta.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
