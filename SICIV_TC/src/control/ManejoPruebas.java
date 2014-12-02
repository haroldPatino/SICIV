/**
 * 
 */
package control;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Lenovo Pc
 *
 */
public class ManejoPruebas implements Serializable{
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = -1782292001916066785L;
	public ManejoPruebas(){
		
	}
	public void prueba(){
	    FacesContext ctxtMsg = FacesContext.getCurrentInstance();
	    ctxtMsg.addMessage(null, new FacesMessage("Successful",  "Producto Agregado Exitosamente") );
	  }
}
