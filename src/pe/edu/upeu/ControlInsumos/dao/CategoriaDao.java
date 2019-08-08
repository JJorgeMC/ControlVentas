package pe.edu.upeu.ControlInsumos.dao;


import java.util.List;

import pe.edu.upeu.ControlInsumos.entity.Categoria;

public interface CategoriaDao {
	public int create(Categoria c);
	public int update(Categoria c);
	public int delete(int id);
	public Categoria read(int id);
	public List<Categoria> readall();
	
}
