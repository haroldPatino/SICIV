/**
 * 
 */
package control;

import java.util.ArrayList;

import persistencia.UsuarioDao;
import logica.Usuario;

/**
 * @author Lenovo Pc
 *
 */
public class GestionUsuarios {
//Attributes--------------------------------
	private ArrayList<Usuario> usuarios;
	private UsuarioDao dao;
//Building----------------------------------
	public GestionUsuarios(){
		dao=new UsuarioDao();
		usuarios=dao.cargaUsuarios();
	}
//Methods-----------------------------------
	/**
	 * @return usuarios
	 */
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	/**
	 * @return dao
	 */
	public UsuarioDao getDao() {
		return dao;
	}
}
