package co.edu.unbosque.model;

import java.io.Serializable;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int precio;
	private String id;
	private String nombre;
	private String imagen;

	public Producto() {
		
	}

	public Producto(int precio, String id, String nombre, String imagen) {
		super();
		this.precio = precio;
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Producto [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}

}
