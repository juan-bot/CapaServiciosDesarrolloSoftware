package cursoDAgil.service.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.service.cliente.ClienteService;
import cursoDAgil.service.direccion.DireccionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ClienteServiceImplTest {

	@Inject
	ClienteService clienteService;
	@Inject
	DireccionService direccionService;
	
	@Test
	public void pruebaConsultarTodo(){
		try{
			List<Cliente> lista = clienteService.listarTodosClientes();
			assertEquals(lista.size(),lista.size());
		}catch (Exception e){
			System.out.println("Error" + e);
		}
	}
	@Ignore
	public void editarRegistro(){
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente=new HashMap<>();
		mapCliente.put("id", 2);
		try{
			System.out.println("Editar cliente");
			cliente.setId(2);
			cliente.setNombre("Daniel Enrique");
			cliente.setApellido("Guzmán Jiménez");
			cliente.setEmail("danielholosguzman@gmail.com");
			cliente.setSexo("Masculino");
			cliente.setIdDireccion(14);
			clienteService.editarCliente(cliente);
		}catch (Exception e){
			System.out.println("Error en editar cliente" + e);
		}
		
	}
	@Ignore
	public void nuevoCliente() {
		Cliente cliente = new Cliente();
		Direccion direccion= new Direccion();
		Map<String, Integer> mapDireccion= new HashMap<>();
		mapDireccion.put("idDireccion",3);
		System.out.println("Ingresa un nuevo cliente");
		try {
			cliente.setNombre("Luisa Andrea");
			cliente.setApellido("Morales García");
			cliente.setEmail("luisa.andrea126@gmail.com");
			cliente.setSexo("Femenino");
			direccion= direccionService.obtenerDireccionPorId(mapDireccion);
			cliente.setIdDireccion(direccion.getIdDireccion());
			cliente.setDireccion(direccion);
			System.out.println("entraa");
			clienteService.nuevoCliente(cliente);
		} catch (Exception e) {
			System.out.println("Error al crear cliente: " + e);
		}
	}
	@Ignore
	public void consultarClientePorId() {
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		mapCliente.put("id", 1);
		try {
			cliente = clienteService.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			System.out.println("Id: " + cliente.getId());
			System.out.println("Nombre: " + cliente.getNombre());
			System.out.println("Apellido: " + cliente.getApellido());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("idDireccion: " + cliente.getIdDireccion());
		} catch (Exception e) {
			System.out.println("Error en consultar cliente por id: " + e);
		}
	}

	
	@Ignore
	public void eliminarCliente(){
		Map<String, Integer> mapCliente=new HashMap<>();
		mapCliente.put("id", 5);
		try{
			clienteService.eliminarCliente(mapCliente);
		}catch (Exception e) {
				System.out.println("Error al eliminar cliente: " + e);
		}
	}
}
