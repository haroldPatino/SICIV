/**
 * 
 */
package control;

/**
 * @author Harold Pati�o
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
    		      ctxtMsg.addMessage(null, new FacesMessage("Alert",  "Usuario o contrase�a erroneos") );
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
    	ctxtMsg.addMessage(null, new FacesMessage("Alert",  "Usuario o contrase�a erroneos") );
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