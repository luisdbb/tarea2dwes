package com.dawes.util;

import com.dawes.servicios.*;

import servicioImpl.ServicioEjemplarImpl;
import servicioImpl.ServicioLocalizacionImpl;
import servicioImpl.ServicioParcelaImpl;
import servicioImpl.ServicioPlantaImpl;

public class InvernaderoServiciosFactory {
	public static InvernaderoServiciosFactory servicios;
	
	public static InvernaderoServiciosFactory getServicios() {
		if (servicios ==null)
			servicios=new InvernaderoServiciosFactory();
		return servicios;
	}
	
	public ServicioEjemplar getServiciosEjemplar() {
		return new ServicioEjemplarImpl();
	}
	
	public ServicioPlanta getServiciosPlanta() {
		return new ServicioPlantaImpl();
	}
	
	public ServicioParcela getServiciosParcela() {
		return new ServicioParcelaImpl();
	}
	
	public ServicioLocalizacion getServiciosLocalizacion() {
		return new ServicioLocalizacionImpl();
	}
	
}
