package com.dawes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ParcelaVO;


public interface ParcelaDAO {
	
	int insertar(ParcelaVO p);
	int modificar(ParcelaVO p);
	int eliminar(ParcelaVO p);
	ParcelaVO findById(int id);
	ArrayList<ParcelaVO> findByNombre(String nombre);
	ArrayList<ParcelaVO> findByArea(double a);
	ArrayList<ParcelaVO> findByIsPrivada(boolean b);
	List<ParcelaVO> findAll();
	
}
	
//
//	static Connection conex = null;
//
//	public ParcelaDAO() {
//		super();
//		conex = ConexionBD.establecerConexion();
//		if (conex == null) {
//			System.out.println("Error al conectar a la BD");
//		}
//	}
//
//	public static ArrayList<Parcela> seleccionarTodas() {
//		ArrayList<Parcela> ret = new ArrayList<Parcela>();
//		String consulta = "SELECT * FROM parcela";
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
//				Parcela nueva = new Parcela();
//				nueva.setId(rs.getInt(1));
//				nueva.setNombre(rs.getString(2));
//				nueva.setArea(rs.getFloat(3));
//				nueva.setPrivada(true);
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
//	public static void insertarParcela(Parcela pa) {
//		ArrayList<Parcela> ret = new ArrayList<Parcela>();
//		String consulta = "INSERT INTO planta values (?,?,?,?)";
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
//	public static void borrarParcela(int id) {
//		Connection conex = null;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//			String sql = "DELETE FROM parcela WHERE id = " + id;
//			Statement stmt = conex.createStatement();
//			stmt.executeUpdate(sql);
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void actualizarParcela(int id) {
//		Connection conex = null;
//		try {
//			if (conex == null) {
//				conex = ConexionBD.establecerConexion();
//			}
//			String sql = "UPDATE FROM parcela WHERE id = " + id;
//			Statement stmt = conex.createStatement();
//			stmt.executeUpdate(sql);
//			conex.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
