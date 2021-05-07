package cursoDAgil.service.ventas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.dao.cliente.ClienteDao;
import cursoDAgil.dao.detalleventas.DetalleVentasDao;
import cursoDAgil.dao.ganancias.GananciasDao;
import cursoDAgil.dao.productos.ProductosDao;
import cursoDAgil.dao.ventas.VentasDao;
import cursoDAgil.service.cliente.ClienteService;
import cursoDAgil.service.detalleventas.DetalleVentasService;
import cursoDAgil.service.ganancias.GananciaService;
import cursoDAgil.service.producto.ProductoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class VentasServiceImplTest {

	@Inject
	VentasService ventasService;
	@Inject
	GananciaService gananciaService;
	@Inject
	ClienteService clienteService;
	@Inject
	DetalleVentasService detalleVentasService;
	@Inject
	ProductoService productoService;
	
	@Test
	public void listarVentasTodo() {
		System.out.println("---Test consultar todas las ventas---");
		try{
			List<Ventas> lista = ventasService.listarVentasTodo();
			Cliente cliente =new Cliente();
			Map<String, Integer> mapCliente = new HashMap<>();
			assertEquals(lista.size(), 14);
			System.out.println("id nombre     fecha     ventatotal");
			for(Ventas v: lista){
				mapCliente.put("id", v.getClienteId());
				try{
					cliente=clienteService.obtenerClientePorId(mapCliente);
					assertNotNull(cliente);
				} catch (Exception e) {
					System.out.println("Error: " + e);
				}
				Date date = v.getFecha(); // convertir tipo date to string
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String strDate = dateFormat.format(date);
				
				System.out.println(v.getClienteId()+"  "+
				cliente.getNombre()+"     "+ strDate+"   "+ v.getTotalVenta()+"\n");
			}
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

	public Productos buscaProducto(Integer idproducto) {
		Productos producto = new Productos();
		Map<String, Integer> mapProductos = new HashMap<>();
		Integer nproductos;
		mapProductos.put("idProducto", idproducto);// verifico que el producto se encuentre
		try {
			producto = productoService.listarProductosPorId(mapProductos);
			if (producto == null)
				System.out.println("el producto no esta en stock");
			else {
				System.out.println("producto en existencia");
				return producto;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Ignore
	public void RealizarVenta() { //realizar venta
		Productos producto = new Productos();
		DetalleVentas detalleventas = new DetalleVentas();
		Ventas venta = new Ventas();
		Ventas ventaAux = new Ventas();
		Map<String, Integer> mapProductos = new HashMap<>();
		Integer nproductos, idproducto, aux, idventa = 17, n = 0, cont = 0;
		Double tventa = 0.0, totalcomprado = 0.0, pventa = 0.0, pnormal, ganan = 0.0;
		System.out.println("----------Test realizar venta----------");
		ArrayList<Integer> product = new ArrayList<Integer>();
		ArrayList<Integer> cantidadProductos = new ArrayList<Integer>();
		product.add(6);
		product.add(7);
		product.add(8);
		product.add(9);
		cantidadProductos.add(1);
		cantidadProductos.add(1);
		cantidadProductos.add(1);
		cantidadProductos.add(1);
		do {
			try {
				venta.setIdVenta(idventa);// se crea el objeto venta
				venta.setClienteId(1);
				venta.setTotalVenta(totalcomprado);
				SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy"); // convertir tipo string to date
				try {
					Date date = DateFor.parse("08/07/2019");
					venta.setFecha(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				idproducto=product.get(n);
				producto = buscaProducto(idproducto);
				if (producto != null) {
					nproductos=cantidadProductos.get(n);
					aux = producto.getCantidad();
					if (nproductos <= aux) {
						tventa = producto.getPrecioVta() * nproductos;
						producto.setIdProducto(idproducto);
						producto.setNombre(producto.getNombre());
						pnormal = producto.getPrecio();
						producto.setPrecio(pnormal);
						pventa = producto.getPrecioVta();
						producto.setPrecioVta(pventa);
						producto.setCantidad(aux - nproductos);
						producto.setMarcaId(producto.getMarcaId());
						ganan = (pventa - pnormal) * nproductos;
						totalcomprado += pventa * nproductos;
						venta.setTotalVenta(totalcomprado);
						if (cont == 0)// si es la primera vez comprando, solo se crea una tupla
							ventasService.nuevaVenta(venta);
						ventasService.actualizaVenta(venta);
						productoService.actualizaProducto(producto);
						Ganancias ganancia = new Ganancias();
						try { // se crea un detalle venta
							detalleventas.setVentaId(idventa);
							detalleventas.setProductoId(idproducto);
							detalleventas.setCantidad(nproductos);
							detalleVentasService.nuevoDetalleVenta(detalleventas);
						} catch (Exception e) {
							System.out.println("Error al crear cliente: " + e);
						}
						try {// se crea una ganancia
							ganancia.setIdVenta(idventa);
							ganancia.setTotalGanancia(ganan);
							DateFor = new SimpleDateFormat("dd/MM/yyyy");// convertir tipo string to date
							try {
								Date date = DateFor.parse("08/07/2019");
								ganancia.setDate(date);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							gananciaService.nuevaGanancia(ganancia);
						} catch (Exception e) {
							System.out.println("Error: " + e);
						}
						cont = 1;
					}
				}

			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
			n++;
		} while (n != 4);
		System.out.println("adios");
	}

	@Test
	public void DetalleVentaCliente() {//// CONSULTA DE DETALLE DE VENTA
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		//
		List<Ventas> list = null;
		Map<String, Integer> mapVentas = new HashMap<>();
		//
		List<DetalleVentas> list3 = null;
		DetalleVentas detalleVentas = new DetalleVentas();
		Map<String, Integer> mapDetalle = new HashMap<>();
		//
		Productos producto = new Productos();
		Map<String, Integer> mapProductos = new HashMap<>();
		System.out.println("---Test consultar detalle de venta---");
		mapCliente.put("id", 1);
		try {
			cliente = clienteService.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido()); // nombre del cliente
			mapVentas.put("clienteId", cliente.getId());
			try {
				list = ventasService.obtenerVentaPorClienteId(mapVentas);
				for (Ventas v : list) {

					mapDetalle.put("ventaId", v.getIdVenta());
					Date date = v.getFecha(); // convertir tipo date to string
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					String strDate = dateFormat.format(date);
					try {
						list3 = detalleVentasService.DetalleVentaPorId(mapDetalle);
						for (DetalleVentas d : list3) {
							mapProductos.put("idProducto", d.getProductoId());
							try {
								producto = productoService.listarProductosPorId(mapProductos);
								assertNotNull(producto);
								System.out.println("Compro #" + d.getCantidad() + " producto:" + producto.getNombre()
										+ " el: " + strDate);
							} catch (Exception e) {
								System.out.println("Error: " + e);
							}
						}
					} catch (Exception e) {
						System.out.println("Error: " + e);
					}
				}
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}

		} catch (Exception e) {
			System.out.println("Error en consultar cliente por id: " + e);
		}
	}

	@Test
	public void ventasPorCliente() {/// compras por cliente
		List<Ventas> list = null;
		List<Cliente> clientes = null;
		Cliente cliente=new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		System.out.println("---Test consultar ventas por cliente---");
		try {
			list = ventasService.listarVentasTodo();
			for (Ventas v : list) {
				System.out.println("idVenta: " + v.getIdVenta()+" total comprado: $" + v.getTotalVenta());
				mapCliente.put("id", v.getClienteId());
				cliente = clienteService.obtenerClientePorId(mapCliente);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
