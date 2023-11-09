package models.entity;

import java.util.List;

public class Usuario {

	private int id;

	private String usuario;

	private String contrasena;

	private String nombre;

	private String apellido;

	private String telefono;

	private String direccion;

	private String email;

	private String sexo;

	private List<Role> roles;

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public Usuario(int id, String usuario, String contrasena, String nombre, String apellido, String telefono,
			String direccion, String email, String sexo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.sexo = sexo;
	}

	public Usuario(int id, String usuario, String contrasena, List<Role> roles) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email
				+ ", sexo=" + sexo + ", roles=" + roles + "]";
	}

}
