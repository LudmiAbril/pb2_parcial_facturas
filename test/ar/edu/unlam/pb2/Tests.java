package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void queSePuedePedirImpuestoSobreArticulo() {
		Articulo lapiz = new Articulo("lapiz", 1, 30.0);
		Factura factura = new Factura();

		Double deseado = 6.3;
		Double obtenido = factura.calcularImpuesto(lapiz);

		assertEquals(obtenido, deseado);
	}

	@Test
	public void queSePuedePedirImpuestoSobreArticuloDeLujo() {
		Bebida coca = new Bebida("coca-cola", 1, 50.0);
		Factura factura = new Factura();

		Double deseado = 7.5;
		Double obtenido = factura.calcularImpuestoLujo(coca);

		assertEquals(obtenido, deseado);
	}

	@Test
	public void queSePuedaCalularElTotalPorDetalle() {
		Perfume perfume = new Perfume("carolina herrera", 2, 200.0);
		Factura factura = new Factura();

		Double deseado = 544.0;
		Double obtenido = factura.calcularTotalPorDetalles(perfume);

		assertEquals(obtenido, deseado);
	}

	@Test
	public void queSePuedaCalularElTotalDeLaFactura() {
		Articulo lapiz = new Articulo("lapiz", 1, 30.0);
		Perfume perfume = new Perfume("carolina herrera", 2, 200.0);
		Bebida coca = new Bebida("coca-cola", 3, 50.0);
		Factura factura = new Factura();

		factura.agregarProductos(lapiz);
		factura.agregarProductos(perfume);
		factura.agregarProductos(coca);

		Double deseado = 784.3;
		Double obtenido = factura.calcularTotalFactura();

		assertEquals(obtenido, deseado);
	}

	@Test
	public void queSePuedaReportarseBasico() {
		Articulo lapiz = new Articulo("lapiz", 1, 30.0);
		Perfume perfume = new Perfume("carolina herrera", 2, 200.0);
		Bebida coca = new Bebida("coca-cola", 3, 50.0);
		Factura factura = new Factura();
		ReportadorBasico reportador = new ReportadorBasico();

		factura.agregarProductos(lapiz);
		factura.agregarProductos(coca);
		factura.agregarProductos(perfume);
		

		String deseado = "\n" + "\nproducto: " + lapiz.getNombre() + "precio unitario: " + lapiz.getPrecio() + "IVA: "
				+ factura.calcularImpuesto(lapiz) + "adicional: " + factura.calcularImpuestoLujo(lapiz) + "total: "
				+ factura.calcularTotalPorDetalles(lapiz) + "\nproducto: " + coca.getNombre() + "precio unitario: "
				+ coca.getPrecio() + "IVA: " + factura.calcularImpuesto(coca) + "adicional: "
				+ factura.calcularImpuestoLujo(coca) + "total: " + factura.calcularTotalPorDetalles(coca)
				+ "\nproducto: " + perfume.getNombre() + "precio unitario: " + perfume.getPrecio() + "IVA: "
				+ factura.calcularImpuesto(perfume) + "adicional: " + factura.calcularImpuestoLujo(perfume) + "total: "
				+ factura.calcularTotalPorDetalles(perfume) + "\ntotal: " + factura.calcularTotalFactura();

		String obtenido = reportador.reportar(factura);

		assertEquals(obtenido, deseado);
	}

}
