/**
 * 
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logica.Producto;
import logica.Proveedor;
/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class ProductoDao {
	//Attributes-----------------------------------
	private ProductoSql sqlProducto;
	private Conexion conexion;
	
	//Building-------------------------------------
	public ProductoDao() {
		sqlProducto = new ProductoSql();
		conexion = new Conexion();
	}
	
	//Methods--------------------------------------
	
	public ArrayList<Producto> selecionarProductos(){		
		ResultSet result;
		ArrayList<Producto> productos = new ArrayList<Producto>();
		if(conexion.conectar()){
			Statement sentence;
			try {
				sentence = conexion.getConexion().createStatement();
				result = sentence.executeQuery(sqlProducto.selectListaProductos());
				while(result.next()){
					Producto producto = new Producto();
					producto.setIdProducto(Integer.parseInt(result.getString("ID_PRODUCTO")));
					producto.setIdProveedor(Integer.parseInt(result.getString("ID_PROVEEDOR")));
					producto.setNombreProducto(result.getString("NOMBRE_PRODUCTO"));
					producto.setTipoProducto(result.getString("TIPO_PRODUCTO"));
					producto.setMarcaProducto(result.getString("MARCA"));
					producto.setPrecioCompra(Integer.parseInt(result.getString("PRECIO_COMPRA")));
					producto.setPrecioVenta(Integer.parseInt(result.getString("PRECIO_VENTA")));
					productos.add(producto);
				}
				return productos;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 				}			
		return null;
	}
	
	public int insertarProducto(Producto producto){
		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			return sentencia.executeUpdate(sqlProducto.crearProducto(producto));
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return -1;
	}
	
	public Producto buscarProductoPorId(int idProducto){
		ResultSet result;
		Producto producto = new Producto();
		if(conexion.conectar()){
			Statement sentence;
			try {
				sentence = conexion.getConexion().createStatement();
				result = sentence.executeQuery(sqlProducto.buscarProductoPorID(idProducto));
				while(result.next()){						
					
					producto.setIdProducto(Integer.parseInt(result.getString("ID_PRODUCTO")));
					producto.setIdProveedor(Integer.parseInt(result.getString("ID_PROVEEDOR")));
					producto.setNombreProducto(result.getString("NOMBRE_PRODUCTO"));
					producto.setTipoProducto(result.getString("TIPO_PRODUCTO"));
					producto.setMarcaProducto(result.getString("MARCA"));
					producto.setPrecioCompra(Integer.parseInt(result.getString("PRECIO_COMPRA")));
					producto.setPrecioVenta(Integer.parseInt(result.getString("PRECIO_VENTA")));
				}
				return producto;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}			
		return null;
	}
	
	public int actualizarDatosProducto(Producto producto){
		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			return sentencia.executeUpdate(sqlProducto.actualizarDatosProducto(producto));
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return -1;
		
	}
	
	public int actualizarIdProducto(int anterior, int nuevo){
		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			return sentencia.executeUpdate(sqlProducto.actualizarIdProducto(anterior, nuevo));
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return -1;

	}
	
}
