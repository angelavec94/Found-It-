package tests;
import java.sql.SQLException;

import junit.framework.*;
import model.CartaBean;
import model.CartaModel;
import model.CartaModelDM;

public class TestModelCarta extends TestCase{
	private CartaModel model;
	
	
	protected void setUp() throws Exception {
		model=new CartaModelDM();
	}
	
	protected void tearDown() throws Exception {
		model=null;
	}
	
	public void testDoSave(){
		CartaBean carta=new CartaBean();
		carta.setNumeroCarta("1234567891234567");
		carta.setIntestatario("Eugenio");
		carta.setCvv(1234);
		try {
			model.doSave(carta);
			assertTrue(model.doRetrieveByKey("1234567891234567")!=null);
			model.doDelete("1234567891234567");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void testDoDelete(){
		CartaBean carta=new CartaBean();
		carta.setNumeroCarta("1234567891234567");
		carta.setIntestatario("Eugenio");
		carta.setCvv(1234);
		try {
			model.doSave(carta);
			model.doDelete("1234567891234567");
			assertTrue((model.doRetrieveByKey("1234567891234567")).getNumeroCarta()==null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void testDoUpdate(){
		CartaBean carta=new CartaBean();
		carta.setNumeroCarta("1234567891234567");
		carta.setIntestatario("Eugenio");
		carta.setCvv(1234);
		try {
			model.doSave(carta);
			carta.setIntestatario("Simone");
			model.doUpdate(carta);
			assertTrue((model.doRetrieveByKey("1234567891234567")).getIntestatario().equals("Simone"));
			model.doDelete("1234567891234567");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void testDoRetrieveByKey(){
		CartaBean carta=new CartaBean();
		carta.setNumeroCarta("1234567891234567");
		carta.setIntestatario("Eugenio");
		carta.setCvv(1234);
		
		try {
			model.doSave(carta);
			assertTrue(model.doRetrieveByKey("1234567891234567")!=null);
			model.doDelete("1234567891234567");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Test suite(){
		return new TestSuite(TestModelCarta.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}

