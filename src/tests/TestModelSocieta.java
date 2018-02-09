package tests;
import java.sql.SQLException;

import junit.framework.*;
import model.SocietaSportivaBean;
import model.SocietaSportivaModel;
import model.SocietaSportivaModelDM;

public class TestModelSocieta extends TestCase{
	private SocietaSportivaModel model;
	
	
	protected void setUp() throws Exception {
		model=new SocietaSportivaModelDM();
	}
	
	protected void tearDown() throws Exception {
		model=null;
	}
	
	public void testDoSave(){
		SocietaSportivaBean societa=new SocietaSportivaBean();
		societa.setNomeSocieta("Palladoro S.p.a");
		societa.setIndirizzoSede("via Roma");
		societa.setPartitaIva("01234567654");
		societa.setTelefono("0815123456");
	
		try {
			model.doSave(societa);
			assertTrue(model.doRetrieveByKey("01234567654")!=null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void testDoUpdate(){
		SocietaSportivaBean societa=new SocietaSportivaBean();
		societa.setNomeSocieta("Palladoro S.p.a");
		societa.setIndirizzoSede("via Roma");
		societa.setPartitaIva("01234567654");
		societa.setTelefono("0815123456");
		try {
			model.doSave(societa);
			societa.setNomeSocieta("Buonavita");
			model.doUpdate(societa);
			assertTrue((model.doRetrieveByKey("01234567654")).getNomeSocieta().equals("Buonavita"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void testDoRetrieveByKey(){
		SocietaSportivaBean societa=new SocietaSportivaBean();
		societa.setNomeSocieta("Palladoro S.p.a");
		societa.setIndirizzoSede("via Roma");
		societa.setPartitaIva("01234567654");
		societa.setTelefono("0815123456");
		try {
			model.doSave(societa);
			assertTrue(model.doRetrieveByKey("01234567654")!=null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Test suite(){
		return new TestSuite(TestModelSocieta.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
