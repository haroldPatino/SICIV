/**
 * 
 */
package persistencia;

/**
 * @author Victor Rojas
 *
 */
public class ReporteSql {

	public String selectElementosFactura(int idFactura){
		return "SELECT NUM_SERIE, MARCA, "
				+ "NOMBRE_PRODUCTO, PRECIO_VENTA "
				+ "FROM producto_serie JOIN producto "
				+ "WHERE producto_serie.ID_PRODUCTO = "
				+ "producto.ID_PRODUCTO AND "
				+ "NUMERO_FACTURA = "+ idFactura +";";
	}
	
	public String selectReporteInventario(){
		return "SELECT NUM_SERIE, TIPO_PRODUCTO, "
				+ "MARCA, NOMBRE_PRODUCTO, "
				+ "NOMBRE_PROVEEDOR, ESTADO, "
				+ "PRECIO_COMPRA, PRECIO_VENTA, "
				+ "producto_serie.NUMERO_FACTURA "
				+ "FROM factura_venta JOIN producto_serie "
				+ "JOIN producto JOIN proveedor "
				+ "WHERE factura_venta.NUMERO_FACTURA = "
				+ "producto_serie.NUMERO_FACTURA AND "
				+ "producto_serie.ID_PRODUCTO = "
				+ "producto.ID_PRODUCTO AND "
				+ "producto.ID_PROVEEDOR = proveedor.ID_PROVEEDOR "
				+ "ORDER BY NUM_SERIE;";
	}
	
	public String selectReporteLugares(){
		return "SELECT lugar.ID_LUGAR, NOMBRE_PADRE, "
				+ "NOMBRE_LUGAR "
				+ "FROM lugar_pertenece JOIN lugar WHERE "
				+ "lugar_pertenece.ID_LUGAR = lugar.LUG_ID_LUGAR;";
	}
	
	public String selectReporteProveedores(){
		return "SELECT ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, "
				+ "DIRECCION_PROVEEDOR, NOMBRE_LUGAR FROM proveedor "
				+ "JOIN lugar WHERE proveedor.ID_LUGAR = lugar.ID_LUGAR;";
	}
	
	
	
}
