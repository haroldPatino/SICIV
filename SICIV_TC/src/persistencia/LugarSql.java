/**
 * 
 */
package persistencia;

/**
 * @author GandalfXI
 *
 */
public class LugarSql {

	//Attributes-------------------------------
		//No son necesarios atributos
		
	//Building---------------------------------
		//No es necesario constructor
			
	//Methods----------------------------------

	public String selectLugares(){
		return "SELECT * FROM lugar";
	}
	
	public String buscarLugarPorNombre(String nombre){
		return "SELECT id_lugar, nombre_lugar  FROM lugar "
				+ "WHERE NOMBRE_LUGAR like '"+nombre+"';";
		
	}
	
	public String buscarLugarPorID(int idLugar){
		return "SELECT * FROM lugar "
				+ "WHERE ID_LUGAR = "+idLugar+";";
	}
	
	
}
