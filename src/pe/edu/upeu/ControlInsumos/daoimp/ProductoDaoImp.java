package pe.edu.upeu.ControlInsumos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.ControlInsumos.dao.ProductoDao;
import pe.edu.upeu.ControlInsumos.entity.Categoria;
import pe.edu.upeu.ControlInsumos.entity.Producto;
import pe.edu.upeu.ControlInsumos.util.Conexion;

public class ProductoDaoImp implements ProductoDao{
	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Producto p) {
		int x = 0;
		String sql = "INSERT INTO producto (id_producto, id_categoria, nombre, precio, cantidad) VALUES (NULL, ?, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, p.getId_categoria());
			ps.setString(2, p.getNombre_pro());
			ps.setDouble(3, p.getPrecio());
			ps.setInt(4, p.getCantidad());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Create");
		}
		return x;
	}

	@Override
	public int update(Producto p) {
		int x = 0;
		String sql = "UPDATE producto SET id_categoria = ?, nombre = ?, precio = ?, cantidad = ? WHERE id_producto = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, p.getId_categoria());
			ps.setString(2, p.getNombre_pro());
			ps.setDouble(3, p.getPrecio());
			ps.setInt(4, p.getCantidad());
			ps.setInt(5, p.getId_producto());
			x = ps.executeUpdate();			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("update");
		}
		return x;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		String sql = "DELETE FROM producto WHERE id_producto = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			x = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("delete");
		}
		return x;
	}

	@Override
	public Producto read(int id) {
		String sql = "SELECT * FROM producto WHERE id_producto = ?";
		Producto p = new Producto();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				p.setId_producto(rs.getInt("id_producto"));
				p.setId_categoria(rs.getInt("id_categoria"));
				p.setNombre_pro(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setCantidad(rs.getInt("cantidad"));
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("read");
		}
		return p;
	}

	@Override
	public List<Map<String, Object>> readall() {
		String sql = "SELECT c.id_categoria, c.nombre_cat, p.id_producto, p.nombre,p.precio,p.cantidad FROM producto AS p , categoria AS c WHERE p.id_categoria=c.id_categoria";
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id_categoria", rs.getInt("id_categoria"));
				map.put("nombre_cat", rs.getString("nombre_cat"));
				map.put("id_producto", rs.getInt("id_producto"));
				map.put("nombre_pro", rs.getString("nombre"));
				map.put("precio", rs.getDouble("precio"));
				map.put("cantidad", rs.getInt("cantidad"));
				list.add(map);				
			}
		} catch (Exception e) {
			
			System.err.println(e);
			System.out.println("readall");
		}
		return list;
	}
	
	@Override	
	public int updateStock(int id, int cant) {
		String sql = "UPDATE producto SET cantidad = (cantidad - ?) WHERE id_producto = ?";
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, cant);
			ps.setInt(2, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return x;
	}
}
