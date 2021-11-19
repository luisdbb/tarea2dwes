package com.dawes.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dawes.dao.LocalizacionDAO;
import com.dawes.modelo.LocalizacionVO;

public class LocalizacionDAOImpl implements LocalizacionDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public LocalizacionDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(LocalizacionVO l) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modificar(LocalizacionVO l) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int eliminar(LocalizacionVO l) {
		// TODO Auto-generated method stub
		return 0;
	}

	public LocalizacionVO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LocalizacionVO> findByLongitud(char l) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LocalizacionVO> findByLatitud(char l) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LocalizacionVO> findByGradosLongitud(double g) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LocalizacionVO> findByGradosLatitud(double g) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LocalizacionVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
