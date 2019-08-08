package pe.edu.upeu.ControlInsumos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.edu.upeu.ControlInsumos.dao.ClienteDao;
import pe.edu.upeu.ControlInsumos.entity.Cliente;
import pe.edu.upeu.ControlInsumos.util.Conexion;

public class ClienteDaoImp implements ClienteDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public Cliente read(String dni) {
		Cliente c = new Cliente();
		String sql = "SELECT * FROM cliente WHERE dni = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, dni);
			rs = ps.executeQuery();
			while(rs.next()) {
				c.setId_cliente(rs.getInt("id_cliente"));
				c.setNombre_cli(rs.getString("nombre_cli"));
				c.setDni(rs.getString("dni"));
			}
			
		} catch (Exception e) {
			System.out.println(e);			
		}
		return c;
	}
	@Override
	public boolean existe(String dni) {
		boolean b = false;
		String sql = "SELECT * FROM cliente WHERE dni = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, dni);
			rs = ps.executeQuery();
			
			b=rs.first();
			System.out.println("b" + b);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
	@Override
	public int create(Cliente c) {
		int x = 0;
		String sql = "INSERT INTO cliente (id_cliente, nombre_cli, dni) VALUES (NULL, ?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(1, c.getNombre_cli());
			ps.setString(2, c.getDni());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	
}
