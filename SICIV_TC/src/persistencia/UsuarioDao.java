/**
 * 
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logica.Usuario;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class UsuarioDao {
//Attributes-----------------------------------
	private UsuarioSql sqlUsuario;
	private Conexion conexion;
//Building-------------------------------------
	public UsuarioDao(){
		sqlUsuario = new UsuarioSql();
		conexion = new Conexion();
	}
//Methods--------------------------------------
	public ArrayList<Usuario> selecionarUsuarios(){
		ResultSet result;
		ArrayList<Usuario> empleados=new ArrayList<Usuario>();
		if(conexion.conectar()){
			try{
				Statement sentence=conexion.getConexion().createStatement();
				result=sentence.executeQuery(sqlUsuario.selectUsuarios());
				while(result.next()){
					Usuario user=new Usuario();
					user.setIdUsuario(Integer.parseInt(result.getString("ID_USUARIO")));
					user.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));
					user.setNombreUsuario(result.getString("NOMBRES_USUARIO"));
					user.setApellidosUsuario(result.getString("APELLIDOS_USUARIO"));
					user.setDireccionUsuario(result.getString("DIRECCION_USUARIO"));
					user.setTelefonoUsuario(result.getString("TELEFONO_USUARIO"));
					user.setTipoUsuario(result.getString("TIPO_USUARIO").charAt(0));
					user.setNickname(result.getString("NICKNAME_USUARIO"));
					user.setContrasena(result.getString("CONTRASENA"));
					empleados.add(user);
				}
				return empleados;
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	public int inserartUsuario (Usuario user){
		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			return sentencia.executeUpdate(sqlUsuario.crearUsuario(user));
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return -1;
	}
	
	public int actualizarUsuario(Usuario user){
		
		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			return sentencia.executeUpdate(sqlUsuario.actualizarDatos(user));
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return -1;
	}
	
	public Usuario buscarPorNombre(String nombre){
		ResultSet result;
		Usuario usuario = new Usuario();;
		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			result = sentencia.executeQuery(sqlUsuario.buscarUsuarioPorNombre(nombre));
			while(result.next()){
				usuario.setIdUsuario(Integer.parseInt(result.getString("ID_USUARIO")));
				usuario.setNombreUsuario(result.getString("NOMBRES_USUARIO"));
				usuario.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));
				usuario.setApellidosUsuario(result.getString("APELLIDOS_USUARIO"));
				usuario.setDireccionUsuario(result.getString("DIRECCION_USUARIO"));
				usuario.setTelefonoUsuario(result.getString("TELEFONO_USUARIO"));
				usuario.setTipoUsuario(result.getString("TIPO_USUARIO").charAt(0));
				usuario.setContrasena(result.getString("CONTRASENA"));
				usuario.setNickname(result.getString("NICKNAME_USUARIO"));
			}
			return usuario;
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	public Usuario buscarPorNickname(String nickname){
		ResultSet result;
		Usuario usuario = new Usuario();;
		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			result = sentencia.executeQuery(sqlUsuario.buscarUsuarioPorNickname(nickname));
			while(result.next()){
				usuario.setIdUsuario(Integer.parseInt(result.getString("ID_USUARIO")));
				usuario.setNombreUsuario(result.getString("NOMBRES_USUARIO"));
				usuario.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));
				usuario.setApellidosUsuario(result.getString("APELLIDOS_USUARIO"));
				usuario.setDireccionUsuario(result.getString("DIRECCION_USUARIO"));
				usuario.setTelefonoUsuario(result.getString("TELEFONO_USUARIO"));
				usuario.setTipoUsuario(result.getString("TIPO_USUARIO").charAt(0));
				usuario.setContrasena(result.getString("CONTRASENA"));
				usuario.setNickname(result.getString("NICKNAME_USUARIO"));
			}
			return usuario;
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	public Usuario buscarPorCedula(int cedula){
		
		ResultSet result;
		Usuario usuario = new Usuario();;
		if(conexion.conectar()){
			try{		
			Statement sentencia=conexion.getConexion().createStatement();			
			result = sentencia.executeQuery(sqlUsuario.buscarUsuarioPorCedula(cedula));			
			while(result.next()){
				usuario.setIdUsuario(Integer.parseInt(result.getString("ID_USUARIO")));			
				usuario.setNombreUsuario(result.getString("NOMBRES_USUARIO"));
				usuario.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));
				usuario.setApellidosUsuario(result.getString("APELLIDOS_USUARIO"));
				usuario.setDireccionUsuario(result.getString("DIRECCION_USUARIO"));			
				usuario.setTelefonoUsuario(result.getString("TELEFONO_USUARIO"));
				usuario.setTipoUsuario(result.getString("TIPO_USUARIO").charAt(0));
				usuario.setContrasena(result.getString("CONTRASENA"));
				usuario.setNickname(result.getString("NICKNAME_USUARIO"));
			}			
			return usuario;
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	public int restablecerContrasena(int cedula, String contrasena){

		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			return sentencia.executeUpdate(sqlUsuario.restablecerContrasenaUsuario(cedula, contrasena));
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return -1;		
	}
	
	public int cambiarContrasena(int cedula, String anterior, String nueva){

		if(conexion.conectar()){
			try{
			Statement sentencia=conexion.getConexion().createStatement();
			return sentencia.executeUpdate(sqlUsuario.cambiarContrasenaUsuario(cedula, anterior, nueva));
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return -1;		
	}
	
}
