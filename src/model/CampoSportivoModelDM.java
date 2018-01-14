package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class CampoSportivoModelDM implements CampoSportivoModel {
	
	private static final String TABLE_NAME = "`campo sportivo`";
	
	public synchronized void doSave(CampoSportivoBean campoToSave) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		String insertSQL="INSERT INTO "+CampoSportivoModelDM.TABLE_NAME+" (IDCAMPO SPORTIVO,NOME,FASCIA ORARIA,LUOGO,TIPOLOGIA,PREZZO ONLINE,PREZZO SUL CAMPO,SOCIETA SPORTIVA_PARTITA IVA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try{
			connection = DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(insertSQL);
			prepStat.setInt(1, campoToSave.getIdCampoSportivo());
			prepStat.setString(2, campoToSave.getNome());
			prepStat.setString(3, campoToSave.getFasciaOraria());
			prepStat.setString(4, campoToSave.getLuogo());
			prepStat.setString(5, campoToSave.getTipologia());
			prepStat.setDouble(6, campoToSave.getPrezzoOnline());
			prepStat.setDouble(7, campoToSave.getPrezzoSulCampo());
			prepStat.setString(8, campoToSave.getPartitaIvaSocieta());
			prepStat.executeUpdate();
			connection.commit();
		}finally {
			try {
				if (prepStat!=null)
					prepStat.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	public synchronized boolean doDelete(int anID) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		int res=0;
		String deleteSQL="DELETE FROM "+CampoSportivoModelDM.TABLE_NAME+" WHERE IDCAMPO SPORTIVO = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(deleteSQL);
			prepStat.setInt(1, anID);
			res=prepStat.executeUpdate();
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

	public boolean doUpdate(CampoSportivoBean campoToUpdate) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		int result=0;
		String updateSQL="UPDATE "+CampoSportivoModelDM.TABLE_NAME+" SET IDCAMPO SPORTIVO = ?, NOME = ?, FASCIA ORARIA = ?, LUOGO = ?, TIPOLOGIA = ?, PREZZO ONLINE = ?, PREZZO SUL CAMPO = ?, SOCIETA SPORTIVA_PARTITA IVA = ? WHERE IDCAMPO SPORTIVO = ?";
		try {
			connection=DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(updateSQL);
			prepStat.setInt(1, campoToUpdate.getIdCampoSportivo());
			prepStat.setString(2, campoToUpdate.getNome());
			prepStat.setString(3, campoToUpdate.getFasciaOraria());
			prepStat.setString(4, campoToUpdate.getLuogo());
			prepStat.setString(5, campoToUpdate.getTipologia());
			prepStat.setDouble(6, campoToUpdate.getPrezzoOnline());
			prepStat.setDouble(7, campoToUpdate.getPrezzoSulCampo());
			prepStat.setString(8, campoToUpdate.getPartitaIvaSocieta());
			prepStat.setInt(9, campoToUpdate.getIdCampoSportivo());
			result=prepStat.executeUpdate();
			connection.commit();
		}finally{
			try{
				if(prepStat!=null)
					prepStat.close();
			}finally{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return(result!=0);
	}

	public CampoSportivoBean doRetrieveByKey(int anID) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		CampoSportivoBean campo=new CampoSportivoBean();
		String selectSQL="SELECT * FROM "+CampoSportivoModelDM.TABLE_NAME+" WHERE IDCAMPO SPORTIVO = ?";
		try{
			connection=DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(selectSQL);
			prepStat.setInt(1,anID);
			ResultSet rs=prepStat.executeQuery();
			while(rs.next()){
				campo.setIdCampoSportivo(rs.getInt("IDCAMPO SPORTIVO"));
				campo.setNome(rs.getString("NOME"));
				campo.setFasciaOraria(rs.getString("FASCIA ORARIA"));
				campo.setLuogo(rs.getString("LUOGO"));
				campo.setTipologia(rs.getString("TIPOLOGIA"));
				campo.setPrezzoOnline(rs.getDouble("PREZZO ONLINE"));
				campo.setPrezzoSulCampo(rs.getDouble("PREZZO SUL CAMPO"));
				campo.setPartitaIvaSocieta(rs.getString("SOCIETA SPORTIVA_PARTITA IVA"));
			}
		}finally{
			try{
				if(prepStat!=null)
					prepStat.close();
			}finally{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return campo;
	}

	public Collection<CampoSportivoBean> doRetrieveAll(String order) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		Collection<CampoSportivoBean> campi=new LinkedList<CampoSportivoBean>();
		String selectSQL="SELECT * FROM "+CampoSportivoModelDM.TABLE_NAME;
		if (order!=null&&!order.equals("")){
			selectSQL+=" ORDER BY "+order;
		}
		try{
			connection=DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(selectSQL);
			ResultSet rs=prepStat.executeQuery();
			while(rs.next()){
				CampoSportivoBean campo = new CampoSportivoBean();
				campo.setIdCampoSportivo(rs.getInt("IDCAMPO SPORTIVO"));
				campo.setNome(rs.getString("NOME"));
				campo.setFasciaOraria(rs.getString("FASCIA ORARIA"));
				campo.setLuogo(rs.getString("LUOGO"));
				campo.setTipologia(rs.getString("TIPOLOGIA"));
				campo.setPrezzoOnline(rs.getDouble("PREZZO ONLINE"));
				campo.setPrezzoSulCampo(rs.getDouble("PREZZO SUL CAMPO"));
				campo.setPartitaIvaSocieta(rs.getString("SOCIETA SPORTIVA_PARTITA IVA"));
				campi.add(campo);
			}
		}finally{
			try{
				if(prepStat!=null)
					prepStat.close();
			}finally{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return campi;
	}

}
