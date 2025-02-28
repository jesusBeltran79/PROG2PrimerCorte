package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.RopaDTO;

public class RopaDAO implements CRUDOperation<RopaDTO> {
	
	private ArrayList<RopaDTO> listaRopa;

	private final String SERIAL_NAME = "lista_ropa.dat";

	public RopaDAO() {
		listaRopa = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
		
	}

	public ArrayList<RopaDTO> getListaRopa() {
		return listaRopa;
	}

	public void setListaRopa(ArrayList<RopaDTO> listaRopa) {
		this.listaRopa = listaRopa;
	}

	@Override
	public void crear(RopaDTO nuevoDato) {
		if (listaRopa.isEmpty()) {
			listaRopa = new ArrayList<>();
		}
		listaRopa.add(nuevoDato);
		writeSerializable();
	}

	@Override
	public void eliminar(RopaDTO nuevoDato) {
		listaRopa.remove(nuevoDato);
		writeSerializable();
	}

	@Override
	public void eliminar(int pos) {
		listaRopa.remove(pos);
		writeSerializable();
	}

	@Override
	public void actualizar(int pos, RopaDTO datoActualizado) {
		listaRopa.set(pos, datoActualizado);
		writeSerializable();
	}

	@Override
	public ArrayList<RopaDTO> buscarTodo() {
		return listaRopa;
	}

	@Override
	public RopaDTO buscarUno(int pos) {
		return null;
	}

	public void writeSerializable() {
		FileHandler.writeSerializable(SERIAL_NAME, listaRopa);
	}

	/**
	 * Metodo para leer un serializable
	 */
	public void readSerializable() {
		Object content = FileHandler.readSerializable(SERIAL_NAME);
		listaRopa = (content == null) ? new ArrayList<>() : (ArrayList<RopaDTO>) content;
	}
}
