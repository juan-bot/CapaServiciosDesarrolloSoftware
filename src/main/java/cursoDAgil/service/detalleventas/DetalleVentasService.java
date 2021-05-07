package cursoDAgil.service.detalleventas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasService {
	List<DetalleVentas> listarTodasDetalleVentas();
	Integer nuevoDetalleVenta(DetalleVentas detalleventas);
	List<DetalleVentas> DetalleVentaPorId(Map<String, Integer> mapDetalle);
}
