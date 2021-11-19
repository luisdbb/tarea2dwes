package servicioImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.daoImpl.PlantaDAOImpl;
import com.dawes.modelo.PlantaVO;
import com.dawes.servicios.ServicioPlanta;
import com.dawes.util.MySqlDAOFactory;

public class ServicioPlantaImpl implements ServicioPlanta {

	private MySqlDAOFactory factoria;
	private PlantaDAOImpl plantaDAO;

	public ServicioPlantaImpl() {
		factoria=MySqlDAOFactory.getCon();
		plantaDAO=(PlantaDAOImpl) factoria.getPlantaDAO();
	}

	public int insertar(PlantaVO e) {
		return plantaDAO.insertar(e);
	}

	public int modificar(PlantaVO e) {
		return plantaDAO.modificar(e);
	}

	public int eliminar(PlantaVO e) {
		return plantaDAO.eliminar(e);
	}

	public PlantaVO findById(int id) {
		return plantaDAO.findById(id);
	}

	public List<PlantaVO> findAll() {
		return plantaDAO.findAll();
	}

	public ArrayList<PlantaVO> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}


}
