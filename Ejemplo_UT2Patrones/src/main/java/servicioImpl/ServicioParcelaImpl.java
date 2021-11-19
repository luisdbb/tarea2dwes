package servicioImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.daoImpl.ParcelaDAOImpl;
import com.dawes.modelo.ParcelaVO;
import com.dawes.servicios.ServicioParcela;
import com.dawes.util.MySqlDAOFactory;

public class ServicioParcelaImpl implements ServicioParcela {

	private MySqlDAOFactory factoria;
	private ParcelaDAOImpl parcelaDAO;

	public ServicioParcelaImpl() {
		factoria=MySqlDAOFactory.getCon();
		parcelaDAO=(ParcelaDAOImpl) factoria.getParcelaDAO();
	}

	public int insertar(ParcelaVO e) {
		return parcelaDAO.insertar(e);
	}

	public int modificar(ParcelaVO e) {
		return parcelaDAO.modificar(e);
	}

	public int eliminar(ParcelaVO e) {
		return parcelaDAO.eliminar(e);
	}

	public ParcelaVO findById(int id) {
		return parcelaDAO.findById(id);
	}

	public List<ParcelaVO> findAll() {
		return parcelaDAO.findAll();
	}

	public ArrayList<ParcelaVO> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ParcelaVO> findByArea(double a) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ParcelaVO> findByIsPrivada(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
