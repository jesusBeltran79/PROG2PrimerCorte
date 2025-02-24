package co.edu.unbosque.model;

public class AlimentoLacteoDTO extends Producto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean sinLactosa;
	private String tipoDeLeche;

	public AlimentoLacteoDTO() {
		// TODO Auto-generated constructor stub
	}

	public AlimentoLacteoDTO(boolean sinLactosa, String tipoDeLeche) {
		super();
		this.sinLactosa = sinLactosa;
		this.tipoDeLeche = tipoDeLeche;
	}

	public AlimentoLacteoDTO(int precio, String id, String nombre, String imagen, boolean sinLactosa,
			String tipoDeLeche) {
		super(precio, id, nombre, imagen);
		this.sinLactosa = sinLactosa;
		this.tipoDeLeche = tipoDeLeche;
	}

	public AlimentoLacteoDTO(int precio, String id, String nombre, String imagen) {
		super(precio, id, nombre, imagen);
		// TODO Auto-generated constructor stub
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AlimentoLacteoDTO [sinLactosa=" + sinLactosa + ", tipoDeLeche=" + tipoDeLeche + "]";
	}

}
