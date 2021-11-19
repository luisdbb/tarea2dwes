package com.dawes.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.PlantaVO;

public interface ServicioPlanta {

	int insertar(PlantaVO e);

	int modificar(PlantaVO e);

	int eliminar(PlantaVO e);

	PlantaVO findById(int id);

	ArrayList<PlantaVO> findByNombre(String nombre);

	List<PlantaVO> findAll();

}