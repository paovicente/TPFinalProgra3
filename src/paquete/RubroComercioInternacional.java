package paquete;

public class RubroComercioInternacional extends Rubro{

	@Override
	public double persona(Persona persona) {
		return persona.porcentajeComercioInternacional();
	}


	@Override
	public String toString() {
		return "RubroComercioInternacional []";
	}

	
}
