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
	
	@Override
	public void gestionarTicket()
	{
		this.ticket.setEstado(new ActivoState(this.ticket));
		
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
		return "Suspendido";
	}

	@Override
	public void activa()
	{
		this.ticket.setEstado(new ActivoState(this.ticket));
		
	}

	@Override
	public void suspende()
	{
		System.out.println("Ticet ya suspendido previamente");
		
	}

	@Override
	public void cancela()
	{
		this.ticket.setEstado(new CanceladoState(this.ticket));
		
	}

	@Override
	public void finaliza()
	{
		System.out.println("El ticket debe estar activado para poder ser finalizado.");
		
	}

}
