package model;

import java.sql.SQLException;
import java.util.Collection;

public interface UtenteModel {
	public void doSave(UtenteBean utenteToSave) throws SQLException;
	
	public boolean doUpdate(UtenteBean utenteToUpdate) throws SQLException;

	public boolean doDelete(String unCodiceFiscale) throws SQLException;
	
	public UtenteBean doRetrieveByKey(String unCodiceFiscale) throws SQLException;
	
	public Collection<UtenteBean> doRetrieveAll(String order) throws SQLException;
}
