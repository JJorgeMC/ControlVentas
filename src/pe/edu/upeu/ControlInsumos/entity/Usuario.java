package pe.edu.upeu.ControlInsumos.entity;

public class Usuario {
	private int id_usuario;
	private int id_rol;
	private String nombre_usu;
	private String clave;
	public Usuario(int id_usuario, int id_rol, String nombre_usu, String clave) {
		super();
		this.id_usuario = id_usuario;
		this.id_rol = id_rol;
		this.nombre_usu = nombre_usu;
		this.clave = clave;
	}
	public Usuario() {
		super();
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombre_usu() {
		return nombre_usu;
	}
	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
