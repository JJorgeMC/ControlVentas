package pe.edu.upeu.ControlInsumos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.google.gson.Gson;

import pe.edu.upeu.ControlInsumos.dao.VentaDao;
import pe.edu.upeu.ControlInsumos.entity.Venta;
import pe.edu.upeu.ControlInsumos.util.Conexion;

public class VentaDaoImp implements VentaDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx=null;
	@Override
	public int create(Venta v) {
		int x = 0;
		String sql = "INSERT INTO venta VALUES (NULL,?,?,?,?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, v.getId_usuario());
			ps.setInt(2, v.getId_cliente());
			ps.setString(3, v.getTipo_doc());
			ps.setTimestamp(4, v.getFecha());
			ps.setString(5, v.getNum_doc());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return x;
	}
	@Override
	public String getVentasLength() {
		String length = null;
		String sql = "SELECT COUNT(*)+1 num_doc FROM VENTA";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				length = rs.getString("num_doc");
			}
		} catch (Exception e) {
			System.out.println(e + "raios");
		}
		return length;
	}
	
}
