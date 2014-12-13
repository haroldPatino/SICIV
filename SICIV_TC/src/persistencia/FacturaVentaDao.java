/**
 * 
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import logica.FacturaVenta;
import logica.Producto;
import logica.ProductoSerie;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class FacturaVentaDao {
	//Attributes-----------------------------------
		private FacturaVentaSql sqlFactura;
		private Conexion conexion;
		
		//Building-------------------------------------
		public FacturaVentaDao() {
			sqlFactura = new FacturaVentaSql();
			conexion = new Conexion();
		}
		
		//Methods--------------------------------------
		
		public ArrayList<FacturaVenta> selecionarFacturas(){		
			ResultSet result;
			ArrayList<FacturaVenta> facturas = new ArrayList<FacturaVenta>();
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlFactura.selectFacturas());
					while(result.next()){
						FacturaVenta factura = new FacturaVenta();
						factura.setNumeroFactura(Integer.parseInt(result.getString("NUMERO_FACTURA")));
						factura.setIdUsuario(Integer.parseInt(result.getString("ID_USUARIO")));
						factura.setIdCliente(Integer.parseInt(result.getString("ID_CLIENTE")));
						DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
						factura.setFechaFactura(formato.parse(result.getString("FECHA_FACTURA")));
						factura.setDescuento(Integer.parseInt(result.getString("DESCUENTO")));
						factura.setImpuestos(Integer.parseInt(result.getString("IMPUESTOS")));
						factura.setEstadoFactura(result.getString("ESTADO_FACTURA"));
						facturas.add(factura);
					}
					return facturas;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 				}			
			return null;
		}
		
		public String consultarMayorNumeroFactura(){
			ResultSet result;
			String numerofacturas = "";
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlFactura.selectMayorFactura());
					while(result.next()){						
						numerofacturas = result.getString("NUMERO_FACTURA");
					}
					return numerofacturas;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 				}			
			return null;
		}
		
		public int insertarFactura(FacturaVenta factura){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlFactura.crearFactura(factura));
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;
		}
		public FacturaVenta buscarFacturaPorNumero(int numero){
			ResultSet result;
			FacturaVenta factura = new FacturaVenta();
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlFactura.buscarFacturaPorNumero(numero));
					while(result.next()){						
						factura.setNumeroFactura(Integer.parseInt(result.getString("NUMERO_FACTURA")));
						factura.setIdUsuario(Integer.parseInt(result.getString("ID_USUARIO")));
						factura.setIdCliente(Integer.parseInt(result.getString("ID_CLIENTE")));
						DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");						;
						factura.setFechaFactura(formato.parse(result.getString("FECHA_FACTURA")));
						factura.setDescuento(Integer.parseInt(result.getString("DESCUENTO")));
						factura.setImpuestos(Integer.parseInt(result.getString("IMPUESTOS")));
						factura.setEstadoFactura(result.getString("ESTADO_FACTURA"));
					}
					return factura;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}			
			return null;
		}
		public int cambiarEstadoFactura(String nuevoEstado, int numeroFactura ){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlFactura.cambiarEstadoFactura(nuevoEstado, numeroFactura));
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;
		}
}
