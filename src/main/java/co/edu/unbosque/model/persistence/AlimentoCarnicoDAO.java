package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AlimentoCarnicoDTO;

public class AlimentoCarnicoDAO implements CRUDOperation<AlimentoCarnicoDTO> {
	
	private ArrayList<AlimentoCarnicoDTO> listaAliCarnico;

	private final String SERIAL_NAME = "lista_Carnico.dat";

	public AlimentoCarnicoDAO() {
		listaAliCarnico = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
	}

	public ArrayList<AlimentoCarnicoDTO> getListaAliCarnico() {
		return listaAliCarnico;
	}

	public void setListaAliCarnico(ArrayList<AlimentoCarnicoDTO> listaAliCarnico) {
		this.listaAliCarnico = listaAliCarnico;
	}

	@Override
	public void crear(AlimentoCarnicoDTO nuevoDato) {		
		if (listaAliCarnico.isEmpty()) {
		listaAliCarnico = new ArrayList<>();
	}
		listaAliCarnico.add(nuevoDato);
		writeSerializable();
	}

	@Override
	public void eliminar(AlimentoCarnicoDTO nuevoDato) {
		listaAliCarnico.remove(nuevoDato);
		writeSerializable();

	}

	@Override
	public void eliminar(int pos) {
		// TODO Auto-generated method stub
		listaAliCarnico.remove(pos);
		writeSerializable();

	}

	@Override
	public void actualizar(int pos, AlimentoCarnicoDTO datoActualizado) {
		// TODO Auto-generated method stub
		listaAliCarnico.set(pos, datoActualizado);
		writeSerializable();

	}

	@Override
	public ArrayList<AlimentoCarnicoDTO> buscarTodo() {
		// TODO Auto-generated method stub
		return listaAliCarnico;
	}

	@Override
	public AlimentoCarnicoDTO buscarUno(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	public void writeSerializable() {
		FileHandler.writeSerializable(SERIAL_NAME, listaAliCarnico);
	}

	/**
	 * Metodo para leer un serializable
	 */
	public void readSerializable() {
		Object content = FileHandler.readSerializable(SERIAL_NAME);
		listaAliCarnico = (content == null) ? new ArrayList<>() : (ArrayList<AlimentoCarnicoDTO>) content;
	}

}
