/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author GandalfXI
 *
 */
public class ReporteDatosFactura {
	//Attributes Header----------------------------------
	private int numeroFactura;
	private String nombreUsuario;
	private String nombreCliente;
	private Calendar fechaFactura;	
	private String ciudad;
	private String telefono;
	private int cedula;
	private String direccion;
	private int descuento;
	private int impuestos;
	
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
	 * @return nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario nombreUsuario a colocar
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente nombreCliente a colocar
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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
	 * @return ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad ciudad a colocar
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono telefono a colocar
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return cedula
	 */
	public int getCedula() {
		return cedula;
	}
	/**
	 * @param cedula cedula a colocar
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion direccion a colocar
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
}
