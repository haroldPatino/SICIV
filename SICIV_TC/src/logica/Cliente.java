/**
 * 
 */
package logica;

import java.util.Calendar;
import java.util.Date;

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
	private Date fechaNacimiento;
	private String ocupacionCliente = "";
	private String entidadCliente = "";
	private String estadoCivilCliente = "";
	private String eMailCliente = "";
	private String antecPatologico = "";
	private String antecQuirurgico = "";
	private String antecFamiliar = "";
	private String antecAlergico = "";
	private String antecMedicamento = "";
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento fechaNacimiento a colocar
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return ocupacionCliente
	 */
	public String getOcupacionCliente() {
		return ocupacionCliente;
	}
	/**
	 * @param ocupacionCliente ocupacionCliente a colocar
	 */
	public void setOcupacionCliente(String ocupacionCliente) {
		this.ocupacionCliente = ocupacionCliente;
	}
	/**
	 * @return entidadCliente
	 */
	public String getEntidadCliente() {
		return entidadCliente;
	}
	/**
	 * @param entidadCliente entidadCliente a colocar
	 */
	public void setEntidadCliente(String entidadCliente) {
		this.entidadCliente = entidadCliente;
	}
	/**
	 * @return estadoCivilCliente
	 */
	public String getEstadoCivilCliente() {
		return estadoCivilCliente;
	}
	/**
	 * @param estadoCivilCliente estadoCivilCliente a colocar
	 */
	public void setEstadoCivilCliente(String estadoCivilCliente) {
		this.estadoCivilCliente = estadoCivilCliente;
	}
	/**
	 * @return eMailCliente
	 */
	public String geteMailCliente() {
		return eMailCliente;
	}
	/**
	 * @param eMailCliente eMailCliente a colocar
	 */
	public void seteMailCliente(String eMailCliente) {
		this.eMailCliente = eMailCliente;
	}
	/**
	 * @return antecPatologico
	 */
	public String getAntecPatologico() {
		return antecPatologico;
	}
	/**
	 * @param antecPatologico antecPatologico a colocar
	 */
	public void setAntecPatologico(String antecPatologico) {
		this.antecPatologico = antecPatologico;
	}
	/**
	 * @return antecQuirurgico
	 */
	public String getAntecQuirurgico() {
		return antecQuirurgico;
	}
	/**
	 * @param antecQuirurgico antecQuirurgico a colocar
	 */
	public void setAntecQuirurgico(String antecQuirurgico) {
		this.antecQuirurgico = antecQuirurgico;
	}
	/**
	 * @return antecFamiliar
	 */
	public String getAntecFamiliar() {
		return antecFamiliar;
	}
	/**
	 * @param antecFamiliar antecFamiliar a colocar
	 */
	public void setAntecFamiliar(String antecFamiliar) {
		this.antecFamiliar = antecFamiliar;
	}
	/**
	 * @return antecAlergico
	 */
	public String getAntecAlergico() {
		return antecAlergico;
	}
	/**
	 * @param antecAlergico antecAlergico a colocar
	 */
	public void setAntecAlergico(String antecAlergico) {
		this.antecAlergico = antecAlergico;
	}
	/**
	 * @return antecMedicamento
	 */
	public String getAntecMedicamento() {
		return antecMedicamento;
	}
	/**
	 * @param antecMedicamento antecMedicamento a colocar
	 */
	public void setAntecMedicamento(String antecMedicamento) {
		this.antecMedicamento = antecMedicamento;
	}	
}
