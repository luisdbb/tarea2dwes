package com.dawes.dao;
import java.time.LocalDate;


import com.dawes.daoImpl.UsuarioDAOImpl;
import com.dawes.modelo.UsuarioVO;
import com.dawes.util.MySqlDAOFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestSingleton {

	MySqlDAOFactory factoria=MySqlDAOFactory.getCon();
	UsuarioDAOImpl u=(UsuarioDAOImpl) factoria.getUsuarioDAO();

	@Test
	public void testInsertar() {
		assertEquals(1,u.insertar(new UsuarioVO("Alvaro",LocalDate.now(),1000)));
	}
}
