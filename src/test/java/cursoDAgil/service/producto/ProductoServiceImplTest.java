package cursoDAgil.service.producto;

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

import cursoDAgil.bd.domain.Productos;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProductoServiceImplTest {
	
	@Inject
	ProductoService productoService;
	
	@Test
	public void pruebaConsultarTodo(){
		System.out.println("Test consultar todos los productos----");
		try{
			List<Productos> lista = productoService.listarTodosProductos();
			assertEquals(lista.size(),lista.size());
		}catch (Exception e){
			System.out.println("Error1: " +e);
		}
	}
	
	@Test
	public void pruebaConsultarProductosPorId(){
		Productos producto = new Productos();
		Map<String, Integer> mapProductos = new HashMap<>();
		mapProductos.put("idProducto", 2);
		System.out.println("Test consultar producto por id-----");
		try{
			producto = productoService.listarProductosPorId(mapProductos);
			assertNotNull(producto);
			System.out.println("idProducto: "+ producto.getIdProducto());
			System.out.println("nombre: "+ producto.getNombre());
			System.out.println("precio: "+ producto.getPrecio());
			System.out.println("precioVta: "+ producto.getPrecioVta());
			System.out.println("cantidad: "+ producto.getCantidad());
			System.out.println("marcaId: "+ producto.getMarcaId());
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	@Test
	public void pruebaNuevoProducto(){
		Productos producto = new Productos();
		Integer aux;
		System.out.println("Test nuevo producto------");
		//producto.setIdProducto(3);
		producto.setNombre("carro");
		producto.setPrecio(23.34);
		producto.setPrecioVta(45.2);
		producto.setCantidad(4);
		producto.setMarcaId(2);
		aux =productoService.nuevoProducto(producto);
		if (aux == 1)
			System.out.println("Producto agregado con exito");
		else
			System.out.println("Error al agregar producto");
	}
	
	@Ignore
	public void eliminaProducto(){
		Map<String, Integer> mapProductos = new HashMap<>();
		Integer aux;
		mapProductos.put("idProducto", 3);
		try{
			aux=productoService.eliminaProducto(mapProductos);
			if(aux == 1){
				System.out.println("Producto eliminado con exito");
			}
			else{
				System.out.println("Error al elimnar producto");
			}
		}catch(Exception e){
			System.out.println("Error:" + e);
		}
	}
	
	@Test
	public void actualizaProducto(){
		Integer aux;
		Productos producto = new Productos();
		producto.setIdProducto(2);
		producto.setNombre("telefono");
		producto.setPrecio(33.2);
		producto.setPrecioVta(45.2);
		producto.setCantidad(56);
		producto.setMarcaId(1);
		System.out.println("Test actualizar producto----");
		try{
			aux = productoService.actualizaProducto(producto);
			if(aux == 1){
				System.out.println("Producto actualizado con exito");
			}
			else{
				System.out.println("Error al actualizar producto");
			}
		}catch(Exception e){
			System.out.println("Error: " +e );
		}
	}
}
