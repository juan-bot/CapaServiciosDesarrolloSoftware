package cursoDAgil.service.direccion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.dao.direccion.DireccionDao;

@Named
public class DireccionServiceImpl implements DireccionService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	DireccionDao direccionDao;

	@Override
	public List<Direccion> obtenerDirecciones() {
		return direccionDao.obtenerDirecciones();
	}

	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		return direccionDao.nuevaDireccionCliente(direccion);
	}

	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion) {
		return direccionDao.obtenerDireccionPorId(mapDireccion);
	}

	@Override
	public Integer eliminarDireccion(Map<String, Integer> mapDireccion) {
		return direccionDao.eliminarDireccion(mapDireccion);
	}

	@Override
	public Integer editarDireccion(Direccion direccion) {
		return direccionDao.editarDireccion(direccion);
	}
}
