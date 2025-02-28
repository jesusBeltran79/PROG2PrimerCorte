/**
 * Paquete Model. Es el modelo del MVC para que se pueda generar los datos y se puedan tener la informacion
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
Clase que representa una ropa que es un producto por ende
 * extendiendo la clase Producto. Implementa la interfaz Serializable para
 * permitir la persistencia de los objetos. Esta clase nos permite tener toda la
 * informacion que tiene una ropa
 */
public class RopaDTO extends Producto implements Serializable {

    /**
     * Número de versión serial para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Talla de la prenda de ropa.
     */
    private String talla;

    /**
     * Tipo de prenda de ropa (ej. Camisa, Pantalón, etc.).
     */
    private String tipoDePrenda;

    /**
     * Constructor por defecto de la clase RopaDTO.
     */
    public RopaDTO() {

    }

    /**
     * Constructor de la clase RopaDTO con parámetros de talla y tipo de prenda.
     *
     * @param talla        La talla de la prenda de ropa.
     * @param tipoDePrenda El tipo de prenda de ropa.
     */
    public RopaDTO(String talla, String tipoDePrenda) {
        super();
        this.talla = talla;
        this.tipoDePrenda = tipoDePrenda;
    }

    /**
     * Constructor de la clase RopaDTO con todos los parámetros, incluyendo los de la clase Producto.
     *
     * @param precio       El precio de la prenda de ropa.
     * @param id           El identificador único de la prenda de ropa.
     * @param nombre       El nombre de la prenda de ropa.
     * @param imagen       La ruta de la imagen de la prenda de ropa.
     * @param talla        La talla de la prenda de ropa.
     * @param tipoDePrenda El tipo de prenda de ropa.
     */
    public RopaDTO(int precio, String id, String nombre, String imagen, String talla, String tipoDePrenda) {
        super(precio, id, nombre, imagen);
        this.talla = talla;
        this.tipoDePrenda = tipoDePrenda;
    }

    /**
     * Constructor de la clase RopaDTO con los parámetros de la clase Producto.
     *
     * @param precio El precio de la prenda de ropa.
     * @param id     El identificador único de la prenda de ropa.
     * @param nombre El nombre de la prenda de ropa.
     * @param imagen La ruta de la imagen de la prenda de ropa.
     */
    public RopaDTO(int precio, String id, String nombre, String imagen) {
        super(precio, id, nombre, imagen);
    }

    /**
     * Obtiene la talla de la prenda de ropa.
     *
     * @return La talla de la prenda de ropa.
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Establece la talla de la prenda de ropa.
     *
     * @param talla La talla de la prenda de ropa.
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * Obtiene el tipo de prenda de ropa.
     *
     * @return El tipo de prenda de ropa.
     */
    public String getTipoDePrenda() {
        return tipoDePrenda;
    }

    /**
     * Establece el tipo de prenda de ropa.
     *
     * @param tipoDePrenda El tipo de prenda de ropa.
     */
    public void setTipoDePrenda(String tipoDePrenda) {
        this.tipoDePrenda = tipoDePrenda;
    }

    /**
     * Devuelve una representación en cadena del objeto RopaDTO, incluyendo la representación de la clase Producto.
     *
     * @return Una cadena que representa el objeto RopaDTO.
     */
    @Override
    public String toString() {
        return super.toString() + "RopaDTO [talla=" + talla + ", tipoDePrenda=" + tipoDePrenda + "]";
    }
}