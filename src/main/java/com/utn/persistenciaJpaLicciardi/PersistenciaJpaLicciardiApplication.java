package com.utn.persistenciaJpaLicciardi;

import com.utn.persistenciaJpaLicciardi.entities.*;
import com.utn.persistenciaJpaLicciardi.enumerations.Estado;
import com.utn.persistenciaJpaLicciardi.enumerations.FormaDePago;
import com.utn.persistenciaJpaLicciardi.enumerations.TipoDeEnvio;
import com.utn.persistenciaJpaLicciardi.enumerations.TipoProducto;
import com.utn.persistenciaJpaLicciardi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class PersistenciaJpaLicciardiApplication {
	// Inyeccion de dependencia
	@Autowired
	RubroRepository rubroRepository;

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	DomicilioRepository domicilioRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	@Autowired
	FacturaRepository facturaRepository;


	public static void main(String[] args) {
		SpringApplication.run(PersistenciaJpaLicciardiApplication.class, args);
		System.out.println("---Funcionando Ahora----");
	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository, ProductoRepository productoRepository, ClienteRepository clienteRepository, DomicilioRepository domicilioRepository, PedidoRepository pedidoRepository, DetallePedidoRepository detallePedidoRepository, FacturaRepository facturaRepository){
	return args -> {
		System.out.println("Funcionando ---");

		// Creacion Rubro
		Rubro rubro1 = Rubro.builder()
				.denominacion("Hamburgesa")
				.build();

		// Creacion Productos
		Producto producto1 = Producto.builder()
				.tipo(TipoProducto.MANUFACTURADO)
				.tiempoEstimadoCocina(5)
				.denominacion("Hamburguesa con queso")
				.precioVenta(3000)
				.precioCompra(1000)
				.stockMinimo(25)
				.stockActual(200)
				.unidadMedida("gramos")
				.receta("Pan de papa, carne y queso")
				.build();

		Producto producto2 = Producto.builder()
				.tipo(TipoProducto.INSUMO)
				.tiempoEstimadoCocina(4)
				.denominacion("Hamburguesa con cebolla")
				.precioVenta(2500)
				.precioCompra(800)
				.stockMinimo(20)
				.stockActual(175)
				.unidadMedida("gramos")
				.receta("Pan de papa, carne y cebolla")
				.build();


		// Vinculo y guardo
		rubro1.agregarProductos(producto1);
		rubro1.agregarProductos(producto2);

		rubroRepository.save(rubro1);

		// Creo Clientes
		Cliente cliente1 = Cliente.builder()
				.nombre("Ignacio")
				.apellido("Marcos")
				.email("marcos@mail.com")
				.telefono(156893254)
				.build();

		Cliente cliente2 = Cliente.builder()
				.nombre("Pepe")
				.apellido("Argento")
				.email("coquipao@mail.com")
				.telefono(156842221)
				.build();

		// Creo Domicilios
		Domicilio domicilio1 = Domicilio.builder()
				.calle("Laprida")
				.numero(5675)
				.localidad("Ciudad")
				.build();

		Domicilio domicilio2 = Domicilio.builder()
				.calle("Pridala")
				.numero(5234)
				.localidad("Ciudad")
				.build();


		// Vinculo
		cliente1.agregarDomicilio(domicilio1);
		cliente2.agregarDomicilio(domicilio2);

		// Creo Detalles
		DetallePedido detallePedido1 = DetallePedido.builder()
				.cantidad(2)
				.subtotal(6300)
				.build();

		DetallePedido detallePedido2 = DetallePedido.builder()
				.cantidad(1)
				.subtotal(2950)
				.build();


		// 	Configuracion Fecha
		SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
		String fechaString = "2023-16-09";

		Date fecha = formatoFecha.parse(fechaString);

		// Creo Pedidos
		Pedido pedido1 = Pedido.builder()
				.estado(Estado.INICIADO)
				.fecha(fecha)
				.tipoEnvio(TipoDeEnvio.DELIVERY)
				.total(3150)
				.build();

		Pedido pedido2 = Pedido.builder()
				.estado(Estado.PREPARACION)
				.fecha(fecha)
				.tipoEnvio(TipoDeEnvio.DELIVERY)
				.total(2950)
				.build();

		// Creo Facturas
		Factura factura1 = Factura.builder()
				.numero(1)
				.fecha(fecha)
				.descuento(0)
				.formaPago(FormaDePago.MERCADOPAGO)
				.total(6300)
				.build();

		Factura factura2 = Factura.builder()
				.numero(2)
				.fecha(fecha)
				.descuento(10)
				.formaPago(FormaDePago.EFECTIVO)
				.total(2655)
				.build();

		// Vinculo y guardo

		pedido1.agregarDetalles(detallePedido1);
		pedido2.agregarDetalles(detallePedido2);


		cliente1.agregarPedidos(pedido1);
		cliente2.agregarPedidos(pedido2);


		detallePedido1.setProducto(producto1);
		detallePedido2.setProducto(producto2);

		pedido1.setFactura(factura1);
		pedido2.setFactura(factura2);


		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);


	};

	}

}