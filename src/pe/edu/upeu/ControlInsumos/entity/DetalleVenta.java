package pe.edu.upeu.ControlInsumos.entity;

public class DetalleVenta {
	private int id_detalle_venta;
	private int id_venta;
	private int id_producto;
	private double precio_venta;
	private int cantidad_venta;
	public DetalleVenta(int id_detalle_venta, int id_venta, int id_producto, double precio_venta, int cantidad_venta) {
		super();
		this.id_detalle_venta = id_detalle_venta;
		this.id_venta = id_venta;
		this.id_producto = id_producto;
		this.precio_venta = precio_venta;
		this.cantidad_venta = cantidad_venta;
	}
	public DetalleVenta() {
		super();
	}
	public int getId_detalle_venta() {
		return id_detalle_venta;
	}
	public void setId_detalle_venta(int id_detalle_venta) {
		this.id_detalle_venta = id_detalle_venta;
	}
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public int getCantidad_venta() {
		return cantidad_venta;
	}
	public void setCantidad_venta(int cantidad_venta) {
		this.cantidad_venta = cantidad_venta;
	}
	
}
