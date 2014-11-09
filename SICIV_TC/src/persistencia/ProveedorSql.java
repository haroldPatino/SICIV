/**
 * 
 */
package persistencia;

import logica.Proveedor;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 */
public class ProveedorSql {

	//Attributes-------------------------------
			//No son necesarios atributos
			
		//Building---------------------------------
			//No es necesario constructor
				
		//Methods----------------------------------
	
	public String selectProveedores(){
		return "SELECT * FROM PROVEEDOR;";
	}
	
	public String crearProveedor(Proveedor proveedor){
		return "INSERT INTO proveedor(ID_PROVEEDOR, "
				+ "ID_LUGAR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, "
				+ "DIRECCION_PROVEEDOR) "
				+ "VALUES ("+proveedor.getIdProveedor()+
				","+proveedor.getIdLugar()+
				",'"+proveedor.getNombreProveedor()+
				"',"+proveedor.getTelefonoProveedor()+
				",'"+proveedor.getDireccionProveedor()+"');";
	}
	
	public String buscarProveedorPorID(int idProveedor){
	return "SELECT * FROM PROVEEDOR WHERE ID_PROVEEDOR= "+idProveedor+";";	
	}
	
	public String actualizarDatosProveedor(Proveedor proveedor){
		return "UPDATE proveedor SET ID_LUGAR="+proveedor.getIdLugar()+
				", NOMBRE_PROVEEDOR='"+proveedor.getNombreProveedor()+
				"',TELEFONO_PROVEEDOR="+proveedor.getTelefonoProveedor()+
				", DIRECCION_PROVEEDOR='"+proveedor.getDireccionProveedor()+
				"' WHERE ID_PROVEEDOR="+proveedor.getIdProveedor()+";";
	}
	
	public String actualizarIdProveedor(String idAnterior, String idNuevo){
		return "UPDATE proveedor SET ID_PROVEEDOR= "+idNuevo+
				" WHERE ID_PROVEEDOR = "+idAnterior+";";
	}	
}