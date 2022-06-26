package state;

import java.io.Serializable;

import paquete.Ticket;
import paquete.UsuarioInteractivo;

public class ActivoState implements IState
{

	private Ticket ticket;
	
	
	
	public ActivoState(Ticket ticket)
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
		System.out.println("Tciket ya activado previamente.");
	}
	
	/**
	 * Continua con la ronda de encuentros laborales, dependiendo del estado de ambos tickets.
	 */

	@Override
	public void rondaEncuentros(UsuarioInteractivo usuario1, UsuarioInteractivo usuario2, Ticket ticket)
	{
		
		usuario1.sigue(usuario2,ticket);
	}

	
	/**
	 * Devuelve un String con el nombre del estado.
	 */

	@Override
	public String diceEstado()
	{
		return "Activo";
		
	}

	/**
	 * Activa el ticket.
	 */
	
	@Override
	public void activa()
	{
		System.out.println("Ticket ya previamente activado.");
		
	}
	
	/**
	 * Suspende el ticket.
	 */

	@Override
	public void suspende()
	{
		this.ticket.setEstado(new SuspendidoState(this.ticket));
		
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
		this.ticket.setEstado(new FinalizadoState(this.ticket));
		
	}

}
