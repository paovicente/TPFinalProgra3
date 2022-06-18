package paquete;

public class RubroSalud extends Rubro{

	@Override
	public double persona(Persona persona) {
		return persona.porcentajeSalud();
	}


	@Override
	public String toString() {
		return "RubroSalud []";
	}

	
}
