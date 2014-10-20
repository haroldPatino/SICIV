/**
 * 
 */
package logica;

/**
 * @author Harold Patiño
 *
 */
public class Producto {
//Attributes------------------------------------
	private int idProducto;
	private Proveedor proveedor;
	private String nombreProducto;
	private String tipoProducto;
	private String marcaProducto;
	private double precioCompra;
	private double precioVenta;
//Building-------------------------------------
	/**
	 * 
	 */
	public Producto(){
		
	}
//Methods--------------------------------------
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
	 * @return proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}
	/**
	 * @param proveedor proveedor a colocar
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	/**
	 * @return nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto nombreProducto a colocar
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}
	/**
	 * @param tipoProducto tipoProducto a colocar
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	/**
	 * @return marcaProducto
	 */
	public String getMarcaProducto() {
		return marcaProducto;
	}
	/**
	 * @param marcaProducto marcaProducto a colocar
	 */
	public void setMarcaProducto(String marcaProducto) {
		this.marcaProducto = marcaProducto;
	}
	/**
	 * @return precioCompra
	 */
	public double getPrecioCompra() {
		return precioCompra;
	}
	/**
	 * @param precioCompra precioCompra a colocar
	 */
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	/**
	 * @return precioVenta
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * @param precioVenta precioVenta a colocar
	 */
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
}
