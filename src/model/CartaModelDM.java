package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartaModelDM implements CartaModel {
	
	private static final String TABLE_NAME = "`carta`";

	public void doSave(CartaBean cartaToSave) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		String insertSQL="INSERT INTO "+CartaModelDM.TABLE_NAME+" (NUMEROCARTA,INTESTATARIO,SCADENZA,CVV/CVV2) VALUES (?, ?, ?, ?)";
		try{
			connection = DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(insertSQL);
			prepStat.setString(1, cartaToSave.getNumeroCarta());
			prepStat.setString(2, cartaToSave.getIntestatario());
			prepStat.setDate(3, cartaToSave.getScadenza());
			prepStat.setInt(4, cartaToSave.getCvv());
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

	public boolean doUpdate(CartaBean cartaToUpdate) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		int result=0;
		String updateSQL="UPDATE "+CartaModelDM.TABLE_NAME+" SET NUMEROCARTA = ?, INTESTATARIO = ?, SCADENZA = ?, CVV/CVV2 = ? WHERE NUMEROCARTA = ?";
		try {
			connection=DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(updateSQL);
			prepStat.setString(1, cartaToUpdate.getNumeroCarta());
			prepStat.setString(2, cartaToUpdate.getIntestatario());
			prepStat.setDate(3, cartaToUpdate.getScadenza());
			prepStat.setInt(4, cartaToUpdate.getCvv());
			prepStat.setString(5, cartaToUpdate.getNumeroCarta());
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

	public boolean doDelete(String aNumero) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		int res=0;
		String deleteSQL="DELETE FROM "+CartaModelDM.TABLE_NAME+" WHERE NUMEROCARTA = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(deleteSQL);
			prepStat.setString(1, aNumero);
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

	public CartaBean doRetrieveByKey(String aNumero) throws SQLException {
		Connection connection=null;
		PreparedStatement prepStat=null;
		CartaBean carta=new CartaBean();
		String selectSQL="SELECT * FROM "+CartaModelDM.TABLE_NAME+" WHERE NUMEROCARTA = ?";
		try{
			connection=DriverManagerConnectionPool.getConnection();
			prepStat=connection.prepareStatement(selectSQL);
			prepStat.setString(1,aNumero);
			ResultSet rs=prepStat.executeQuery();
			while(rs.next()){
				carta.setNumeroCarta(rs.getString("NUMEROCARTA"));
				carta.setIntestatario(rs.getString("INTESTATARIO"));
				carta.setScadenza(rs.getDate("SCADENZA"));
				carta.setCvv(rs.getInt("CVV/CVV2"));
			}
		}finally{
			try{
				if(prepStat!=null)
					prepStat.close();
			}finally{
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return carta;
	}
}
