/**
 * 
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logica.Producto;
import logica.ProductoSerie;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class ProductoSerieDao {

	//Attributes-----------------------------------
		private ProductoSerieSql sqlProductoSerie;
		private Conexion conexion;
		
		//Building-------------------------------------
		public ProductoSerieDao() {
			sqlProductoSerie = new ProductoSerieSql();
			conexion = new Conexion();
		}
		
		//Methods--------------------------------------
		public ArrayList<ProductoSerie> selecionarProductosSerie(){		
			ResultSet result;
			ArrayList<ProductoSerie> productos = new ArrayList<ProductoSerie>();
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlProductoSerie.selectProductosSerie());
					while(result.next()){
						ProductoSerie productoSerie = new ProductoSerie();
						productoSerie.setNumeroSerie(result.getString("NUM_SERIE"));
						productoSerie.setIdProducto(Integer.parseInt(result.getString("ID_PRODUCTO")));
						productoSerie.setIdFactura(Integer.parseInt(result.getString("NUMERO_FACTURA")));
						productoSerie.setEstadoProducto(result.getString("ESTADO"));
						productos.add(productoSerie);
					}
					return productos;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			return null;
		}
		
		public ArrayList<ProductoSerie> selecionarPorNumeroFactura(int numeroFactura){		
			ResultSet result;
			ArrayList<ProductoSerie> productos = new ArrayList<ProductoSerie>();
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlProductoSerie.SelectProductosSeriePorNumFactura(numeroFactura));
					while(result.next()){
						ProductoSerie productoSerie = new ProductoSerie();
						productoSerie.setNumeroSerie(result.getString("NUM_SERIE"));
						productoSerie.setIdProducto(Integer.parseInt(result.getString("ID_PRODUCTO")));
						productoSerie.setIdFactura(Integer.parseInt(result.getString("NUMERO_FACTURA")));
						productoSerie.setEstadoProducto(result.getString("ESTADO"));
						productos.add(productoSerie);
					}
					return productos;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			return null;
		}
		
		public int insertarProductoSerie(ProductoSerie producto){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlProductoSerie.crearProductoSerie(producto));
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;
		}
		
		public int cambiarEstadoProducto(String idProducto, String estado ){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlProductoSerie.cambiarEstadoProduucto(idProducto, estado));
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;
		}
		
		public int actualizarDatosProductoSerie(ProductoSerie producto){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlProductoSerie.actualizarDatosProductoSerie(producto));
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;
			
		}
		
		public int actualizarNumSerieProducto(String anterior, String nuevo){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlProductoSerie.actualizarNumSerieProducto(anterior, nuevo));		
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;

		}
}
