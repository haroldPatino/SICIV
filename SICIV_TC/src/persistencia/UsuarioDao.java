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
 *
 */
public class UsuarioDao {
//Attributes-----------------------------------
	private UsuarioSql sql;
	private Conexion conexion;
//Building-------------------------------------
	public UsuarioDao(){
		sql=new UsuarioSql();
		conexion=new Conexion();
	}
//Methods--------------------------------------
	public ArrayList<Usuario> cargaUsuarios(){
		ResultSet result;
		ArrayList<Usuario> empleados=new ArrayList<Usuario>();
		if(conexion.conectar()){
			try{
				Statement sentence=conexion.getConexion().createStatement();
				result=sentence.executeQuery(sql.selectUsuarios());
				while(result.next()){
					Usuario user=new Usuario();
					user.setIdUsuario(Integer.parseInt(result.getString("ID_USUARIO")));
					user.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));
					user.setNombreUsuario(result.getString("NOMBRES_USUARIO"));
					user.setApellidosUsuario(result.getString("APELLIDOS_USUARIO"));
					user.setDireccionUsuario(result.getString("DIRECCION_USUARIO"));
					user.setTelefonoUsuario(Long.parseLong(result.getString("TELEFONO_USUARIO")));
					user.setTipoUsuario(result.getString("TIPO_USUARIO").charAt(0));
					user.setNickname(result.getString("NICKNAME_USUARIO"));
					user.setContraseña(result.getString("CONTRASENA"));
					empleados.add(user);
				}
				return empleados;
			}catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
}
