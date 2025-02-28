/**
 * Este paquete model representa el modelo de la arquitectura MVC.
 * 
 * En este paquete es una adicion a la clase modelo, y es la que guarda los datos, y hace que los persistan, y se guarden despues de cerrar el aplicativo 
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.RopaDTO;

/**
 * Clase encargada de la persistencia de ropa
 */
public class RopaDAO implements CRUDOperation<RopaDTO> {
	/**
	 * Lista de ropas
	 */
	private ArrayList<RopaDTO> listaRopa;
	/**
	 * Nombre del archivo serializado
	 */
	private final String SERIAL_NAME = "lista_ropa.dat";

	/**
	 * Constructor vacio que inicializa la lista, verifica la existencia de los
	 * folder y lee la informacion del serializable
	 */
	public RopaDAO() {
		listaRopa = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();

	}
	/**
	 *  Nos trae la lista
	 * @return La lista
	 */
	public ArrayList<RopaDTO> getListaRopa() {
		return listaRopa;
	}
	/**
	 * Le cambia valor a la lista
	 * @param nueva lista
	 */
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
	/**
	 * Metodo para escribir serializable
	 */
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
