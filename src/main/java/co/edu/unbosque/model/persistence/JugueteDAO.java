/**
 * Este paquete model representa el modelo de la arquitectura MVC.
 * 
 * En este paquete es una adicion a la clase modelo, y es la que guarda los datos, y hace que los persistan, y se guarden despues de cerrar el aplicativo 
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.JugueteDTO;
/**
 * Clase encargada de la persistencia de juguetes
 */
public class JugueteDAO implements CRUDOperation<JugueteDTO> {
	/**
	 * Lista de juguetes
	 */
	private ArrayList<JugueteDTO> listaJuguete;
	/**
	 * Nombre del archivo serializado
	 */
	private final String SERIAL_NAME = "lista_juguete.dat";
	/**
	 * Constructor vacio que inicializa la lista, verifica la existencia de los
	 * folder y lee la informacion del serializable
	 */
	public JugueteDAO() {
		listaJuguete = new ArrayList<>();
		FileHandler.checkFolder();
		readSerializable();
	}
	/**
	 *  Nos trae la lista
	 * @return La lista
	 */
	public ArrayList<JugueteDTO> getListaJuguete() {
		return listaJuguete;
	}
	/**
	 * Le cambia valor a la lista
	 * @param nueva lista
	 */
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
	/**
	 * Metodo para escribir serializable
	 */
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
