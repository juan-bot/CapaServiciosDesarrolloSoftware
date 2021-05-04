package cursoDAgil.service.cliente;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.dao.cliente.ClienteDao;

@Named
public class ClienteServiceImpl implements ClienteService, Serializable{

	private static final long serialVersionUID = 7962397593863792875L;

	@Inject
	ClienteDao clienteDao;
	
	@Override
	public List<Cliente> listarTodosClientes() {
		return clienteDao.listarTodosClientes();
	}

}
