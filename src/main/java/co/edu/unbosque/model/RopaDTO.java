package co.edu.unbosque.model;

import java.io.Serializable;

public class RopaDTO extends Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String talla;
	private String tipoDePrenda;

	public RopaDTO() {
		
	}

	public RopaDTO(String talla, String tipoDePrenda) {
		super();
		this.talla = talla;
		this.tipoDePrenda = tipoDePrenda;
	}

	public RopaDTO(int precio, String id, String nombre, String imagen, String talla, String tipoDePrenda) {
		super(precio, id, nombre, imagen);
		this.talla = talla;
		this.tipoDePrenda = tipoDePrenda;
	}

	public RopaDTO(int precio, String id, String nombre, String imagen) {
		super(precio, id, nombre, imagen);
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

	@Override
	public String toString() {
		return super.toString()+"RopaDTO [talla=" + talla + ", tipoDePrenda=" + tipoDePrenda + "]";
	}

}
