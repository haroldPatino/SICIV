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
	private Producto producto;
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
	 * @return producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param producto producto a colocar
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
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
}
