package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.unbosque.model.AlimentoCarnicoDTO;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("CarnicoBean")
@SessionScoped
public class CarnicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int precio;
	private String id;
	private String nombre;
	private String imagen;
	private String tipoDeCarne;
	private boolean procesada;
	private List<AlimentoCarnicoDTO> lista = new ArrayList<>();
	private AlimentoCarnicoDTO usuarioSeleccionado;

	public void guardar() {

		AlimentoCarnicoDTO nuevoUsuario = new AlimentoCarnicoDTO(precio, id, nombre, imagen, tipoDeCarne, procesada);
		lista.add(nuevoUsuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alimento carnico agregado correctamente"));
		limpiarFormulario();
	}

	public void eliminar(AlimentoCarnicoDTO usuario) {
		Iterator<AlimentoCarnicoDTO> iterator = lista.iterator();
		while (iterator.hasNext()) {
			AlimentoCarnicoDTO u = iterator.next();
			if (u.equals(usuario)) {
				iterator.remove();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Alimento carnico eliminado correctamente"));
				break;
			}
		}
	}

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

	private void limpiarFormulario() {
		this.precio = 0;
		this.id = "";
		this.nombre = "";
		this.imagen = "";
		this.tipoDeCarne = "";
		this.procesada = false;
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

	public String getTipoDeCarne() {
		return tipoDeCarne;
	}

	public void setTipoDeCarne(String tipoDeCarne) {
		this.tipoDeCarne = tipoDeCarne;
	}

	public boolean isProcesada() {
		return procesada;
	}

	public void setProcesada(boolean procesada) {
		this.procesada = procesada;
	}

	public List<AlimentoCarnicoDTO> getLista() {
		return lista;
	}

	public void setLista(List<AlimentoCarnicoDTO> lista) {
		this.lista = lista;
	}

	public AlimentoCarnicoDTO getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(AlimentoCarnicoDTO usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CarnicoBean [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen
				+ ", tipoDeCarne=" + tipoDeCarne + ", procesada=" + procesada + ", lista=" + lista
				+ ", usuarioSeleccionado=" + usuarioSeleccionado + "]";
	}

}
