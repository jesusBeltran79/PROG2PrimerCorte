package co.edu.unbosque.model;

public class AlimentoCarnicoDTO extends Producto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoDeCarne;
	private boolean procesada;

	public AlimentoCarnicoDTO() {
		// TODO Auto-generated constructor stub
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AlimentoCarnicoDTO [tipoDeCarne=" + tipoDeCarne + ", procesada=" + procesada + "]";
	}

}
