package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * Intefaz CRUD
 * 
 * @param <D> DTO
 * @param <E> Entidad
 */
public interface CRUDOperation<D> {
	public void crear(D nuevoDato);

	public void eliminar(D nuevoDato);

	public void eliminar(int pos);

	public void actualizar(int pos, D datoActualizado);

	public ArrayList<D> buscarTodo();

	public D buscarUno(int pos);
}
