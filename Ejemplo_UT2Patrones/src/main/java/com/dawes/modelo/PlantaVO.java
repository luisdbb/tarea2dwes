package com.dawes.modelo;

import java.util.Scanner;

public class PlantaVO {

    private int id;
    private String nombre;

    public PlantaVO() {
    }

    public PlantaVO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static PlantaVO nuevaPlanta() {
        Scanner in = new Scanner(System.in);
        PlantaVO pl;
        boolean correcto = false;
        do {
            pl = new PlantaVO();
            System.out.println("Introduzca los datos para una nueva PlantaVO:");
            System.out.println("nombre");
            String nombre = in.nextLine();
            pl.setNombre(nombre);
            correcto = PlantaVO.validarPlanta(pl);
            if (!correcto) {
                System.out.println("Error de validación: los datos introducidos no son correctos.");
            }
        } while (!correcto);
        return pl;
    }

    public static boolean validarPlanta(PlantaVO p) {
        if (p.getId() != 0) {
            if (p.getId() < 0) {
                return false;
            }
        }
        if (p.getNombre().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlantaVO{" + "id=" + id + ", nombre=" + nombre + '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		PlantaVO other = (PlantaVO) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
