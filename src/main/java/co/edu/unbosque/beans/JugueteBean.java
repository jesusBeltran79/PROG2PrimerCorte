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

	public void guardar() {

		JugueteDTO nuevoUsuario = new JugueteDTO(precio, id, nombre, imagen, esMas18);
		lista.add(nuevoUsuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario agregado correctamente"));
		limpiarFormulario();
	}

	public void eliminar(JugueteDTO usuario) {
		Iterator<JugueteDTO> iterator = lista.iterator();
		while (iterator.hasNext()) {
			JugueteDTO u = iterator.next();
			if (u.equals(usuario)) {
				iterator.remove();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario eliminado correctamente"));
				break;
			}
		}
	}

	public void actualizar() {
		if (usuarioSeleccionado != null) {
			for (JugueteDTO u : lista) {
				if (u.equals(usuarioSeleccionado)) {
					u.getPrecio();
					u.getId();
					u.getNombre();
					u.getImagen();
					u.isEsMas18();
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Usuario actualizado correctamente"));
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

}
