/**
 * 
 */
package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import logica.Lugar;
import persistencia.ClienteDao;
import persistencia.LugarDao;

/**
 * @author Lenovo Pc
 *
 */
public class ControlClientes implements Serializable{
//Attributes-------------------------------------
	private static final long serialVersionUID = 5459148776780736708L;
	private String idCliente;
	private String nombres;
	private String apellidos;
	private String lugarResidencia;
	private String direccion;
	private String telefono;
	private String fechaNacimiento;
	private ClienteDao dao;
//Building---------------------------------------
	public ControlClientes(){
		dao=new ClienteDao();
	}
//Methods----------------------------------------
	/**
	 * @return idCliente
	 */
	public String getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente idCliente a colocar
	 */
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres nombres a colocar
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos apellidos a colocar
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return lugarResidencia
	 */
	public String getLugarResidencia() {
		return lugarResidencia;
	}
	/**
	 * @param lugarResidencia lugarResidencia a colocar
	 */
	public void setLugarResidencia(String lugarResidencia) {
		this.lugarResidencia = lugarResidencia;
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
	 * @return fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento fechaNacimiento a colocar
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return dao
	 */
	public ClienteDao getDao() {
		return dao;
	}
	public List<String> completeLugares(String text){
		ArrayList<Lugar> lugares=new ArrayList<Lugar>();
		LugarDao lugar=new LugarDao();
		lugares=lugar.seleccionarLugares();
		List<String> result=new ArrayList<String>();
		for(int i=0;i<lugares.size();i++){
			if(lugares.get(i).getNombreLugar().toUpperCase().contains(text.toUpperCase())){
				result.add(lugares.get(i).getNombreLugar());
			}
		}
		return result;
	}
}
