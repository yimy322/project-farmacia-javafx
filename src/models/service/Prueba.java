package models.service;

import java.sql.SQLException;
import java.util.List;

import models.entity.Usuario;

public class Prueba {

	public static void main(String[] args) throws SQLException {

		UsuarioService usuarioService = new UsuarioService();		
		
		List<Usuario> usuarios = usuarioService.findAll();
		
		System.out.println(usuarioService.validarIngreso("admin", "s"));
		
		//Actualizar
		//Usuario x = new Usuario(2, "sideral", "grillo");
		//usuarioService.update(x);		
		
		for(Usuario usuario:usuarios) {
			System.out.println(usuario);
		}
	}

}
