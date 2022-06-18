package paquete;

public class PersonaFisica extends Persona {
	
	
	public double porcentajeSalud() {
		return 0.6;
	}
	
	public double porcentajeComercioLocal() {
		return 0.7;
	}


	public double porcentajeComercioInternacional() {
		return 0.8;
	}
	
	public boolean juridica() {
		return false;
	}
}
