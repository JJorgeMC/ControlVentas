package pe.edu.upeu.ControlInsumos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.ControlInsumos.dao.RolDao;
import pe.edu.upeu.ControlInsumos.entity.Rol;
import pe.edu.upeu.ControlInsumos.util.Conexion;

public class RolDaoImp implements RolDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public List<Rol> readall() {
		List<Rol> list = new ArrayList<>();
		String sql = "SELECT * FROM rol";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();			
			while(rs.next()) {
				Rol r = new Rol(rs.getInt("id_rol"), rs.getString("nombre_rol"));
				list.add(r);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
