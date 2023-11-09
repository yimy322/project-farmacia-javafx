package models.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import models.dao.IProveedorDao;
import models.entity.Proveedor;

public class ProveedorService implements IProveedorDao{
	
	private static final String SQL_SELECT = "SELECT * FROM proveedores";
    private static final String SQL_INSERT = "INSERT INTO proveedores(nombre, telefono, direccion, nacionalidad) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE proveedores SET nombre = ?,telefono = ?,direccion = ?,nacionalidad = ? WHERE id_proveedor = ?";
    private static final String SQL_DELETE = "DELETE FROM proveedores WHERE id_proveedor =?";
    private static final String SQL_SELECTBYID = "SELECT * FROM proveedores WHERE id_proveedor=?";

	@Override
	public int save(Proveedor proveedor) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, proveedor.getNombre());
			stmt.setString(2, proveedor.getTelefono());
			stmt.setString(3, proveedor.getDireccion());
			stmt.setString(4, proveedor.getNacionalidad());
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
	public List<Proveedor> findAll() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Proveedor proveedor = null;
		
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int idProveedor = rs.getInt("id_proveedor");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String direccion = rs.getString("direccion");
				String nacionalidad = rs.getString("nacionalidad");
				proveedor = new Proveedor(idProveedor, nombre, telefono, direccion, nacionalidad);
				proveedores.add(proveedor);
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
		
		return proveedores;
	}

	@Override
	public int update(Proveedor proveedor) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, proveedor.getNombre());
			stmt.setString(2, proveedor.getTelefono());
			stmt.setString(3, proveedor.getDireccion());
			stmt.setString(4, proveedor.getNacionalidad());
			stmt.setInt(5, proveedor.getId());
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
	public int delete(Proveedor proveedor) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, proveedor.getId());
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
	public Proveedor findById(Proveedor proveedor) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECTBYID);
			stmt.setInt(1, proveedor.getId());
            rs = stmt.executeQuery();
            rs.next();//Nos posicionamos en el primer registro devuelto
            
            int id = rs.getInt("id_proveedor");
            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            String direccion = rs.getString("direccion");
            String nacionalidad = rs.getString("nacionalidad");
            
            proveedor.setId(id);;
            proveedor.setNombre(nombre);
            proveedor.setTelefono(telefono);
            proveedor.setDireccion(direccion);
            proveedor.setNacionalidad(nacionalidad);
            
            
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return proveedor;
	}

}
