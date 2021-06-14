package cursoDAgil.service.cliente;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Cliente;

public interface ClienteService {
	List<Cliente> listarTodosClientes();
	Integer nuevoCliente(Cliente cliente);
	Integer editarCliente(Cliente cliente);
	Cliente obtenerClientePorId(Map<String, Integer> mapCliente);
	Integer eliminarCliente(Map<String, Integer> mapCliente);
	Integer numberOfRows();
}
