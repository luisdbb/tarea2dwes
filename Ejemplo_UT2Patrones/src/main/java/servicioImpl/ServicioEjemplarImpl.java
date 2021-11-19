package servicioImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dawes.daoImpl.EjemplarDAOImpl;
import com.dawes.modelo.EjemplarVO;
import com.dawes.servicios.ServicioEjemplar;
import com.dawes.util.MySqlDAOFactory;

public class ServicioEjemplarImpl implements ServicioEjemplar {

	private MySqlDAOFactory factoria;
	private EjemplarDAOImpl ejemplarDAO;

	public ServicioEjemplarImpl() {
		factoria=MySqlDAOFactory.getCon();
		ejemplarDAO=(EjemplarDAOImpl) factoria.getEjemplarDAO();
	}

	public int insertar(EjemplarVO e) {
		return ejemplarDAO.insertar(e);
	}

	public int modificar(EjemplarVO e) {
		return ejemplarDAO.modificar(e);
	}

	public int eliminar(EjemplarVO e) {
		return ejemplarDAO.eliminar(e);
	}

	public EjemplarVO findById(int id) {
		return ejemplarDAO.findById(id);
	}
	
	public ArrayList<EjemplarVO> findByEdad(int edad) {
		return ejemplarDAO.findByEdad(edad);
	}


	public ArrayList<EjemplarVO> findByFechaCompra(Date fecha) {
		return ejemplarDAO.findByFechaCompra(fecha);
	}

	public List<EjemplarVO> findAll() {
		return ejemplarDAO.findAll();
	}

	public ArrayList<EjemplarVO> findByFechaPlantacion(Date fecha) {
		return ejemplarDAO.findByFechaPlantacion(fecha);
	}


}
