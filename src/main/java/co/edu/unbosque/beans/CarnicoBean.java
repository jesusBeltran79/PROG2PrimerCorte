/**
 * Paquete beans. Usado para poder tener una interaccion entre el back y el front. En el back van los datos dirijidos a sus respectivos daos y front a sus respectivos .xhtml
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import co.edu.unbosque.model.AlimentoCarnicoDTO;
import co.edu.unbosque.model.persistence.AlimentoCarnicoDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("CarnicoBean")
@SessionScoped

/**
 * Clase que representa el bean de los alimentos carnicos. Implementa la interfaz Serializable
 * para permitir la persistencia de los alimentos carnicos. A su vez es la que tiene la
 * conexion entre los datos en el DAO y el front en los .xhtml
 */
public class CarnicoBean implements Serializable {

	

	 /**
     * Identificador único para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Precio del alimento cárnico.
     */
    private int precio;

    /**
     * Identificador del alimento cárnico.
     */
    private String id;

    /**
     * Nombre del alimento cárnico.
     */
    private String nombre;

    /**
     * Ruta de la imagen del alimento cárnico.
     */
    private String imagen;

    /**
     * Tipo de carne del alimento cárnico.
     */
    private String tipoDeCarne;

    /**
     * Indica si el alimento cárnico ha sido procesado.
     */
    private boolean procesada;

    /**
     * Indica si el botón asociado al alimento cárnico es visible.
     */
    private boolean botonVisible = true;

    /**
     * Lista de alimentos cárnicos.
     */
    private List<AlimentoCarnicoDTO> lista = new ArrayList<>();

    /**
     * Alimento cárnico seleccionado por el usuario.
     */
    private AlimentoCarnicoDTO usuarioSeleccionado;

