package cursoDAgil.service.marcas;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Marcas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class MarcasServiceImplTest {
	
	@Inject
	MarcasService marcasService;
	
	@Ignore
	public void pruebaConsultarTodo(){
		try{
			List<Marcas> lista = marcasService.listarTodasMarcas();
			assertEquals(lista.size(),5);
			for(Marcas m: lista){
				System.out.println("idMarca :" + m.getIdMarca());
				System.out.println("Nombre: " + m.getNombreMarca());
			}
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void pruebaConsultarPorId(){
		try{
			Map<String,Integer> mapMarcas = new HashMap<>();
			mapMarcas.put("idMarca", 2);
			Marcas dato = marcasService.listarMarcaPorId(mapMarcas);
			assertNotNull(dato);
			System.out.println("id: " + dato.getIdMarca());
			System.out.println("Nombre: " + dato.getNombreMarca());
		}catch(Exception e){ 
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void pruebaNuevaMarca(){
		Marcas marca = new Marcas();
		Integer aux;
		marca.setIdMarca(6);
		marca.setNombreMarca("Vans");
		aux = marcasService.nuevaMarca(marca);
		if(aux == 1){
			System.out.println("Marca insertada con exito");
		}
		else{
			System.out.println("Error al insertar marca");
		}
	}
	
	@Ignore
	public void pruebaEliminaMarca(){
		Map<String,Integer> mapMarcas = new HashMap<>();
		mapMarcas.put("idMarca", 6);
		Integer aux;
		aux = marcasService.eliminaMarca(mapMarcas);
		if(aux == 1){
			System.out.println("Marca eliminada con exito");
		}
		else{
			System.out.println("Error al eliminar marca");
		}
	}
	
	@Test
	public void pruebaActualizaMarca(){
		Marcas marca = new Marcas();
		Integer aux;
		marca.setIdMarca(5);
		marca.setNombreMarca("Vans");
		aux = marcasService.actualizaMarca(marca);
		if(aux == 1){
			System.out.println("Marca actualizada con exito");
		}
		else{
			System.out.println("Error al actualizar marca");
		}
	}

}
