package tests;
import java.sql.SQLException;

import junit.framework.*;
import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;

public class TestModelUtente extends TestCase{
	private UtenteModel model;
	
	
	protected void setUp() throws Exception {
		model=new UtenteModelDM();
	}
	
	protected void tearDown() throws Exception {
		model=null;
	}
	
	public void testDoSave(){
		UtenteBean utente=new UtenteBean();
		utente.setNome("Angela");
		utente.setCognome("Vecchione");
		utente.setCodiceFiscale("VCCNGL94P50F924X");
		utente.setCitta("Nola");
		utente.setCap(80035);
		utente.setTelefono("3276178567");
		utente.setEmail("angelavecchione94@gmail.com");
		utente.setUsername("AngelaVec94");
		utente.setPassword("AngelaVec94");
		try {
			model.doSave(utente);
			assertTrue(model.doRetrieveByKey("VCCNGL94P50F924X")!=null);
			model.doDelete("VCCNGL94P50F924X");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void testDoDelete(){
		UtenteBean utente=new UtenteBean();
		utente.setNome("Angela");
		utente.setCognome("Vecchione");
		utente.setCodiceFiscale("VCCNGL94P50F924X");
		utente.setCitta("Nola");
		utente.setCap(80035);
		utente.setTelefono("3276178567");
		utente.setEmail("angelavecchione94@gmail.com");
		utente.setUsername("AngelaVec94");
		utente.setPassword("AngelaVec94");
		try {
			model.doSave(utente);
			model.doDelete("VCCNGL94P50F924X");
			assertTrue((model.doRetrieveByKey("VCCNGL94P50F924X")).getCodiceFiscale()==null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void testDoUpdate(){
		UtenteBean utente=new UtenteBean();
		utente.setNome("Angela");
		utente.setCognome("Vecchione");
		utente.setCodiceFiscale("VCCNGL94P50F924X");
		utente.setCitta("Nola");
		utente.setCap(80035);
		utente.setTelefono("3276178567");
		utente.setEmail("angelavecchione94@gmail.com");
		utente.setUsername("AngelaVec94");
		utente.setPassword("AngelaVec94");
	
		try {
			model.doSave(utente);
			utente.setNome("Andrea");
			model.doUpdate(utente);
			assertTrue((model.doRetrieveByKey("VCCNGL94P50F924X")).getNome().equals("Andrea"));
			model.doDelete("VCCNGL94P50F924X");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void testDoRetrieveByKey(){
		UtenteBean utente =new UtenteBean();
		utente.setNome("Angela");
		utente.setCognome("Vecchione");
		utente.setCodiceFiscale("VCCNGL94P50F924X");
		utente.setCitta("Nola");
		utente.setCap(80035);
		utente.setTelefono("3276178567");
		utente.setEmail("angelavecchione94@gmail.com");
		utente.setUsername("AngelaVec94");
		utente.setPassword("AngelaVec94");
		try {
			model.doSave(utente);
			assertTrue(model.doRetrieveByKey("VCCNGL94P50F924X")!=null);
			model.doDelete("VCCNGL94P50F924X");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Test suite(){
		return new TestSuite(TestModelUtente.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
