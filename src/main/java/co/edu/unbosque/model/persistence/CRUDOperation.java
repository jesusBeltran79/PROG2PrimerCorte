package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * Intefaz CRUD
 * 
 * @param <D> DTO
 * @param <E> Entidad
 */
public interface CRUDOperation<D> {
	/**
	 * Metodo que nos hace crear un nuevo dato
	 * @param nuevoDato El dato nuevo
	 */
	public void crear(D nuevoDato);
/**
 * Metodo que nos trae la informacion para encontrar quien se va a eliminar
 * @param nuevoDato Dato a eliminar
 */
	public void eliminar(D nuevoDato);
/**
 * Metodo que nos trae la posicion del dato a eliminar
 * @param pos Posicion del dato
 */
	public void eliminar(int pos);
/**
 * Metodo para actualizar por posicion 
 * @param pos Posicion a actualizar
 * @param datoActualizado Informacion del dato a actualizar
 */
	public void actualizar(int pos, D datoActualizado);
/**
 * Nos busca toda la informacion dentro del array
 * @return La lista completa
 */
	public ArrayList<D> buscarTodo();
/**
 * Nos busca un dato exacto por posicion
 * @param pos Posicion a buscar
 * @return Nos retorna el dato en dicha posicion
 */
	public D buscarUno(int pos);
}
