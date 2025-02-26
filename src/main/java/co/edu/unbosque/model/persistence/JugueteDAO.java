package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.JugueteDTO;

public class JugueteDAO implements CRUDOperation<JugueteDTO> {
	
	private ArrayList<JugueteDTO> listaJuguete;

	private final String SERIAL_NAME = "lista_juguete.dat";

	public JugueteDAO() {
		listaJuguete = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
	}

	public ArrayList<JugueteDTO> getListaJuguete() {
		return listaJuguete;
	}

	public void setListaJuguete(ArrayList<JugueteDTO> listaJuguete) {
		this.listaJuguete = listaJuguete;
	}

	@Override
	public void crear(JugueteDTO nuevoDato) {
		if (listaJuguete.isEmpty()) {
			listaJuguete = new ArrayList<>();
		}
		listaJuguete.add(nuevoDato);
		writeSerializable();
	}

	@Override
	public void eliminar(JugueteDTO nuevoDato) {
		listaJuguete.remove(nuevoDato);
		writeSerializable();

	}

	@Override
	public void eliminar(int pos) {
		listaJuguete.remove(pos);
		writeSerializable();

	}

	@Override
	public void actualizar(int pos, JugueteDTO datoActualizado) {
		listaJuguete.set(pos, datoActualizado);
		writeSerializable();

	}

	@Override
	public ArrayList<JugueteDTO> buscarTodo() {
		return listaJuguete;
	}

	@Override
	public JugueteDTO buscarUno(int pos) {
		return null;
	}

	public void writeSerializable() {
		FileHandler.writeSerializable(SERIAL_NAME, listaJuguete);
	}

	/**
	 * Metodo para leer un serializable
	 */
	public void readSerializable() {
		Object content = FileHandler.readSerializable(SERIAL_NAME);
		listaJuguete = (content == null) ? new ArrayList<>() : (ArrayList<JugueteDTO>) content;
	}
}
