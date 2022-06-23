package DecoratorRubros;

public class DecoratorComercioInternacional extends DecoratorRubros
{

	public DecoratorComercioInternacional(IPersona encapsulado)
	{
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularComision()
	{
		// TODO Auto-generated method stub
		return this.encapsulado.calcularComision()+0.8;
	}

	@Override
	public String diceRubro()
	{
		// TODO Auto-generated method stub
		return "RubroComercioInternacional";
	}

}
