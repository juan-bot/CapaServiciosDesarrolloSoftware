package cursoDAgil.service.ganancias;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.dao.ganancias.GananciasDao;

@Named
public class GananciaServiceImpl implements GananciaService, Serializable{

	private static final long serialVersionUID = -3685686332270475324L;
	
	@Inject
	GananciasDao gananciasDao;
	
	@Override
	public List<Ganancias> obtenerGanancias() {
		return gananciasDao.obtenerGanancias();
	}

	@Override
	public Integer nuevaGanancia(Ganancias ganancias) {
		return gananciasDao.nuevaGanancia(ganancias);
	}

	@Override
	public List<Ganancias> obtenerGananciasPorFecha(Map<String, String> mapGanancias) {
		return gananciasDao.obtenerGananciasPorFecha(mapGanancias);
	}

	@Override
	public Integer numberOfRows() {
		return gananciasDao.numberOfRows();
	}
}
