package fachada;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.dawes.modelo.*;
import com.dawes.servicios.*;
import com.dawes.util.InvernaderoServiciosFactory;
import com.dawes.util.MySqlDAOFactory;
import com.dawes.util.Utilidades;
//import com.dawes.dao.*;
//import com.dawes.daoImpl.EjemplarDAOImpl;

public class InvernaderoFachada {
	private static InvernaderoFachada portal;
	
	MySqlDAOFactory factoriaDAO = MySqlDAOFactory.getCon();
	InvernaderoServiciosFactory factoriaServicios = InvernaderoServiciosFactory.getServivios(); 
		
	ServicioEjemplar ejServ = factoriaServicios.getServiciosEjemplar();
	ServicioPlanta plantaServ = factoriaServicios.getServiciosPlanta();
	ServicioParcela parcelaServ = factoriaServicios.getServiciosParcela();
	ServicioLocalizacion localServ = factoriaServicios.getServiciosLocalizacion();
	
	public static InvernaderoFachada getPortal() {
		if (portal==null)
			portal=new InvernaderoFachada();
		return portal;
	}


	public void mostrarMenuPrincipal() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Gestionar Plantas.");
		System.out.println("2.  Gestionar Ejemplares.");
		System.out.println("3.  Gestionar Parcelas.");
		System.out.println("4.  Gestionar Localizaciones.");
	
		System.out.println("5.  Comprar un ejemplar de una planta.");
		System.out.println("6.  Plantar un ejemplar.");
		System.out.println("7.  Establecer áreas de plantación.");
	
