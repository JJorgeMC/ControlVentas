package pe.edu.upeu.ControlInsumos.entity;

public class Producto {
	private int id_producto;
	private int id_categoria;
	private String nombre_pro;
	private double precio;
	private int cantidad;
	public Producto(int id_producto, int id_categoria, String nombre_pro, double precio, int cantidad) {
		super();
		this.id_producto = id_producto;
		this.id_categoria = id_categoria;
		this.nombre_pro = nombre_pro;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public Producto() {
		super();
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre_pro() {
		return nombre_pro;
	}
	public void setNombre_pro(String nombre_pro) {
		this.nombre_pro = nombre_pro;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
