/**
 * 
 */
package control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import logica.Cliente;
import logica.FacturaVenta;
import logica.Lugar;
import logica.Producto;
import logica.ProductoSerie;
import logica.ReporteElementosFactura;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import persistencia.ClienteDao;
import persistencia.FacturaVentaDao;
import persistencia.LugarDao;
import persistencia.ProductoDao;
import persistencia.ProductoSerieDao;
import persistencia.ReporteDao;

/**
 * @author Victor Rojas
 *
 */

@ManagedBean
@RequestScoped
public class Reportes {

	private FacturaVenta factura = new FacturaVenta();
	private Cliente cliente = new Cliente();
	private ClienteDao clienteDao = new ClienteDao();
	private Lugar lugar = new Lugar();
	private LugarDao lugarDao = new LugarDao();
	private FacturaVentaDao facturaDao = new FacturaVentaDao();	
	private ProductoSerie serieProducto = new ProductoSerie();
	private ProductoSerieDao serieDao = new ProductoSerieDao();	
	private ProductoDao productoDao = new ProductoDao();	
	private ReporteDao reporteFactura = new ReporteDao();
	
	public ArrayList<ReporteElementosFactura> listadoElementosFactura(int idFactura){
		factura = facturaDao.buscarFacturaPorNumero(idFactura); 
		ArrayList<ProductoSerie> listProductosSerie = serieDao.selecionarPorNumeroFactura(idFactura);
		ArrayList<ReporteElementosFactura> resultado = new ArrayList<ReporteElementosFactura>();
				
		for (int i=0; i<listProductosSerie.size();i++){
			ReporteElementosFactura elementosFactura = new ReporteElementosFactura();
			Producto producto = new Producto();
			producto = productoDao.buscarProductoPorId(listProductosSerie.get(i).getIdProducto());
			elementosFactura.setNombreProducto(producto.getNombreProducto());
			elementosFactura.setNumeroSerie(listProductosSerie.get(i).getNumeroSerie());
			elementosFactura.setPrecioVenta(producto.getPrecioVenta());
			elementosFactura.setMarcaProducto(producto.getMarcaProducto());
			resultado.add(elementosFactura);
		}		
		return resultado;
	}
	
	
	public Map<String, Object> datosFactura(int idFactura){
		HashMap<String, Object> mapaParametros = new HashMap<String, Object>();
		factura = facturaDao.buscarFacturaPorNumero(idFactura);
		cliente = clienteDao.buscarClientePorCedula(factura.getIdCliente());
		lugar = lugarDao.buscarLugarPorID(cliente.getIdLugar());
		mapaParametros.put("idFactura", factura.getNumeroFactura());
		mapaParametros.put("idCliente", cliente.getIdCliente());
		mapaParametros.put("nombreCliente", cliente.getNombreCliente()+" "+ cliente.getApellidosCliente());
		mapaParametros.put("fechaFactura", factura.getFechaFactura().getTime());
		mapaParametros.put("direccionCliente", cliente.getDireccionCliente());
		mapaParametros.put("nombreLugar", lugar.getNombreLugar());		
		mapaParametros.put("telefonoCliente", cliente.getTelefonoCliente());
		mapaParametros.put("totalFactura", valorTotalFactura(idFactura));
		return mapaParametros;
	}
	
	public double valorTotalFactura(int idFacturaV){
		ArrayList<ReporteElementosFactura> elementos = listadoElementosFactura(idFacturaV);
		double resultado =0;
		for (int i=0;i<elementos.size();i++){
			resultado += elementos.get(i).getPrecioVenta();
		}		
		return resultado;
	}
	
	public void verReporteFactura(int idFactura){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteFactura.jasper"));
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), this.datosFactura(idFactura), new JRBeanCollectionDataSource(this.listadoElementosFactura(idFactura)));
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream stream=response.getOutputStream();
		stream.write(bytes,0,bytes.length);
		stream.flush();
		stream.close();		
		FacesContext.getCurrentInstance().responseComplete();		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void verReporteInventario(){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteInventario.jasper"));
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporteFactura.consultarReporteInventario()));
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream stream=response.getOutputStream();
		stream.write(bytes,0,bytes.length);
		stream.flush();
		stream.close();		
		FacesContext.getCurrentInstance().responseComplete();		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void verReporteLugares(){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteLugares.jasper"));
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporteFactura.consultarReporteLugares()));
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream stream=response.getOutputStream();
		stream.write(bytes,0,bytes.length);
		stream.flush();
		stream.close();		
		FacesContext.getCurrentInstance().responseComplete();		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void verReporteProveedores(){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteProveedores.jasper"));
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporteFactura.consultarReporteProveedores()));
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream stream=response.getOutputStream();
		stream.write(bytes,0,bytes.length);
		stream.flush();
		stream.close();		
		FacesContext.getCurrentInstance().responseComplete();		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
