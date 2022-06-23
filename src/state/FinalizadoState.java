package state;

import paquete.Ticket;
import paquete.UsuarioInteractivo;

public class FinalizadoState implements IState
{

	private Ticket ticket;

	public FinalizadoState(Ticket ticket)
	{
		super();
		this.ticket = ticket;
	}

	
	@Override
	public void gestionarTicket()
	{
		System.out.println("Ticket finalizado. Imposible activar nuevamente");
		
	}

	@Override
	public void rondaEncuentros(UsuarioInteractivo usuario1, UsuarioInteractivo usuario2, Ticket ticket)
	{
		//solo funciona cuando ambos tickets estan activos
		
	}

	@Override
	public String diceEstado()
	{
		// TODO Auto-generated method stub
		return "Finalizado";
	}


	@Override
	public void activa()
	{
		this.ticket.setEstado(new ActivoState(this.ticket));
		
	}


	@Override
	public void suspende()
	{
		System.out.println("Error: Ticket finalizado.");
		
	}


	@Override
	public void cancela()
	{
		System.out.println("Error: Ticket finalizado.");
		
	}


	@Override
	public void finaliza()
	{
		System.out.println("Ticket ya finalizado previamente.");
		
	}

}