		System.out.println("8.  Salir");
	}


	public void mostrarMenuPrincipalPlantas() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Seleccionar Planta/s.");
		System.out.println("2.  Crear nueva Planta.");
		System.out.println("3.  Leer detalles de Planta.");
		System.out.println("4.  Modificar datos de Planta.");
		System.out.println("5.  Eliminar Planta.");
		System.out.println("6.  Volver al menu Principal");
	}
	
	private void mostrarMenuPrincipalEjemplares() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Seleccionar Ejemplar/es.");
		System.out.println("2.  Crear nuevo Ejemplar.");
		System.out.println("3.  Leer detalles de Ejemplar.");
		System.out.println("4.  Modificar datos de Ejemplar.");
		System.out.println("5.  Eliminar Ejemplar.");
		System.out.println("6.  Volver al menu Principal");
	}

	private void mostrarMenuPrincipalParcelas() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Seleccionar Parcela/s.");
		System.out.println("2.  Crear nueva Parcela.");
		System.out.println("3.  Leer detalles de Parcela.");
		System.out.println("4.  Modificar datos de Parcela.");
		System.out.println("5.  Eliminar Parcela.");
		System.out.println("6.  Volver al menu Principal");
	}

	private void mostrarMenuPrincipalLocalizaciones() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Seleccionar Localizacion/es.");
		System.out.println("2.  Crear nueva Localizacion.");
		System.out.println("3.  Leer detalles de Localizacion.");
		System.out.println("4.  Modificar datos de Localizacion.");
		System.out.println("5.  Eliminar Localizacion.");
		System.out.println("6.  Volver al menu Principal");
	}

	public void mostrarMenuGestionEjemplares() {
        Scanner in = new Scanner(System.in);
        System.out.println("Gestion de ejemplares");
        int opcion = 0;
        do {
            mostrarMenuPrincipalEjemplares();
            opcion = in.nextInt();
            if (opcion < 1 || opcion > 6) {
                System.out.println("Opcion incorrecta.");
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionar-filtrar Ejemplar/es:");
                    ArrayList<EjemplarVO> ejemplares = new ArrayList<EjemplarVO>();
                    mostarMenuSeleccionarEjemplares();
                    int filtroEjemplares = 0;
                    filtroEjemplares = in.nextInt();
                    switch (filtroEjemplares) {
                        case 0:
                            System.out.println("Seleccionados todos los ejemplares:");
                            ejemplares = (ArrayList<EjemplarVO>) ejServ.findAll();
                            for (EjemplarVO e : ejemplares) {
                                System.out.println(e);
                            }
                            break;
                        case 1:
                        	//TO-DO
                        	System.out.println("Introduzca la edad para filtrar:");
                        	int edadSel = in.nextInt();
                            ejemplares = ejServ.findByEdad(edadSel);
                            System.out.println("Seleccionados los ejemplares:");
                            for (EjemplarVO e : ejemplares) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                        	System.out.println("Introduzca la fecha de compra para filtrar:");
                        	Date fechaSel = Utilidades.leerFecha();
                            ejemplares = ejServ.findByFechaCompra(fechaSel);
                            System.out.println("Seleccionados los ejemplares:");
                            for (EjemplarVO e : ejemplares) {
                                System.out.println(e);
                            }
                            break;
                        case 3:
                        	System.out.println("Introduzca la fecha de plantacion para filtrar:");
                        	Date fechaSelec = Utilidades.leerFecha();
                            ejemplares = ejServ.findByFechaPlantacion(fechaSelec);
                            System.out.println("Seleccionados los ejemplares:");
                            for (EjemplarVO e : ejemplares) {
                                System.out.println(e);
                            }
                            break;
                        default:
                            System.out.println("Error al seleccionar filtro.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Crear nuevo Ejemplar:");
                    try {
                    	EjemplarVO e = EjemplarVO.nuevoEjemplar();
                        ejServ.insertar(e);
                        System.out.println("El ejemplar " + e.toString() + " se ha creado en la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Leer detalles de Ejemplar:");
                    System.out.println("Seleccione el id del ejemplar:");
                    mostrarEjemplares();
                    int idejemplar = 0;
                    idejemplar = in.nextInt();
                    try {
                        System.out.println("Los detalles del ejemplar con id=" + idejemplar + " son:");
                        verDetallesEjemplar(idejemplar);

                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Modificar datos de Ejemplar");
                    System.out.println("Seleccione el id del ejemplar:");
                    mostrarEjemplares();
                    int idejemplar = 0;
                    idejemplar = in.nextInt();
                    try {
                        modificarEjemplar(idejemplar);
                        System.out.println("El ejemplar con id=" + idejemplar + " se ha modificado en la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Eliminar Ejemplar:");
                    System.out.println("Seleccione el id del ejemplar:");
                    mostrarEjemplares();
                    int idejemplar = 0;
                    idejemplar = in.nextInt();
                    try {
                        eliminarEjemplar(idejemplar);
                        System.out.println("El ejemplar con id=" + idejemplar + " se ha eliminado de la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 6:
                    break;
            }
        } while (opcion != 6);
    }

	public void mostrarMenuGestionPlantas() {
        Scanner in = new Scanner(System.in);
        System.out.println("Gestion de plantas");
        int opcion = 0;
        do {
            mostrarMenuPrincipalPlantas();
            opcion = in.nextInt();
            if (opcion < 1 || opcion > 6) {
                System.out.println("Opcion incorrecta.");
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionar-filtrar Planta/s:");
                    ArrayList<PlantaVO> plantas = new ArrayList<PlantaVO>();
                    mostarMenuSeleccionarPlantas();
                    int filtroPlantas = 0;
                    filtroPlantas = in.nextInt();
                    switch (filtroPlantas) {
                        case 0:
                            System.out.println("Seleccionados todas las plantas:");
                            plantas = todasPlantas();
                            for (PlantaVO p : plantas) {
                                System.out.println(p);
                            }
                            break;
                        case 1:
                            plantas = filtrarPlantaPorNombre();
                            System.out.println("Seleccionados las plantas:");
                            for (PlantaVO p : plantas) {
                                System.out.println(p);
                            }
                            break;
                        default:
                            System.out.println("Error al seleccionar filtro.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Crear nueva Planta:");
                    try {
                        PlantaVO p = PlantaVO.nuevaPlanta();
                        insertarPlanta(p);
                        System.out.println("La planta " + p.toString() + " se ha creado en la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Leer detalles de Planta:");
                    System.out.println("Seleccione el id de la planta");
                    mostrarPlantas();
                    int idplanta = 0;
                    idplanta = in.nextInt();
                    try {
                        System.out.println("Los detalles de la planta con id=" + idplanta + " son:");
                        verDetallesPlanta(idplanta);

                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Modificar datos de Planta");
                    System.out.println("Seleccione el id de la planta:");
                    mostrarPlantas();
                    int idplanta = 0;
                    idplanta = in.nextInt();
                    try {
                        modificarPlanta(idplanta);
                        System.out.println("La planta con id=" + idplanta+ " se ha modificado en la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Eliminar Planta:");
                    System.out.println("Seleccione el id de la planta:");
                    mostrarPlantas();
                    int idplanta = 0;
                    idplanta = in.nextInt();
                    try {
                        eliminarPlanta(idplanta);
                        System.out.println("La planta con id=" + idplanta + " se ha eliminado de la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 6:
                    break;
            }
        } while (opcion != 6);
    }

	public void mostrarMenuGestionLocalizaciones() {
        Scanner in = new Scanner(System.in);
        System.out.println("Gestion de localizaciones");
        int opcion = 0;
        do {
            mostrarMenuPrincipalLocalizaciones();
            opcion = in.nextInt();
            if (opcion < 1 || opcion > 6) {
                System.out.println("Opcion incorrecta.");
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionar-filtrar Localizacion/es:");
                    ArrayList<LocalizacionVO> localizaciones = new ArrayList<LocalizacionVO>();
                    mostarMenuSeleccionarLocalizaciones();
                    int filtroLocalizaciones = 0;
                    filtroLocalizaciones = in.nextInt();
                    switch (filtroLocalizaciones) {
                        case 0:
                            System.out.println("Seleccionados todas las localizaciones:");
                            localizaciones = todasLocalizaciones();
                            for (LocalizacionVO l : localizaciones) {
                                System.out.println(l);
                            }
                            break;
                        case 1:
                            localizaciones = filtrarEjemplarPorLongitudLatitud();
                            System.out.println("Seleccionados las localizaciones:");
                            for (LocalizacionVO l : localizaciones) {
                                System.out.println(l);
                            }
                            break;
                        default:
                            System.out.println("Error al seleccionar filtro.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Crear nueva Localizacion:");
                    try {
                    	LocalizacionVO l = LocalizacionVO.nuevaLocalizacion();
                        insertarLocalizacion(l);
                        System.out.println("La localizacion " + l.toString() + " se ha creado en la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Leer detalles de Localización:");
                    System.out.println("Seleccione el id de la localización");
                    mostrarLocalizaciones();
                    int idlocalizacion = 0;
                    idlocalizacion = in.nextInt();
                    try {
                        System.out.println("Los detalles de la localizacion con id=" + idlocalizacion + " son:");
                        verDetallesLocalizacion(idlocalizacion);

                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Modificar datos de Localización");
                    System.out.println("Seleccione el id de la localización:");
                    mostrarLocalizaciones();
                    int idlocalizacion = 0;
                    idlocalizacion = in.nextInt();
                    try {
                        modificarLocalizacion(idlocalizacion);
                        System.out.println("La localización con id=" + idlocalizacion + " se ha modificado en la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Eliminar Localizacion:");
                    System.out.println("Seleccione el id de la localizacion:");
                    mostrarLocalizaciones();
                    int idlocalizacion = 0;
                    idlocalizacion = in.nextInt();
                    try {
                        eliminarLocalizacion(idlocalizacion);
                        System.out.println("La localizacion con id=" + idlocalizacion + " se ha eliminado de la BD.");
                    } catch (Exception e) {
                        System.out.println("Se ha producido una excepcion: " + e.getMessage());
                    }
                    break;
                case 6:
                    break;
            }
        } while (opcion != 6);
    }

	public void insertarLocalizacion(LocalizacionVO l) {
		LocalizacionDAO.insertar(l);
		
	}

	public void mostrarLocalizacion() {
		for (LocalizacionVO l : LocalizacionDAOseleccionarTodas()) {
			System.out.println(l);
		}
	}

	public void mostrarMenuGestionParcelas() {
        Scanner in = new Scanner(System.in);
        System.out.println("Gestion de parcelas");
        int opcion = 0;
        do {
            mostrarMenuPrincipalParcelas();
            opcion = in.nextInt();
            if (opcion < 1 || opcion > 6) {
                System.out.println("Opcion incorrecta.");
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionar-filtrar Parcela/s:");
                    ArrayList<ParcelaVO> parcelas = new ArrayList<ParcelaVO>();
                    mostarMenuSeleccionarParcelas();
                    int filtroParcelas = 0;
                    filtroParcelas = in.nextInt();
                    switch (filtroParcelas) {
                        case 0:
                            System.out.println("Seleccionadas todas las parcelas:");
                            parcelas = (ArrayList<ParcelaVO>) parcelaServ.findAll();
                            for (ParcelaVO p : parcelas) {
                                System.out.println(p);
                            }
                            break;
                        case 1:
                        	System.out.println("Introduzca el nombre de la parcela para filtrar");
                        	String nombreSel = in.nextLine();
                            parcelas = parcelaServ.findByNombre(nombreSel);
                            System.out.println("Seleccionadas las parcelas:");
                            for (ParcelaVO p : parcelas) {
                                System.out.println(p);
                            }
                            break;
                        case 2:
                        	System.out.println("Introduzca el area de la parcela para filtrar");
                        	double areaSel = Utilidades.leerDouble();
                            parcelas = parcelaServ.findByArea(areaSel);
                            System.out.println("Seleccionadas las parcelas:");
                            for (ParcelaVO p : parcelas) {
                                System.out.println(p);
                            }
                            break;
                        case 3:
                        	System.out.println("Introduzca si desea solo parcelas privadas para filtrar");
                        	boolean selecc = Utilidades.leerBoolean();
                            parcelas = parcelaServ.findByIsPrivada(selecc);
                            System.out.println("Seleccionadas las parcelas:");
                            for (ParcelaVO p : parcelas) {
                                System.out.println(p);
                            }
                            break;
                        default:
                            System.out.println("Error al seleccionar filtro.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Crear nueva Parcela:");
                    try {
                    	ParcelaVO p = ParcelaVO.nuevaParcela();
                        parcelaServ.insertar(p);
                        System.out.println("La parcela " + p.toString() + " se ha creado en la BD.");
                    } catch (Exception e) {

                    }
                    break;
                case 3:
                    System.out.println("Leer detalles de Parcela:");
                    System.out.println("Seleccione el id de la parcela");
                    mostrarParcelas();
                    int idparcela = 0;
                    idparcela = in.nextInt();
                    try {
                        System.out.println("Los detalles de la parcela con id=" + idparcela + " son:");
                        verDetallesParcela(idparcela);

                    } catch (Exception e) {

                    }
                    break;
                case 4:
                    System.out.println("Modificar datos de Parcela");
                    System.out.println("Seleccione el id de la parcela:");
                    mostrarParcelas();
                    int idparcela = 0;
                    idparcela = in.nextInt();
                    try {
                        modificarParcela(idparcela);
                        System.out.println("La parcela con id=" + idparcela+ " se ha modificado en la BD.");
                    } catch () {

                    }
                    break;
                case 5:
                    System.out.println("Eliminar Parcela:");
                    System.out.println("Seleccione el id de la parcela:");
                    mostrarParcelas();
                    int idparcela = 0;
                    idparcela = in.nextInt();
                    try {
                        eliminarParcela(idparcela);
                        System.out.println("La parcela con id=" + idparcela + " se ha eliminado de la BD.");
                    } catch (Exception e) {

                    }
                    break;
                case 6:
                    break;
            }
        } while (opcion != 6);
    }

	public void mostarMenuSeleccionarPlantas() {
		System.out.println("Pulse 0 para todas las Plantas.");
		System.out.println("Pulse 1 para filtrar plantas por NOMBRE.");
	}

	public void mostarMenuSeleccionarEjemplares() {
		System.out.println("Pulse 0 para todos los Ejemplares.");
		System.out.println("Pulse 1 para filtrar ejemplares por EDAD.");
		System.out.println("Pulse 2 para filtrar ejemplares por FECHA COMPRA.");
		System.out.println("Pulse 3 para filtrar ejemplares por FECHA PLANTACION.");
	}

	public void mostarMenuSeleccionarParcelas() {
		System.out.println("Pulse 0 para todas las Parcelas.");
		System.out.println("Pulse 1 para filtrar parcelas por NOMBRE.");
		System.out.println("Pulse 2 para filtrar parcelas por AREA.");
		System.out.println("Pulse 3 para filtrar parcelas por PRIVADO/PUBLICO.");
	}

	public void mostarMenuSeleccionarLocalizaciones() {
		System.out.println("Pulse 0 para todas las Localizaciones.");
		System.out.println("Pulse 1 para filtrar localizaciones por LONGITUD/LATITUD.");
	}


	public void comprarEjemplarDePlanta() {
		// TODO Auto-generated method stub
		
	}


	public void plantarEjemplar() {
		// TODO Auto-generated method stub
		
	}


	public void establerAreasDePlantacion() {
		// TODO Auto-generated method stub
		
	}

}
