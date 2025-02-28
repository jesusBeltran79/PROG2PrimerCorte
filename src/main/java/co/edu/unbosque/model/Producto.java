/**
 * Paquete Model. Es el modelo del MVC para que se pueda generar los datos y se puedan tener la informacion
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase padre de todos los productos que va a tener el aplicativo. Es la clase
 * producto que implica serializable para que se pueda guardar la informacion
 */
public class Producto implements Serializable {

	/**
	 * Número de versión serial para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Precio del producto.
	 */
	private int precio;

	/**
	 * Identificador único del producto.
	 */
	private String id;

	/**
	 * Nombre del producto.
	 */
	private String nombre;

	/**
	 * Ruta de la imagen del producto.
	 */
	private String imagen;

	/**
	 * Constructor por defecto de la clase Producto.
	 */
	public Producto() {

	}

	/**
	 * Constructor de la clase Producto con parámetros.
	 *
	 * @param precio El precio del producto.
	 * @param id     El identificador único del producto.
	 * @param nombre El nombre del producto.
	 * @param imagen La ruta de la imagen del producto.
	 */
	public Producto(int precio, String id, String nombre, String imagen) {
		super();
		this.precio = precio;
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto.
	 *
	 * @return El precio del producto.
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto.
	 *
	 * @param precio El precio del producto.
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene el identificador único del producto.
	 *
	 * @return El identificador único del producto.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador único del producto.
	 *
	 * @param id El identificador único del producto.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del producto.
	 *
	 * @return El nombre del producto.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto.
	 *
	 * @param nombre El nombre del producto.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la ruta de la imagen del producto.
	 *
	 * @return La ruta de la imagen del producto.
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la ruta de la imagen del producto.
	 *
	 * @param imagen La ruta de la imagen del producto.
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Devuelve una representación en cadena del objeto Producto.
	 *
	 * @return Una cadena que representa el objeto Producto.
	 */
	@Override
	public String toString() {
		return "Producto [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}
}