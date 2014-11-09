/**
 * 
 */
package logica;

/**
 * @author Harold Patiño
 *
 */
public class ProductoSerie {
//Attributes-----------------------------
	private String numeroSerie;
	private int idProducto;
	private int idFactura;
	private String estadoProducto;
//Methods--------------------------------
	/**
	 * 
	 */
	public ProductoSerie(){
		
	}
//Methods-------------------------------
	/**
	 * @return numeroSerie
	 */
	public String getNumeroSerie() {
		return numeroSerie;
	}
	/**
	 * @param numeroSerie numeroSerie a colocar
	 */
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}	
	/**
	 * @return idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto idProducto a colocar
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return estadoProducto
	 */
	public String getEstadoProducto() {
		return estadoProducto;
	}
	/**
	 * @param estadoProducto estadoProducto a colocar
	 */
	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}
	/**
	 * @return factura
	 */
	/**
	 * @return idFactura
	 */
	public int getIdFactura() {
		return idFactura;
	}
	/**
	 * @param idFactura idFactura a colocar
	 */
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
		
}
