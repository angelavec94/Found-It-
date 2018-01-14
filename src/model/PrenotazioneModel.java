package model;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collection;

public interface PrenotazioneModel {
	
    public void doSave(PrenotazioneBean prenotazioneToSave) throws SQLException;
	
    public boolean doUpdate(PrenotazioneBean prenotazioneToUpdate, Date oldData, Time oldTime) throws SQLException;
	
	public Collection<PrenotazioneBean> doRetrieveAll(String username,String order) throws SQLException;

}
