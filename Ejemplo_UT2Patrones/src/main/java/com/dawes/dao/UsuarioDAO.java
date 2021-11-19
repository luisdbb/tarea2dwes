package com.dawes.dao;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.UsuarioVO;

public interface UsuarioDAO {

	int insertar(UsuarioVO usuario);
	int modificar(UsuarioVO usuario);
	int eliminar(Optional<UsuarioVO> usuario);
	UsuarioVO findById(int idusuario);
	Optional<UsuarioVO> findByNombre(String nombre);
	List<UsuarioVO> findAll();

}
