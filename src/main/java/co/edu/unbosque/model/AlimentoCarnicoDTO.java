package co.edu.unbosque.model;

import java.io.Serializable;

public class AlimentoCarnicoDTO extends Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tipoDeCarne;
	private boolean procesada;

	public AlimentoCarnicoDTO() {
		
	}

	public AlimentoCarnicoDTO(String tipoDeCarne, boolean procesada) {
		super();
		this.tipoDeCarne = tipoDeCarne;
		this.procesada = procesada;
	}

	public AlimentoCarnicoDTO(int precio, String id, String nombre, String imagen, String tipoDeCarne,
			boolean procesada) {
		super(precio, id, nombre, imagen);
		this.tipoDeCarne = tipoDeCarne;
		this.procesada = procesada;
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

	@Override
	public String toString() {
		return super.toString()+"AlimentoCarnicoDTO [tipoDeCarne=" + tipoDeCarne + ", procesada=" + procesada + "]";
	}

}
