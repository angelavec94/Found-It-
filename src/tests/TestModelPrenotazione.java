package tests;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.*;
import model.PrenotazioneBean;
import model.PrenotazioneModel;
import model.PrenotazioneModelDM;

public class TestModelPrenotazione extends TestCase{
	private PrenotazioneModel model;
	
	
	protected void setUp() throws Exception {
		model=new PrenotazioneModelDM();
	}
	
	protected void tearDown() throws Exception {
		model=null;
	}
	
	public void testDoSave(){
		PrenotazioneBean prenotazione=new PrenotazioneBean();
		Date data= new Date(2018-12-25);
		prenotazione.setData(data);
		prenotazione.setIdPrenotazione(100);
		prenotazione.setTipo("online");
		try {
			model.doSave(prenotazione);
			assertTrue(model.doRetrieveByIDCampo(100)!=null);
			model.doDelete(100);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void testDoDelete(){
		PrenotazioneBean prenotazione=new PrenotazioneBean();
		Date data= new Date(2018-12-25);
		prenotazione.setData(data);
		prenotazione.setIdPrenotazione(100);
		prenotazione.setTipo("online");
		try {
			model.doSave(prenotazione);
			model.doDelete(100);
			assertTrue(model.doRetrieveByIDCampo(100)==null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void testDoUpdate(){
		PrenotazioneBean prenotazione=new PrenotazioneBean();
		Date data= new Date(2018-12-25);
		prenotazione.setData(data);
		prenotazione.setIdPrenotazione(100);
		prenotazione.setTipo("online");
		try {
			model.doSave(prenotazione);
			prenotazione.setTipo("telefonica");
			model.doUpdate(prenotazione);
			Collection<PrenotazioneBean> prenotazioni=model.doRetrieveByIDCampo(100);
			Iterator it=prenotazioni.iterator();
			while(it.hasNext()){
				PrenotazioneBean prenot=(PrenotazioneBean)it.next();
				if(prenot.getTipo().equals("telefonica")){
					assertTrue(prenot.getTipo().equals("telefonica"));
				}
			}
			model.doDelete(100);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void testDoRetrieveByIDCampo(){
		PrenotazioneBean prenotazione=new PrenotazioneBean();
		Date data= new Date(2018-12-25);
		prenotazione.setData(data);
		prenotazione.setIdPrenotazione(100);
		prenotazione.setTipo("online");
		
		try {
			model.doSave(prenotazione);
			assertTrue(model.doRetrieveByIDCampo(100)!=null);
			model.doDelete(100);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Test suite(){
		return new TestSuite(TestModelPrenotazione.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}


