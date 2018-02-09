package tests;

import junit.framework.*;

public class TestRicercaCampi extends TestCase{
	private String luogo;
	private int ore;
	private int minuti;
	
	protected void setUp() throws Exception {
		luogo="Nola";
		ore=14;
		minuti=30;
	}
	
	protected void tearDown() throws Exception {
		luogo="";
		ore=-1;
		minuti=-1;
	}
	
	public void testLuogo(){
		assertTrue(luogo.length()>=3);
		assertTrue(luogo.length()<=25);
		assertTrue(luogo.matches("^(?=.{3,25}$)^[A-Za-zטשאעי][a-zA-Z'טשאעי ]*$"));
	}
	
	public void testOre(){
		assertTrue(ore>=0);
		assertTrue(ore<24);
		assertTrue((""+ore).matches("^([01][0-9]|2[0-3]|[1-9])$"));
	}
	
	public void testMinuti(){
		assertTrue(minuti>=0);
		assertTrue(minuti<59);
		assertTrue((""+minuti).matches("^([0-5][0-9])$"));
	}
	
	public static Test suite(){
		return new TestSuite(TestRicercaCampi.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
