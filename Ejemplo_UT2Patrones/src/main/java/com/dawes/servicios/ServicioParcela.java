package com.dawes.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ParcelaVO;

public interface ServicioParcela {

	int insertar(ParcelaVO e);

	int modificar(ParcelaVO e);

	int eliminar(ParcelaVO e);

	ParcelaVO findById(int id);

	ArrayList<ParcelaVO> findByNombre(String nombre);
	
	ArrayList<ParcelaVO> findByArea(double a);
	
	ArrayList<ParcelaVO> findByIsPrivada(boolean b);

	List<ParcelaVO> findAll();

    public void mostrarParcelas();

}