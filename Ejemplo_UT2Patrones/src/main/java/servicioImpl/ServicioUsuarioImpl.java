package servicioImpl;

import java.util.List;
import java.util.Optional;

import com.dawes.daoImpl.UsuarioDAOImpl;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.ServicioUsuario;
import com.dawes.util.MySqlDAOFactory;

public class ServicioUsuarioImpl implements ServicioUsuario {

	private MySqlDAOFactory factoria;
	private UsuarioDAOImpl usuarioDAO;

	public ServicioUsuarioImpl() {
		factoria=MySqlDAOFactory.getCon();
		usuarioDAO=(UsuarioDAOImpl) factoria.getUsuarioDAO();
	}

	public int insertar(UsuarioVO usuario) {
		return usuarioDAO.insertar(usuario);
	}

	public int modificar(UsuarioVO usuario) {
		return usuarioDAO.modificar(usuario);
	}

	public int eliminar(Optional<UsuarioVO> usuario) {
		return usuarioDAO.eliminar(usuario);
	}

	public UsuarioVO findById(int idusuario) {
		return usuarioDAO.findById(idusuario);
	}

	public Optional<UsuarioVO> findByNombre(String nombre) {
		return usuarioDAO.findByNombre(nombre);
	}

	public List<UsuarioVO> findAll() {
		return usuarioDAO.findAll();
	}


}
