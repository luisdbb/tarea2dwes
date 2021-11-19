package com.dawes.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.dao.ParcelaDAO;
import com.dawes.modelo.ParcelaVO;

public class ParcelaDAOImpl implements ParcelaDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public ParcelaDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(ParcelaVO p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modificar(ParcelaVO p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int eliminar(ParcelaVO p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ParcelaVO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ParcelaVO> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ParcelaVO> findByArea(double a) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ParcelaVO> findByIsPrivada(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ParcelaVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
