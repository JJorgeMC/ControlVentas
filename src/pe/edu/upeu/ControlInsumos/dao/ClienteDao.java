package pe.edu.upeu.ControlInsumos.dao;

import pe.edu.upeu.ControlInsumos.entity.Cliente;

public interface ClienteDao {
	public Cliente read(String dni);
	public boolean existe(String dni);
	public int create(Cliente c);
}
