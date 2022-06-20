package paquete;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	
	public abstract double porcentajeSalud();
	public abstract double porcentajeComercioLocal();
	public abstract double porcentajeComercioInternacional();
	public abstract boolean juridica();
}
