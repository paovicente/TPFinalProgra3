package state;

import paquete.Ticket;
import paquete.UsuarioInteractivo;

public class CanceladoState implements IState
{

	private Ticket ticket;

	public CanceladoState(Ticket ticket)
	{
		super();
		this.ticket = ticket;
	}
	
	/**
	 * Continua con la gestion del ticket, dependiendo del estado del mismo.
	 */
	@Override
	public void gestionarTicket()
	{
		System.out.println("Ticket cancelado. Imposible activar nuevamente");

	}
	
	/**
	 * Continua con la ronda de encuentros laborales, dependiendo del estado de ambos tickets.
	 */

	@Override
	public void rondaEncuentros(UsuarioInteractivo usuario1, UsuarioInteractivo usuario2, Ticket ticket)
	{
		System.out.println("Error: ambos tickets deben estar activos.");

	}
	
	/**
	 * Devuelve un String con el nombre del estado.
	 */

	@Override
	public String diceEstado()
	{
		// TODO Auto-generated method stub
		return "Cancelado";
	}
	
	/**
	 * Activa el ticket.
	 */

	@Override
	public void activa()
	{
		System.out.println("Error: Ticket cancelado. Imposible activar nuevamente");
		
	}
	
	/**
	 * Suspende el ticket.
	 */

	@Override
	public void suspende()
	{
		System.out.println("Error: Ticket cancelado.");
		
	}
	
	/**
	 * Cancela el ticket.
	 */

	@Override
	public void cancela()
	{
		System.out.println("Ticket ya cancelado previamente.");
		
	}
	
	/**
	 * Finaliza el ticket.
	 */

	@Override
	public void finaliza()
	{
		System.out.println("Error: Ticket cancelado.");
		
	}
	
	

}
