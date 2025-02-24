package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.RopaDTO;

public class RopaDAO implements CRUDOperation<RopaDTO> {
	private ArrayList<RopaDTO> listaRopa;

	private final String SERIAL_NAME = "lista_ropa.dat";

	public RopaDAO() {
		// TODO Auto-generated constructor stub
		listaRopa = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
	}

	@Override
	public void crear(RopaDTO nuevoDato) {
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
		// TODO Auto-generated method stub
		listaRopa.remove(pos);
		writeSerializable();

	}

	@Override
	public void actualizar(int pos, RopaDTO datoActualizado) {
		// TODO Auto-generated method stub
		listaRopa.set(pos, datoActualizado);
		writeSerializable();

	}

	@Override
	public ArrayList<RopaDTO> buscarTodo() {
		// TODO Auto-generated method stub
		return listaRopa;
	}

	@Override
	public RopaDTO buscarUno(int pos) {
		// TODO Auto-generated method stub
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
