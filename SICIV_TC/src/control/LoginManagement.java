/**
 * 
 */
package control;

/**
 * @author Harold Patiño
 *
 */
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import logica.Usuario;

import org.primefaces.context.RequestContext;

import persistencia.UsuarioDao;

public class LoginManagement implements Serializable {
//Attributes------------------------------------------------------------
  private static final long serialVersionUID = -2152389656664659476L;
  private String nombre;
  private String clave;
  private boolean logeado = false;
  private UsuarioDao dao;
  private String oldPass;
  private String newPass;
  private String confPass;
//Methods---------------------------------------------------------------
  public boolean estaLogeado() {
    return logeado;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }
  /**
 * @return oldPass
 */
public String getOldPass() {
	return oldPass;
}

/**
 * @param oldPass oldPass a colocar
 */
public void setOldPass(String oldPass) {
	this.oldPass = oldPass;
}

/**
 * @return newPass
 */
public String getNewPass() {
	return newPass;
}

/**
 * @param newPass newPass a colocar
 */
public void setNewPass(String newPass) {
	this.newPass = newPass;
}

/**
 * @return confPass
 */
public String getConfPass() {
	return confPass;
}

/**
 * @param confPass confPass a colocar
 */
public void setConfPass(String confPass) {
	this.confPass = confPass;
}

public void login(ActionEvent actionEvent) {
    RequestContext context = RequestContext.getCurrentInstance();
    FacesContext ctxtMsg = FacesContext.getCurrentInstance();
    dao=new UsuarioDao();
    Usuario user= buscarUser(nombre);
    if(user!=null){
    	 if (nombre != null && nombre.equals(user.getNickname()) && clave != null
    		        && clave.equals(user.getContrasena())) {
    		      logeado = true;
    		      ctxtMsg.addMessage(null, new FacesMessage("Successful",  "Bienvenid@ " + user.getNombreUsuario()) );
    		    } else {
    		      logeado = false;
    		      ctxtMsg.addMessage(null, new FacesMessage("Alert",  "Usuario o contraseña erroneos") );
    		    }
    		    context.addCallbackParam("estaLogeado", logeado);
    		    if (logeado){
    		    	if(user.getTipoUsuario()=='A'){
    		    		context.addCallbackParam("view", "employee.xhtml");
    		    	}
    		    	if(user.getTipoUsuario()=='G'){
    		    		context.addCallbackParam("view", "boss.xhtml");
    		    	}
    		    }
    }
    else{
    	logeado = false;
    	ctxtMsg.addMessage(null, new FacesMessage("Alert",  "Usuario o contraseña erroneos") );
    }
    		      
  }
  public Usuario buscarUser(String nickname){
	  ArrayList<Usuario> usuarios=dao.selecionarUsuarios();
	  for(int i=0;i<usuarios.size();i++){
		  if(usuarios.get(i).getNickname().equals(nickname)){
			  return usuarios.get(i);
		  }
	  }
	  return null;
  }
  public void logout(ActionEvent actionEvent) {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    session.invalidate();
    logeado = false;
  }
  public void cambiarContrasena(ActionEvent actionEvent){
	  FacesContext ctxtMsg = FacesContext.getCurrentInstance();
	  ControlEmpleados control=new ControlEmpleados();
		String docContra=String.valueOf(control.buscarEmpleadoNickname(nombre).getIdUsuario());
		if(newPass!="" && docContra!="" && docContra!=null && oldPass!=""){
			Usuario user=control.buscarEmpleadoId(Integer.parseInt(docContra));
			if(user!=null){
				if(oldPass.equals(user.getContrasena())){
					if(confPass.equals(newPass)){
						user.setContrasena(newPass);
						dao.cambiarContrasena(user.getIdUsuario(), oldPass, newPass);
						ctxtMsg.addMessage(null, new FacesMessage("Successful",  "Contraseña Actualizada Exitosamente"));
					}
					else{
						ctxtMsg.addMessage(null, new FacesMessage("Exception",  "Los campos de la nueva contraseña no coinciden"));
					}
				}else{
					ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El password Actual no coincide"));
				}
			}
			else{
				ctxtMsg.addMessage(null, new FacesMessage("Exception",  "El documento del usuario no existe"));
			}
		}
		else{
			ctxtMsg.addMessage(null, new FacesMessage("Exception",  "Existen campos obligatorios vacios"));

		}
  }
/**
 * @return the serialversionuid
 */
public static long getSerialversionuid() {
	return serialVersionUID;
}

/**
 * @return the dao
 */
public UsuarioDao getDao() {
	return dao;
}
  
}