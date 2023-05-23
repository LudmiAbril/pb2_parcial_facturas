package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Factura {
	private ArrayList<Articulo> articulos = new ArrayList<Articulo>();

	public Factura() {
	}

	public Double calcularImpuesto(Articulo articulo) {
		return articulo.getPrecio() * 0.21;
	}

	public Double calcularImpuestoLujo(Articulo articulo) {
		if (articulo instanceof Bebida || articulo instanceof Perfume) {
			return articulo.getPrecio() * 0.15;
		}
		return 0.0;
	}

	public Double calcularTotalPorDetalles(Articulo articulo) {
		Double total = (articulo.getPrecio() + calcularImpuesto(articulo) + calcularImpuestoLujo(articulo))
				* articulo.getCantidad();
		return total;
	}

	public void agregarProductos(Articulo articulo) {
		articulos.add(articulo);

	}

	public Double calcularTotalFactura() {
		Double total = 0.0;
		for (Articulo a : articulos) {
			total += calcularTotalPorDetalles(a);
		}
		return total;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

}
