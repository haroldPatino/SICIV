/**
 * 
 */
package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import logica.Lugar;
import logica.Usuario;
import persistencia.LugarDao;
import persistencia.UsuarioDao;

/**
 * @author Lenovo Pc
 *
 */
public class ControlEmpleados implements Serializable{
//Attributes---------------------------------------------------------------
	private static final long serialVersionUID = -2779201899085153040L;
	private String idEmpleado;
	private String nombres;
	private String apellidos;
	private String lugarResidencia;
	private String direccion;
	private String telefono;
	private String nickname;
	private String password;
	private String tipoUser;
	private UsuarioDao dao;
//Building-----------------------------------------------------------------
	public ControlEmpleados(){
		dao=new UsuarioDao();
	}
//Methods------------------------------------------------------------------
	/**
	 * @return idEmpleado
	 */
	public String getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * @param idEmpleado idEmpleado a colocar
	 */
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
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
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname nickname a colocar
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password password a colocar
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return tipoUser
	 */
	public String getTipoUser() {
		return tipoUser;
	}
	/**
	 * @param tipoUser tipoUser a colocar
	 */
	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
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
	public UsuarioDao getDao() {
		return dao;
	}
	public void agregarEmpleado(ActionEvent actionEvent){
		FacesContext ctxtMsg = FacesContext.getCurrentInstance();
		if(idEmpleado!="" && nombres!="" && apellidos!="" && lugarResidencia!="" && nickname!="" && password!="" && tipoUser!=""){
			Usuario user=new Usuario();
			user.setIdUsuario(Integer.parseInt(idEmpleado));
			user.setNombreUsuario(nombres);
			user.setApellidosUsuario(apellidos);
			user.setIdLugar(buscarLugarNombre(lugarResidencia));
			user.setDireccionUsuario(direccion);
			user.setTelefonoUsuario(Long.parseLong(telefono));
			user.setNickname(nickname);
			user.setTipoUsuario(tipoUser.toUpperCase().charAt(0));
			user.setContrasena(password);
			if(buscarEmpleadoId(user.getIdUsuario())==null && buscarEmpleadoNickname(user.getNickname())==null){
				dao.inserartUsuario(user);
				ctxtMsg.addMessage(null, new FacesMessage("Successful",  "Empleado Agregado Exitosamente"));
			}
			else{
				ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El numero de documento o el nickname de sistema ya pertenecen a otro empleado"));
			}
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Alert",  "Existen campos obligatorios vacios"));
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
	public Usuario buscarEmpleadoNickname(String nickname){
		ArrayList<Usuario> usuarios=dao.selecionarUsuarios();
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getNickname().toUpperCase().equals(nickname.toUpperCase())){
				return usuarios.get(i);
			}
		}
		return null;
	}
	public Usuario buscarEmpleadoId(int id){
		ArrayList<Usuario> usuarios=dao.selecionarUsuarios();
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getIdUsuario()==id){
				return usuarios.get(i);
			}
		}
		return null;
	}

}
