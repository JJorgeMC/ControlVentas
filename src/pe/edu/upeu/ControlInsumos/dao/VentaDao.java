package pe.edu.upeu.ControlInsumos.dao;

import pe.edu.upeu.ControlInsumos.entity.Venta;

public interface VentaDao {
	public int create(Venta v);
	public String getVentasLength();
}
