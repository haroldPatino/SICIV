/**
 * 
 */
package persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import logica.Cliente;
import logica.HistoriaClinica;

/**
 * @author Victor Rojas
 *
 */
public class HistoriaClinicaSql {

	//Attributes-------------------------------
		//No son necesarios atributos
		
	//Building---------------------------------
		//No es necesario constructor
			
	//Methods----------------------------------
		
	/**
	 * Sentencia SQL para seleccionar todas las tuplas existentes de la tabla historia_clinica
	 * @return
	 */
	public String selectHistoriasClinicas(){
			return "SELECT * FROM historia_clinica WHERE NUM_HISTORIA != 0;";
	}
		
	public String selectMayorHistoria(){
		return"SELECT NUM_HISTORIA FROM historia_clinica "
				+ "WHERE NUM_HISTORIA= (SELECT MAX(NUMERO_FACTURA) "
				+ "FROM historia_clinica);";
	}
	
	/**
	 * Sentencia SQL para insertar un nuevo elemento en la tabla historia_clinica en la Base de datos
	 * @return
	 */	
	public String crearHistoriaClinica(HistoriaClinica historia){
				
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechAux=formato.format(historia.getFechaHistoria());
		
		return "INSERT INTO historia_clinica VALUES ("
				+historia.getNumHistoria() 
				+", "+historia.getIdCliente()
				+", "+historia.getIdUsuario()
				+",'"+fechAux
				+"','"+historia.getMotivoConsulta()
				+"','"+historia.getAv_sc_od1()
				+"','"+historia.getOi2()
				+"','"+historia.getAv_sc_od3()
				+"','"+historia.getOi4()
				+"','"+historia.getAv_cc_od5()
				+"','"+historia.getOi6()
				+"','"+historia.getAv_cc_od7()
				+"','"+historia.getOi8()
				+"','"+historia.getRxUsoOD9()
				+"','"+historia.getOi10()
				+"','"+historia.gettColoresOD11()
				+"','"+historia.getOi12()
				+"','"+historia.getExterno13()
				+"','"+historia.getMotilidad14()
				+"','"+historia.getPupilas15()
				+"','"+historia.getbOD16()
				+"','"+historia.getOi17()
				+"','"+historia.gettOD18()
				+"','"+historia.getOi19()
				+"','"+historia.getfOD20()
				+"','"+historia.getOi21()
				+"','"+historia.getgOD22()
				+"','"+historia.getOi23()
				+"','"+historia.getId124()
				+"','"+historia.getId225()				
				+"','"+historia.getRecomendacion()+"');";
	}
	
	/**
	 * Sentencia SQL para actualizar los datos de una historia clinica
	 * @return
	 */	
	public String actualizarDatosHistoria(HistoriaClinica historia){
		return "UPDATE historia_clinica SET "+
				"ID_CLIENTE="+historia.getIdCliente()+
				", ID_USUARIO="+historia.getIdUsuario()+
				", MOTIVO_C='"+historia.getMotivoConsulta()+
				"', 1AV_SC_OD='"+historia.getAv_sc_od1()+
				"', 2OI='"+historia.getOi2()+
				"', 3AV_SC_OD='"+historia.getAv_sc_od3()+
				"', 4OI='"+historia.getOi4()+
				"', 5AV_CC_OD='"+historia.getAv_cc_od5()+
				"', 6OI='"+historia.getOi6()+
				"', 7AV_CC_OD='"+historia.getAv_cc_od7()+
				"', 8OI='"+historia.getOi8()+
				"', 9RX_USO_OD='"+historia.getRxUsoOD9()+
				"', 10OI='"+historia.getOi10()+
				"', 11T_COLORES_OD='"+historia.gettColoresOD11()+
				"', 12OI='"+historia.getOi12()+
				"', 13EXTERNO='"+historia.getExterno13()+
				"', 14MOTILIDAD='"+historia.getMotilidad14()+
				"', 15PUPILAS='"+historia.getPupilas15()+
				"', 16B_OD='"+historia.getbOD16()+
				"', 17OI='"+historia.getOi17()+
				"', 18T_OD='"+historia.gettOD18()+
				"', 19OI='"+historia.getOi19()+
				"', 20F_OD='"+historia.getfOD20()+
				"', 21OI='"+historia.getOi21()+
				"', 22G_OD='"+historia.getgOD22()+
				"', 23OI='"+historia.getOi23()+
				"', 24ID1='"+historia.getId124()+
				"', 25ID2='"+historia.getId225()+
				"', RECOMENDACION='"+historia.getRecomendacion()+
				"' WHERE NUM_HISTORIA = "+historia.getNumHistoria()+";";
	}
	
	
	/**
	 * Sentencia SQL para consultar la historia clinica por numero de historia
	 * @return
	 */	
	public String buscarHistoriaPorNumero(int numero){
		return "SELECT *"
				+ " FROM historia_clinica "
				+ " WHERE NUM_HISTORIA = '"+numero+"';";
	}
	
	public String buscarHistoriaPorCedula(int numero){
		return "SELECT FECHA_HISTORIA, NUM_HISTORIA, ID_CLIENTE, ID_USUARIO"
				+ " FROM historia_clinica "
				+ " WHERE ID_CLIENTE = '"+numero+"';";
	}
	
	
}
