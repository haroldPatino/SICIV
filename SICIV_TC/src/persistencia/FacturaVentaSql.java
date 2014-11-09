/**
 * 
 */
package persistencia;

import logica.FacturaVenta;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 *
 */
public class FacturaVentaSql {

	public String selectFacturas(){
		return "SELECT * FROM factura_venta;";
	}
	
	public String crearFactura(FacturaVenta factura){
		return "INSERT INTO factura_venta (NUMERO_FACTURA,"
				+ " ID_USUARIO, ID_CLIENTE, FECHA_FACTURA,"
				+ " DESCUENTO, IMPUESTOS, ESTADO_FACTURA)"
				+ " VALUES ("+factura.getNumeroFactura()
				+","+factura.getIdUsuario()
				+","+factura.getIdCliente()
				+",'"+factura.getFechaFactura()
				+"',"+factura.getDescuento()
				+","+factura.getImpuestos()
				+",'"+factura.getEstadoFactura()+"')";
	}
	
	public String buscarFacturaPorNumero(int numero){
		return "SELECT * FROM factura_venta WHERE NUMERO_FACTURA ="+numero+" ;";
	}
	
	public String cambiarEstadoFactura(String nuevoEstado,
			int numeroFactura){
		return "UPDATE factura_venta SET ESTADO_FACTURA='"+nuevoEstado
				+"' WHERE NUMERO_FACTURA="+numeroFactura+";";		
	}
	
}
