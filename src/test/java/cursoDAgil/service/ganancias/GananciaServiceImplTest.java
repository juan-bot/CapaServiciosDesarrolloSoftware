package cursoDAgil.service.ganancias;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Ganancias;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class GananciaServiceImplTest {
	
	@Inject
	GananciaService gananciaService;
	
	@Test
	public void pruebaConsultarTodo() {
		int reg;
		List<Ganancias> lista;
		System.out.println("\nTest consultar todas las ganancias---");
		try{
			lista=gananciaService.obtenerGanancias();
			reg=lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
			
		}catch (Exception e) {
			System.out.println("error al consultar" + e);
		}
	}
	
	@Ignore
	public void obtenerGananciasPorFecha() {
		Ganancias ganancias = new Ganancias();
		Map<String, String> mapGanancias = new HashMap<>();
		System.out.println("\nTest obtener ganancia por fecha---");
		mapGanancias.put("fecha", "08/07/2019");
		
		List <Ganancias> lista = gananciaService.obtenerGananciasPorFecha(mapGanancias);
		int reg = lista.size();
		assertEquals(lista.size(), reg);
		System.out.println("TOTAL: "+ reg);
	}
	
	
	@Ignore
	public void nuevoRegistro() {
		Ganancias ganancia = new Ganancias();
		System.out.println("\nTest nuevo registro--");
		try {
			//ganancia.setIdGanancia(4);
			ganancia.setVentaId(3);
			ganancia.setTotalGanancia(11.2);
			ganancia.setFecha("28/17/2020");
			gananciaService.nuevaGanancia(ganancia);
		} catch (Exception e) {
			System.out.println("Error6: " + e);
		}
	}
}
