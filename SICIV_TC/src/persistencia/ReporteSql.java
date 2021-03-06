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
				+ "PRECIO_COMPRA, PRECIO_VENTA "
				+ "FROM factura_venta JOIN producto_serie "
				+ "JOIN producto JOIN proveedor "
				+ "WHERE factura_venta.NUMERO_FACTURA = "
				+ "producto_serie.NUMERO_FACTURA AND "
				+ "producto_serie.ID_PRODUCTO = "
				+ "producto.ID_PRODUCTO AND "
				+ "producto.ID_PROVEEDOR = proveedor.ID_PROVEEDOR "
				+ "AND producto_serie.NUMERO_FACTURA = 0 "
				+ "ORDER BY NUM_SERIE;";
	}	
	
	public String selectReporteProveedores(){
		return "SELECT ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, "
				+ "DIRECCION_PROVEEDOR, NOMBRE_LUGAR FROM proveedor "
				+ "JOIN lugar WHERE proveedor.ID_LUGAR = lugar.ID_LUGAR AND "
				+ "ID_PROVEEDOR != 0;";
	}
	
	public String selectReporteCumpleanos(){
		return "SELECT NOMBRES_CLIENTE, APELLIDOS_CLIENTE, "
				+ "NUMERO_TELEFONICO, FECHA_NACIMIENTO "
				+ "FROM cliente WHERE MONTH(FECHA_NACIMIENTO) = "
				+ "MONTH(Current_date) AND DAY(FECHA_NACIMIENTO) = "
				+ "DAY(Current_date);";
	}
	
	public String selectReporteDefectuosos(){
		return "SELECT NUM_SERIE, TIPO_PRODUCTO, "
				+ "MARCA, NOMBRE_PRODUCTO, "
				+ "NOMBRE_PROVEEDOR, ESTADO, "
				+ "PRECIO_COMPRA, PRECIO_VENTA "
				+ "FROM factura_venta JOIN producto_serie "
				+ "JOIN producto JOIN proveedor "
				+ "WHERE factura_venta.NUMERO_FACTURA = "
				+ "producto_serie.NUMERO_FACTURA AND "
				+ "producto_serie.ID_PRODUCTO = "
				+ "producto.ID_PRODUCTO AND "
				+ "producto.ID_PROVEEDOR = proveedor.ID_PROVEEDOR "
				+ "AND producto_serie.NUMERO_FACTURA = 0 "
				+ "AND ESTADO LIKE 'SD' "				
				+ "ORDER BY NUM_SERIE;";
	}
	
	public String selectReporteVendidos(int mes, int anio){
		return "SELECT NUM_SERIE, TIPO_PRODUCTO, MARCA, "
				+ "NOMBRE_PRODUCTO, NOMBRE_PROVEEDOR, "
				+ "PRECIO_VENTA FROM factura_venta "
				+ "JOIN producto_serie JOIN producto "
				+ "JOIN proveedor WHERE "
				+ "factura_venta.NUMERO_FACTURA = "
				+ "producto_serie.NUMERO_FACTURA "
				+ "AND producto_serie.ID_PRODUCTO = "
				+ "producto.ID_PRODUCTO AND "
				+ "producto.ID_PROVEEDOR = "
				+ "proveedor.ID_PROVEEDOR AND ESTADO "
				+ "LIKE 'VD' AND MONTH(FECHA_FACTURA) = "+mes+" "
				+ "AND YEAR(FECHA_FACTURA) = "+anio+" "
				+ "ORDER BY NUM_SERIE;";
	}
	
	public String selectReporteVentaMesElemento(int mes, int anio){
		return "SELECT NOMBRE_PRODUCTO, NOMBRE_PROVEEDOR, "
				+ "SUM(PRECIO_VENTA) FROM factura_venta "
				+ "JOIN producto_serie JOIN producto "
				+ "JOIN proveedor WHERE factura_venta.NUMERO_FACTURA "
				+ "= producto_serie.NUMERO_FACTURA "
				+ "AND producto_serie.ID_PRODUCTO "
				+ "= producto.ID_PRODUCTO AND "
				+ "producto.ID_PROVEEDOR = "
				+ "proveedor.ID_PROVEEDOR AND ESTADO "
				+ "LIKE 'VD' AND MONTH(FECHA_FACTURA) = "+mes+" "
				+ "AND YEAR(FECHA_FACTURA) = "+anio+" "
				+ "GROUP BY NOMBRE_PRODUCTO ORDER BY "
				+ "SUM(PRECIO_VENTA) DESC;";
	}
	

	public String selectReporteVentaMesProveedor(int mes, int anio){
		return "SELECT NOMBRE_PRODUCTO, NOMBRE_PROVEEDOR, "
				+ "SUM(PRECIO_VENTA) FROM factura_venta "
				+ "JOIN producto_serie JOIN producto "
				+ "JOIN proveedor WHERE factura_venta.NUMERO_FACTURA "
				+ "= producto_serie.NUMERO_FACTURA "
				+ "AND producto_serie.ID_PRODUCTO "
				+ "= producto.ID_PRODUCTO AND "
				+ "producto.ID_PROVEEDOR = "
				+ "proveedor.ID_PROVEEDOR AND ESTADO "
				+ "LIKE 'VD' AND MONTH(FECHA_FACTURA) = "+mes+" "
				+ "AND YEAR(FECHA_FACTURA) = "+anio+" "
				+ "GROUP BY NOMBRE_PROVEEDOR "
				+ "ORDER BY SUM(PRECIO_VENTA) DESC;";				
	}
	
	public String selectReporteEnviadosLaboratorio(){
		return "SELECT NUM_SERIE, TIPO_PRODUCTO, "
				+ "MARCA, NOMBRE_PRODUCTO, "
				+ "NOMBRE_PROVEEDOR, ESTADO, "
				+ "PRECIO_COMPRA, PRECIO_VENTA "
				+ "FROM factura_venta JOIN producto_serie "
				+ "JOIN producto JOIN proveedor "
				+ "WHERE factura_venta.NUMERO_FACTURA = "
				+ "producto_serie.NUMERO_FACTURA AND "
				+ "producto_serie.ID_PRODUCTO = "
				+ "producto.ID_PRODUCTO AND "
				+ "producto.ID_PROVEEDOR = proveedor.ID_PROVEEDOR "
				+ "AND ESTADO LIKE 'EL' "				
				+ "ORDER BY NUM_SERIE;";
	}
	
	public String selectReporteListosEntrega(){
		return "SELECT NUM_SERIE, TIPO_PRODUCTO, "
				+ "MARCA, NOMBRE_PRODUCTO, "
				+ "NOMBRE_PROVEEDOR, ESTADO, "
				+ "PRECIO_COMPRA, PRECIO_VENTA "
				+ "FROM factura_venta JOIN producto_serie "
				+ "JOIN producto JOIN proveedor "
				+ "WHERE factura_venta.NUMERO_FACTURA = "
				+ "producto_serie.NUMERO_FACTURA AND "
				+ "producto_serie.ID_PRODUCTO = "
				+ "producto.ID_PRODUCTO AND "
				+ "producto.ID_PROVEEDOR = proveedor.ID_PROVEEDOR "
				+ "AND ESTADO LIKE 'PE' "				
				+ "ORDER BY NUM_SERIE;";
	}
	
	public String selectReporteDevueltos(){
		return "SELECT NUM_SERIE, TIPO_PRODUCTO, "
				+ "MARCA, NOMBRE_PRODUCTO, "
				+ "NOMBRE_PROVEEDOR, ESTADO, PRECIO_COMPRA, "
				+ "PRECIO_VENTA FROM factura_venta JOIN "
				+ "producto_serie JOIN producto JOIN "
				+ "proveedor WHERE factura_venta.NUMERO_FACTURA "
				+ "= producto_serie.NUMERO_FACTURA AND "
				+ "producto_serie.ID_PRODUCTO = "
				+ "producto.ID_PRODUCTO AND producto.ID_PROVEEDOR "
				+ "= proveedor.ID_PROVEEDOR "
				+ "AND ESTADO LIKE 'DV' "
				+ "ORDER BY NUM_SERIE;";
	}	
}
