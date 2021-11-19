package com.dawes.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.dawes.dao.UsuarioDAO;
import com.dawes.modelo.UsuarioVO;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public UsuarioDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(UsuarioVO usuario) {
		try {
			ps = con.prepareStatement("insert into usuarios (nombre,fecha,saldo) values (?,?,?)");
			ps.setString(1, usuario.getNombre());
			ps.setDate(2, Date.valueOf(usuario.getFecha()));
			ps.setDouble(3, usuario.getSaldo());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en usuarios " + e.getMessage());
		}
		return 0;
	}

	public int modificar(UsuarioVO usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int eliminar(Optional<UsuarioVO> usuario) {
		try {
			ps=con.prepareStatement("delete from usuarios where idusuarios=?");
			ps.setInt(1, usuario.get().getIdusuario());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar usuarios "+e.getMessage());
		}
		return 0;
	}

	public UsuarioVO findById(int idusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<UsuarioVO> findByNombre(String nombre) {
		try {
			ps = con.prepareStatement("select * from usuarios where nombre=?");
			ps.setString(1, nombre);
			rs = ps.executeQuery();
			if (rs.next())
				return Optional.of(new UsuarioVO(rs.getInt("idusuarios"), rs.getString(2), rs.getDate(3).toLocalDate(),
						rs.getDouble(4)));

		} catch (SQLException e) {
			System.out.println("error al consultar por nombre " + e.getMessage());

		}
		return Optional.empty();
	}

	public List<UsuarioVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
