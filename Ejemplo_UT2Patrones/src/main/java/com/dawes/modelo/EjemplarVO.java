package com.dawes.modelo;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class EjemplarVO {

    static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static EjemplarVO nuevoEjemplar() {
        Scanner in = new Scanner(System.in);
        EjemplarVO ej;
        boolean correcto = false;
        do {
            ej = new EjemplarVO();
            System.out.println("Introduzca los datos para un nuevo ejemplar:");
            System.out.println("fechaCompra (dd/mm/aaaa) Pulse intro para la fecha de hoy:");
            String fecha = in.nextLine();
            LocalDate fechaCompra;
            if(fecha.isEmpty())
                fechaCompra = LocalDate.now();
            else
                fechaCompra = LocalDate.parse(fecha, dateFormatter);
            ej.setFechaCompra(fechaCompra);
            System.out.println("Edad: ");
            int edad = in.nextInt();
            ej.setEdad(edad);
            correcto = EjemplarVO.validarEjemplar(ej);
            if (!correcto) {
                System.out.println("Error de validación: los datos introducidos no son correctos.");
            }
        } while (!correcto);
        return ej;
    }

    public static boolean validarEjemplar(EjemplarVO ej) {
        if (ej.getEdad() < 0) {
            return false;
        }
        if (ej.getId() != 0) {
            if (ej.getId() < 0) {
                return false;
            }
        }
        if (ej.getIdPlanta() != 0) {
            if (ej.getIdPlanta() < 0) {
                return false;
            }
        }
        if (ej.getIdLocalizacion() != 0) {
            if (ej.getIdLocalizacion() < 0) {
                return false;
            }
        }
        if (ej.getFechaPlantacion() != null) {
            if (ej.getFechaCompra() != null) {
                if (ej.getFechaPlantacion().compareTo(ej.getFechaCompra()) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int id;
    private int edad;
    private LocalDate fechaCompra;
    private LocalDate fechaPlantacion;
    private int idPlanta;
    private int idLocalizacion;

    public EjemplarVO() {
    }

    public EjemplarVO(int id, int edad, LocalDate fechaCompra, int idPlanta) {
        this.id = id;
        this.edad = edad;
        this.fechaCompra = fechaCompra;
        this.idPlanta = idPlanta;
    }

    public EjemplarVO(int id, int edad, LocalDate fechaCompra, int idPlanta, LocalDate fechaPlantacion, int idLocalizacion) {
        this.id = id;
        this.edad = edad;
        this.fechaCompra = fechaCompra;
        this.fechaPlantacion = fechaPlantacion;
        this.idPlanta = idPlanta;
        this.idLocalizacion = idLocalizacion;
    }

    public int getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDate getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(LocalDate fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    @Override
    public String toString() {
        return "EjemplarVO{" + "id=" + id + ", edad=" + edad + ", fechaCompra=" + fechaCompra + ", fechaPlantacion=" + fechaPlantacion + ", idPlanta=" + idPlanta + ", idLocalizacion=" + idLocalizacion + '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
		result = prime * result + ((fechaPlantacion == null) ? 0 : fechaPlantacion.hashCode());
		result = prime * result + id;
		result = prime * result + idLocalizacion;
		result = prime * result + idPlanta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EjemplarVO other = (EjemplarVO) obj;
		if (edad != other.edad)
			return false;
		if (fechaCompra == null) {
			if (other.fechaCompra != null)
				return false;
		} else if (!fechaCompra.equals(other.fechaCompra))
			return false;
		if (fechaPlantacion == null) {
			if (other.fechaPlantacion != null)
				return false;
		} else if (!fechaPlantacion.equals(other.fechaPlantacion))
			return false;
		if (id != other.id)
			return false;
		if (idLocalizacion != other.idLocalizacion)
			return false;
		if (idPlanta != other.idPlanta)
			return false;
		return true;
	}
    
    

}
