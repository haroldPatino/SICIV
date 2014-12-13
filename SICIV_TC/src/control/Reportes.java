/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import logica.Usuario;
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
import persistencia.UsuarioDao;

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
	private ReporteDao reporte = new ReporteDao();
	private UsuarioDao usuarioDao = new UsuarioDao();
	private Usuario usuario = new Usuario();
	
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
		usuario = usuarioDao.buscarPorCedula(factura.getIdUsuario());
		lugar = lugarDao.buscarLugarPorID(cliente.getIdLugar());
		mapaParametros.put("idFactura", factura.getNumeroFactura());
		mapaParametros.put("idCliente", cliente.getIdCliente());
		mapaParametros.put("nombreCliente", cliente.getNombreCliente()+" "+ cliente.getApellidosCliente());
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechAux=formato.format(factura.getFechaFactura());
		mapaParametros.put("fechaFactura", fechAux);
		mapaParametros.put("direccionCliente", cliente.getDireccionCliente());
		mapaParametros.put("nombreLugar", lugar.getNombreLugar());		
		mapaParametros.put("telefonoCliente", cliente.getTelefonoCliente());
		mapaParametros.put("totalFactura", valorTotalFactura(idFactura));
		mapaParametros.put("nicknameUsuario", usuario.getNickname());
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
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporte.consultarReporteInventario()));
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
	
	public void verReporteElementosVendidos(int mes, int anio){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteVendidos.jasper"));
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporte.consultarReporteElementosVendidos(mes, anio)));
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
	
	public void verReporteEnviadosLaboratorio(){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteEnviadoLaboratorio.jasper"));
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporte.consultarReporteEnviadosLaboratorio()));
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
	
	public void verReporteListoEntrega(){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteEntrega.jasper"));
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporte.consultarReporteListoEntrega()));
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
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporte.consultarReporteProveedores()));
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
	
	public void verReporteCumpleanos(){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteCumpleanos.jasper"));
//		byte[] bytes = null;
//		if (clienteDao.seleccionarCumpleaños().next()){
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporte.consultarReporteCumpleanos()));	
//		}else{
//			bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(null));
//		}		
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
	
	public void verReporteDefectuosos(){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteDefectuosos.jasper"));
//		byte[] bytes = null;
//		if (clienteDao.seleccionarCumpleaños().next()){
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporte.consultarReporteDefectuosos()));	
//		}else{
//			bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(null));
//		}		
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
	
	public void verReporteVentasMes(int numeroMes, int numeroAno){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteVentasMes.jasper"));//		
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), datosReporteMes(numeroMes, numeroAno), new JRResultSetDataSource(reporte.consultarReporteElementosVendidos(numeroMes, numeroAno)));			
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
	
	public void verReporteDevueltos(){
		try {
		File jasper=new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReporteDevueltos.jasper"));
		byte[] bytes=JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRResultSetDataSource(reporte.consultarReporteDevueltos()));	
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
	
	public String elementoMasVendido(int mes, int anio){
		
		ArrayList<String[]> listado = new ArrayList<String[]>();
		listado = reporte.consultarReporteVentasMesElemento(mes, anio);
		return listado.get(0)[0];
	}
	
	public String proveedorMasVendido(int mes, int anio){
		
		ArrayList<String[]> listado = new ArrayList<String[]>();
		listado = reporte.consultarReporteVentasMesProveedor(mes, anio);
		return listado.get(0)[1];
	}
	
	public double totalVendidoMes(int mes, int anio){
		
		ArrayList<String[]> listado = new ArrayList<String[]>();
		listado = reporte.consultarReporteVentasMesProveedor(mes, anio);
		double ventas = 0;
		for (int i=0;i<listado.size();i++){
			double aux =0;
			aux = Double.parseDouble(listado.get(i)[2]);
			ventas+=aux;
		}
		
		return ventas;
	}
	
	public HashMap<String, Object> datosReporteMes(int mes, int anio){
		
		HashMap<String, Object> mapaParametros = new HashMap<String, Object>();
		double diezmo = totalVendidoMes(mes, anio) * 0.10;
		double disponible = totalVendidoMes(mes, anio) - diezmo;
		
		mapaParametros.put("totalVendido", totalVendidoMes(mes, anio));
		mapaParametros.put("pagarDiezmo", diezmo);
		mapaParametros.put("totalDisponible", disponible);
		mapaParametros.put("productoMasVendido", elementoMasVendido(mes, anio));
		mapaParametros.put("proveedorMasVendido", proveedorMasVendido(mes, anio));
		mapaParametros.put("fechaReporte", ""+mes+" / "+ anio);
				
		return mapaParametros;
	}
}

