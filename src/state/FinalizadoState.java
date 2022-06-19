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
		this.ticket.setEstado(new ActivoState(this.ticket));
		
	}

	@Override
	public void rondaEncuentros(UsuarioInteractivo usuario1, UsuarioInteractivo usuario2, Ticket ticket)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String diceEstado()
	{
		// TODO Auto-generated method stub
		return "Finalizado";
	}

}
