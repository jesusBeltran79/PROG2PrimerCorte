/**
 * Paquete Model. Es el modelo del MVC para que se pueda generar los datos y se puedan tener la informacion
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa un alimento cárnico que es un producto por ende
 * extendiendo la clase Producto. Implementa la interfaz Serializable para
 * permitir la persistencia de los objetos. Esta clase nos permite tener toda la
 * informacion que tiene un alimento carnico
 */
public class AlimentoCarnicoDTO extends Producto implements Serializable {

	/**
	 * Identificador único para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Tipo de carne del alimento cárnico.
	 */
	private String tipoDeCarne;

	/**
	 * Indica si el alimento cárnico ha sido procesado.
	 */
	private boolean procesada;

	/**
	 * Constructor por defecto.
	 */
	public AlimentoCarnicoDTO() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa los atributos tipoDeCarne y procesada.
	 *
	 * @param tipoDeCarne el tipo de carne del alimento cárnico
	 * @param procesada   indica si el alimento cárnico ha sido procesado
	 */
	public AlimentoCarnicoDTO(String tipoDeCarne, boolean procesada) {
		super();
		this.tipoDeCarne = tipoDeCarne;
		this.procesada = procesada;
	}

	/**
	 * Constructor que inicializa todos los atributos de la clase.
	 *
	 * @param precio      el precio del alimento cárnico
	 * @param id          el identificador del alimento cárnico
	 * @param nombre      el nombre del alimento cárnico
	 * @param imagen      la ruta de la imagen del alimento cárnico
	 * @param tipoDeCarne el tipo de carne del alimento cárnico
	 * @param procesada   indica si el alimento cárnico ha sido procesado
	 */
	public AlimentoCarnicoDTO(int precio, String id, String nombre, String imagen, String tipoDeCarne,
			boolean procesada) {
		super(precio, id, nombre, imagen);
		this.tipoDeCarne = tipoDeCarne;
		this.procesada = procesada;
	}

	/**
	 * Obtiene el tipo de carne del alimento cárnico.
	 *
	 * @return el tipo de carne
	 */
	public String getTipoDeCarne() {
		return tipoDeCarne;
	}

	/**
	 * Establece el tipo de carne del alimento cárnico.
	 *
	 * @param tipoDeCarne el tipo de carne a establecer
	 */
	public void setTipoDeCarne(String tipoDeCarne) {
		this.tipoDeCarne = tipoDeCarne;
	}

	/**
	 * Indica si el alimento cárnico ha sido procesado.
	 *
	 * @return true si el alimento cárnico ha sido procesado, false en caso
	 *         contrario
	 */
	public boolean isProcesada() {
		return procesada;
	}

	/**
	 * Establece el estado de procesamiento del alimento cárnico.
	 *
	 * @param procesada indica si el alimento cárnico ha sido procesado
	 */
	public void setProcesada(boolean procesada) {
		this.procesada = procesada;
	}

	/**
	 * Devuelve una representación en cadena del objeto AlimentoCarnicoDTO.
	 *
	 * @return una cadena que representa el alimento cárnico
	 */
	@Override
	public String toString() {
		return super.toString() + "AlimentoCarnicoDTO [tipoDeCarne=" + tipoDeCarne + ", procesada=" + procesada + "]";
	}
}