/**
 * 
 */
package logica;

import java.util.ArrayList;

/**
 * @author Victor Rojas
 *
 */
public class ReporteElementosFactura {

	//Attributes body----------------------------------
	
	private String nombreProducto;
	private double precioVenta;
	private String numeroSerie;
	private String marcaProducto;
	//Methods-------------------------------
	
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
	
	
}
