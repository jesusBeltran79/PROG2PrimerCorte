/**
 * Este paquete model representa el modelo de la arquitectura MVC.
 * 
 * En este paquete es una adicion a la clase modelo, y es la que guarda los datos, y hace que los persistan, y se guarden despues de cerrar el aplicativo 
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AlimentoCarnicoDTO;
/**
 * Clase encargada de la persistencia de alimentos carnicos
 */
public class AlimentoCarnicoDAO implements CRUDOperation<AlimentoCarnicoDTO> {
	/**
	 * Lista de alimentos carnicos
	 */
	private ArrayList<AlimentoCarnicoDTO> listaAliCarnico;
/**
 * Nombre del archivo serializado
 */
	private final String SERIAL_NAME = "lista_Carnico.dat";
	/**
	 * Constructor vacio que inicializa la lista, verifica la existencia de los
	 * folder y lee la informacion del serializable
	 */
	public AlimentoCarnicoDAO() {
		listaAliCarnico = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
	}
/**
 *  Nos trae la lista
 * @return La lista
 */
	public ArrayList<AlimentoCarnicoDTO> getListaAliCarnico() {
		return listaAliCarnico;
	}
/**
 * Le cambia valor a la lista
 * @param nueva lista
 */
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
/**
 * Metodo para escribir serializable
 */
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
