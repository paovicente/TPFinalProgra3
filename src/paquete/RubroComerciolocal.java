package paquete;

public class RubroComerciolocal extends Rubro{

	@Override
	public double persona(Persona persona) {
		return persona.porcentajeComercioLocal();
	}


	@Override
	public String toString() {
		return "RubroComerciolocal []";
	}
	
	

}
