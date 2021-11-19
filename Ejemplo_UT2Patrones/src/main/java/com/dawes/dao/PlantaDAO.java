package com.dawes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.PlantaVO;


public interface PlantaDAO {
	
	int insertar(PlantaVO p);
	int modificar(PlantaVO p);
	int eliminar(PlantaVO p);
	PlantaVO findById(int id);
	ArrayList<PlantaVO> findByNombre(String nombre);
	List<PlantaVO> findAll();
	
}
//	static Connection conex = null;
//
//	public PlantaDAO() {
//		super();
//		conex = ConexionBD.establecerConexion();
//		if (conex == null) {
//			System.out.println("Error al conectar a la BD");
//		}
//	}
//
//	public static ArrayList<Planta> seleccionarTodas() {
//		ArrayList<Planta> ret = new ArrayList<Planta>();
//		String consulta = "SELECT * FROM planta";
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
//				Planta nueva = new Planta();
//				nueva.setId(Integer.valueOf((int) rs.getLong(1)));
//				nueva.setNombre(rs.getString(2));
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
//	public static void insertarPlanta(Planta p) {
//		ArrayList<Planta> ret = new ArrayList<Planta>();
//		String consulta = "INSERT INTO planta values (?,?)";
//		ResultSet rs;
//		Statement st;
//		PreparedStatement pstm;
//
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//				pstm = conex.prepareStatement(consulta);
//				
//				//TODO
//			}
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void borrarPlanta(int id) {
//		Connection conex = null;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//			String sql = "DELETE FROM planta WHERE id = " + id;
//			Statement stmt = conex.createStatement();
//			stmt.executeUpdate(sql);
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void actualizarPlanta(int id) {
//		Connection conex = null;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//			String sql = "UPDATE FROM planta WHERE id = " + id;
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
