/**
 * Este paquete model representa el modelo de la arquitectura MVC.
 * 
 * En este paquete es una adicion a la clase modelo, y es la que guarda los datos, y hace que los persistan, y se guarden despues de cerrar el aplicativo 
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AlimentoLacteoDTO;
/**
 * Clase encargada de la persistencia de alimentos lacteos
 */
public class AlimentoLacteoDAO implements CRUDOperation<AlimentoLacteoDTO> {
	/**
	 * Lista de alimentos lacteos
	 */
	private ArrayList<AlimentoLacteoDTO> listaAliLacteo;
	/**
	 * Nombre del archivo serializado
	 */
	private final String SERIAL_NAME = "lista_Lacteo.dat";
	/**
	 * Constructor vacio que inicializa la lista, verifica la existencia de los
	 * folder y lee la informacion del serializable
	 */
	public AlimentoLacteoDAO() {
		listaAliLacteo = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
	}
	/**
	 *  Nos trae la lista
	 * @return La lista
	 */
	public ArrayList<AlimentoLacteoDTO> getListaAliLacteo() {
		return listaAliLacteo;
	}
	/**
	 * Le cambia valor a la lista
	 * @param nueva lista
	 */
	public void setListaAliLacteo(ArrayList<AlimentoLacteoDTO> listaAliLacteo) {
		this.listaAliLacteo = listaAliLacteo;
	}

	@Override
	public void crear(AlimentoLacteoDTO nuevoDato) {
		if (listaAliLacteo.isEmpty()) {
			listaAliLacteo = new ArrayList<>();
		}
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
	/**
	 * Metodo para escribir serializable
	 */
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
