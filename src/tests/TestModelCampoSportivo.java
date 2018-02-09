package tests;

import java.sql.SQLException;

import junit.framework.*;
import model.CampoSportivoBean;
import model.CampoSportivoModel;
import model.CampoSportivoModelDM;

public class TestModelCampoSportivo extends TestCase{
	private CampoSportivoModel model;
	
	
	protected void setUp() throws Exception {
		model=new CampoSportivoModelDM();
	}
	
	protected void tearDown() throws Exception {
		model=null;
	}
	
	public void testDoSave(){
		CampoSportivoBean campo=new CampoSportivoBean();
		campo.setIdCampoSportivo(100);
		campo.setNome("Palladoro");
		campo.setFasciaOraria("7-23");
		campo.setLuogo("Nola");
		campo.setTipologia("calcio");
		campo.setPrezzoOnline(5.0);
		campo.setPrezzoSulCampo(7.5);
		campo.setPartitaIvaSocieta("12345678912");
		try {
			model.doSave(campo);
			assertTrue(model.doRetrieveByKey(100)!=null);
			model.doDelete(100);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testDoDelete(){
		CampoSportivoBean campo=new CampoSportivoBean();
		campo.setIdCampoSportivo(100);
		campo.setNome("Palladoro");
		campo.setFasciaOraria("7-23");
		campo.setLuogo("Nola");
		campo.setTipologia("calcio");
		campo.setPrezzoOnline(5.0);
		campo.setPrezzoSulCampo(7.5);
		campo.setPartitaIvaSocieta("12345678912");
		try {
			model.doSave(campo);
			model.doDelete(100);
			assertTrue((model.doRetrieveByKey(100)).getNome()==null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testDoUpdate(){
		CampoSportivoBean campo=new CampoSportivoBean();
		campo.setIdCampoSportivo(100);
		campo.setNome("Palladoro");
		campo.setFasciaOraria("7-23");
		campo.setLuogo("Nola");
		campo.setTipologia("calcio");
		campo.setPrezzoOnline(5.0);
		campo.setPrezzoSulCampo(7.5);
		campo.setPartitaIvaSocieta("12345678912");
		try {
			model.doSave(campo);
			campo.setNome("Pallargento");
			model.doUpdate(campo);
			assertTrue((model.doRetrieveByKey(100)).getNome().equals("Pallargento"));
			model.doDelete(100);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testDoRetrieveByKey(){
		CampoSportivoBean campo=new CampoSportivoBean();
		campo.setIdCampoSportivo(100);
		campo.setNome("Palladoro");
		campo.setFasciaOraria("7-23");
		campo.setLuogo("Nola");
		campo.setTipologia("calcio");
		campo.setPrezzoOnline(5.0);
		campo.setPrezzoSulCampo(7.5);
		campo.setPartitaIvaSocieta("12345678912");
		try {
			model.doSave(campo);
			assertTrue(model.doRetrieveByKey(100)!=null);
			model.doDelete(100);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Test suite(){
		return new TestSuite(TestModelCampoSportivo.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
