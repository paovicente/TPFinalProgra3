package subclasesDeAtributosDeFormulario;

import formularioclases.TipoPuesto;

/**
 * @author Usuario
 * Junior que hereda de TipoPuesto
 */
public class Junior extends TipoPuesto
{

	
	/**
	 * Devuelve el 80% del salario pretendido.
	 */
	@Override
	public double calcularComision(double valor)
	{
		return valor*0.8;
	}
	
	/**
	 * Llama al método de TipoPuesto con el que se está comparando cuando el que invocó originalemnte es Junior.
	 */
	@Override
	public double calcularTipoPuesto(TipoPuesto tipoPuesto)
	{
		return tipoPuesto.junior();
	}

	/**
	 * Devuelve el resultado de la matriz de Ronda de Encuentros Laborales cuando el TipoPuesto que invoca es Junior y el pasado como parámetro es Junior.
	 */
	@Override
	public double junior()
	{
		return 1.;
	}
	/**
	 * Devuelve el resultado de la matriz de Ronda de Encuentros Laborales cuando el TipoPuesto que invoca es Senior y el pasado como parámetro es Junior.
	 */
	@Override
	public double senior()
	{
		return -0.5;
	}


	/**
	 	 * Devuelve el resultado de la matriz de Ronda de Encuentros Laborales cuando el TipoPuesto que invoca es Management y el pasado como parámetro es Junior.
	 */
	@Override
	public double management()
	{
		return -1.;
	}

	/**
	 * Muestra que el TipoPuesto es Junior.
	 */
	@Override
	public String diceTipo()
	{
		// TODO Auto-generated method stub
		return "Junior";
	}
	
	

}
