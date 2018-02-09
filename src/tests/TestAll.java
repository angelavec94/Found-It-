package tests;

import junit.framework.*;

public class TestAll{

	/**
	 * Manually built a suite containing all the TestClass to run them all in one time
	 * @return suite - suite containing all the TestClass
	 */
	public static Test suite(){
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(TestGestioneCampi.class);
		suite.addTestSuite(TestGestioneCarta.class);
		suite.addTestSuite(TestGestionePrenotazioni.class);
		suite.addTestSuite(TestLogin.class);
		suite.addTestSuite(TestRegistrazioneUtente.class);
		suite.addTestSuite(TestRicercaCampi.class);
		
		return suite;
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
