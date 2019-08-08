package pe.edu.upeu.ControlInsumos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.edu.upeu.ControlInsumos.dao.DetalleVentaDao;
import pe.edu.upeu.ControlInsumos.entity.DetalleVenta;
import pe.edu.upeu.ControlInsumos.util.Conexion;

public class DetalleVentaDaoImp implements DetalleVentaDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	@Override
	public int create(DetalleVenta d) {
		int  x = 0;
		String sql = "INSERT INTO detalle_venta VALUES (NULL, ?, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, d.getId_venta());
			ps.setInt(2, d.getId_producto());
			ps.setDouble(3, d.getPrecio_venta());
			ps.setInt(4, d.getCantidad_venta());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

}
