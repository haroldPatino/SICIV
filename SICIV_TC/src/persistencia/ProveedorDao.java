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

import logica.Cliente;
import logica.Proveedor;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class ProveedorDao {
	
		//Attributes-----------------------------------
			private ProveedorSql sqlProveedor;
			private Conexion conexion;
			
		//Building-------------------------------------
			public ProveedorDao() {
				sqlProveedor = new ProveedorSql();
				conexion = new Conexion();
			}
			
		//Methods--------------------------------------
			
			public ArrayList<Proveedor> selecionarProveedores(){
				ResultSet result;
				ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
				if(conexion.conectar()){
					Statement sentence;
					try {
						sentence = conexion.getConexion().createStatement();
						result = sentence.executeQuery(sqlProveedor.selectProveedores());
						while(result.next()){
						Proveedor proveedor = new Proveedor();
							proveedor.setIdProveedor(Integer.parseInt(result.getString("ID_PROVEEDOR")));
							proveedor.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));;
							proveedor.setNombreProveedor(result.getString("NOMBRES_PROVEEDOR"));
							proveedor.setTelefonoProveedor(Integer.parseInt(result.getString("TELEFONO_PROVEEDOR")));
							proveedor.setDireccionProveedor(result.getString("DIRECCION_CLIENTE"));
							proveedores.add(proveedor);
						}
						return proveedores;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 				}			
				return null;
			}
			
			public int insertarProveedor(Proveedor proveedor){
				if(conexion.conectar()){
					try{
					Statement sentencia=conexion.getConexion().createStatement();
					return sentencia.executeUpdate(sqlProveedor.crearProveedor(proveedor));
					}catch (SQLException e){
						System.out.println(e.getMessage());
					}
				}
				return -1;
			}
			
			public Proveedor buscarProveedorId(int idProveedor){
				ResultSet result;
				Proveedor proveedor = new Proveedor();
				if(conexion.conectar()){
					Statement sentence;
					try {
						sentence = conexion.getConexion().createStatement();
						result = sentence.executeQuery(sqlProveedor.buscarProveedorPorID(idProveedor));
						while(result.next()){						
							
							proveedor.setIdProveedor(Integer.parseInt(result.getString("ID_PROVEEDOR")));
							proveedor.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));;
							proveedor.setNombreProveedor(result.getString("NOMBRES_PROVEEDOR"));
							proveedor.setTelefonoProveedor(Integer.parseInt(result.getString("TELEFONO_PROVEEDOR")));
							proveedor.setDireccionProveedor(result.getString("DIRECCION_CLIENTE"));
						}
						return proveedor;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}			
				return null;
			}
			
			public int actualizarDatosProveedor(Proveedor proveedor){
				if(conexion.conectar()){
					try{
					Statement sentencia=conexion.getConexion().createStatement();
					return sentencia.executeUpdate(sqlProveedor.actualizarDatosProveedor(proveedor));
					}catch (SQLException e){
						System.out.println(e.getMessage());
					}
				}
				return -1;
				
			}
			
			public int actualizarIdProveedor(String anterior, String nueva){
				if(conexion.conectar()){
					try{
					Statement sentencia=conexion.getConexion().createStatement();
					return sentencia.executeUpdate(sqlProveedor.actualizarIdProveedor(anterior, nueva));
					}catch (SQLException e){
						System.out.println(e.getMessage());
					}
				}
				return -1;

			}
			
}
