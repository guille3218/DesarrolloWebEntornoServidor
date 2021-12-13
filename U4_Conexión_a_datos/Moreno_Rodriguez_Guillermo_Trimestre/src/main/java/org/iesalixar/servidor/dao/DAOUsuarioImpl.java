package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

	public DAOUsuarioImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getUsuario(String email) {
		
		Usuario usuario = null;

		try {

			
			PoolDB pool = new PoolDB();

			Connection con;
			con = pool.getConnection();
			
			
			String sql = "select * from usuarios where email=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				usuario = new Usuario();
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setRole(rs.getString("role"));
				usuario.setNombre(rs.getString("firstName"));
				usuario.setApellidos(rs.getString("lastName"));

			}

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return usuario;

	}

	@Override
	public boolean registerUsuario(Usuario usuario) {
		int resultado = 0;

		try {
			
			
			PoolDB pool = new PoolDB();

			Connection con;
			con = pool.getConnection();
			

			String sql = "insert into usuarios values(?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, usuario.getUsuario());
			statement.setString(3, usuario.getPassword());
			statement.setString(2, usuario.getEmail());
			statement.setString(4, usuario.getRole());
			statement.setString(5, usuario.getNombre());
			statement.setString(6, usuario.getApellidos());

			resultado = statement.executeUpdate();

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}
	
	
	

}
