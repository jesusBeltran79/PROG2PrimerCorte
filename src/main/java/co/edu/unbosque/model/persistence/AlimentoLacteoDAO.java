package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AlimentoLacteoDTO;

public class AlimentoLacteoDAO implements CRUDOperation<AlimentoLacteoDTO> {
	private ArrayList<AlimentoLacteoDTO> listaAliLacteo;

	private final String SERIAL_NAME = "lista_lacteo.dat";

	public AlimentoLacteoDAO() {
		listaAliLacteo = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
	}

	@Override
	public void crear(AlimentoLacteoDTO nuevoDato) {
		listaAliLacteo.add(nuevoDato);
		writeSerializable();

	}

	@Override
	public void eliminar(AlimentoLacteoDTO nuevoDato) {
		listaAliLacteo.remove(nuevoDato);
		writeSerializable();

	}

	@Override
	public void eliminar(int pos) {
		// TODO Auto-generated method stub
		listaAliLacteo.remove(pos);
		writeSerializable();

	}

	@Override
	public void actualizar(int pos, AlimentoLacteoDTO datoActualizado) {
		// TODO Auto-generated method stub
		listaAliLacteo.set(pos, datoActualizado);
		writeSerializable();

	}

	@Override
	public ArrayList<AlimentoLacteoDTO> buscarTodo() {
		// TODO Auto-generated method stub
		return listaAliLacteo;
	}

	@Override
	public AlimentoLacteoDTO buscarUno(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	public void writeSerializable() {
		FileHandler.writeSerializable(SERIAL_NAME, listaAliLacteo);
	}

	/**
	 * Metodo para leer un serializable
	 */
	public void readSerializable() {
		Object content = FileHandler.readSerializable(SERIAL_NAME);
		listaAliLacteo = (content == null) ? new ArrayList<>() : (ArrayList<AlimentoLacteoDTO>) content;
	}
}
