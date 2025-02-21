package co.edu.unbosque.beans;

import java.time.LocalDate;

import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;

//Las anotaciones empizan con @

@Named("UserBean")
@RequestScoped // Visibilidad de datos en donde se van a cargar unicamente cuando se genere una
				// solicitud.
//@ApplicationScoped Sirve para que la informacion de otras paginas se pueda usar, ya que la anterior, cuando se cambia de pagina no libera la memoria.
//@ViewScoped 

public class UserBean {// Este es el bean de la logica de la pagina de usuarios.
//Se recomienda crear un atributo para cada input del front.
	private String nomUsuario;
	private String contrasenia;
	private boolean checkBox;
	private LocalDate date9;

	public UserBean() {

	}

	public LocalDate getDate9() {
		return date9;
	}

	public void setDate9(LocalDate date9) {
		this.date9 = date9;
	}

	public boolean isCheckBox() {
		return checkBox;
	}

	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void guardar() {
		System.out.println(nomUsuario);
		System.out.println(contrasenia);

		System.out.println(checkBox);
		System.out.println(date9);
	}

	public void eliminar() {
		this.nomUsuario = "";
		this.contrasenia = "";
	}

}
