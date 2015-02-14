/**
 * 
 */
package persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
			return "SELECT ID_CLIENTE, ID_LUGAR, NOMBRES_CLIENTE, APELLIDOS_CLIENTE, "
					+ "DIRECCION_CLIENTE, NUMERO_TELEFONICO, FECHA_NACIMIENTO"
					+ "FROM cliente WHERE ID_CLIENTE != 0;";
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
				+",'"+fechAux
				+"',"+cliente.getEntidadCliente()
				+"',"+cliente.getEstadoCivilCliente()
				+"',"+cliente.geteMailCliente()
				+"',"+cliente.getOcupacionCliente()
				+"',"+cliente.getAntecPatologico()
				+"',"+cliente.getAntecQuirurgico()
				+"',"+cliente.getAntecFamiliar()
				+"',"+cliente.getAntecAlergico()
				+"',"+cliente.getAntecMedicamento()+"');";
	}
	
	/**
	 * Sentencia SQL para consultar los clientes que cumplen anos el dia que se realiza la consulta
	 * @return
	 */	
	public String consultarCumpleanos(){
		return "SELECT NOMBRES_CLIENTE, "
				+ "NUMERO_TELEFONICO FROM cliente "
				+ "WHERE MONTH(FECHA_NACIMIENTO) = "
				+ "MONTH(Current_date) AND DAY(FECHA_NACIMIENTO) = "
				+ "DAY(Current_date);";
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
				", ENTIDAD='"+cliente.getEntidadCliente()+
				", ESTADO_CIVIL='"+cliente.getEstadoCivilCliente()+
				", E_MAIL='"+cliente.geteMailCliente()+
				", OCUPACION='"+cliente.getOcupacionCliente()+
				", ANT_PATOLOGICO='"+cliente.getAntecPatologico()+
				", ANT_QUIRURGICO='"+cliente.getAntecQuirurgico()+
				", ANT_FAMILIAR='"+cliente.getAntecFamiliar()+
				", ANT_ALERGICO='"+cliente.getAntecAlergico()+
				", ANT_MEDICAMENTO='"+cliente.getAntecMedicamento()+
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
		return "SELECT ID_CLIENTE, ID_LUGAR, NOMBRES_CLIENTE, APELLIDOS_CLIENTE, "
				+ "DIRECCION_CLIENTE, NUMERO_TELEFONICO, FECHA_NACIMIENTO"
				+ " FROM cliente "
				+ " WHERE NOMBRES_CLIENTE = '"+nombre+"';";
	}
	
	/**
	 * Sentencia SQL para consultar los clientes que cumplen anos el dia que se realiza la consulta
	 * @return
	 */	
	public String buscarClientePorCedula(int cedula){
		return "SELECT ID_CLIENTE, ID_LUGAR, NOMBRES_CLIENTE, APELLIDOS_CLIENTE, "
				+ "DIRECCION_CLIENTE, NUMERO_TELEFONICO, FECHA_NACIMIENTO"
				+ " FROM cliente "
				+ " WHERE ID_CLIENTE = "+cedula+";";
	}
}
