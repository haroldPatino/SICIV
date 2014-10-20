/**
 * 
 */
package logica;

/**
 * @author Harold Patiño
 *
 */
public class Proveedor {
//Attributes------------------------------------
	private int idProveedor;
	private int idLugar;
	private String nombreProveedor;
	private int telefonoProveedor;
	private String direccionProveedor;
//Building--------------------------------------
	/**
	 * 
	 */
	public Proveedor(){
		
	}
//Methods--------------------------------------
	/**
	 * @return idProveedor
	 */
	public int getIdProveedor() {
		return idProveedor;
	}
	/**
	 * @param idProveedor idProveedor a colocar
	 */
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
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
	 * @return nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	/**
	 * @param nombreProveedor nombreProveedor a colocar
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	/**
	 * @return telefonoProveedor
	 */
	public int getTelefonoProveedor() {
		return telefonoProveedor;
	}
	/**
	 * @param telefonoProveedor telefonoProveedor a colocar
	 */
	public void setTelefonoProveedor(int telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}
	/**
	 * @return direccionProveedor
	 */
	public String getDireccionProveedor() {
		return direccionProveedor;
	}
	/**
	 * @param direccionProveedor direccionProveedor a colocar
	 */
	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}
}
