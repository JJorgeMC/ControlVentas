package pe.edu.upeu.ControlInsumos.dao;

import pe.edu.upeu.ControlInsumos.entity.Usuario;

public interface UsuarioDao {
	public Usuario read(String user, String pass);
	public boolean log(String user, String pass);
	public int create(Usuario u);
}
