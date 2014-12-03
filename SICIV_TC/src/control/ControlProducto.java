/**
 * 
 */
package control;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import logica.Producto;
import logica.Proveedor;
import persistencia.ProductoDao;
import persistencia.ProveedorDao;

/**
 * @author Lenovo Pc
 *
 */
public class ControlProducto implements Serializable{
//Attributes-------------------------------------------------------------
	private static final long serialVersionUID = -2116310479639491793L;
	private String idProduct;
	private String nombreProduct;
	private String nombreProveedor;
	private String tipoproduct;
	private String marcaProduct;
	private String precioCompra;
	private String precioVenta;
	private ProductoDao dao;
//Building---------------------------------------------------------------
	public ControlProducto(){
		dao=new ProductoDao();
	}
//Methods----------------------------------------------------------------
	/**
	 * @return nombreProduct
	 */
	public String getNombreProduct() {
		return nombreProduct;
	}
	/**
	 * @return idProduct
	 */
	public String getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct idProduct a colocar
	 */
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @param nombreProduct nombreProduct a colocar
	 */
	public void setNombreProduct(String nombreProduct) {
		this.nombreProduct = nombreProduct;
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
	 * @return tipoproduct
	 */
	public String getTipoproduct() {
		return tipoproduct;
	}
	/**
	 * @param tipoproduct tipoproduct a colocar
	 */
	public void setTipoproduct(String tipoproduct) {
		this.tipoproduct = tipoproduct;
	}
	/**
	 * @return marcaProduct
	 */
	public String getMarcaProduct() {
		return marcaProduct;
	}
	/**
	 * @param marcaProduct marcaProduct a colocar
	 */
	public void setMarcaProduct(String marcaProduct) {
		this.marcaProduct = marcaProduct;
	}
	/**
	 * @return precioCompra
	 */
	public String getPrecioCompra() {
		return precioCompra;
	}
	/**
	 * @param precioCompra precioCompra a colocar
	 */
	public void setPrecioCompra(String precioCompra) {
		this.precioCompra = precioCompra;
	}
	/**
	 * @return precioVenta
	 */
	public String getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * @param precioVenta precioVenta a colocar
	 */
	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
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
	public ProductoDao getDao() {
		return dao;
	}
	public void agregarProducto(ActionEvent actionEvent){
	    FacesContext ctxtMsg = FacesContext.getCurrentInstance();
		if(idProduct!="" && nombreProduct!="" && nombreProveedor!="" && tipoproduct!="" && marcaProduct!="" && precioCompra!="" && precioVenta!=null){
			Producto product=new Producto();
			product.setIdProducto(Integer.parseInt(idProduct));
			product.setNombreProducto(nombreProduct);
			product.setIdProveedor(buscarProveedorName(nombreProveedor));
			product.setTipoProducto(tipoproduct);
			product.setMarcaProducto(marcaProduct);
			product.setPrecioCompra(Double.parseDouble(precioCompra));
			product.setPrecioVenta(Double.parseDouble(precioVenta));
			if(buscarProductoId(product.getIdProducto())==null){
				dao.insertarProducto(product);
				ctxtMsg.addMessage(null, new FacesMessage("Successful",  "Producto Agregado Exitosamente"));
			}
			else{
				ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El identificador del producto ya existe"));
			}			
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Alert",  "Existen campos vacios"));
		}
	}
	public int buscarProveedorName(String name){
		ArrayList<Proveedor> proveedores=new ArrayList<Proveedor>();
		ProveedorDao prover=new ProveedorDao();
		proveedores=prover.selecionarProveedores();
		for(int i=0;i<proveedores.size();i++){
			Proveedor aux=proveedores.get(i);
			if(aux.getNombreProveedor().toUpperCase().equals(name.toUpperCase())){
				return aux.getIdProveedor();
			}
		}
		return -1;
	}
	public Producto buscarProductoId(int id){
		ProductoDao daoProd=new ProductoDao();
		ArrayList<Producto> list=daoProd.selecionarProductos();
		for(int i=0;i<list.size();i++){
			Producto aux=list.get(i);
			if(aux.getIdProducto()==id){
				return aux;
			}
		}
		return null;
	}
	public List<String> completeProveedores(String text){
		ArrayList<Proveedor> proveedores=new ArrayList<Proveedor>();
		ProveedorDao prover=new ProveedorDao();
		proveedores=prover.selecionarProveedores();
		List<String> result=new ArrayList<String>();
		for(int i=0;i<proveedores.size();i++){
			if(proveedores.get(i).getNombreProveedor().toUpperCase().contains(text.toUpperCase())){
				result.add(proveedores.get(i).getNombreProveedor());
			}
		}
		return result;
	}
}
