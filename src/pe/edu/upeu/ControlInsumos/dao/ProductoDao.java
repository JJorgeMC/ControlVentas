package pe.edu.upeu.ControlInsumos.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.ControlInsumos.entity.Producto;

public interface ProductoDao {
	public int create (Producto p);
	public int update (Producto p);
	public int delete (int id);
	public Producto read(int id);
	public List<Map<String, Object>> readall();
	public int updateStock(int id, int cant);
}
