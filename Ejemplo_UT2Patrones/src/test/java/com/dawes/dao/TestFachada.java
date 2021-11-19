package com.dawes.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;

import org.junit.Test;

import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.ServicioUsuario;

import servicioImpl.ServicioUsuarioImpl;

public class TestFachada {

	ServicioUsuario su=new ServicioUsuarioImpl();

	@Test
	public void insertar() {
		assertEquals(1,su.insertar(new UsuarioVO("Santiago",LocalDate.now(),2000)));
	}

	@Test
	public void buscarPorNombre() {
		assertFalse(su.findByNombre("charo").isPresent());
	}

	@Test
	public void buscarPorNombre2() {
		assertEquals("Ruslan",su.findByNombre("Ruslan").get().getNombre());
	}

	@Test
	public void eliminar() {
		assertEquals(1,su.eliminar(su.findByNombre("Sergio")));
	}
}
