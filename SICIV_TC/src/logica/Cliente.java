/**
 * 
 */
package logica;

import java.util.Calendar;

/**
 * @author Harold Patiño
 *
 */
public class Cliente {
//Attributes---------------------------------------
	private int idCliente;
	private int idLugar;
	private String nombreCliente;
	private String apellidosCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private Calendar fechaNacimiento;
//Building-----------------------------------------
	/**
	 * 
	 */
	public Cliente(){
		
	}
//Methods------------------------------------------
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
	/**
	 * @return idLugar
	 */
	public int getIdLugar() {
		return idLugar;
	}
	/**
	 * @param idLugar idLugar a colocar
	 */
	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
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
	 * @return apellidosCliente
	 */
	public String getApellidosCliente() {
		return apellidosCliente;
	}
	/**
	 * @param apellidosCliente apellidosCliente a colocar
	 */
	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}
	/**
	 * @return direccionCliente
	 */
	public String getDireccionCliente() {
		return direccionCliente;
	}
	/**
	 * @param direccionCliente direccionCliente a colocar
	 */
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	
	/**
	 * @return telefonoCliente
	 */
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	/**
	 * @param telefonoCliente telefonoCliente a colocar
	 */
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	/**
	 * @return fechaNacimiento
	 */
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento fechaNacimiento a colocar
	 */
	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
