/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Harold Patiño
 *
 */
public class FacturaVenta {
//Attributes----------------------------------
	private int numeroFactura;
	private Usuario usuario;
	private Cliente cliente;
	private Calendar fechaFactura;
	private int descuento;
	private int impuestos;
	private String estadoFactura;
	private ArrayList<ProductoSerie> productos;
//Building------------------------------------
	/**
	 * 
	 */
	public FacturaVenta(){
		productos=new ArrayList<ProductoSerie>();
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
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario usuario a colocar
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente cliente a colocar
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return fechaFactura
	 */
	public Calendar getFechaFactura() {
		return fechaFactura;
	}
	/**
	 * @param fechaFactura fechaFactura a colocar
	 */
	public void setFechaFactura(Calendar fechaFactura) {
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
	 * @return productos
	 */
	public ArrayList<ProductoSerie> getProductos() {
		return productos;
	}
}
