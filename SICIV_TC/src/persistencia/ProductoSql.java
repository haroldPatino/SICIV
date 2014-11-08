/**
 * 
 */
package persistencia;

import logica.Producto;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class ProductoSql {

	public String selectListaProductos(){
		return "SELECT * FROM PRODUCTO;";
	}
	
	public String crearProducto(Producto producto){
		return "INSERT INTO producto(ID_PRODUCTO, ID_PROVEEDOR, "
				+ "NOMBRE_PRODUCTO, TIPO_PRODUCTO, MARCA, "
				+ "PRECIO_COMPRA, PRECIO_VENTA) "
				+ "VALUES ("+producto.getIdProducto()
				+","+producto.getIdProveedor()
				+",'"+producto.getNombreProducto()
				+"','"+producto.getTipoProducto()
				+"','"+producto.getMarcaProducto()
				+"',"+producto.getPrecioCompra()
				+","+producto.getPrecioVenta()+");";
	}
	
	public String buscarProductoPorID (int busqueda){
		return "SELECT * FROM producto WHERE ID_PRODUCTO = "+busqueda+";";
	}
	
	public String actualizarDatosProducto(Producto producto){
		return "UPDATE producto SET ID_PROVEEDOR="+producto.getIdProveedor()
				+", NOMBRE_PRODUCTO='"+producto.getNombreProducto()
				+"', TIPO_PRODUCTO='"+producto.getTipoProducto()
				+"', MARCA='"+producto.getMarcaProducto()
				+"', PRECIO_COMPRA="+producto.getPrecioCompra()
				+", PRECIO_VENTA="+producto.getPrecioVenta()
				+" WHERE ID_PRODUCTO="+producto.getIdProducto()+";";
		
	}
	
	public String actualizarIdProducto(int idAnterior, int idNuevo){
		return "UPDATE producto SET ID_PRODUCTO="+idNuevo
				+" WHERE ID_PRODUCTO="+idAnterior+";";
	}
	
}