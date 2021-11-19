package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.UsuarioVO;

public interface ServicioUsuario {

	int insertar(UsuarioVO usuario);

	int modificar(UsuarioVO usuario);

	int eliminar(Optional<UsuarioVO> usuario);

	UsuarioVO findById(int idusuario);

	Optional<UsuarioVO> findByNombre(String nombre);

	List<UsuarioVO> findAll();

}