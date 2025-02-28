/**
 * Paquete beans. Usado para poder tener una interaccion entre el back y el front. En el back van los datos dirijidos a sus respectivos daos y front a sus respectivos .xhtml
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.persistence.JugueteDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("JugueteBean")
@SessionScoped

/**
 * Clase que representa el bean del juguete. Implementa la interfaz Serializable
 * para permitir la persistencia del juguete. A su vez es la que tiene la
 * conexion entre los datos en el DAO y el front en los .xhtml
 */
public class JugueteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int precio;
	private String id;
	private String nombre;
	private String imagen;
	private boolean esMas18;
	private boolean botonVisible = true;
	private List<JugueteDTO> lista = new ArrayList<>();
	private JugueteDTO usuarioSeleccionado;
	private JugueteDAO jugueteDAO = new JugueteDAO();
	/**
	 * Constructor vacio. Nos trae la lista y el seleccionado por el usuario
	 */
	public JugueteBean() {
		usuarioSeleccionado = new JugueteDTO();
		lista = jugueteDAO.getListaJuguete();
	}

	// lista = jugueteDAO.getListaJuguete();
	/**
	 * Metodo usado para poder guardar la informacion
	 */
	public void guardar() {

		Random r = new Random();
		int aleatorio = 1000000 + r.nextInt(9000000);
		String identificacion = String.valueOf(aleatorio);
		JugueteDTO nuevoUsuario = new JugueteDTO(precio, identificacion, nombre, imagen, esMas18);
		if (lista.isEmpty()) {
			lista.add(nuevoUsuario);
		} else {
			jugueteDAO.crear(nuevoUsuario);
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Juguete agregado correctamente"));
		limpiarFormulario();
	}
	/**
	 * Metodo usado para poder eliminar respecto a una informacion dada
	 * @param usuario Nos da el valor del usuario 
	 */

	public void eliminar(JugueteDTO usuario) {
		Iterator<JugueteDTO> iterator = lista.iterator();
		while (iterator.hasNext()) {
			JugueteDTO u = iterator.next();
			if (u.equals(usuario)) {
				jugueteDAO.eliminar(u);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Juguete eliminado correctamente"));
				break;
			}
		}
	}
	/**
	 * Metodo actualizar del crud, el cual actualiza la informacion que se quiera ver
	 */
	public void actualizar() {
		if (usuarioSeleccionado != null) {
			for (JugueteDTO u : lista) {
				if (u.getId().equals(usuarioSeleccionado.getId())) { // Usar ID en lugar de equals
					u.setPrecio(usuarioSeleccionado.getPrecio());
					u.setNombre(usuarioSeleccionado.getNombre());
					u.setImagen(usuarioSeleccionado.getImagen());
					u.setEsMas18(usuarioSeleccionado.isEsMas18());
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Juguete actualizado correctamente"));
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
		this.esMas18 = false;
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
	 * Obtiene el precio del juguete.
	 *
	 * @return El precio del juguete.
	 */
	public int getPrecio() {
	    return precio;
	}

	/**
	 * Establece el precio del juguete.
	 *
	 * @param precio El precio del juguete.
	 */
	public void setPrecio(int precio) {
	    this.precio = precio;
	}

	/**
	 * Obtiene el ID del juguete.
	 *
	 * @return El ID del juguete.
	 */
	public String getId() {
	    return id;
	}

	/**
	 * Establece el ID del juguete.
	 *
	 * @param id El ID del juguete.
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * Obtiene el nombre del juguete.
	 *
	 * @return El nombre del juguete.
	 */
	public String getNombre() {
	    return nombre;
	}

	/**
	 * Establece el nombre del juguete.
	 *
	 * @param nombre El nombre del juguete.
	 */
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	/**
	 * Obtiene la ruta de la imagen del juguete.
	 *
	 * @return La ruta de la imagen del juguete.
	 */
	public String getImagen() {
	    return imagen;
	}

	/**
	 * Establece la ruta de la imagen del juguete.
	 *
	 * @param imagen La ruta de la imagen del juguete.
	 */
	public void setImagen(String imagen) {
	    this.imagen = imagen;
	}

	/**
	 * Obtiene el valor booleano que indica si el juguete es para mayores de 18 años.
	 *
	 * @return true si el juguete es para mayores de 18 años, false en caso contrario.
	 */
	public boolean isEsMas18() {
	    return esMas18;
	}

	/**
	 * Establece el valor booleano que indica si el juguete es para mayores de 18 años.
	 *
	 * @param esMas18 true si el juguete es para mayores de 18 años, false en caso contrario.
	 */
	public void setEsMas18(boolean esMas18) {
	    this.esMas18 = esMas18;
	}

	/**
	 * Obtiene la lista de objetos JugueteDTO asociados a este juguete.
	 *
	 * @return La lista de objetos JugueteDTO.
	 */
	public List<JugueteDTO> getLista() {
	    return lista;
	}

	/**
	 * Establece la lista de objetos JugueteDTO asociados a este juguete.
	 *
	 * @param lista La lista de objetos JugueteDTO.
	 */
	public void setLista(List<JugueteDTO> lista) {
	    this.lista = lista;
	}

	/**
	 * Obtiene el objeto JugueteDTO seleccionado.
	 *
	 * @return El objeto JugueteDTO seleccionado.
	 */
	public JugueteDTO getUsuarioSeleccionado() {
	    return usuarioSeleccionado;
	}

	/**
	 * Establece el objeto JugueteDTO seleccionado.
	 *
	 * @param usuarioSeleccionado El objeto JugueteDTO seleccionado.
	 */
	public void setUsuarioSeleccionado(JugueteDTO usuarioSeleccionado) {
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
	 * Devuelve una representación en cadena del objeto JugueteBean.
	 *
	 * @return Una cadena que representa el objeto JugueteBean.
	 */
	@Override
	public String toString() {
	    return "JugueteBean [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen
	            + ", esMas18=" + esMas18 + ", lista=" + lista + ", usuarioSeleccionado=" + usuarioSeleccionado + "]";
	}

}
