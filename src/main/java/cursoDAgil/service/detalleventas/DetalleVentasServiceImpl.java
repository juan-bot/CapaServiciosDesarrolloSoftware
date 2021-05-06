package cursoDAgil.service.detalleventas;

import java.io.Serializable;
import java.util.List;

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

}
