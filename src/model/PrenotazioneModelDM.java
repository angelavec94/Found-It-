package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class PrenotazioneModelDM implements PrenotazioneModel{
	private static final String TABLE_NAME = "Prenotazione";


	@Override
	public void doSave(PrenotazioneBean prenotazioneToSave) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO "+PrenotazioneModelDM.TABLE_NAME+" (IDPRENOTAZIONE,DATA,ORA,SALDATA,TIPO,CAMPOSPORTIVOIDCAMPOSPORTIVO,UTENTECODICEFISCALE) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, prenotazioneToSave.getIdPrenotazione());
			preparedStatement.setDate(2, prenotazioneToSave.getData());
			preparedStatement.setTime(3, prenotazioneToSave.getOra());
			preparedStatement.setBoolean(4, prenotazioneToSave.isSaldata());
			preparedStatement.setString(5, prenotazioneToSave.getTipo());
			preparedStatement.setInt(6, prenotazioneToSave.getIdCampoSportivo());
			preparedStatement.setString(7, prenotazioneToSave.getCodiceFiscaleUtente());

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

	public synchronized boolean doDelete(int anID) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		int res=0;
		String deleteSQL="DELETE FROM "+PrenotazioneModelDM.TABLE_NAME+" WHERE IDPRENOTAZIONE = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(deleteSQL);
			prepStat.setInt(1, anID);
			prepStat.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (prepStat!=null)
					prepStat.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (res!=0);
	}
	
	@Override
	public boolean doUpdate(PrenotazioneBean prenotazioneToUpdate) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String updateSQL = "UPDATE "+PrenotazioneModelDM.TABLE_NAME+" SET IDPRENOTAZIONE = ?, DATA = ?, ORA = ?, SALDATA = ?, TIPO = ?, CAMPOSPORTIVOIDCAMPOSPORTIVO = ?, UTENTECODICEFISCALE = ? WHERE IDPRENOTAZIONE = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, prenotazioneToUpdate.getIdPrenotazione());
			preparedStatement.setDate(2, prenotazioneToUpdate.getData());
			preparedStatement.setTime(3, prenotazioneToUpdate.getOra());
			preparedStatement.setBoolean(4, prenotazioneToUpdate.isSaldata());
			preparedStatement.setString(5, prenotazioneToUpdate.getTipo());
			preparedStatement.setInt(6, prenotazioneToUpdate.getIdCampoSportivo());
			preparedStatement.setString(7, prenotazioneToUpdate.getCodiceFiscaleUtente());
			preparedStatement.setInt(8, prenotazioneToUpdate.getIdPrenotazione());
			
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

	@Override
	public Collection<PrenotazioneBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<PrenotazioneBean> prenotazioni = new LinkedList<PrenotazioneBean>();

		String selectSQL = "SELECT * FROM " + PrenotazioneModelDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PrenotazioneBean prenotazione = new PrenotazioneBean();

				prenotazione.setIdPrenotazione(rs.getInt("IDPRENOTAZIONE"));
				prenotazione.setData(rs.getDate("DATA"));
				prenotazione.setOra(rs.getTime("ORA"));
				prenotazione.setSaldata(rs.getBoolean("SALDATA"));
				prenotazione.setTipo(rs.getString("TIPO"));
				prenotazione.setIdCampoSportivo(rs.getInt("CAMPOSPORTIVOIDCAMPOSPORTIVO"));
				prenotazione.setCodiceFiscaleUtente(rs.getString("UTENTECODICEFISCALE"));
				
				prenotazioni.add(prenotazione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prenotazioni;

	}

	@Override
	public Collection<PrenotazioneBean> doRetrieveByIDCampo(int anIDCampo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<PrenotazioneBean> prenotazioni = new LinkedList<PrenotazioneBean>();

		String selectSQL = "SELECT * FROM "+PrenotazioneModelDM.TABLE_NAME+" WHERE CAMPOSPORTIVOIDCAMPOSPORTIVO = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, anIDCampo);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PrenotazioneBean prenotazione = new PrenotazioneBean();

				prenotazione.setIdPrenotazione(rs.getInt("IDPRENOTAZIONE"));
				prenotazione.setData(rs.getDate("DATA"));
				prenotazione.setOra(rs.getTime("ORA"));
				prenotazione.setSaldata(rs.getBoolean("SALDATA"));
				prenotazione.setTipo(rs.getString("TIPO"));
				prenotazione.setIdCampoSportivo(rs.getInt("CAMPOSPORTIVOIDCAMPOSPORTIVO"));
				prenotazione.setCodiceFiscaleUtente(rs.getString("UTENTECODICEFISCALE"));
				
				prenotazioni.add(prenotazione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prenotazioni;
	}
	
	@Override
	public Collection<PrenotazioneBean> doRetrieveByCodiceFiscale(String aCodiceFiscale) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<PrenotazioneBean> prenotazioni = new LinkedList<PrenotazioneBean>();

		String selectSQL = "SELECT * FROM "+PrenotazioneModelDM.TABLE_NAME+" WHERE UTENTECODICEFISCALE = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, aCodiceFiscale);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PrenotazioneBean prenotazione = new PrenotazioneBean();

				prenotazione.setIdPrenotazione(rs.getInt("IDPRENOTAZIONE"));
				prenotazione.setData(rs.getDate("DATA"));
				prenotazione.setOra(rs.getTime("ORA"));
				prenotazione.setSaldata(rs.getBoolean("SALDATA"));
				prenotazione.setTipo(rs.getString("TIPO"));
				prenotazione.setIdCampoSportivo(rs.getInt("CAMPOSPORTIVOIDCAMPOSPORTIVO"));
				prenotazione.setCodiceFiscaleUtente(rs.getString("UTENTECODICEFISCALE"));
				
				prenotazioni.add(prenotazione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prenotazioni;
	}
}
