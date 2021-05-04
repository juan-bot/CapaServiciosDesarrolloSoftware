package cursoDAgil.service.producto;

import java.util.List;
import java.util.Map;


import cursoDAgil.bd.domain.Productos;
public interface ProductoService {
	List<Productos> listarTodosProductos();
	Productos listarProductosPorId(Map<String, Integer> mapProductos);
	Integer nuevoProducto(Productos producto);
	Integer eliminaProducto(Map<String, Integer> mapProductos);
	Integer actualizaProducto(Productos producto);
}
