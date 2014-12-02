/**
 * 
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import logica.Cliente;
import logica.Lugar;

/**
 * @author GandalfXI
 *
 */
public class LugarDao {
	//Attributes-----------------------------------
			private LugarSql sqlLugar;
			private Conexion conexion;
			
	//Building-------------------------------------
			public LugarDao() {
				sqlLugar = new LugarSql();
				conexion = new Conexion();
			}
				
	//Methods--------------------------------------
			public ArrayList<Lugar> seleccionarLugares(){
				ResultSet result;
				ArrayList<Lugar> lugares = new ArrayList<Lugar>();
				if(conexion.conectar()){
					Statement sentence;
					try {
						sentence = conexion.getConexion().createStatement();
						result = sentence.executeQuery(sqlLugar.selectLugares());
						while(result.next()){
							Lugar lugar = new Lugar();
							lugar.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));
							lugar.setLugarPadre(Integer.parseInt(result.getString("LUG_ID_LUGAR")));
							lugar.setNombreLugar(result.getString("NOMBRE_LUGAR"));
							lugares.add(lugar);
						}
						return lugares;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}			
				return null;			
			}
			
			public Lugar buscarLugarPorNombre(String nombre){
				ResultSet result;
				Lugar lugar = new Lugar();
				if(conexion.conectar()){
					Statement sentence;
					try {
						sentence = conexion.getConexion().createStatement();
						result = sentence.executeQuery(sqlLugar.buscarLugarPorNombre(nombre));
						while(result.next()){						
							lugar.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));
							lugar.setLugarPadre(Integer.parseInt(result.getString("LUG_ID_LUGAR")));
							lugar.setNombreLugar(result.getString("NOMBRE_LUGAR"));
							
						}
						return lugar;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}			
				return null;			
			}
			
			public Lugar buscarLugarPorID(int buscar){
				ResultSet result;
				Lugar lugar = new Lugar();
				if(conexion.conectar()){
					Statement sentence;
					try {
						sentence = conexion.getConexion().createStatement();
						result = sentence.executeQuery(sqlLugar.buscarLugarPorID(buscar));
						while(result.next()){						
							lugar.setIdLugar(Integer.parseInt(result.getString("ID_LUGAR")));
							lugar.setLugarPadre(Integer.parseInt(result.getString("LUG_ID_LUGAR")));
							lugar.setNombreLugar(result.getString("NOMBRE_LUGAR"));
							
						}
						return lugar;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}			
				return null;			
			}
			
}
