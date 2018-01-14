package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collection;
import java.util.LinkedList;

public class PrenotazioneModelDM implements PrenotazioneModel{
	private static final String TABLE_NAME = "Prenotazione";


	@Override
	public void doSave(PrenotazioneBean prenotazioneToSave) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO " + PrenotazioneModelDM.TABLE_NAME
				+ " (DATA, ORA, IDPRENOTAZIONE, IDCAMPOSPORTIVO, SALDATA, TIPO) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDate(1, prenotazioneToSave.getData());
			preparedStatement.setTime(2, prenotazioneToSave.getOra());
			preparedStatement.setInt(3, prenotazioneToSave.getIdPrenotazione());
			preparedStatement.setInt(4, prenotazioneToSave.getIdCampoSportivo());
			preparedStatement.setBoolean(5, prenotazioneToSave.isSaldata());
			preparedStatement.setString(6, prenotazioneToSave.getTipo());

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
	public boolean doUpdate(PrenotazioneBean prenotazioneToUpdate, Date oldData, Time oldTime) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String updateSQL = "UPDATE" + PrenotazioneModelDM.TABLE_NAME
				+ " SET DATA = ?, ORA = ?, IDPRENOTAZIONE = ?, IDCAMPOSPORTIVO = ?, SALDATA=?, TIPO =?,"
				+ " WHERE DATA = ? AND ORA = ? AND IDPRENOTAZIONE = ? AND IDCAMPOSPORTIVO = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setDate(1, prenotazioneToUpdate.getData());
			preparedStatement.setTime(2, prenotazioneToUpdate.getOra());
			preparedStatement.setInt(3, prenotazioneToUpdate.getIdPrenotazione());
			preparedStatement.setInt(4, prenotazioneToUpdate.getIdCampoSportivo());
			preparedStatement.setDate(5, oldData);
			preparedStatement.setTime(6, oldTime);
			preparedStatement.setInt(7, prenotazioneToUpdate.getIdPrenotazione());
			preparedStatement.setInt(8, prenotazioneToUpdate.getIdCampoSportivo());
			
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
	public Collection<PrenotazioneBean> doRetrieveAll(String username, String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<PrenotazioneBean> prenotazioni = new LinkedList<PrenotazioneBean>();

		String selectSQL = "SELECT * FROM " + PrenotazioneModelDM.TABLE_NAME +"WHERE IDPRENOTAZIONE = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PrenotazioneBean prenotazione = new PrenotazioneBean();

				prenotazione.setData(rs.getDate("DATA"));
				prenotazione.setOra(rs.getTime("ORA"));
				prenotazione.setIdPrenotazione(rs.getInt("IDPRENOTAZIONE"));
				prenotazione.setIdCampoSportivo(rs.getInt("IDCAMPOSPORTIVO"));
				
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
