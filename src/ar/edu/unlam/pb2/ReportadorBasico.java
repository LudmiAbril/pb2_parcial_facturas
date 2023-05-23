package ar.edu.unlam.pb2;

public class ReportadorBasico implements Reportador {

	@Override
	public String reportar(Factura factura) {
		String reporte="\n";
		for (Articulo a : factura.getArticulos()) {
			reporte += "\nproducto: " + a.getNombre() + "precio unitario: " + a.getPrecio() + "IVA: "
					+ factura.calcularImpuesto(a) + "adicional: " + factura.calcularImpuestoLujo(a) + "total: "
					+ factura.calcularTotalPorDetalles(a);
		}
		reporte += "\ntotal: " + factura.calcularTotalFactura();
		return reporte;
	}

}
