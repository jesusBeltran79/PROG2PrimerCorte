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
public class RopaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int precio;
	private String id;
	private String nombre;
	private String imagen;
	private String talla;
	private String tipoDePrenda;
	private boolean botonVisible = true;
	private List<RopaDTO> lista = new ArrayList<>();
	private RopaDTO usuarioSeleccionado;
	private RopaDAO ropaDAO = new RopaDAO();

	public RopaBean() {
		usuarioSeleccionado = new RopaDTO();
		lista = ropaDAO.getListaRopa();
	}

	public void guardar() {

		Random r = new Random();
		int aleatorio = 1000000 + r.nextInt(9000000);
		String identificacion = String.valueOf(aleatorio);
		RopaDTO nuevoUsuario = new RopaDTO(precio, identificacion, nombre, imagen, talla, tipoDePrenda);
		if (lista.isEmpty()) {
			lista.add(nuevoUsuario);
		}else {
			ropaDAO.crear(nuevoUsuario);
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ropa agregada correctamente"));
		limpiarFormulario();
	}

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

	private void limpiarFormulario() {
		this.precio = 0;
		this.id = "";
		this.nombre = "";
		this.imagen = "";
		this.talla = "";
		this.tipoDePrenda = "";
	}

	public boolean isBotonVisible() {
		return botonVisible;
	}

	public void ejecutarAccion() {
		// Lógica del botón
		System.out.println("Botón presionado");

		// Ocultar el botón después de presionarlo
		botonVisible = false;
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

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getTipoDePrenda() {
		return tipoDePrenda;
	}

	public void setTipoDePrenda(String tipoDePrenda) {
		this.tipoDePrenda = tipoDePrenda;
	}

	public List<RopaDTO> getLista() {
		return lista;
	}

	public void setLista(List<RopaDTO> lista) {
		this.lista = lista;
	}

	public RopaDTO getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(RopaDTO usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	@Override
	public String toString() {
		return "RopaBean [precio=" + precio + ", id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", talla="
				+ talla + ", tipoDePrenda=" + tipoDePrenda + ", lista=" + lista + ", usuarioSeleccionado="
				+ usuarioSeleccionado + "]";
	}

}
