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

import logica.Lugar;
import logica.Proveedor;
import persistencia.LugarDao;
import persistencia.ProveedorDao;

/**
 * @author Harold Patiño
 *
 */
public class ControlProveedores implements Serializable{
//Attributes------------------------------------------------------------
	private static final long serialVersionUID = -5501620774484969553L;
	private String idProveedor;
	private String lugarUbicacion;
	private String nombreProveedor;
	private String telProveedor;
	private String dirProveedor;
	private ProveedorDao dao;
//Building--------------------------------------------------------------
	public ControlProveedores(){
		dao=new ProveedorDao();
	}
//Methods---------------------------------------------------------------
	/**
	 * @return idProveedor
	 */
	public String getIdProveedor() {
		return idProveedor;
	}
	/**
	 * @param idProveedor idProveedor a colocar
	 */
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	/**
	 * @return lugarUbicacion
	 */
	public String getLugarUbicacion() {
		return lugarUbicacion;
	}
	/**
	 * @param lugarUbicacion lugarUbicacion a colocar
	 */
	public void setLugarUbicacion(String lugarUbicacion) {
		this.lugarUbicacion = lugarUbicacion;
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
	 * @return telProveedor
	 */
	public String getTelProveedor() {
		return telProveedor;
	}
	/**
	 * @param telProveedor telProveedor a colocar
	 */
	public void setTelProveedor(String telProveedor) {
		this.telProveedor = telProveedor;
	}
	/**
	 * @return dirProveedor
	 */
	public String getDirProveedor() {
		return dirProveedor;
	}
	/**
	 * @param dirProveedor dirProveedor a colocar
	 */
	public void setDirProveedor(String dirProveedor) {
		this.dirProveedor = dirProveedor;
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
	public ProveedorDao getDao() {
		return dao;
	}
	public void agregarProveedor(ActionEvent actionEvent){
		FacesContext ctxtMsg = FacesContext.getCurrentInstance();
		if(idProveedor!="" && lugarUbicacion!="" && nombreProveedor!="" && telProveedor!="" && dirProveedor!=""){
			Proveedor proveedor=new Proveedor();
			proveedor.setIdProveedor(Integer.parseInt(idProveedor));
			proveedor.setIdLugar(buscarLugarNombre(lugarUbicacion));
			proveedor.setNombreProveedor(nombreProveedor.toUpperCase());
			proveedor.setTelefonoProveedor(telProveedor);
			proveedor.setDireccionProveedor(dirProveedor.toUpperCase());
			if(buscarProveedorId(proveedor.getIdProveedor())==null){
				dao.insertarProveedor(proveedor);
				ctxtMsg.addMessage(null, new FacesMessage("Sucessfull",  "Proveedor Insertado Exitosamente"));
			}
			else{
				ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El id del proveedor ya esta registrado"));
			}
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Alert",  "Existen campos obligatorios vacios"));
		}
	}
	public List<String> completeLugares(String text){
		ArrayList<Lugar> lugares=new ArrayList<Lugar>();
		LugarDao lugar=new LugarDao();
		lugares=lugar.seleccionarLugares();
		List<String> result=new ArrayList<String>();
		for(int i=0;i<lugares.size();i++){
			if(lugares.get(i).getNombreLugar().toUpperCase().contains(text.toUpperCase())){
				result.add(lugares.get(i).getNombreLugar());
			}
		}
		return result;
	}
	public int buscarLugarNombre(String nombreLugar){
		LugarDao daoLug=new LugarDao();
		ArrayList<Lugar> lugares=daoLug.seleccionarLugares();
		for(int i=0;i<lugares.size();i++){
			Lugar aux=lugares.get(i);
			if(aux.getNombreLugar().toUpperCase().equals(nombreLugar.toUpperCase())){
				return aux.getIdLugar();
			}
		}
		return -1;
	}
	public Proveedor buscarProveedorId(int idProveedor){
		ArrayList<Proveedor> prover=dao.selecionarProveedores();
		for(int i=0;i<prover.size();i++){
			if(prover.get(i).getIdProveedor()==idProveedor){
				return prover.get(i);
			}
		}
		return null;
	}
}
