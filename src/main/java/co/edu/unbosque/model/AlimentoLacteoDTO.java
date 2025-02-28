/**
 * Paquete Model. Es el modelo del MVC para que se pueda generar los datos y se puedan tener la informacion
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
Clase que representa un alimento lacteo que es un producto por ende
 * extendiendo la clase Producto. Implementa la interfaz Serializable para
 * permitir la persistencia de los objetos. Esta clase nos permite tener toda la
 * informacion que tiene un alimento lacteo
 */
public class AlimentoLacteoDTO extends Producto implements Serializable {

    /**
     * Número de versión serial para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Indica si el alimento lácteo es sin lactosa.
     */
    private boolean sinLactosa;

    /**
     * Tipo de lácteo (ej. Leche, Queso, Yogurt, etc.).
     */
    private String tipoDeLacteo;

    /**
     * Constructor por defecto de la clase AlimentoLacteoDTO.
     */
    public AlimentoLacteoDTO() {

    }

    /**
     * Constructor de la clase AlimentoLacteoDTO con parámetros de sin lactosa y tipo de lácteo.
     *
     * @param sinLactosa    Indica si el alimento lácteo es sin lactosa.
     * @param tipoDeLacteo El tipo de lácteo.
     */
    public AlimentoLacteoDTO(boolean sinLactosa, String tipoDeLacteo) {
        super();
        this.sinLactosa = sinLactosa;
        this.tipoDeLacteo = tipoDeLacteo;
    }

    /**
     * Constructor de la clase AlimentoLacteoDTO con todos los parámetros, incluyendo los de la clase Producto.
     *
     * @param precio       El precio del alimento lácteo.
     * @param id           El identificador único del alimento lácteo.
     * @param nombre       El nombre del alimento lácteo.
     * @param imagen       La ruta de la imagen del alimento lácteo.
     * @param sinLactosa    Indica si el alimento lácteo es sin lactosa.
     * @param tipoDeLacteo El tipo de lácteo.
     */
    public AlimentoLacteoDTO(int precio, String id, String nombre, String imagen, boolean sinLactosa,
            String tipoDeLacteo) {
        super(precio, id, nombre, imagen);
        this.sinLactosa = sinLactosa;
        this.tipoDeLacteo = tipoDeLacteo;
    }

    /**
     * Constructor de la clase AlimentoLacteoDTO con los parámetros de la clase Producto.
     *
     * @param precio El precio del alimento lácteo.
     * @param id     El identificador único del alimento lácteo.
     * @param nombre El nombre del alimento lácteo.
     * @param imagen La ruta de la imagen del alimento lácteo.
     */
    public AlimentoLacteoDTO(int precio, String id, String nombre, String imagen) {
        super(precio, id, nombre, imagen);
    }

    /**
     * Obtiene el valor booleano que indica si el alimento lácteo es sin lactosa.
     *
     * @return true si el alimento lácteo es sin lactosa, false en caso contrario.
     */
    public boolean isSinLactosa() {
        return sinLactosa;
    }

    /**
     * Establece el valor booleano que indica si el alimento lácteo es sin lactosa.
     *
     * @param sinLactosa true si el alimento lácteo es sin lactosa, false en caso contrario.
     */
    public void setSinLactosa(boolean sinLactosa) {
        this.sinLactosa = sinLactosa;
    }

    /**
     * Obtiene el tipo de lácteo.
     *
     * @return El tipo de lácteo.
     */
    public String getTipoDeLacteo() {
        return tipoDeLacteo;
    }

    /**
     * Establece el tipo de lácteo.
     *
     * @param tipoDeLacteo El tipo de lácteo.
     */
    public void setTipoDeLacteo(String tipoDeLacteo) {
        this.tipoDeLacteo = tipoDeLacteo;
    }

    /**
     * Devuelve una representación en cadena del objeto AlimentoLacteoDTO, incluyendo la representación de la clase Producto.
     *
     * @return Una cadena que representa el objeto AlimentoLacteoDTO.
     */
    @Override
    public String toString() {
        return super.toString() + "AlimentoLacteoDTO [sinLactosa=" + sinLactosa + ", tipoDeLacteo=" + tipoDeLacteo + "]";
    }
}