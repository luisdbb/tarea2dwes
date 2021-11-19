package com.dawes.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dawes.dao.EjemplarDAO;
import com.dawes.modelo.EjemplarVO;

public class EjemplarDAOImpl implements EjemplarDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public EjemplarDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(EjemplarVO ej) {
		try {
			ps = con.prepareStatement("insert into ejemplares (id, edad, fechacompra, fechaplantacion) values (?,?,?,?)");
			ps.setInt(1, ej.getId());
			ps.setInt(2, ej.getEdad());
			ps.setDate(3, Date.valueOf(ej.getFechaCompra()));
			ps.setDate(3, Date.valueOf(ej.getFechaPlantacion()));
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en ejemplares " + e.getMessage());
		}
		return 0;
	}

	public int modificar(EjemplarVO ej) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int eliminar(EjemplarVO ej) {
		try {
			ps=con.prepareStatement("delete from ejemplares where idejemplar=?");
			ps.setInt(1, ej.getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar ejemplar "+e.getMessage());
		}
		return 0;
	}

	public EjemplarVO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EjemplarVO> findByEdad(int edad) {
		ArrayList<EjemplarVO> ret = new ArrayList<EjemplarVO>();
		try {
			ps = con.prepareStatement("select * from ejemplares where edad=?");
			ps.setInt(1, edad);
			rs = ps.executeQuery();
			if (rs.next())
				ret.add(new EjemplarVO(rs.getInt("id"), rs.getInt(2), rs.getDate(3).toLocalDate(),	rs.getInt(4), rs.getDate(5).toLocalDate(), rs.getInt(6)));
		} catch (SQLException e) {
			System.out.println("error al consultar por edad " + e.getMessage());
		}
		return ret;
	}

	public List<EjemplarVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<EjemplarVO> findByFechaCompra(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EjemplarVO> findByFechaPlantacion(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}


}
