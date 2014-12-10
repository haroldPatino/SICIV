/**
 * 
 */
package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import logica.Producto;
import logica.ProductoSerie;
import persistencia.ProductoDao;
import persistencia.ProductoSerieDao;

/**
 * @author Harold Patiño
 *
 */
public class ControlSeries implements Serializable{

//Attributes---------------------------
	private static final long serialVersionUID = 6534302942046890092L;
	private String serial;
	private String serialCarga;
	private String nombreProducto;
	private String estadoProducto;
	private ProductoSerieDao dao;
//Building-----------------------------
	public ControlSeries(){
		dao=new ProductoSerieDao();
	}
//Methods------------------------------
	/**
	 * @return serial
	 */
	public String getSerial() {
		return serial;
	}
	/**
	 * @return serialCarga
	 */
	public String getSerialCarga() {
		return serialCarga;
	}

	/**
	 * @param serialCarga serialCarga a colocar
	 */
	public void setSerialCarga(String serialCarga) {
		this.serialCarga = serialCarga;
	}

	/**
	 * @param serial serial a colocar
	 */
	public void setSerial(String serial) {
		this.serial = serial;
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
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return dao
	 */
	public ProductoSerieDao getDao() {
		return dao;
	}
	public Producto buscarProductoName(String name){
		ProductoDao daoP=new ProductoDao();
		ArrayList<Producto> list=daoP.selecionarProductos();
		for(int i=0;i<list.size();i++){
			Producto aux=list.get(i);
			if(aux.getNombreProducto().toUpperCase().equals(name.toUpperCase())){
				return aux;
			}
		}
		return null;
	}
	public Producto buscarProductoId(int id){
		ProductoDao daoP=new ProductoDao();
		ArrayList<Producto> list=daoP.selecionarProductos();
		for(int i=0;i<list.size();i++){
			Producto aux=list.get(i);
			if(aux.getIdProducto()==id){
				return aux;
			}
		}
		return null;
	}
	public void agregarProducto(ActionEvent actionEvent){
	    FacesContext ctxtMsg = FacesContext.getCurrentInstance();
		if(serial!="" && nombreProducto!="" && estadoProducto!=""){
			ProductoSerie product=new ProductoSerie();
			product.setNumeroSerie(serial);
			product.setEstadoProducto(estadoProducto);
			product.setIdFactura(0);
			product.setIdProducto(buscarProductoName(nombreProducto).getIdProducto());
			if(buscarSerie(product.getNumeroSerie())==null){
				dao.insertarProductoSerie(product);
				ctxtMsg.addMessage(null, new FacesMessage("Successful",  "Producto Agregado Exitosamente"));
			}
			else{
				ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El producto ya esta existente en el inventario"));
			}
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Error",  "Existen campos vacios"));

		}
	}
	public void cargarSerial(ActionEvent actionEvent){
		System.out.println("------------------------Hola");
	    FacesContext ctxtMsg = FacesContext.getCurrentInstance();
	    ProductoSerie productSerie=buscarSerie(serialCarga);
	    if(productSerie!=null){
	    	serial=productSerie.getNumeroSerie();
	    	nombreProducto=buscarProductoId(productSerie.getIdProducto()).getNombreProducto();
	    	estadoProducto=manejoEstado(productSerie.getEstadoProducto());
			ctxtMsg.addMessage(null, new FacesMessage("Successfull",  "Carga exitosa"));
	    }
	    else{
			ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El producto no esta registrado"));
	    }
	}
	public void actualizarSerial(ActionEvent actionEvent){
	    FacesContext ctxtMsg = FacesContext.getCurrentInstance();
		if(serial!="" && nombreProducto!="" && estadoProducto!=""){
			ProductoSerie product=new ProductoSerie();
			product.setNumeroSerie(serial);
			product.setEstadoProducto(manejoEstadoInverso(estadoProducto));
			product.setIdFactura(0);
			product.setIdProducto(buscarProductoName(nombreProducto).getIdProducto());
			dao.cambiarEstadoProducto(product.getNumeroSerie(), product.getEstadoProducto());
			ctxtMsg.addMessage(null, new FacesMessage("Successful",  "Producto Actualizado Exitosamente"));
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Error",  "Existen campos vacios"));

		}
	}
	public ProductoSerie buscarSerie(String serie){
		ArrayList<ProductoSerie> series=dao.selecionarProductosSerie();
		for(int i=0;i<series.size();i++){
			if(series.get(i).getNumeroSerie().toUpperCase().equals(serie.toUpperCase())){
				return series.get(i);
			}
		}
		return null;
	}
	public void search(ActionEvent actionEvent){
	    FacesContext ctxtMsg = FacesContext.getCurrentInstance();
		if(serialCarga!=""){
			ProductoSerie product=buscarSerie(serialCarga);
			if(product!=null){
				String msg="ID Barras: "+product.getNumeroSerie()+"\n"
						+"Nombre Producto: "+buscarProductoId(product.getIdProducto()).getNombreProducto()+"\n"
						+"Precio Compra: "+buscarProductoId(product.getIdProducto()).getPrecioCompra()+"\n"
						+"Precio Venta: " +buscarProductoId(product.getIdProducto()).getPrecioVenta()+"\n"
						+"Estado: "+manejoEstado(product.getEstadoProducto());
				ctxtMsg.addMessage(null, new FacesMessage("Info System",  msg));
			}
			else{
				ctxtMsg.addMessage(null, new FacesMessage("Exception","No existe el producto en el inventario"));
			}
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Exception","Existen campos vacios"));
		}
	}
	public String manejoEstado(String est){
		if(est.equals("AC")){
			return "ACTIVO";
		}
		else if(est.equals("DV")){
			return "DEVUELTO";
		}
		else if(est.equals("EP")){
			return "EN PROCESO";
		}
		else if(est.equals("PE")){
			return "PENDIENTE";
		}
		else{
			return "VENDIDO";
		}
	}
	public String manejoEstadoInverso(String est){
		if(est.equals("ACTIVO")){
			return "AC";
		}
		else if(est.equals("DEVUELTO")){
			return "DV";
		}
		else if(est.equals("EN PROCESO")){
			return "EP";
		}
		else if(est.equals("PENDIENTE")){
			return "PE";
		}
		else{
			return "VD";
		}
	}
	public List<String> completeProductos(String text){
		ArrayList<String> list=new ArrayList<String>();
		list.add("ACTIVO");
		list.add("DEVUELTO");
		list.add("EN PROCESO");
		list.add("PENDIENTE");
		List<String> result=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).toUpperCase().contains(text.toUpperCase())){
				result.add(list.get(i));
			}
		}
		return result;
	}
}
