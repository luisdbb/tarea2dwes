package com.dawes.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.LocalizacionVO;

public interface ServicioLocalizacion {

	int insertar(LocalizacionVO e);

	int modificar(LocalizacionVO e);

	int eliminar(LocalizacionVO e);

	LocalizacionVO findById(int id);

	ArrayList<LocalizacionVO> findByLongitud(char l);
	
	ArrayList<LocalizacionVO> findByLatitud(char l);
	
	ArrayList<LocalizacionVO> findByGradosLongitud(double g);
	
	ArrayList<LocalizacionVO> findByGradosLatitud(double g);

	List<LocalizacionVO> findAll();

}