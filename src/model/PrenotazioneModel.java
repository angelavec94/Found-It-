package model;

import java.sql.SQLException;
import java.util.Collection;

public interface PrenotazioneModel {
	
    public void doSave(PrenotazioneBean prenotazioneToSave) throws SQLException;
	
    public boolean doUpdate(PrenotazioneBean prenotazioneToUpdate) throws SQLException;
	
	public Collection<PrenotazioneBean> doRetrieveAll(String order) throws SQLException;

}
