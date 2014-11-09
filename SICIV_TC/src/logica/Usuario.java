/**
 * 
 */
package logica;

/**
 * @author Harold Patiño
 *
 */
public class Usuario {
//Attributes----------------------------------
	private int idUsuario;
	private int idLugar;
	private String nombreUsuario;
	private String apellidosUsuario;
	private String direccionUsuario;
	private long telefonoUsuario;
	private char tipoUsuario;
	private String nickname;
	private String contrasena;
//Building------------------------------------
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
//Methods------------------------------------
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
	 * @return apellidosUsuario
	 */
	public String getApellidosUsuario() {
		return apellidosUsuario;
	}
	/**
	 * @param apellidosUsuario apellidosUsuario a colocar
	 */
	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}
	/**
	 * @return direccionUsuario
	 */
	public String getDireccionUsuario() {
		return direccionUsuario;
	}
	/**
	 * @param direccionUsuario direccionUsuario a colocar
	 */
	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}
	/**
	 * @return telefonoUsuario
	 */
	public long getTelefonoUsuario() {
		return telefonoUsuario;
	}
	/**
	 * @param telefonoUsuario telefonoUsuario a colocar
	 */
	public void setTelefonoUsuario(long telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	/**
	 * @return tipoUsuario
	 */
	public char getTipoUsuario() {
		return tipoUsuario;
	}
	/**
	 * @param tipoUsuario tipoUsuario a colocar
	 */
	public void setTipoUsuario(char tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
	 * @return contraseña
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contraseña contraseña a colocar
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}		
}
