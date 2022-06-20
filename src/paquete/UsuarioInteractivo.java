package paquete;

import java.io.Serializable;

import excepciones.ListaNoGeneradaException;

/**
 * @author Usuario El tipo de usuario con el que un empleador o un empleado se
 *         puede registrar.
 *
 */
public abstract class UsuarioInteractivo extends Usuario implements Serializable
{

	private int puntaje;

	public UsuarioInteractivo(String nombre, String nombreDeUsuario, String contrasenia, int puntaje)
	{
		super(nombre, nombreDeUsuario, contrasenia);
		this.puntaje = puntaje;
	}

	/**
	 * M�todo abstracto que realiza la Ronda de Encuentros Laborales.
	 * 
	 * @throws ListaNoGeneradaException: Se lanza cuando la lista es null.
	 */
	public abstract void rondaEncuentros() throws ListaNoGeneradaException;

	/**
	 * Gestiona el ticket.
	 * @param c: caracter.
	 */
	public abstract void gestionarTicket(char c);

	/**
	 * Calcula la comision.<br> 
	 * <b>Pre: </b>formulario no es null. Hubo una contrataci�n<br>
	 * <b>Post: </b>Muestra por pantalla el nombre del usuario y la comisi�n que se le cobra.<br> 
	 * @param formulario
	 */
	public void calcularComision(FormularioDeBusqueda formulario)
	{
		System.out.print("Se le cobra a " + super.getNombre() + " una comision de $");
	}

	/**
	 * Muestra las opciones disponibles para la gesti�n del ticket.
	 */
	public static void instruccion()
	{
		System.out.println("Ingrese c�mo quiere gestionar su ticket.");
		System.out.println("A- Alta");
		System.out.println("B- Baja");
		System.out.println("C- Consulta");
		System.out.println("M- Modificaci�n");
		System.out.println("S- Suspender Ticket");
		System.out.println("K- Cancelar Ticket");
		System.out.println("X- Activar Ticket");
	}

	public int getPuntaje()
	{
		return puntaje;
	}

	public void setPuntaje(int puntaje)
	{
		this.puntaje = puntaje;
	}

	/**
	 * Muestra la lista creada luego de la Ronda de Encuentros Laborales.
	 */
	public void muestraLista()
	{ // ser� sobreescrito por clases hijas
		this.muestraLista();
	}

	/**
	 * Calcula el puntaje obtenido en el c�lculo de coincidencias laborales entre un empleado y un ticket de un empleador.<br> 
	 * <b>Pre: </b>empleado y ticket no son null.<br>
	 * <b>Post: </b>Se obtiene la sumatoria de los resultados de cada "matriz" de la Ronda de Encuentros Laborales.<br> 
	 * @param empleado: Empleado que interact�a en la Ronda de Encuentros Laborales.
	 * @param ticket: TicketBuscaEmpleado de Empleador que interact�a en la Ronda de Encuentros Laborales.
	 * @return Devuelve la suma que se obtiene.
	 */
	protected double calculaAspectos(Empleado empleado, TicketBuscaEmpleado ticket) // calculo de puntaje
	{
		double aux = 0.;

		aux += empleado.getTicket().getFormulario().getLocacion().calcularLocacion(ticket.getFormulario().getLocacion())
				* ticket.getPesos().get(0);
		aux += empleado.getTicket().getFormulario().getRemuneracion()
				.calcularRemuneracion(ticket.getFormulario().getRemuneracion()) * ticket.getPesos().get(1);
		aux += empleado.getTicket().getFormulario().getCargaHoraria()
				.calcularCargaHoraria(ticket.getFormulario().getCargaHoraria()) * ticket.getPesos().get(2);
		aux += empleado.getTicket().getFormulario().getTipoPuesto()
				.calcularTipoPuesto(ticket.getFormulario().getTipoPuesto()) * ticket.getPesos().get(3);
		aux += empleado.getTicket().getFormulario().getRangoEtario()
				.calcularRangoEtario(ticket.getFormulario().getRangoEtario()) * ticket.getPesos().get(4);
		aux += empleado.getTicket().getFormulario().getExperiencia()
				.calcularExperiencia(ticket.getFormulario().getExperiencia()) * ticket.getPesos().get(5);
		aux += empleado.getTicket().getFormulario().getEstudiosCursados()
				.calcularEstudiosCursados(ticket.getFormulario().getEstudiosCursados()) * ticket.getPesos().get(6);

		return aux;

	}
	
	public abstract void sigue(UsuarioInteractivo empleado, Ticket ticket);

	@Override
	public String toString()
	{
		return "UsuarioInteractivo [ " + super.toString() + ", puntaje = " + puntaje + "]";
	}

}
