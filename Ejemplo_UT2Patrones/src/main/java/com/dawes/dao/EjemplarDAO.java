package com.dawes.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.dawes.modelo.EjemplarVO;
import com.dawes.modelo.LocalizacionVO;


public interface EjemplarDAO {
	
	int insertar(EjemplarVO e);
	int modificar(EjemplarVO e);
	int eliminar(EjemplarVO e);
	EjemplarVO findById(int idusuario);
	ArrayList<EjemplarVO> findByEdad(int nombre);
	ArrayList<EjemplarVO> findByFechaCompra(Date fecha);
	ArrayList<EjemplarVO> findByFechaPlantacion(Date fecha);
	List<EjemplarVO> findAll();
	int plantarEjemplar(EjemplarVO ej, LocalizacionVO loc, Date fecha);
	
}
	

//	static Connection conex = null;
//
//	public EjemplarDAO() {
//		super();
//		conex = ConexionBD.establecerConexion();
//		if (conex == null) {
//			System.out.println("Error al conectar a la BD");
//		}
//	}
//
//	public static ArrayList<Ejemplar> seleccionarTodos() {
//		ArrayList<Ejemplar> ret = new ArrayList<Ejemplar>();
//		String consulta = "SELECT * FROM ejemplar";
//		ResultSet rs;
//		Statement st;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//
//			st = conex.createStatement();
//			rs = st.executeQuery(consulta);
//
//			while (rs.next()) {
//				Ejemplar nuevo = new Ejemplar();
//				nuevo.setId(rs.getInt(1));
//				nuevo.setEdad(rs.getInt(2));
//				nuevo.setFechaCompra(rs.getDate(3));
//				nuevo.setFechaPlantacion(rs.getDate(4));
//				nuevo.setIdPlanta(rs.getInt(5));
//				nuevo.setIdLocalizacion(rs.getInt(6));
//				ret.add(nuevo);
//			}
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return ret;
//	}
//
//	public static void insertarEjemplar(Ejemplar ej) {
//		ArrayList<Ejemplar> ret = new ArrayList<Ejemplar>();
//		String consulta = "INSERT INTO ejemplar values (?,?,?,?,?,?)";
//		ResultSet rs;
//		Statement st;
//		PreparedStatement pstm;
//
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//				pstm = conex.prepareStatement(consulta);
//				
//		
//				// TODO
//			}
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void borrarEjemplar(int id) {
//		Connection conex = null;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//			String sql = "DELETE FROM ejemplar WHERE id = " + id;
//			Statement stmt = conex.createStatement();
//			stmt.executeUpdate(sql);
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void actualizarEjemplar(int id) {
//		Connection conex = null;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//			String sql = "UPDATE FROM ejemplar WHERE id = " + id;
//			Statement stmt = conex.createStatement();
//			stmt.executeUpdate(sql);
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}


