package tests;

import junit.framework.*;

public class testGestioneCarta extends TestCase{
	private String numeroCarta;
	private String intestatario;
	private String cvv;
	
	protected void setUp() throws Exception {
		numeroCarta="1234567891234567";
		intestatario="Eugenio";
		cvv="1234";
	}
	
	protected void tearDown() throws Exception {
		numeroCarta="";
		intestatario="";
		cvv="";
	}
	
	public void testNumeroCarta(){
		assertTrue(numeroCarta.length()==16);
		assertTrue(numeroCarta.matches("^[0-9]{16}$"));
	}
	
	public void testIntestatario(){
		assertTrue(intestatario.length()>=3);
		assertTrue(intestatario.length()<=25);
		assertTrue(intestatario.matches("^(?=.{3,25}$)^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$"));
	}
	
	public void testCvv(){
		assertTrue(cvv.length()==4);
		assertTrue(cvv.matches("^[0-9]{4}$"));
	}
	
	public static Test suite(){
		return new TestSuite(testGestioneCarta.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