    /**
     * Acceso a la base de datos de alimentos cárnicos.
     */
    private AlimentoCarnicoDAO carnicoDAO = new AlimentoCarnicoDAO();
	/**
	 * Constructor vacio. Nos trae la lista y el seleccionado por el usuario
	 */
	public CarnicoBean() {
		usuarioSeleccionado = new AlimentoCarnicoDTO();
		lista = carnicoDAO.getListaAliCarnico();
	}
	/**
	 * Metodo usado para poder guardar la informacion
	 */
	public void guardar() {
		Random r = new Random();
		int aleatorio = 1000000 + r.nextInt(9000000);
		String identificacion = String.valueOf(aleatorio);

		AlimentoCarnicoDTO nuevoUsuario = new AlimentoCarnicoDTO(precio, identificacion, nombre, imagen, tipoDeCarne,
				procesada);
		if (lista.isEmpty()) {
			lista.add(nuevoUsuario);
		}else {
			carnicoDAO.crear(nuevoUsuario);
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alimento carnico agregado correctamente"));
		limpiarFormulario();
	}
	
	/**
	 * Metodo usado para poder eliminar respecto a una informacion dada
	 * @param usuario Nos da el valor del usuario 
	 */

	public void eliminar(AlimentoCarnicoDTO usuario) {
		Iterator<AlimentoCarnicoDTO> iterator = lista.iterator();
		while (iterator.hasNext()) {
			AlimentoCarnicoDTO u = iterator.next();
			if (u.equals(usuario)) {
				carnicoDAO.eliminar(u);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Alimento carnico eliminado correctamente"));
				break;
			}
		}
	}
	/**
	 * Metodo actualizar del crud, el cual actualiza la informacion que se quiera ver
	 */
	public void actualizar() {
		if (usuarioSeleccionado != null) {
			for (AlimentoCarnicoDTO u : lista) {
				if (u.equals(usuarioSeleccionado)) {
					u.getPrecio();
					u.getId();
					u.getNombre();
					u.getImagen();
					u.getTipoDeCarne();
					u.isProcesada();
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Alimento carnico actualizado correctamente"));
					break;
				}
			}
		}
	}
	/**
	 * Limpia toda la informacio dentro del formulario
	 */
	private void limpiarFormulario() {
		this.precio = 0;
		this.id = "";
		this.nombre = "";
		this.imagen = "";
		this.tipoDeCarne = "";
		this.procesada = false;
	}
	/**
	 * Da la visibilidad de los botones
	 * @return Verdadero si se muestra falso si no
	 */
	public boolean isBotonVisible() {
		return botonVisible;
	}
	/**
	 * Es quien ejecuta y da la accion al boton
	 */
	public void ejecutarAccion() {
		// Lógica del botón
		System.out.println("Botón presionado");

		// Ocultar el botón después de presionarlo
		botonVisible = false;
	}

	/**
	 * Obtiene el precio del alimento cárnico.
	 *
	 * @return El precio del alimento cárnico.
	 */
	public int getPrecio() {
	    return precio;
	}

	/**
	 * Establece el precio del alimento cárnico.
	 *
	 * @param precio El precio del alimento cárnico.
	 */
	public void setPrecio(int precio) {
	    this.precio = precio;
	}

	/**
	 * Obtiene el ID del alimento cárnico.
	 *
	 * @return El ID del alimento cárnico.
	 */
	public String getId() {
	    return id;
	}

	/**
	 * Establece el ID del alimento cárnico.
	 *
	 * @param id El ID del alimento cárnico.
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * Obtiene el nombre del alimento cárnico.
	 *
	 * @return El nombre del alimento cárnico.
	 */
	public String getNombre() {
	    return nombre;
	}

	/**
	 * Establece el nombre del alimento cárnico.
	 *
	 * @param nombre El nombre del alimento cárnico.
	 */
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	/**
	 * Obtiene la ruta de la imagen del alimento cárnico.
	 *
	 * @return La ruta de la imagen del alimento cárnico.
	 */
	public String getImagen() {
	    return imagen;
	}

	/**
	 * Establece la ruta de la imagen del alimento cárnico.
	 *
	 * @param imagen La ruta de la imagen del alimento cárnico.
	 */
	public void setImagen(String imagen) {
	    this.imagen = imagen;
	}

	/**
	 * Obtiene el tipo de carne del alimento cárnico.
	 *
	 * @return El tipo de carne del alimento cárnico.
	 */
	public String getTipoDeCarne() {
	    return tipoDeCarne;
	}

	/**
	 * Establece el tipo de carne del alimento cárnico.
	 *
	 * @param tipoDeCarne El tipo de carne del alimento cárnico.
	 */
	public void setTipoDeCarne(String tipoDeCarne) {
	    this.tipoDeCarne = tipoDeCarne;
	}

	/**
	 * Obtiene el valor booleano que indica si el alimento cárnico es procesado.
	 *
	 * @return true si el alimento cárnico es procesado, false en caso contrario.
	 */
	public boolean isProcesada() {
	    return procesada;
	}

	/**
	 * Establece el valor booleano que indica si el alimento cárnico es procesado.
	 *
	 * @param procesada true si el alimento cárnico es procesado, false en caso contrario.
	 */
	public void setProcesada(boolean procesada) {
	    this.procesada = procesada;
	}

	/**
	 * Obtiene la lista de objetos AlimentoCarnicoDTO asociados a este alimento cárnico.
	 *
	 * @return La lista de objetos AlimentoCarnicoDTO.
	 */
	public List<AlimentoCarnicoDTO> getLista() {
	    return lista;
	}

	/**
	 * Establece la lista de objetos AlimentoCarnicoDTO asociados a este alimento cárnico.
	 *
	 * @param lista La lista de objetos AlimentoCarnicoDTO.
	 */
	public void setLista(List<AlimentoCarnicoDTO> lista) {
	    this.lista = lista;
	}

	/**
	 * Obtiene el objeto AlimentoCarnicoDTO seleccionado.
	 *
	 * @return El objeto AlimentoCarnicoDTO seleccionado.
	 */
	public AlimentoCarnicoDTO getUsuarioSeleccionado() {
	    return usuarioSeleccionado;
	}

	/**
	 * Establece el objeto AlimentoCarnicoDTO seleccionado.
	 *
	 * @param usuarioSeleccionado El objeto AlimentoCarnicoDTO seleccionado.
	 */
	public void setUsuarioSeleccionado(AlimentoCarnicoDTO usuarioSeleccionado) {
	    this.usuarioSeleccionado = usuarioSeleccionado;
	}

	/**
	 * Obtiene el número de versión serial para la serialización.
	 *
	 * @return El número de versión serial.
	 */
	public static long getSerialversionuid() {
	    return serialVersionUID;
	}

	/**
	 * Devuelve una representación en cadena del objeto CarnicoBean.
	 *
	 * @return Una cadena que representa el objeto CarnicoBean.
	 */
	@Override
	public String toString() {
	    return "CarnicoBean [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen
	            + ", tipoDeCarne=" + tipoDeCarne + ", procesada=" + procesada + ", lista=" + lista
	            + ", usuarioSeleccionado=" + usuarioSeleccionado + "]";
	}
}
