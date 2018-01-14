package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SocietaSportivaModelDM implements SocietaSportivaModel {
	
	private static final String TABLE_NAME = "`societa sportiva`";

	public void doSave(SocietaSportivaBean societaToSave) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		String insertSQL="INSERT INTO "+SocietaSportivaModelDM.TABLE_NAME+" (PARTITA IVA,NOME,INDIRIZZO,TEL,CODICE AUTENTICAZIONE) VALUES (?, ?, ?, ?, ?)";
		try{
			connection = DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(insertSQL);
			prepStat.setString(1,societaToSave.getPartitaIva());
			prepStat.setString(2,societaToSave.getNomeSocieta());
			prepStat.setString(3,societaToSave.getIndirizzoSede());
			prepStat.setString(4,societaToSave.getTelefono());
			prepStat.setString(5,societaToSave.getCodiceAutenticazione());
			prepStat.executeUpdate();
			connection.commit();
		}finally{
			try {
				if (prepStat!=null)
					prepStat.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	public boolean doUpdate(SocietaSportivaBean societaToUpdate) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		int result=0;
		String updateSQL="UPDATE "+SocietaSportivaModelDM.TABLE_NAME+" SET PARTITA IVA = ?, NOME = ?, INDIRIZZO = ?, TEL = ?, CODICE AUTENTICAZIONE = ? WHERE PARTITA IVA = ?";
		try {
			connection=DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(updateSQL);
			prepStat.setString(1, societaToUpdate.getPartitaIva());
			prepStat.setString(2, societaToUpdate.getNomeSocieta());
			prepStat.setString(3, societaToUpdate.getIndirizzoSede());
			prepStat.setString(4, societaToUpdate.getTelefono());
			prepStat.setString(5, societaToUpdate.getCodiceAutenticazione());
			prepStat.setString(6, societaToUpdate.getPartitaIva());
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

	public SocietaSportivaBean doRetrieveByKey(String aPartitaIVA) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		SocietaSportivaBean societa=new SocietaSportivaBean();
		String selectSQL="SELECT * FROM "+SocietaSportivaModelDM.TABLE_NAME+" WHERE PARTITA IVA = ?";
		try{
			connection=DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(selectSQL);
			prepStat.setString(1,aPartitaIVA);
			ResultSet rs=prepStat.executeQuery();
			while(rs.next()){
				societa.setPartitaIva(rs.getString("PARTITA IVA"));
				societa.setNomeSocieta(rs.getString("NOME"));
				societa.setIndirizzoSede(rs.getString("INDIRIZZO"));
				societa.setTelefono(rs.getString("TEL"));
				societa.setCodiceAutenticazione(rs.getString("CODICE AUTENTICAZIONE"));
			}
		}finally{
			try{
				if(prepStat!=null)
					prepStat.close();
			}finally{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return societa;
	}
}
