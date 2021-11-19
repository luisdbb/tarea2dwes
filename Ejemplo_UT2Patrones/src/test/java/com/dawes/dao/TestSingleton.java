package com.dawes.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.dawes.daoImpl.UsuarioDAOImpl;
import com.dawes.modelo.UsuarioVO;
import com.dawes.util.MySqlDAOFactory;

public class TestSingleton {

	MySqlDAOFactory factoria=MySqlDAOFactory.getCon();
	UsuarioDAOImpl u=(UsuarioDAOImpl) factoria.getUsuarioDAO();

	@Test
	public void testInsertar() {
		assertEquals(1,u.insertar(new UsuarioVO("Alvaro",LocalDate.now(),1000)));
	}
}
