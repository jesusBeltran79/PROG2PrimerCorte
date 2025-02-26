package co.edu.unbosque.model;

public class JugueteDTO extends Producto {

	private static final long serialVersionUID = 1L;
	private boolean esMas18;

	public JugueteDTO() {

	}

	public JugueteDTO(boolean esMas18) {
		super();
		this.esMas18 = esMas18;
	}

	public JugueteDTO(int precio, String id, String nombre, String imagen, boolean esMas18) {
		super(precio, id, nombre, imagen);
		this.esMas18 = esMas18;
	}

	public JugueteDTO(int precio, String id, String nombre, String imagen) {
		super(precio, id, nombre, imagen);
	}

	public boolean isEsMas18() {
		return esMas18;
	}

	public void setEsMas18(boolean esMas18) {
		this.esMas18 = esMas18;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return super.toString() + "JugueteDTO [esMas18=" + esMas18 + "]";
	}

}
