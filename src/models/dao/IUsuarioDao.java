package models.dao;

import java.util.List;

import models.entity.*;

//CRUD
public interface IUsuarioDao {
	
	//create
	public int save(Usuario usuario);
	//read
	public List<Usuario> findAll();
	//udpate
	public int update(Usuario usuario);
	//delete
	public int delete(Usuario usuario);
	
	//Buscar por id
	public Usuario findById(Usuario usuario);
	
	//validar usuario y contraseña
	public int validarIngreso(String username, String password);
	
}
