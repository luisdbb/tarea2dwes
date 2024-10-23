package com.dawes.dao;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.UsuarioVO;
import com.dawes.util.MySqlDAOFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUsuarioDAO {

	// instanciamos la factoria y se realiza la conexi�n a la base de datos
	MySqlDAOFactory factoria= MySqlDAOFactory.getCon();

	// obtenemos a trav�s de la factoria un objeto para acceder a la tabla de usuarios
	UsuarioDAO u=factoria.getUsuarioDAO();

	@Test
	public void test1Insertar() {
		// tengo que llamar al m�todo que realiza la inserci�n en la tabla de usuarios
		assertEquals(1,u.insertar(new UsuarioVO("Diego",LocalDate.now(),1000)));
	}

	@Test
	public void test2BuscarPorNombre() {
		assertNotNull(u.findByNombre("Ruben"));
	}
}
