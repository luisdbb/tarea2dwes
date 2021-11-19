package com.dawes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.LocalizacionVO;

public interface LocalizacionDAO {
	
	int insertar(LocalizacionVO l);
	int modificar(LocalizacionVO l);
	int eliminar(LocalizacionVO l);
	LocalizacionVO findById(int id);
	ArrayList<LocalizacionVO> findByLongitud(char l);
	ArrayList<LocalizacionVO> findByLatitud(char l);
	ArrayList<LocalizacionVO> findByGradosLongitud(double g);
	ArrayList<LocalizacionVO> findByGradosLatitud(double g);
	List<LocalizacionVO> findAll();
	
}
	
//
//	static Connection conex = null;
//
//	public LocalizacionDAO() {
//		super();
//		conex = ConexionBD.establecerConexion();
//		if (conex == null) {
//			System.out.println("Error al conectar a la BD");
//		}
//	}
//
//	public static ArrayList<Localizacion> seleccionarTodas() {
//		ArrayList<Localizacion> ret = new ArrayList<Localizacion>();
//		String consulta = "SELECT * FROM localizaciones";
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
//				Localizacion nueva = new Localizacion();
//				nueva.setId(Integer.valueOf((int) rs.getLong(1)));
//				nueva.setLongitud(rs.getString(2).charAt(0));
//				nueva.setLatitud(rs.getString(3).charAt(0));
//				nueva.setGradosLongitud(rs.getFloat(4));
//				nueva.setGradosLatitud(rs.getFloat(5));
//				ret.add(nueva);
//			}
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return ret;
//	}
//
//	public static void insertarLocalizacion(Localizacion l) {
//		ArrayList<Localizacion> ret = new ArrayList<Localizacion>();
//		String consulta = "INSERT INTO localizaciones values (?,?,?,?)";
//		ResultSet rs;
//		Statement st;
//		PreparedStatement pstm;
//
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//				pstm = conex.prepareStatement(consulta);
//				pstm.setLong(1, l.getId());
//				pstm.setString(2, String.valueOf(l.getLatitud()));
//				pstm.setString(3, String.valueOf(l.getLongitud()));
//				pstm.setString(4, String.valueOf(l.getGradosLongitud()));
//				pstm.setString(5, String.valueOf(l.getGradosLatitud()));
//			}
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void borrarLocalizacion(int id) {
//		Connection conex = null;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//			String sql = "DELETE FROM localizacion WHERE id = " + id;
//			Statement stmt = conex.createStatement();
//			stmt.executeUpdate(sql);
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void actualizarLocalizacion(int id) {
//		Connection conex = null;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//			String sql = "UPDATE FROM localizacion WHERE id = " + id;
//			Statement stmt = conex.createStatement();
//			stmt.executeUpdate(sql);
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//
//}
