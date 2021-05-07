package cursoDAgil.service.detalleventas;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.DetalleVentas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class DetalleVentasServiceImplTest {
	
	@Inject
	DetalleVentasService detalleVentasService;
	
	@Test
	public void pruebaConsultarTodo(){
		try{
			List<DetalleVentas> lista = detalleVentasService.listarTodasDetalleVentas();
			assertEquals(lista.size(),lista.size());
			for(DetalleVentas d: lista){
				System.out.println("ventaId: " + d.getVentaId());
				System.out.println("prodictoId: " +  d.getProductoId());
				System.out.println("cantidad: " + d.getCantidad());
			}
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

}
