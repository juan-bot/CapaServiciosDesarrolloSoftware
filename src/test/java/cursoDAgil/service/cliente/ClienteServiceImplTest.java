package cursoDAgil.service.cliente;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ClienteServiceImplTest {
	
	@Inject
	ClienteService clienteService;
	
	@Test
	public void pruebaConsultarTodo() {
		System.out.println("Test consultar todos los clientes");
		try {
			List<Cliente> lista = clienteService.listarTodosClientes();
			assertEquals(lista.size(), 7);
			System.out.println("//------------------------------------");
		} catch (Exception e) {
			System.out.println("Error en consultar todos los clientes" + e);
		}
	}
}
