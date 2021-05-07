package cursoDAgil.service.detalleventas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.dao.detalleventas.DetalleVentasDao;

@Named
public class DetalleVentasServiceImpl implements DetalleVentasService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -145525830540465314L;
	
	@Inject
	DetalleVentasDao detalleVentasDao;

	@Override
	public List<DetalleVentas> listarTodasDetalleVentas() {
		return detalleVentasDao.listarTodasDetalleVentas();
	}

	@Override
	public Integer nuevoDetalleVenta(DetalleVentas detalleventas) {
		// TODO Auto-generated method stub
		return detalleVentasDao.nuevoDetalleVenta(detalleventas);
	}

	@Override
	public List<DetalleVentas> DetalleVentaPorId(Map<String, Integer> mapDetalle) {
		// TODO Auto-generated method stub
		return detalleVentasDao.DetalleVentaPorId(mapDetalle);
	}

}
