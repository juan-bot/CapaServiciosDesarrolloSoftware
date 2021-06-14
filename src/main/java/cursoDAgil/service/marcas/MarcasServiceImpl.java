package cursoDAgil.service.marcas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.dao.marcas.MarcasDao;

@Named
public class MarcasServiceImpl implements MarcasService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -667396859277789262L;
	
	@Inject
	MarcasDao marcasDao;

	@Override
	public List<Marcas> listarTodasMarcas() {
		return marcasDao.listarTodasMarcas();
	}

	@Override
	public Marcas listarMarcaPorId(Map<String, Integer> mapMarcas) {
		return marcasDao.listarMarcaPorId(mapMarcas);
	}

	@Override
	public Integer nuevaMarca(Marcas marca) {
		return marcasDao.nuevaMarca(marca);
	}

	@Override
	public Integer eliminaMarca(Map<String, Integer> mapMarcas) {
		return marcasDao.eliminaMarca(mapMarcas);
	}

	@Override
	public Integer actualizaMarca(Marcas marca) {
		return marcasDao.actualizaMarca(marca);
	}
	
	@Override
	public Integer numberOfRows() {
		return marcasDao.numberOfRows();
	}
}
