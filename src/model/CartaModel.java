package model;

import java.sql.SQLException;

public interface CartaModel {
	public void doSave(CartaBean cartaToSave) throws SQLException;
	public boolean doUpdate(CartaBean cartaToUpdate) throws SQLException;
	public boolean doDelete(String aNumero) throws SQLException;
	public CartaBean doRetrieveByKey(String aNumero) throws SQLException;
}
