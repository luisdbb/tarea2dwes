package com.dawes.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.EjemplarVO;

public interface ServicioEjemplar {

	int insertar(EjemplarVO e);

	int modificar(EjemplarVO e);

	int eliminar(EjemplarVO e);

	EjemplarVO findById(int id);

	ArrayList<EjemplarVO> findByEdad(int nombre);
	
	ArrayList<EjemplarVO> findByFechaCompra(Date fecha);
	
	ArrayList<EjemplarVO> findByFechaPlantacion(Date fecha);

	List<EjemplarVO> findAll();

}