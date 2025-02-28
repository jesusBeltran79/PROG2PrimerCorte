/**
 * Paquete Model. Es el modelo del MVC para que se pueda generar los datos y se puedan tener la informacion
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 *Clase que representa un juguete que es un producto por ende
 * extendiendo la clase Producto. Implementa la interfaz Serializable para
 * permitir la persistencia de los objetos. Esta clase nos permite tener toda la
 * informacion que tiene un juguete
 */
public class JugueteDTO extends Producto implements Serializable {

    /**
     * Identificador único para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Indica si el juguete es apto para mayores de 18 años.
     */
    private boolean esMas18;

    /**
     * Constructor por defecto.
     */
    public JugueteDTO() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa el atributo esMas18.
     *
     * @param esMas18 indica si el juguete es apto para mayores de 18 años
     */
    public JugueteDTO(boolean esMas18) {
        super();
        this.esMas18 = esMas18;
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param precio el precio del juguete
     * @param id el identificador del juguete
     * @param nombre el nombre del juguete
     * @param imagen la ruta de la imagen del juguete
     * @param esMas18 indica si el juguete es apto para mayores de 18 años
     */
    public JugueteDTO(int precio, String id, String nombre, String imagen, boolean esMas18) {
        super(precio, id, nombre, imagen);
        this.esMas18 = esMas18;
    }

    /**
     * Constructor que inicializa todos los atributos de la clase, excepto esMas18.
     *
     * @param precio el precio del juguete
     * @param id el identificador del juguete
     * @param nombre el nombre del juguete
     * @param imagen la ruta de la imagen del juguete
     */
    public JugueteDTO(int precio, String id, String nombre, String imagen) {
        super(precio, id, nombre, imagen);
    }

    /**
     * Obtiene el valor del atributo esMas18.
     *
     * @return true si el juguete es apto para mayores de 18 años, false en caso contrario
     */
    public boolean isEsMas18() {
        return esMas18;
    }

    /**
     * Establece el valor del atributo esMas18.
     *
     * @param esMas18 indica si el juguete es apto para mayores de 18 años
     */
    public void setEsMas18(boolean esMas18) {
        this.esMas18 = esMas18;
    }

    /**
     * Devuelve una representación en cadena del objeto JugueteDTO.
     *
     * @return una cadena que representa el juguete
     */
    @Override
    public String toString() {
        return super.toString() + "JugueteDTO [esMas18=" + esMas18 + "]";
    }
}