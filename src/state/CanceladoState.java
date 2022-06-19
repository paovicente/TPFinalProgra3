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
		// TODO Auto-generated method stub

	}

	@Override
	public String diceEstado()
	{
		// TODO Auto-generated method stub
		return "Cancelado";
	}

}
