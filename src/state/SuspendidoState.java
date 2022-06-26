package state;

import paquete.Ticket;
import paquete.UsuarioInteractivo;

public class SuspendidoState implements IState
{

	private Ticket ticket;
	
	public SuspendidoState(Ticket ticket)
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
		this.ticket.setEstado(new ActivoState(this.ticket));
		
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
		return "Suspendido";
	}
	
	/**
	 * Activa el ticket.
	 */
	
	@Override
	public void activa()
	{
		this.ticket.setEstado(new ActivoState(this.ticket));
		
	}
	
	/**
	 * Suspende el ticket.
	 */
	
	@Override
	public void suspende()
	{
		System.out.println("Ticet ya suspendido previamente");
		
	}
	
	/**
	 * Cancela el ticket.
	 */

	@Override
	public void cancela()
	{
		this.ticket.setEstado(new CanceladoState(this.ticket));
		
	}
	
	/**
	 * Finaliza el ticket.
	 */
	
	@Override
	public void finaliza()
	{
		System.out.println("El ticket debe estar activado para poder ser finalizado.");
		
	}

}
