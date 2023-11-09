package models.dao;

import java.util.List;

import models.entity.Proveedor;

public interface IProveedorDao {
	
	//create
		public int save(Proveedor proveedor);
		//read
		public List<Proveedor> findAll();
		//udpate
		public int update(Proveedor proveedor);
		//delete
		public int delete(Proveedor proveedor);
		
		//Buscar por id
		public Proveedor findById(Proveedor proveedor);

}
