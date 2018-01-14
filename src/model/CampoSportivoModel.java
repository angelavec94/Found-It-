package model;

import java.sql.SQLException;
import java.util.Collection;

public interface CampoSportivoModel {
	public void doSave(CampoSportivoBean campoToSave) throws SQLException;
	public boolean doDelete(int anID) throws SQLException;
	public boolean doUpdate(CampoSportivoBean campoToUpdate) throws SQLException;
	public CampoSportivoBean doRetrieveByKey(int anID) throws SQLException;
	public Collection<CampoSportivoBean> doRetrieveAll(String order) throws SQLException;
}
