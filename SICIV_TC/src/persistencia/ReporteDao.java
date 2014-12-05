/**
 * 
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Victor Rojas
 *
 */
public class ReporteDao {
	//Attributes-----------------------------------
			private ReporteSql sqlReporte;
			private Conexion conexion;
			
	//Building-------------------------------------
		public ReporteDao() {
			sqlReporte = new ReporteSql();
			conexion = new Conexion();
		}
			
	//Methods--------------------------------------
	
	public ResultSet consultarElementosFactura(int idFactura){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;
			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectElementosFactura(idFactura));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return result;
	}
	
	public ResultSet consultarReporteInventario(){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;
			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteInventario());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return result;
	}
	
	public ResultSet consultarReporteCumpleanos(){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;
			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteCumpleanos());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return result;
	}
	
	public ResultSet consultarReporteProveedores(){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;
			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteProveedores());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return result;
	}
	
	public ResultSet consultarReporteDefectuosos(){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;
			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteDefectuosos());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return result;
	}
	
	public ResultSet consultarReporteDevueltos(){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;
			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteDevueltos());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return result;
	}
	
}
