package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.unbosque.model.JugueteDTO;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("JugueteBean")
@SessionScoped
public class JugueteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int precio;
	private String id;
	private String nombre;
	private String imagen;
	private boolean esMas18;
	private List<JugueteDTO> lista = new ArrayList<>();
	private JugueteDTO usuarioSeleccionado;

	public JugueteBean() {
		usuarioSeleccionado = new JugueteDTO();
	}

	public void guardar() {

		JugueteDTO nuevoUsuario = new JugueteDTO(precio, id, nombre, imagen, esMas18);
		lista.add(nuevoUsuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Juguete agregado correctamente"));
		limpiarFormulario();
	}

	public void eliminar(JugueteDTO usuario) {
		Iterator<JugueteDTO> iterator = lista.iterator();
		while (iterator.hasNext()) {
			JugueteDTO u = iterator.next();
			if (u.equals(usuario)) {
				iterator.remove();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Juguete eliminado correctamente"));
				break;
			}
		}
	}

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

	private void limpiarFormulario() {
		this.precio = 0;
		this.id = "";
		this.nombre = "";
		this.imagen = "";
		this.esMas18 = false;
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

	public boolean isEsMas18() {
		return esMas18;
	}

	public void setEsMas18(boolean esMas18) {
		this.esMas18 = esMas18;
	}

	public List<JugueteDTO> getLista() {
		return lista;
	}

	public void setLista(List<JugueteDTO> lista) {
		this.lista = lista;
	}

	public JugueteDTO getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(JugueteDTO usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JugueteBean [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen
				+ ", esMas18=" + esMas18 + ", lista=" + lista + ", usuarioSeleccionado=" + usuarioSeleccionado + "]";
	}

}
