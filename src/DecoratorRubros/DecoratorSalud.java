package DecoratorRubros;

public class DecoratorSalud extends DecoratorRubros
{
	
	public DecoratorSalud(IPersona encapsulado)
	{
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularComision()
	{
		return this.encapsulado.calcularComision()+0.6;
	}

	@Override
	public String diceRubro()
	{
		return "RubroSalud";
	}

}
