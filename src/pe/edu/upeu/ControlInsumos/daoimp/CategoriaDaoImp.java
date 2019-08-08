package pe.edu.upeu.ControlInsumos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.ControlInsumos.dao.CategoriaDao;
import pe.edu.upeu.ControlInsumos.entity.Categoria;
import pe.edu.upeu.ControlInsumos.util.Conexion;

public class CategoriaDaoImp implements CategoriaDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(Categoria c) {
		int x = 0;
		String sql = "INSERT INTO categoria (id_categoria, nombre_cat) VALUES (NULL, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, c.getNombre_cat());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(Categoria c) {
		int x = 0;
		String sql = "UPDATE categoria SET nombre_cat = ? WHERE id_categoria= ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, c.getNombre_cat());
			ps.setInt(2, c.getId_categoria());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);			
		}
		return x;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		String sql = "DELETE FROM categoria WHERE id_categoria= ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	@Override
	public Categoria read(int id) {
		String sql = "SELECT * FROM categoria  WHERE id_categoria=?";
		Categoria c = new Categoria();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				c.setId_categoria(rs.getInt("id_categoria"));
				c.setNombre_cat(rs.getString("nombre_cat"));				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return c;
	}

	@Override
	public List<Categoria> readall() {
		String sql = "SELECT * FROM categoria";
		List<Categoria> list = new ArrayList<>();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setId_categoria(rs.getInt("id_categoria"));
				c.setNombre_cat(rs.getString("nombre_cat"));
				list.add(c);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
