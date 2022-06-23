package paquete;

public class PersonaFisica extends Persona
{

	public boolean juridica()
	{
		return false;
	}

	@Override
	public double calcularComision()
	{
		return 0.;
	}

	@Override
	public String diceRubro()
	{
		return "";
	}
}
