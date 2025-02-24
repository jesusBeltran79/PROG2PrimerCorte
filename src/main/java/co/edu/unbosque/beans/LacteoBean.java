package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.unbosque.model.AlimentoLacteoDTO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("LacteoBean")
@SessionScoped
public class LacteoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int precio;
	private String id;
	private String nombre;
	private String imagen;
	private boolean sinLactosa;
	private String tipoDeLeche;
	private List<AlimentoLacteoDTO> lista = new ArrayList<>();
	private AlimentoLacteoDTO usuarioSeleccionado;

	public void guardar() {

		AlimentoLacteoDTO nuevoUsuario = new AlimentoLacteoDTO(precio, id, nombre, imagen, sinLactosa, tipoDeLeche);
		lista.add(nuevoUsuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alimento lacteo agregado correctamente"));
		limpiarFormulario();
	}

	public void eliminar(AlimentoLacteoDTO usuario) {
		Iterator<AlimentoLacteoDTO> iterator = lista.iterator();
		while (iterator.hasNext()) {
			AlimentoLacteoDTO u = iterator.next();
			if (u.equals(usuario)) {
				iterator.remove();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Alimento lacteo eliminado correctamente"));
				break;
			}
		}
	}

	public void actualizar() {
		if (usuarioSeleccionado != null) {
			for (AlimentoLacteoDTO u : lista) {
				if (u.equals(usuarioSeleccionado)) {
					u.getPrecio();
					u.getId();
					u.getNombre();
					u.getImagen();
					u.isSinLactosa();
					u.getTipoDeLeche();

					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Alimento lacteo actualizado correctamente"));
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
		this.sinLactosa = false;
		this.tipoDeLeche = "";
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

	public boolean isSinLactosa() {
		return sinLactosa;
	}

	public void setSinLactosa(boolean sinLactosa) {
		this.sinLactosa = sinLactosa;
	}

	public String getTipoDeLeche() {
		return tipoDeLeche;
	}

	public void setTipoDeLeche(String tipoDeLeche) {
		this.tipoDeLeche = tipoDeLeche;
	}

	public List<AlimentoLacteoDTO> getLista() {
		return lista;
	}

	public void setLista(List<AlimentoLacteoDTO> lista) {
		this.lista = lista;
	}

	public AlimentoLacteoDTO getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(AlimentoLacteoDTO usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "LacteoBean [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen
				+ ", sinLactosa=" + sinLactosa + ", tipoDeLeche=" + tipoDeLeche + ", lista=" + lista
				+ ", usuarioSeleccionado=" + usuarioSeleccionado + "]";
	}

}
