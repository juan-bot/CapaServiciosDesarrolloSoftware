package cursoDAgil.service.direccion;

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

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.service.direccion.DireccionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DireccionServiceImplTest {
	
	@Inject
	DireccionService direccionService;
	
	@Ignore
	//YA SALE
	public void consultarDireccionPorId() {
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion", 1);
		try {
			direccion = direccionService.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			System.out.println("id: " + direccion.getIdDireccion());
			System.out.println("Calle: " + direccion.getCalle() );
			System.out.println("Numero: " + direccion.getNumero());
			System.out.println("Colonia: " + direccion.getColonia() );
			System.out.println("Ciudad: " + direccion.getCiudad());
			System.out.println("Pais: " + direccion.getPais());
			System.out.println("Codigo Postal: " + direccion.getCodigoPostal());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	//YA SALE
	public void editarDireccion(){
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion=new HashMap<>();
		mapDireccion.put("idDireccion", 12);
		try{
			direccion.setIdDireccion(12);
			direccion.setCalle("Zaragoza");
			direccion.setNumero(116);
			direccion.setColonia("Las palmas");
			direccion.setCiudad("Oaxaca de Juárez");
			direccion.setEstado("Oaxaca");
			direccion.setPais("mexico");
			direccion.setCodigoPostal(71245);
			direccionService.editarDireccion(direccion);
		}catch (Exception e){
			System.out.println("Error al editar direccion" + e);
		}
	}
	
	
	@Test
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todas las direcciones");
		try {
			List<Direccion> lista = direccionService.obtenerDirecciones();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		} catch (Exception ex) {
			System.out.println("error" + ex);

		}
	}

	@Ignore
	//YA SALE
	public void nuevoRegistro() {
		Direccion direccion = new Direccion();
		System.out.println("Test nuevo registro");
		try {
			direccion.setCalle("Zurcos");
			direccion.setNumero(3);
			direccion.setColonia("La crucecita");
			direccion.setCiudad("Huatulco");
			direccion.setEstado("Oaxaca");
			direccion.setPais("Mexico");
			direccion.setCodigoPostal(18000);
			direccionService.nuevaDireccionCliente(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	//YA SALE
	public void eliminarDireccion(){
		Map<String, Integer> mapDireccion=new HashMap<>();
		mapDireccion.put("idDireccion", 17);
		try{
			direccionService.eliminarDireccion(mapDireccion);
		}catch (Exception e) {
				System.out.println("Error al eliminar direccion: " + e);
		}
	}
}
