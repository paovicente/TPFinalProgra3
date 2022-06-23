package paquete;

public class PersonaJuridica extends Persona{

	
	public boolean juridica() {
		return true;
	}

	@Override
	public double calcularComision()
	{
		return 0.2;
	}

	@Override
	public String diceRubro()
	{
		return "";
	}
	
}
