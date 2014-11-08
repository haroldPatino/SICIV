/**
 * 
 */
package control;

import java.util.ArrayList;

import persistencia.UsuarioDao;
import logica.Usuario;

/**
 * @author Harold Patiño
 *
 */
public class GestionUsuarios {
//Attributes--------------------------------
	private ArrayList<Usuario> usuarios;
	private UsuarioDao dao;
//Building----------------------------------
	public GestionUsuarios(){
		dao=new UsuarioDao();
		usuarios=dao.selecionarUsuarios();
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
