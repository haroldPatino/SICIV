/**
 * 
 */
package persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import logica.Cliente;

/**
 * @author Harold Pati�o
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
		
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechAux=formato.format(cliente.getFechaNacimiento());
		
		return "INSERT INTO cliente VALUES ("
				+cliente.getIdCliente()
				+","+cliente.getIdLugar()
				+",'"+cliente.getNombreCliente()
				+"','"+cliente.getApellidosCliente()
				+"','"+cliente.getDireccionCliente()
				+"',"+cliente.getTelefonoCliente()
				+",'"+fechAux+"');";
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
	public String actualizarDatosCliente(Cliente cliente){
		return "UPDATE cliente SET ID_LUGAR="+cliente.getIdLugar()+
				",NOMBRES_CLIENTE='"+cliente.getNombreCliente()+
				"', APELLIDOS_CLIENTE='"+cliente.getApellidosCliente()+
				"', DIRECCION_CLIENTE='"+cliente.getDireccionCliente()+
				"', NUMERO_TELEFONICO="+cliente.getTelefonoCliente()+
				", FECHA_NACIMIENTO='"+cliente.getFechaNacimiento()+
				"' WHERE ID_CLIENTE = "+cliente.getIdCliente()+";";
	}
	
	public String actualizarCedulaCliente(String cedulaAnterior, String cedulaNueva){
		return "UPDATE cliente SET ID_CLIENTE = "+cedulaNueva+
				" WHERE ID_CLIENTE = "+cedulaAnterior+";";
	}
	
	/**
	 * Sentencia SQL para consultar los clientes que cumplen anos el dia que se realiza la consulta
	 * @return
	 */	
	public String buscarClientePorNombre(String nombre){
		return "SELECT *"
				+ " FROM cliente "
				+ " WHERE NOMBRES_CLIENTE = '"+nombre+"';";
	}
	
	/**
	 * Sentencia SQL para consultar los clientes que cumplen anos el dia que se realiza la consulta
	 * @return
	 */	
	public String buscarClientePorCedula(int cedula){
		return "SELECT *"
				+ " FROM cliente "
				+ " WHERE ID_CLIENTE = "+cedula+";";
	}
}
