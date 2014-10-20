/**
 * 
 */
package persistencia;

/**
 * @author Harold Patiño
 *
 */
public class UsuarioSql {
//Attributes-------------------------------
	
//Building---------------------------------
	public UsuarioSql(){
		
	}
//Methods----------------------------------
	/**
	 * Sentencia SQL para seleccionar todas las tuplas existentes de la tabla usuario
	 * @return
	 */
	public String selectUsuarios(){
		return "SELECT * FROM usuario";
	}
}
