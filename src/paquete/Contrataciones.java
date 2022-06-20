package paquete;

import java.io.Serializable;

public class Contrataciones implements Serializable{
	private Empleado empleado;
	private Empleador empleador;
	
	public Contrataciones(Empleado empleado, Empleador empleador) {
		super();
		this.empleado = empleado;
		this.empleador = empleador;
	}

	@Override
	public String toString() {
		return (empleado.getNombre()+ "es empleado de " + empleador.getNombre());
	}
	
	
}
