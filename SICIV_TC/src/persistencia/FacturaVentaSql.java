/**
 * 
 */
package persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import logica.FacturaVenta;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 *
 */
public class FacturaVentaSql {

	public String selectFacturas(){
		return "SELECT * FROM factura_venta WHERE NUMERO_FACTURA != 0;";
	}
	
	public String crearFactura(FacturaVenta factura){
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechAux=formato.format(factura.getFechaFactura());
		return "INSERT INTO factura_venta (NUMERO_FACTURA,"
				+ " ID_USUARIO, ID_CLIENTE, FECHA_FACTURA,"
				+ " DESCUENTO, IMPUESTOS, ESTADO_FACTURA)"
				+ " VALUES ("+factura.getNumeroFactura()
				+","+factura.getIdUsuario()
				+","+factura.getIdCliente()
				+",'"+fechAux
				+"',"+factura.getDescuento()
				+","+factura.getImpuestos()
				+",'AC')";
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
