package paquete;

public class PersonaJuridica extends Persona{

	@Override
	public double porcentajeSalud() {
		return 0.8;
	}

	@Override
	public double porcentajeComercioLocal() {
		return 0.9;
	}

	@Override
	public double porcentajeComercioInternacional() {
		return 1;
	}
	
	public boolean juridica() {
		return true;
	}
	
}
