package com.dawes.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dawes.dao.PlantaDAO;
import com.dawes.modelo.PlantaVO;

public class PlantaDAOImpl implements PlantaDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public PlantaDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(PlantaVO p) {
		try {
			ps = con.prepareStatement("insert into plantas (id, nombre) values (?,?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en plantas " + e.getMessage());
		}
		return 0;
	}

	public int modificar(PlantaVO p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int eliminar(PlantaVO ej) {
		try {
			ps=con.prepareStatement("delete from plantas where idplanta=?");
			ps.setInt(1, ej.getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar planta "+e.getMessage());
		}
		return 0;
	}

	public PlantaVO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<PlantaVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PlantaVO> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
