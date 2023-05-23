package ar.edu.unlam.pb2;

public class Articulo {
	String nombre;
	Integer cantidad;
	Double precio;

	public Articulo(String nombre, Integer cantidad, Double precio) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

}
