package com.dawes.modelo;

import java.util.Scanner;

public class ParcelaVO {

    private int id;
    private String nombre;
    private float area;
    private boolean privada;

    public ParcelaVO() {
    }

    public ParcelaVO(int id, String nombre, float area, boolean privada) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.privada = privada;
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

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public boolean isPrivada() {
        return privada;
    }

    public void setPrivada(boolean privada) {
        this.privada = privada;
    }

    public static ParcelaVO nuevaParcela() {
        Scanner in = new Scanner(System.in);
        ParcelaVO p;
        boolean correcto = false;
        do {
            p = new ParcelaVO();
            System.out.println("Introduzca los datos para una nueva ParcelaVO:");
            System.out.println("Nombre:");
            String nombre = in.nextLine();
            p.setNombre(nombre);
            System.out.println("Area (xx.xx)");
            float area = Float.valueOf(in.nextLine().replace(",", "."));
            p.setArea(area);
            System.out.println("?La parcela es privada? (s/n");
            char resp = in.nextLine().charAt(0);
            boolean privada;
            if (resp == 'n' || resp == 'N') {
                privada = false;
            } else {
                privada = true;
            }
            p.setPrivada(privada);
            correcto = ParcelaVO.validarParcela(p);
            if (!correcto) {
                System.out.println("Error de validación: los datos introducidos no son correctos.");
            }
        } while (!correcto);
        return p;
    }

    public static boolean validarParcela(ParcelaVO p) {
        if (p.getId() != 0) {
            if (p.getId() < 0) {
                return false;
            }
        }
        if (p.getNombre().isEmpty()) {
            return false;
        }
        if (p.getArea() < 0.0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ParcelaVO{" + "id=" + id + ", nombre=" + nombre + ", area=" + area + ", privada=" + privada + '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(area);
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + (privada ? 1231 : 1237);
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
		ParcelaVO other = (ParcelaVO) obj;
		if (Float.floatToIntBits(area) != Float.floatToIntBits(other.area))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (privada != other.privada)
			return false;
		return true;
	}

}
