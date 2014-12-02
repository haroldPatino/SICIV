/**
 * 
 */
package logica;

/**
 * @author Victor Rojas
 *
 */
public class Lugar {
	////Attributes---------------------------------------
	private int idLugar;
	private int lugarPadre;
	private String nombreLugar;
	//Building-----------------------------------------
		/**
		 * 
		 */
		public Lugar(){
			
		}
	//Methods------------------------------------------
	
	/**
	 * @return idLugar
	 */
	public int getIdLugar() {
		return idLugar;
	}
	/**
	 * @param idLugar idLugar a colocar
	 */
	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}
	/**
	 * @return lugarPadre
	 */
	public int getLugarPadre() {
		return lugarPadre;
	}
	/**
	 * @param lugarPadre lugarPadre a colocar
	 */
	public void setLugarPadre(int lugarPadre) {
		this.lugarPadre = lugarPadre;
	}
	/**
	 * @return nombreLugar
	 */
	public String getNombreLugar() {
		return nombreLugar;
	}
	/**
	 * @param nombreLugar nombreLugar a colocar
	 */
	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}	
}
