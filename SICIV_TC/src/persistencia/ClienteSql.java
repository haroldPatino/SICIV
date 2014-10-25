/**
 * 
 */
package persistencia;

import logica.Cliente;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 *
 */
public class ClienteSql {

	//Attributes-------------------------------
		//No son necesarios atributos
		
	//Building---------------------------------
		//No es necesario constructor
			
	//Methods----------------------------------
		
	/**
	 * Sentencia SQL para seleccionar todas las tuplas existentes de la tabla cliente
	 * @return
	 */
	public String selectClientes(){
			return "SELECT * FROM cliente";
	}
		
	/**
	 * Sentencia SQL para insertar un nuevo elemento en la tabla cliente en la Base de datos
	 * @return
	 */	
	public String crearCliente(Cliente cliente){
		return "INSERT INTO cliente VALUES ("
				+cliente.getIdCliente()
				+","+cliente.getIdLugar()
				+",'"+cliente.getNombreCliente()
				+"','"+cliente.getApellidosCliente()
				+"','"+cliente.getDireccionCliente()
				+"',"+cliente.getTelefonoCliente()
				+",'"+cliente.getFechaNacimiento()+"');";
	}
	
	/**
	 * Sentencia SQL para consultar los clientes que cumplen anos el dia que se realiza la consulta
	 * @return
	 */	
	public String consultarCumpleanos(){
		return "SELECT ID_CLIENTE, NOMBRES_CLIENTE,"
				+ " APELLIDOS_CLIENTE,"
				+ " NUMERO_TELEFONICO,"
				+ " FECHA_NACIMIENTO,"
				+ " DIRECCION_CLIENTE,"
				+ " NOMBRE_LUGAR FROM cliente JOIN lugar"
				+ " WHERE MONTH(Fecha_nacimiento) = MONTH(Current_date)"
				+ " AND DAY(fecha_nacimiento) = DAY(Current_date)"
				+ " AND cliente.ID_LUGAR = lugar.ID_LUGAR;";
	}
	
	/**
	 * Sentencia SQL para consultar los clientes que cumplen anos el dia que se realiza la consulta
	 * @return
	 */	
	public String actualizarDatosCliente(){
		return "";
	}
	
	/**
	 * Sentencia SQL para consultar los clientes que cumplen anos el dia que se realiza la consulta
	 * @return
	 */	
	public String buscarClientePorNombre(){
		return "";
	}
	
	/**
	 * Sentencia SQL para consultar los clientes que cumplen anos el dia que se realiza la consulta
	 * @return
	 */	
	public String buscarClientePorCedula(){
		return "";
	}
}
