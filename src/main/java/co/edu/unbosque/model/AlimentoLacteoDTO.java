package co.edu.unbosque.model;

public class AlimentoLacteoDTO extends Producto {

	private static final long serialVersionUID = 1L;
	private boolean sinLactosa;
	private String tipoDeLacteo;

	public AlimentoLacteoDTO() {
		
	}

	public AlimentoLacteoDTO(boolean sinLactosa, String tipoDeLacteo) {
		super();
		this.sinLactosa = sinLactosa;
		this.tipoDeLacteo = tipoDeLacteo;
	}

	public AlimentoLacteoDTO(int precio, String id, String nombre, String imagen, boolean sinLactosa,
			String tipoDeLacteo) {
		super(precio, id, nombre, imagen);
		this.sinLactosa = sinLactosa;
		this.tipoDeLacteo = tipoDeLacteo;
	}

	public AlimentoLacteoDTO(int precio, String id, String nombre, String imagen) {
		super(precio, id, nombre, imagen);
	}

	public boolean isSinLactosa() {
		return sinLactosa;
	}

	public void setSinLactosa(boolean sinLactosa) {
		this.sinLactosa = sinLactosa;
	}

	public String getTipoDeLacteo() {
		return tipoDeLacteo;
	}

	public void setTipoDeLacteo(String tipoDeLacteo) {
		this.tipoDeLacteo = tipoDeLacteo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return super.toString() + "AlimentoLacteoDTO [sinLactosa=" + sinLactosa + ", tipoDeLacteo=" + tipoDeLacteo + "]";
	}

}
