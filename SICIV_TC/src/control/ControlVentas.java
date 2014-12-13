/**
 * 
 */
package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sun.xml.internal.bind.v2.util.FatalAdapter;

import persistencia.FacturaVentaDao;
import persistencia.ProductoSerieDao;
import logica.FacturaVenta;
import logica.ProductoSerie;

/**
 * @author Lenovo Pc
 *
 */
public class ControlVentas implements Serializable{
//Attributes--------------------------------------------------------------
	private static final long serialVersionUID = 5098230490560839321L;
	private String numFactura;
	private String numCliente;
	private String numVendedor;
	private ArrayList<ProductoSerie> productos;
	private String idProducto;
	private FacturaVentaDao dao;
//Building----------------------------------------------------------------
	public ControlVentas(){
		dao=new FacturaVentaDao();
		productos=new ArrayList<ProductoSerie>();
	}
//Methods-----------------------------------------------------------------
	/**
	 * @return numFactura
	 */
	public String getNumFactura() {
		return numFactura;
	}
	/**
	 * @param numFactura numFactura a colocar
	 */
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	/**
	 * @return numCliente
	 */
	public String getNumCliente() {
		return numCliente;
	}
	/**
	 * @param numCliente numCliente a colocar
	 */
	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}
	/**
	 * @return numVendedor
	 */
	public String getNumVendedor() {
		return numVendedor;
	}
	/**
	 * @param numVendedor numVendedor a colocar
	 */
	public void setNumVendedor(String numVendedor) {
		this.numVendedor = numVendedor;
	}
	/**
	 * @return idProducto
	 */
	public String getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto idProducto a colocar
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return productos
	 */
	public ArrayList<ProductoSerie> getProductos() {
		return productos;
	}
	/**
	 * @return dao
	 */
	public FacturaVentaDao getDao() {
		return dao;
	}
	public void cargarProducto(ActionEvent actionEvent){
		FacesContext ctxtMsg = FacesContext.getCurrentInstance();
		if(idProducto!=""){
			ProductoSerie product=buscarSerie(idProducto);
			if(product!=null){
				if(buscarEnProductos(idProducto)==null){
					productos.add(product);
					ctxtMsg.addMessage(null, new FacesMessage("Sucessfull",  "Producto Agregado al carrito"));
				}
				else{
					ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El producto ya esta en el carrito"));
				}
			}
			else{
				ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El producto no esta en el inventario"));

			}
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Error",  "Existen campos vacios"));
		}
	}
	public ProductoSerie buscarEnProductos(String serie){
		for(int i=0;i<productos.size();i++){
			if(productos.get(i).getNumeroSerie().equals(serie)){
				return productos.get(i);
			}
		}
		return null;
	}
	public void generarFactura(ActionEvent actionEvent){
		FacesContext ctxtMsg = FacesContext.getCurrentInstance();
		ProductoSerieDao daoS=new ProductoSerieDao();
		Reportes reportes=new Reportes();
		if(numFactura!=null && numFactura!="" && productos.size()>0){
			FacturaVenta factura=new FacturaVenta();
			factura.setIdCliente(Integer.parseInt(numCliente));
			factura.setIdUsuario(Integer.parseInt(numVendedor));
			factura.setEstadoFactura("VD");
			Date date=new Date();
			factura.setFechaFactura(date);
			factura.setNumeroFactura(Integer.parseInt(numFactura));
			dao.insertarFactura(factura);
			for(int i=0;i<productos.size();i++){
				ProductoSerie aux=productos.get(i);
				aux.setIdFactura(factura.getNumeroFactura());
				aux.setEstadoProducto("VD");
				daoS.actualizarDatosProductoSerie(aux);
			}
			reportes.verReporteFactura(factura.getNumeroFactura());
		}
		else{
			
		}
	}
	public ProductoSerie buscarSerie(String serie){
		ProductoSerieDao daoS=new ProductoSerieDao();
		ArrayList<ProductoSerie> series=daoS.selecionarProductosSerie();
		for(int i=0;i<series.size();i++){
			if(series.get(i).getNumeroSerie().toUpperCase().equals(serie.toUpperCase())){
				return series.get(i);
			}
		}
		return null;
	}
}
