/**
 * 
 */
package persistencia;

import logica.ProductoSerie;

/**
 * @author Harold Patiño
 * @author Victor Rojas
 *
 */
public class ProductoSerieSql {

	public String crearProductoSerie(ProductoSerie producto){
		return "INSERT INTO `siciv`.`producto_serie` (`NUM_SERIE`, `ID_PRODUCTO`, `NUMERO_FACTURA`, `ESTADO`) VALUES ('"+producto.getNumeroSerie()+"', '"+producto.getIdProducto()+"', '"+producto.getIdFactura()+"', '"+producto.getEstadoProducto()+"');";
	}
	
	public String SelectProductosSeriePorNumFactura(int numeroFactura){
		return "SELECT * FROM producto_serie WHERE NUMERO_FACTURA = "+numeroFactura+";";
	}
	
	public String selectProductosSerie(){
		return "SELECT * FROM producto_serie;";
	}
	
	public String cambiarEstadoProduucto(String idProducto, String estado){
		return "UPDATE `siciv`.`producto_serie` SET ESTADO= '"+estado
				+"' WHERE NUM_SERIE = '"+idProducto+"';";		
	}
	
	public String actualizarDatosProductoSerie(ProductoSerie producto){
		return "UPDATE producto_serie SET ID_PRODUCTO= '"+producto.getIdProducto()
				+"', NUMERO_FACTURA='"+producto.getIdFactura()
				+"', ESTADO='"+producto.getEstadoProducto()
				+"' WHERE NUM_SERIE='"+producto.getNumeroSerie()+"';";
	}
	
	public String actualizarNumSerieProducto(String serieAnterior
			, String serieNuevo){
		return "UPDATE producto_serie SET NUM_SERIE="+serieNuevo
				+" WHERE NUM_SERIE="+serieAnterior+";";
	}
	
}
