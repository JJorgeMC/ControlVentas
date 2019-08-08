package pe.edu.upeu.ControlInsumos.entity;

public class Cliente {
	private int id_cliente;
	private String nombre_cli;
	private String dni;
	public Cliente(int id_cliente, String nombre_cli, String dni) {
		super();
		this.id_cliente = id_cliente;
		this.nombre_cli = nombre_cli;
		this.dni = dni;
	}
	public Cliente() {
		super();
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNombre_cli() {
		return nombre_cli;
	}
	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
	
