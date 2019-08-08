package pe.edu.upeu.ControlInsumos.entity;

import java.sql.Timestamp;

public class Venta {
	private int id_venta;
	private int id_usuario;
	private int id_cliente;
	private String tipo_doc;
	private Timestamp fecha;
	private String num_doc;
	public Venta(int id_venta, int id_usuario, int id_cliente, String tipo_doc, Timestamp fecha, String num_doc) {
		super();
		this.id_venta = id_venta;
		this.id_usuario = id_usuario;
		this.id_cliente = id_cliente;
		this.tipo_doc = tipo_doc;
		this.fecha = fecha;
		this.num_doc = num_doc;
	}
	public Venta() {
		super();
	}
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getTipo_doc() {
		return tipo_doc;
	}
	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getNum_doc() {
		return num_doc;
	}
	public void setNum_doc(String num_doc) {
		this.num_doc = num_doc;
	}

	
}	