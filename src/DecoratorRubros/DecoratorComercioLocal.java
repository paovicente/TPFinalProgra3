package DecoratorRubros;

public class DecoratorComercioLocal extends DecoratorRubros
{

	public DecoratorComercioLocal(IPersona encapsulado)
	{
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularComision()
	{
		return this.encapsulado.calcularComision()+0.7;
	}

	@Override
	public String diceRubro()
	{
		// TODO Auto-generated method stub
		return "RubroComercioLocal";
	}

}
