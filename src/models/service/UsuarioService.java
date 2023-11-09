package models.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import models.dao.IUsuarioDao;
import models.entity.Usuario;

public class UsuarioService implements IUsuarioDao{
	
	private static final String SQL_SELECT = "SELECT * FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(usuario, contrasena, nombre, apellido, telefono, direccion, email, sexo) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET usuario = ?,contrasena = ?,nombre = ?,apellido = ?,telefono = ?,direccion = ?,email = ?,sexo = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario =?";
    private static final String SQL_SELECTBYID = "SELECT * FROM usuarios WHERE id_usuario=?";
    
    private static final String SQL_VALID = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";

	@Override
	public int save(Usuario usuario) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getContrasena());
			stmt.setString(3, usuario.getNombre());
			stmt.setString(4, usuario.getApellido());
			stmt.setString(5, usuario.getTelefono());
			stmt.setString(6, usuario.getDireccion());
			stmt.setString(7, usuario.getEmail());
			stmt.setString(8, usuario.getSexo());
			registros = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return registros;
		
	}

	@Override
	public List<Usuario> findAll(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int idUsuario = rs.getInt("id_usuario");
				String usuarion = rs.getString("usuario");
				String contrasena = rs.getString("contrasena");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String telefono = rs.getString("telefono");
				String direccion = rs.getString("direccion");
				String email = rs.getString("email");
				String sexo = rs.getString("sexo");
				usuario = new Usuario(idUsuario, usuarion, contrasena, nombre, apellido, telefono, direccion, email, sexo);
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conexion.close(rs);
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		return usuarios;
	}

	@Override
	public int update(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getContrasena());
			stmt.setString(3, usuario.getNombre());
			stmt.setString(4, usuario.getApellido());
			stmt.setString(5, usuario.getTelefono());
			stmt.setString(6, usuario.getDireccion());
			stmt.setString(7, usuario.getEmail());
			stmt.setString(8, usuario.getSexo());
			stmt.setInt(9, usuario.getId());
			registros = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return registros;
		
	}

	@Override
	public int delete(Usuario usuario){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, usuario.getId());
			registros = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return registros;
		
	}

	@Override
	public Usuario findById(Usuario usuario){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECTBYID);
			stmt.setInt(1, usuario.getId());
            rs = stmt.executeQuery();
            rs.next();//Nos posicionamos en el primer registro devuelto
            
            int id = rs.getInt("id_usuario");
            String usuarion = rs.getString("usuario");
            String contrasena = rs.getString("contrasena");
            
            usuario.setId(id);;
            usuario.setUsuario(usuarion);
            usuario.setContrasena(contrasena);
            
            
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}

	@Override
	public int validarIngreso(String username, String password) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int rpt = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_VALID);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				rpt = 1;
            } else {
            	rpt = 0;
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rpt;
	}

}
