/**
 * Paquete beans. Usado para poder tener una interaccion entre el back y el front. En el back van los datos dirijidos a sus respectivos daos y front a sus respectivos .xhtml
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import co.edu.unbosque.model.AlimentoLacteoDTO;
import co.edu.unbosque.model.persistence.AlimentoLacteoDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("LacteoBean")
@SessionScoped

/**
 * Clase que representa el bean de los alimentos lacteos. Implementa la interfaz Serializable
 * para permitir la persistencia de los alimentos lacteos. A su vez es la que tiene la
 * conexion entre los datos en el DAO y el front en los .xhtml
 */
public class LacteoBean implements Serializable {

	/**
     * Identificador único para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Precio del alimento lácteo.
     */
    private int precio;

    /**
     * Identificador del alimento lácteo.
     */
    private String id;

    /**
     * Nombre del alimento lácteo.
     */
    private String nombre;

    /**
     * Ruta de la imagen del alimento lácteo.
     */
    private String imagen;

    /**
     * Indica si el alimento lácteo no contiene lactosa.
     */
    private boolean sinLactosa;

    /**
     * Tipo de leche del alimento lácteo.
     */
    private String tipoDeLeche;

    /**
     * Indica si el botón asociado al alimento lácteo es visible.
     */
    private boolean botonVisible = true;

    /**
     * Lista de alimentos lácteos.
     */
    private List<AlimentoLacteoDTO> lista = new ArrayList<>();

    /**
     * Alimento lácteo seleccionado por el usuario.
     */
    private AlimentoLacteoDTO usuarioSeleccionado;

    /**
     * Acceso a la base de datos de alimentos lácteos.
     */
    private AlimentoLacteoDAO lacteoDAO = new AlimentoLacteoDAO();
	/**
	 * Constructor vacio. Nos trae la lista y el seleccionado por el usuario
	 */
	public LacteoBean() {
		usuarioSeleccionado = new AlimentoLacteoDTO();
		lista = lacteoDAO.getListaAliLacteo();
	}
	/**
	 * Metodo usado para poder guardar la informacion
	 */
	public void guardar() {
		Random r = new Random();
		int aleatorio = 1000000 + r.nextInt(9000000);
		String identificacion = String.valueOf(aleatorio);
		AlimentoLacteoDTO nuevoUsuario = new AlimentoLacteoDTO(precio, identificacion, nombre, imagen, sinLactosa,
				tipoDeLeche);
		if (lista.isEmpty()) {
			lista.add(nuevoUsuario);
		}else {
			lacteoDAO.crear(nuevoUsuario);
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alimento lacteo agregado correctamente"));
		limpiarFormulario();
	}
	/**
	 * Metodo usado para poder eliminar respecto a una informacion dada
	 * @param usuario Nos da el valor del usuario 
	 */

	public void eliminar(AlimentoLacteoDTO usuario) {
		Iterator<AlimentoLacteoDTO> iterator = lista.iterator();
		while (iterator.hasNext()) {
			AlimentoLacteoDTO u = iterator.next();
			if (u.equals(usuario)) {
				lacteoDAO.eliminar(u);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Alimento lacteo eliminado correctamente"));
				break;
			}
		}
	}
	/**
	 * Metodo actualizar del crud, el cual actualiza la informacion que se quiera ver
	 */
	public void actualizar() {
		if (usuarioSeleccionado != null) {
			for (AlimentoLacteoDTO u : lista) {
				if (u.equals(usuarioSeleccionado)) {
					u.getPrecio();
					u.getId();
					u.getNombre();
					u.getImagen();
					u.isSinLactosa();
					u.getTipoDeLacteo();
					
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Alimento lacteo actualizado correctamente"));
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
		this.sinLactosa = false;
		this.tipoDeLeche = "";
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
	 * Obtiene el precio del alimento lácteo.
	 *
	 * @return El precio del alimento lácteo.
	 */
	public int getPrecio() {
	    return precio;
	}

	/**
	 * Establece el precio del alimento lácteo.
	 *
	 * @param precio El precio del alimento lácteo.
	 */
	public void setPrecio(int precio) {
	    this.precio = precio;
	}

	/**
	 * Obtiene el ID del alimento lácteo.
	 *
	 * @return El ID del alimento lácteo.
	 */
	public String getId() {
	    return id;
	}

	/**
	 * Establece el ID del alimento lácteo.
	 *
	 * @param id El ID del alimento lácteo.
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * Obtiene el nombre del alimento lácteo.
	 *
	 * @return El nombre del alimento lácteo.
	 */
	public String getNombre() {
	    return nombre;
	}

	/**
	 * Establece el nombre del alimento lácteo.
	 *
	 * @param nombre El nombre del alimento lácteo.
	 */
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	/**
	 * Obtiene la ruta de la imagen del alimento lácteo.
	 *
	 * @return La ruta de la imagen del alimento lácteo.
	 */
	public String getImagen() {
	    return imagen;
	}

	/**
	 * Establece la ruta de la imagen del alimento lácteo.
	 *
	 * @param imagen La ruta de la imagen del alimento lácteo.
	 */
	public void setImagen(String imagen) {
	    this.imagen = imagen;
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
	 * Obtiene el tipo de leche del alimento lácteo.
	 *
	 * @return El tipo de leche del alimento lácteo.
	 */
	public String getTipoDeLeche() {
	    return tipoDeLeche;
	}

	/**
	 * Establece el tipo de leche del alimento lácteo.
	 *
	 * @param tipoDeLeche El tipo de leche del alimento lácteo.
	 */
	public void setTipoDeLeche(String tipoDeLeche) {
	    this.tipoDeLeche = tipoDeLeche;
	}

	/**
	 * Obtiene la lista de objetos AlimentoLacteoDTO asociados a este alimento lácteo.
	 *
	 * @return La lista de objetos AlimentoLacteoDTO.
	 */
	public List<AlimentoLacteoDTO> getLista() {
	    return lista;
	}

	/**
	 * Establece la lista de objetos AlimentoLacteoDTO asociados a este alimento lácteo.
	 *
	 * @param lista La lista de objetos AlimentoLacteoDTO.
	 */
	public void setLista(List<AlimentoLacteoDTO> lista) {
	    this.lista = lista;
	}

	/**
	 * Obtiene el objeto AlimentoLacteoDTO seleccionado.
	 *
	 * @return El objeto AlimentoLacteoDTO seleccionado.
	 */
	public AlimentoLacteoDTO getUsuarioSeleccionado() {
	    return usuarioSeleccionado;
	}

	/**
	 * Establece el objeto AlimentoLacteoDTO seleccionado.
	 *
	 * @param usuarioSeleccionado El objeto AlimentoLacteoDTO seleccionado.
	 */
	public void setUsuarioSeleccionado(AlimentoLacteoDTO usuarioSeleccionado) {
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
	 * Devuelve una representación en cadena del objeto LacteoBean.
	 *
	 * @return Una cadena que representa el objeto LacteoBean.
	 */
	@Override
	public String toString() {
	    return "LacteoBean [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen
	            + ", sinLactosa=" + sinLactosa + ", tipoDeLeche=" + tipoDeLeche + ", lista=" + lista
	            + ", usuarioSeleccionado=" + usuarioSeleccionado + "]";
	}

}
