/**
 * 
 */
package logica;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class FacturaVenta {
//Attributes----------------------------------
	private int numeroFactura;
	private int idUsuario;
	private int idCliente;
	private Date fechaFactura;
	private int descuento;
	private int impuestos;
	private String estadoFactura;

//Building------------------------------------
	/**
	 * 
	 */
	public FacturaVenta(){
		
	}
//Methods-------------------------------------
	/**
	 * @return numeroFactura
	 */
	public int getNumeroFactura() {
		return numeroFactura;
	}
	/**
	 * @param numeroFactura numeroFactura a colocar
	 */
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	
	/**
	 * @return fechaFactura
	 */
	public Date getFechaFactura() {
		return fechaFactura;
	}
	/**
	 * @param fechaFactura fechaFactura a colocar
	 */
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	/**
	 * @return descuento
	 */
	public int getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento descuento a colocar
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return impuestos
	 */
	public int getImpuestos() {
		return impuestos;
	}
	/**
	 * @param impuestos impuestos a colocar
	 */
	public void setImpuestos(int impuestos) {
		this.impuestos = impuestos;
	}
	/**
	 * @return estadoFactura
	 */
	public String getEstadoFactura() {
		return estadoFactura;
	}
	/**
	 * @param estadoFactura estadoFactura a colocar
	 */
	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}
	/**
	 * @return idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario idUsuario a colocar
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente idCliente a colocar
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
}
