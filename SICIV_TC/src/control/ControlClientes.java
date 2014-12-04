/**
 * 
 */
package control;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import logica.Cliente;
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
	private Date fechaNacimiento;
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
	
	public void agregarCliente(ActionEvent actionEvent) throws ParseException{
		FacesContext ctxtMsg = FacesContext.getCurrentInstance();

		System.out.println(".---------------................ Methods");
		if(idCliente!="" && nombres!="" && apellidos!="" && lugarResidencia!=""){
			System.out.println(".---------------................ Is IN");
			Cliente client=new Cliente();
			client.setIdCliente(Integer.parseInt(idCliente));
			client.setNombreCliente(nombres);
			client.setApellidosCliente(apellidos);
			client.setIdLugar(buscarLugarNombre(lugarResidencia));
			client.setDireccionCliente(direccion);
			client.setTelefonoCliente(telefono);
			client.setFechaNacimiento(fechaNacimiento);
			if(buscarClienteDoc(client.getIdCliente())==null){
				dao.insertarCliente(client);
				ctxtMsg.addMessage(null, new FacesMessage("Successful",  "Cliente Agregado Exitosamente"));
			}
			else{
				ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El documento del cliente ya esta registrado"));
			}
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Alert",  "Existen campos vacios"));
		}
	}
	public int buscarLugarNombre(String nombreLugar){
		LugarDao daoLug=new LugarDao();
		ArrayList<Lugar> lugares=daoLug.seleccionarLugares();
		for(int i=0;i<lugares.size();i++){
			Lugar aux=lugares.get(i);
			if(aux.getNombreLugar().toUpperCase().equals(nombreLugar.toUpperCase())){
				return aux.getIdLugar();
			}
		}
		return -1;
	}
	public Cliente buscarClienteDoc(int documento){
		ArrayList<Cliente> clients=dao.seleccionarCliente();
		for(int i=0;i<clients.size();i++){
			if(clients.get(i).getIdCliente()==documento){
				return clients.get(i);
			}
		}
		return null;
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
