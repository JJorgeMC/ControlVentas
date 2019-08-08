package pe.edu.upeu.ControlInsumos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.edu.upeu.ControlInsumos.dao.UsuarioDao;
import pe.edu.upeu.ControlInsumos.entity.Usuario;
import pe.edu.upeu.ControlInsumos.util.Conexion;

public class UsuarioDaoImp implements UsuarioDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public boolean log(String user, String pass) {		
		boolean b = false;
		String sql = "SELECT * FROM usuario WHERE nombre_usu = ? and clave = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.first()) {
				b = true;
			}
			
		} catch (Exception e) {
			
		}
		return b;
	}
	@Override
	public Usuario read(String user, String pass) {
		Usuario u = new Usuario();
		String sql = "SELECT * FROM usuario WHERE nombre_usu = ? AND clave = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setId_rol(rs.getInt("id_rol"));
				u.setNombre_usu(rs.getString("nombre_usu"));
				u.setClave(rs.getString("clave"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
	@Override
	public int create(Usuario u) {
		int x = 0;
		String sql = "INSERT INTO usuario (id_usuario, id_rol, nombre_usu, clave) VALUES (NULL, ?,?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getId_rol());
			ps.setString(2, u.getNombre_usu());
			ps.setString(3, u.getClave());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}	
	
}
