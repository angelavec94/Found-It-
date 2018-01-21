package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;


public class UtenteModelDM  implements UtenteModel{
	private static final String TABLE_NAME = "utente";

	@Override
	public synchronized void doSave(UtenteBean utente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + UtenteModelDM.TABLE_NAME
				+ " (USERNAME,CODICEFISCALE,NOME,COGNOME,CITTA,PROVINCIA,CAP,TEL,PASSWORD,EMAIL,TIPO,SOCIETASPORTIVA_PARTITAIVA,CARTA_NUMEROCARTA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			connection= DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getCodiceFiscale());
			preparedStatement.setString(3, utente.getNome());
			preparedStatement.setString(4, utente.getCognome());
			preparedStatement.setString(5, utente.getCitta());
			preparedStatement.setString(6, utente.getProvincia());
			preparedStatement.setInt(7, utente.getCap());
			preparedStatement.setString(8, utente.getTelefono());
			preparedStatement.setString(9, utente.getPassword());
			preparedStatement.setString(10, utente.getEmail());	
			preparedStatement.setString(11, utente.getTipo());
			preparedStatement.setString(12, utente.getSocietaSportiva_PartitaIva());
			preparedStatement.setString(13, utente.getNumeroCarta());
			



			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public synchronized UtenteBean doRetrieveByKey(String unCodiceFiscale) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UtenteBean utente = new UtenteBean();

		String selectSQL = "SELECT * FROM " + UtenteModelDM.TABLE_NAME + " WHERE CODICEFISCALE = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, unCodiceFiscale);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) { 
				utente.setUsername(rs.getString("USERNAME"));
				utente.setCodiceFiscale(rs.getString("CODICEFISCALE"));
				utente.setNome(rs.getString("NOME"));
				utente.setCognome(rs.getString("COGNOME"));
				utente.setCitta(rs.getString("CITTA"));
				utente.setProvincia(rs.getString("PROVINCIA"));
				utente.setCap(rs.getInt("CAP"));
				utente.setTelefono(rs.getString("TEL"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setEmail(rs.getString("EMAIL"));
				utente.setTipo(rs.getString("TIPO"));
				utente.setSocietaSportiva_PartitaIva(rs.getString("SOCIETASPORTIVA_PARTITAIVA"));
				utente.setNumeroCarta(rs.getString("CARTA_NUMEROCARTA"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		if(utente.getCodiceFiscale()!=null)
		return utente;
		else
		return null;
	}

	@Override
	public synchronized boolean doDelete(String unCodiceFiscale) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + UtenteModelDM.TABLE_NAME + " WHERE CODICEFISCALE = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, unCodiceFiscale);


			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}

	@Override
	public synchronized Collection<UtenteBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<UtenteBean> users = new LinkedList<UtenteBean>();

		String selectSQL = "SELECT * FROM " + UtenteModelDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				UtenteBean utente = new UtenteBean();
				
				utente.setUsername(rs.getString("USERNAME"));
				utente.setCodiceFiscale(rs.getString("CODICEFISCALE"));
				utente.setNome(rs.getString("NOME"));
				utente.setCognome(rs.getString("COGNOME"));
				utente.setCitta(rs.getString("CITTA"));
				utente.setProvincia(rs.getString("PROVINCIA"));
				utente.setCap(rs.getInt("CAP"));
				utente.setTelefono(rs.getString("TEL"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setEmail(rs.getString("EMAIL"));
				utente.setTipo(rs.getString("TIPO"));
				utente.setSocietaSportiva_PartitaIva(rs.getString("SOCIETASPORTIVA_PARTITAIVA"));
				utente.setNumeroCarta(rs.getString("CARTA_NUMEROCARTA"));

				users.add(utente);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return users;
	}

	@Override
	public boolean doUpdate(UtenteBean utenteToUpdate) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String updateSQL = "UPDATE "+UtenteModelDM.TABLE_NAME+" SET USERNAME = ?, CODICEFISCALE = ?, NOME = ?, COGNOME = ?, CITTA = ?, PROVINCIA = ?, CAP = ?, TEL = ?, PASSWORD = ?, EMAIL = ?, TIPO = ?, SOCIETASPORTIVA_PARTITAIVA = ?, CARTA_NUMEROCARTA = ? WHERE CODICEFISCALE = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, utenteToUpdate.getUsername());
			preparedStatement.setString(2, utenteToUpdate.getCodiceFiscale());
			preparedStatement.setString(3, utenteToUpdate.getNome());
			preparedStatement.setString(4, utenteToUpdate.getCognome());
			preparedStatement.setString(5, utenteToUpdate.getCitta());
			preparedStatement.setString(6, utenteToUpdate.getProvincia());
			preparedStatement.setInt(7, utenteToUpdate.getCap());
			preparedStatement.setString(8, utenteToUpdate.getTelefono());
			preparedStatement.setString(9, utenteToUpdate.getPassword());
			preparedStatement.setString(10, utenteToUpdate.getEmail());	
			preparedStatement.setString(11, utenteToUpdate.getTipo());
			preparedStatement.setString(12, utenteToUpdate.getSocietaSportiva_PartitaIva());
			preparedStatement.setString(13, utenteToUpdate.getNumeroCarta());
			preparedStatement.setString(14, utenteToUpdate.getCodiceFiscale());
			
			result = preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}

		return (result != 0);
	}
}
