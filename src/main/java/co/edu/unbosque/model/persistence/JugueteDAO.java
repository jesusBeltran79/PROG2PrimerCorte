package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.JugueteDTO;

public class JugueteDAO implements CRUDOperation<JugueteDTO> {
	private ArrayList<JugueteDTO> listaJuguete;

	private final String SERIAL_NAME = "lista_juguete.dat";

	public JugueteDAO() {
		// TODO Auto-generated constructor stub
		listaJuguete = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
	}

	@Override
	public void crear(JugueteDTO nuevoDato) {
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
		// TODO Auto-generated method stub
		listaJuguete.remove(pos);
		writeSerializable();

	}

	@Override
	public void actualizar(int pos, JugueteDTO datoActualizado) {
		// TODO Auto-generated method stub
		listaJuguete.set(pos, datoActualizado);
		writeSerializable();

	}

	@Override
	public ArrayList<JugueteDTO> buscarTodo() {
		// TODO Auto-generated method stub
		return listaJuguete;
	}

	@Override
	public JugueteDTO buscarUno(int pos) {
		// TODO Auto-generated method stub
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
