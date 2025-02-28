/**
 * Paquete beans. Usado para poder tener una interaccion entre el back y el front. En el back van los datos dirijidos a sus respectivos daos y front a sus respectivos .xhtml
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import co.edu.unbosque.model.RopaDTO;
import co.edu.unbosque.model.persistence.RopaDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("RopaBean")
@SessionScoped
/**
 * Clase que representa el bean de la ropa. Implementa la interfaz Serializable
 * para permitir la persistencia de la ropa. A su vez es la que tiene la
 * conexion entre los datos en el DAO y el front en los .xhtml
 */
public class RopaBean implements Serializable {

	/**
	 * Número de versión serial para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Precio de la prenda.
	 */
	private int precio;

	/**
	 * Identificador único de la prenda.
	 */
	private String id;

	/**
	 * Nombre de la prenda.
	 */
	private String nombre;

	/**
	 * Ruta de la imagen de la prenda.
	 */
	private String imagen;

	/**
	 * Talla de la prenda.
	 */
	private String talla;

	/**
	 * Tipo de prenda (ej. Camisa, Pantalón, etc.).
	 */
	private String tipoDePrenda;

	/**
	 * Indica si el botón asociado a la prenda debe ser visible.
	 */
	private boolean botonVisible = true;

	/**
	 * Lista de objetos RopaDTO (Data Transfer Object) asociados a la prenda.
	 */
	private List<RopaDTO> lista = new ArrayList<>();

	/**
	 * Objeto RopaDTO seleccionado.
	 */
	private RopaDTO usuarioSeleccionado;

	/**
	 * Objeto RopaDAO (Data Access Object) para interactuar con la base de datos de
	 * ropa.
	 */
	private RopaDAO ropaDAO = new RopaDAO();
/**
 * Constructor vacio. Nos trae la lista y el seleccionado por el usuario
 */
	public RopaBean() {
		usuarioSeleccionado = new RopaDTO();
		lista = ropaDAO.getListaRopa();
	}
/**
 * Metodo usado para poder guardar la informacion
 */
	public void guardar() {

		Random r = new Random();
		int aleatorio = 1000000 + r.nextInt(9000000);
		String identificacion = String.valueOf(aleatorio);
		RopaDTO nuevoUsuario = new RopaDTO(precio, identificacion, nombre, imagen, talla, tipoDePrenda);
		if (lista.isEmpty()) {
			lista.add(nuevoUsuario);
		} else {
			ropaDAO.crear(nuevoUsuario);
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ropa agregada correctamente"));
		limpiarFormulario();
	}
/**
 * Metodo usado para poder eliminar respecto a una informacion dada
 * @param usuario Nos da el valor del usuario 
 */
	public void eliminar(RopaDTO usuario) {
		Iterator<RopaDTO> iterator = lista.iterator();
		while (iterator.hasNext()) {
			RopaDTO u = iterator.next();
			if (u.equals(usuario)) {
				ropaDAO.eliminar(u);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ropa eliminada correctamente"));
				break;
			}
		}
	}
/**
 * Metodo actualizar del crud, el cual actualiza la informacion que se quiera ver
 */
	public void actualizar() {
		if (usuarioSeleccionado != null) {
			for (RopaDTO u : lista) {
				if (u.equals(usuarioSeleccionado)) {
					u.getPrecio();
					u.getId();
					u.getNombre();
					u.getImagen();
					u.getTalla();
					u.getTipoDePrenda();

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Ropa actualizado correctamente"));
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
		this.talla = "";
		this.tipoDePrenda = "";
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
	 * Obtiene el precio de la prenda de ropa.
	 *
	 * @return El precio de la prenda de ropa.
	 */
	public int getPrecio() {
	    return precio;
	}

	/**
	 * Establece el precio de la prenda de ropa.
	 *
	 * @param precio El precio de la prenda de ropa.
	 */
	public void setPrecio(int precio) {
	    this.precio = precio;
	}

	/**
	 * Obtiene el ID de la prenda de ropa.
	 *
	 * @return El ID de la prenda de ropa.
	 */
	public String getId() {
	    return id;
	}

	/**
	 * Establece el ID de la prenda de ropa.
	 *
	 * @param id El ID de la prenda de ropa.
	 */
	public void setId(String id) {
	    this.id = id;
	}

	/**
	 * Obtiene el nombre de la prenda de ropa.
	 *
	 * @return El nombre de la prenda de ropa.
	 */
	public String getNombre() {
	    return nombre;
	}

	/**
	 * Establece el nombre de la prenda de ropa.
	 *
	 * @param nombre El nombre de la prenda de ropa.
	 */
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	/**
	 * Obtiene la ruta de la imagen de la prenda de ropa.
	 *
	 * @return La ruta de la imagen de la prenda de ropa.
	 */
	public String getImagen() {
	    return imagen;
	}

	/**
	 * Establece la ruta de la imagen de la prenda de ropa.
	 *
	 * @param imagen La ruta de la imagen de la prenda de ropa.
	 */
	public void setImagen(String imagen) {
	    this.imagen = imagen;
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
	 * Obtiene la lista de objetos RopaDTO asociados a esta prenda de ropa.
	 *
	 * @return La lista de objetos RopaDTO.
	 */
	public List<RopaDTO> getLista() {
	    return lista;
	}

	/**
	 * Establece la lista de objetos RopaDTO asociados a esta prenda de ropa.
	 *
	 * @param lista La lista de objetos RopaDTO.
	 */
	public void setLista(List<RopaDTO> lista) {
	    this.lista = lista;
	}

	/**
	 * Obtiene el objeto RopaDTO seleccionado.
	 *
	 * @return El objeto RopaDTO seleccionado.
	 */
	public RopaDTO getUsuarioSeleccionado() {
	    return usuarioSeleccionado;
	}

	/**
	 * Establece el objeto RopaDTO seleccionado.
	 *
	 * @param usuarioSeleccionado El objeto RopaDTO seleccionado.
	 */
	public void setUsuarioSeleccionado(RopaDTO usuarioSeleccionado) {
	    this.usuarioSeleccionado = usuarioSeleccionado;
	}

	/**
	 * Devuelve una representación en cadena del objeto RopaBean.
	 *
	 * @return Una cadena que representa el objeto RopaBean.
	 */
	@Override
	public String toString() {
	    return "RopaBean [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", talla="
	            + talla + ", tipoDePrenda=" + tipoDePrenda + ", lista=" + lista + ", usuarioSeleccionado="
	            + usuarioSeleccionado + "]";
	}

}
