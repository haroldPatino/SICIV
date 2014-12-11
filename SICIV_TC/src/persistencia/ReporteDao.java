/**
 * 
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logica.Lugar;

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
	
	public ResultSet consultarReporteElementosVendidos(int mes, int anio){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteVendidos(mes, anio));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return result;
	}
	
	public ArrayList<String[]> consultarReporteVentasMesElemento(int mes, int anio){
		ResultSet result = null;
		ArrayList<String []> resultado = new ArrayList<String[]>();
		
		if(conexion.conectar()){
			Statement sentence;			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteVentaMesElemento(mes, anio));
					while(result.next()){
						String [] parcial = new String[3];
						parcial[0] = result.getString("NOMBRE_PRODUCTO");
						parcial[1] = result.getString("NOMBRE_PROVEEDOR");
						parcial[2] = result.getString("SUM(PRECIO_VENTA)");
						resultado.add(parcial);					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return resultado;
	}
	
	public ArrayList<String[]> consultarReporteVentasMesProveedor(int mes, int anio){
		ResultSet result = null;
		ArrayList<String []> resultado = new ArrayList<String[]>();
		
		if(conexion.conectar()){
			Statement sentence;			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteVentaMesProveedor(mes, anio));
					while(result.next()){
						String [] parcial = new String[3];
						parcial[0] = result.getString("NOMBRE_PRODUCTO");
						parcial[1] = result.getString("NOMBRE_PROVEEDOR");
						parcial[2] = result.getString("SUM(PRECIO_VENTA)");
						resultado.add(parcial);					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return resultado;
	}
	
	public ResultSet consultarReporteEnviadosLaboratorio(){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;
			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteEnviadosLaboratorio());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		return result;
	}
	
	public ResultSet consultarReporteListoEntrega(){
		ResultSet result = null;
		if(conexion.conectar()){
			Statement sentence;
			
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlReporte.selectReporteListosEntrega());
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
