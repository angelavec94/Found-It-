package model;

import java.sql.SQLException;

public interface SocietaSportivaModel {
	public void doSave(SocietaSportivaBean societaToSave) throws SQLException;
	public boolean doUpdate(SocietaSportivaBean societaToUpdate) throws SQLException;
	public SocietaSportivaBean doRetrieveByKey(String aPartitaIVA) throws SQLException;
}
