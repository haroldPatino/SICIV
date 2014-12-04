/**
 * 
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import logica.Cliente;


/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class ClienteDao {
	//Attributes-----------------------------------
		private ClienteSql sqlCliente;
		private Conexion conexion;
		
	//Building-------------------------------------
		public ClienteDao() {
			sqlCliente = new ClienteSql();
			conexion = new Conexion();
		}
		
	//Methods--------------------------------------
		public ArrayList<Cliente> seleccionarCliente(){
			ResultSet result;
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlCliente.selectClientes());
					while(result.next()){
						Cliente cliente = new Cliente();
						cliente.setIdCliente(Integer.parseInt(result.getString("ID_CLIENTE")));
						cliente.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));;
						cliente.setNombreCliente(result.getString("NOMBRES_CLIENTE"));
						cliente.setApellidosCliente(result.getString("APELLIDOS_CLIENTE"));
						cliente.setDireccionCliente(result.getString("DIRECCION_CLIENTE"));
						cliente.setTelefonoCliente(result.getString("NUMERO_TELEFONICO"));		
						DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
						cliente.setFechaNacimiento(formato.parse(result.getString("FECHA_NACIMIENTO")));
						clientes.add(cliente);
					}
					return clientes;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}			
			return null;			
		}
		
		public int insertarCliente(Cliente cliente){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlCliente.crearCliente(cliente));
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;

		}
		
		public ArrayList<String[]> seleccionarCumpleaños(){
			ResultSet result;
			ArrayList<String[]> clientes = new ArrayList<String[]>();
			String[] valores = new String [5];
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlCliente.selectClientes());
					while(result.next()){
						valores[0] = result.getString("NOMBRES_CLIENTE");
						valores[1] = result.getString("APELLIDOS_CLIENTE");
						valores[2] = result.getString("DIRECCION_CLIENTE");
						valores[3] = result.getString("NUMERO_TELEFONICO");
						valores[4] = result.getString("FECHA_NACIMIENTO");
						clientes.add(valores);
					}
					return clientes;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 				
			}			
			return null;
		}
		
		public int actualizarDatosCliente(Cliente cliente){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlCliente.actualizarDatosCliente(cliente));
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;

		}
		
		public int actualizarCedulaCliente(String anterior, String nueva){
			if(conexion.conectar()){
				try{
				Statement sentencia=conexion.getConexion().createStatement();
				return sentencia.executeUpdate(sqlCliente.actualizarCedulaCliente(anterior, nueva));
				}catch (SQLException e){
					System.out.println(e.getMessage());
				}
			}
			return -1;

		}
		
		public Cliente buscarClientePorNombre(String nombre){
			ResultSet result;
			Cliente cliente = new Cliente();
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlCliente.buscarClientePorNombre(nombre));
					while(result.next()){						
						cliente.setIdCliente(Integer.parseInt(result.getString("ID_CLIENTE")));
						cliente.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));;
						cliente.setNombreCliente(result.getString("NOMBRES_CLIENTE"));
						cliente.setApellidosCliente(result.getString("APELLIDOS_CLIENTE"));
						cliente.setDireccionCliente(result.getString("DIRECCION_CLIENTE"));
						cliente.setTelefonoCliente(result.getString("NUMERO_TELEFONICO"));
						DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
						cliente.setFechaNacimiento(formato.parse(result.getString("FECHA_NACIMIENTO")));
						
					}
					return cliente;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}			
			return null;			
		}
		
		public Cliente buscarClientePorCedula(int cedula){
			ResultSet result;
			Cliente cliente = new Cliente();
			if(conexion.conectar()){
				Statement sentence;
				try {
					sentence = conexion.getConexion().createStatement();
					result = sentence.executeQuery(sqlCliente.buscarClientePorCedula(cedula));
					while(result.next()){						
						cliente.setIdCliente(Integer.parseInt(result.getString("ID_CLIENTE")));
						cliente.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));;
						cliente.setNombreCliente(result.getString("NOMBRES_CLIENTE"));
						cliente.setApellidosCliente(result.getString("APELLIDOS_CLIENTE"));
						cliente.setDireccionCliente(result.getString("DIRECCION_CLIENTE"));
						cliente.setTelefonoCliente(result.getString("NUMERO_TELEFONICO"));
						DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
						cliente.setFechaNacimiento(formato.parse(result.getString("FECHA_NACIMIENTO")));
						
					}
					return cliente;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}			
			return null;			
		}
		
}
