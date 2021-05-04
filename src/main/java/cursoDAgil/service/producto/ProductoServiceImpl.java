package cursoDAgil.service.producto;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Productos;
import cursoDAgil.dao.productos.ProductosDao;

@Named
public class ProductoServiceImpl implements ProductoService, Serializable{

	private static final long serialVersionUID = -8882847581619198430L;
	
	@Inject
	ProductosDao productosDao;
	
	@Override
	public List<Productos> listarTodosProductos() {
		return productosDao.listarTodosProductos();
	}

	@Override
	public Productos listarProductosPorId(Map<String, Integer> mapProductos) {
		return productosDao.listarProductosPorId(mapProductos);
	}

	@Override
	public Integer nuevoProducto(Productos producto) {
		return productosDao.nuevoProducto(producto);
	}

	@Override
	public Integer eliminaProducto(Map<String, Integer> mapProductos) {
		return productosDao.eliminaProducto(mapProductos);
	}

	@Override
	public Integer actualizaProducto(Productos producto) {
		return productosDao.actualizaProducto(producto);
	}

}
