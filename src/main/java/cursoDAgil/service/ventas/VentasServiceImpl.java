package cursoDAgil.service.ventas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.dao.ventas.VentasDao;
@Named
public class VentasServiceImpl implements VentasService, Serializable{

	private static final long serialVersionUID = 8360377632018543321L;
	
	@Inject
	VentasDao ventasDao;
	
	@Override
	public List<Ventas> listarVentasTodo() {
		// TODO Auto-generated method stub
		return ventasDao.listarVentasTodo();
	}

	@Override
	public Integer nuevaVenta(Ventas venta) {
		// TODO Auto-generated method stub
		return ventasDao.nuevaVenta(venta);
	}

	@Override
	public List<Ventas> listarVentasPorCliente() {
		// TODO Auto-generated method stub
		return ventasDao.listarVentasPorCliente();
	}

	@Override
	public List<Ventas> ListarDetalleVenta() {
		// TODO Auto-generated method stub
		return ventasDao.ListarDetalleVenta();
	}

	@Override
	public List<Ventas> obtenerVentaPorClienteId(Map<String, Integer> mapVentas) {
		// TODO Auto-generated method stub
		return ventasDao.obtenerVentaPorClienteId(mapVentas);
	}

	@Override
	public Integer actualizaVenta(Ventas venta) {
		// TODO Auto-generated method stub
		return ventasDao.actualizaVenta(venta);
	}

}
