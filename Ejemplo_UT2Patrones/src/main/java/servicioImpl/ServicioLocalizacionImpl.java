package servicioImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.daoImpl.LocalizacionDAOImpl;
import com.dawes.modelo.LocalizacionVO;
import com.dawes.servicios.ServicioLocalizacion;
import com.dawes.util.MySqlDAOFactory;

public class ServicioLocalizacionImpl implements ServicioLocalizacion {

	private MySqlDAOFactory factoria;
	private LocalizacionDAOImpl localizacionDAO;

	public ServicioLocalizacionImpl() {
		factoria=MySqlDAOFactory.getCon();
		localizacionDAO=(LocalizacionDAOImpl) factoria.getLocalizacionDAO();
	}

	public int insertar(LocalizacionVO e) {
		return localizacionDAO.insertar(e);
	}

	public int modificar(LocalizacionVO e) {
		return localizacionDAO.modificar(e);
	}

	public int eliminar(LocalizacionVO e) {
		return localizacionDAO.eliminar(e);
	}

	public LocalizacionVO findById(int id) {
		return localizacionDAO.findById(id);
	}

	public List<LocalizacionVO> findAll() {
		return localizacionDAO.findAll();
	}

	public ArrayList<LocalizacionVO> findByLongitud(char l) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LocalizacionVO> findByLatitud(char l) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LocalizacionVO> findByGradosLongitud(double g) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LocalizacionVO> findByGradosLatitud(double g) {
		// TODO Auto-generated method stub
		return null;
	}



}
