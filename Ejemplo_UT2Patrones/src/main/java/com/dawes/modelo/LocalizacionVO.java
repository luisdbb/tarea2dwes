package com.dawes.modelo;

import java.util.Scanner;

public class LocalizacionVO {

    private int id;
    private char latitud;
    private char longitud;
    private float gradosLatitud;
    private float gradosLongitud;

    public LocalizacionVO() {
    }

    public LocalizacionVO(int id, char latitud, char longitud, float gradosLatitud, float gradosLongitud) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.gradosLatitud = gradosLatitud;
        this.gradosLongitud = gradosLongitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getLatitud() {
        return latitud;
    }

    public void setLatitud(char latitud) {
        this.latitud = latitud;
    }

    public char getLongitud() {
        return longitud;
    }

    public void setLongitud(char longitud) {
        this.longitud = longitud;
    }

    public float getGradosLatitud() {
        return gradosLatitud;
    }

    public void setGradosLatitud(float gradosLatitud) {
        this.gradosLatitud = gradosLatitud;
    }

    public float getGradosLongitud() {
        return gradosLongitud;
    }

    public void setGradosLongitud(float gradosLongitud) {
        this.gradosLongitud = gradosLongitud;
    }

    public static LocalizacionVO nuevaLocalizacion(){
        Scanner in = new Scanner(System.in);
        LocalizacionVO loc;
        boolean correcto = false;
        do {
            loc = new LocalizacionVO();
            System.out.println("Introduzca los datos para una nueva LocalizacionVO:");
            System.out.println("Introduzca valor para la latitud (N/S):");
            char latitud = in.nextLine().charAt(0);
            loc.setLatitud(latitud);
            System.out.println("Introduzca valor para los grados de latitud (xx.xx)");
            float gradosLatitud = Float.valueOf(in.nextLine().replace(",", "."));
            loc.setGradosLatitud(gradosLatitud);
            System.out.println("Introduzca valor para la longitud (E/O):");
            char longitud = in.nextLine().charAt(0);
            loc.setLongitud(longitud);
            System.out.println("Introduzca valor para los grados de longitud (xx.xx)");
            float gradosLongitud = Float.valueOf(in.nextLine().replace(",", "."));;
            loc.setGradosLongitud(gradosLongitud);
            correcto = LocalizacionVO.validarLocalizacion(loc);
            if (!correcto) {
                System.out.println("Error de validación: los datos introducidos no son correctos.");
            }
        } while (!correcto);
        return loc;
    }

    public static boolean validarLocalizacion(LocalizacionVO l) {
        if (l.getId() != 0) {
            if (l.getId() < 0) {
                return false;
            }
        }
        if (l.getLatitud() != 0) {
            if (l.getLatitud() != 'n' && l.getLatitud() != 'N' && l.getLatitud() != 's' && l.getLatitud() != 'S') {
                return false;
            }
        }
        if (l.getLongitud() != 0) {
            if (l.getLongitud() != 'e' && l.getLongitud() != 'o' && l.getLongitud() != 'E' && l.getLongitud() != 'O') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "LocalizacionVO{" + "id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + ", gradosLatitud=" + gradosLatitud + ", gradosLongitud=" + gradosLongitud + '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(gradosLatitud);
		result = prime * result + Float.floatToIntBits(gradosLongitud);
		result = prime * result + id;
		result = prime * result + latitud;
		result = prime * result + longitud;
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
		LocalizacionVO other = (LocalizacionVO) obj;
		if (Float.floatToIntBits(gradosLatitud) != Float.floatToIntBits(other.gradosLatitud))
			return false;
		if (Float.floatToIntBits(gradosLongitud) != Float.floatToIntBits(other.gradosLongitud))
			return false;
		if (id != other.id)
			return false;
		if (latitud != other.latitud)
			return false;
		if (longitud != other.longitud)
			return false;
		return true;
	}

}
