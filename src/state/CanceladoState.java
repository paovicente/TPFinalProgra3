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

	@Override
	public void gestionarTicket()
	{
		System.out.println("Ticket cancelado. Imposible activar nuevamente");

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
		return "Cancelado";
	}

	@Override
	public void activa()
	{
		System.out.println("Error: Ticket cancelado. Imposible activar nuevamente");
		
	}

	@Override
	public void suspende()
	{
		System.out.println("Error: Ticket cancelado.");
		
	}

	@Override
	public void cancela()
	{
		System.out.println("Ticket ya cancelado previamente.");
		
	}

	@Override
	public void finaliza()
	{
		System.out.println("Error: Ticket cancelado.");
		
	}
	
	

}
