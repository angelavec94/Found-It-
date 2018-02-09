package tests;

import junit.framework.*;

public class TestGestionePrenotazioni extends TestCase{
	String data;
	
	protected void setUp() throws Exception {
		data="2018-12-25";
	}
	
	protected void tearDown() throws Exception {
		data="";
	}
	
	public void testData(){
		String[] parts=data.split("-");
		assertTrue(Integer.parseInt(parts[0])>=0);
		assertTrue(Integer.parseInt(parts[1])>=1);
		assertTrue(Integer.parseInt(parts[1])<13);
		assertTrue(Integer.parseInt(parts[2])>=1);
		assertTrue(Integer.parseInt(parts[2])<32);
		assertTrue(data.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"));
	}
	
	public static Test suite(){
		return new TestSuite(TestGestionePrenotazioni.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
