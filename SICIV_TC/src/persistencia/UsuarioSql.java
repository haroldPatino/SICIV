/**
 * 
 */
package persistencia;

import logica.Usuario;

/**
 * @author Harold Pati�o
 * @author Victor Rojas
 *
 */
public class UsuarioSql {
//Attributes-------------------------------
	//No son necesarios atributos
	
//Building---------------------------------
	//No es necesario constructor
		
//Methods----------------------------------
	/**
	 * Sentencia SQL para seleccionar todas las tuplas existentes de la tabla usuario
	 * @return
	 */
	public String selectUsuarios(){
		return "SELECT * FROM usuario WHERE ID_USUARIO != 0;";
	}
	
	/**
	 * Sentencia SQL para insertar un nuevo elemento en la tabla usuario en la Base de datos
	 * @return
	 */	
	public String crearUsuario(Usuario usuario){
				
		return  "INSERT INTO usuario VALUES ("
				+usuario.getIdUsuario()+","
				+usuario.getIdLugar()+",'"
				+usuario.getNombreUsuario()+"','"
				+usuario.getApellidosUsuario()+"','"
				+usuario.getDireccionUsuario()+"',"
				+usuario.getTelefonoUsuario()+",'"
				+usuario.getTipoUsuario()+"','"
				+usuario.getContrasena()+"','"
				+usuario.getNickname()+"');";		
	}
		
	/**
	 * Sentencia SQL para buscar un registro en la tabla usuario por el nombre
	 * @return
	 */
	public String buscarUsuarioPorNombre(String nombre){
		return "SELECT * FROM usuario WHERE NOMBRES_USUARIO LIKE '"+nombre+"';";
	}
	
	/**
	 * Sentencia SQL para buscar un registro en la tabla usuario por el nickname
	 * @return
	 */
	public String buscarUsuarioPorNickname(String nickname){
		return "SELECT * FROM usuario WHERE NICKNAME_USUARIO LIKE '"+nickname+"';";
	}
	
	/**
	 * Sentencia SQL para buscar un registro en la tabla usuario por el numero de cedula
	 * @return
	 */
	public String buscarUsuarioPorCedula(int cedula){
		return "SELECT * FROM usuario WHERE ID_USUARIO = "+cedula+";";
	}
	
	/**
	 * Sentencia SQL para restablecer la contrasena de un usuario a partir de su nickname y su numero de cedula
	 * @return
	 */
	public String restablecerContrasenaUsuario(int cedula, String nickname, String contrasena){
		return "UPDATE usuario SET CONTRASENA = '"+contrasena
				+"' WHERE ID_USUARIO = "+cedula
				+" AND NICKNAME_USUARIO = '"+nickname+"';";
	}
	
	/**
	 * Sentencia SQL para cambiar la contrasena existente por una nueva
	 * @return
	 */
	public String cambiarContrasenaUsuario(int cedula, String anterior, 
			String nueva){
		return "UPDATE usuario SET CONTRASENA = '"+nueva
				+"' WHERE ID_USUARIO = "+cedula
				+" AND CONTRASENA = '"+anterior+"';";
	}
		
	/**
	 * Sentencia SQL para actualizar los datos de un usuario
	 * @return
	 */
	public String actualizarDatos(Usuario usuario){
		return "UPDATE usuario SET ID_LUGAR = "+usuario.getIdLugar()
				+", NOMBRES_USUARIO = '"+usuario.getNombreUsuario()
				+"', APELLIDOS_USUARIO = '"+usuario.getApellidosUsuario()
				+"', DIRECCION_USUARIO = '"+usuario.getDireccionUsuario()
				+"', TELEFONO_USUARIO = "+usuario.getTelefonoUsuario()
				+" WHERE ID_USUARIO = "+usuario.getIdUsuario()+";";
	}
	
}
