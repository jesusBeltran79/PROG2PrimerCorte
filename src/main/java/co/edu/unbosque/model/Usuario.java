package co.edu.unbosque.model;

public class Usuario {
String nomUsuario;
String contrasenia;
public Usuario() {
	// TODO Auto-generated constructor stub
}
public Usuario(String nomUsuario, String contrasenia) {
	super();
	this.nomUsuario = nomUsuario;
	this.contrasenia = contrasenia;
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
@Override
public String toString() {
	return "Usuario [nomUsuario=" + nomUsuario + ", contrasenia=" + contrasenia + "]";
}

}
