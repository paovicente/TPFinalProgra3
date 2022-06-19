package state;

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

	@Override
	public void gestionarTicket()
	{
		//ya esta activo
	}

	@Override
	public void rondaEncuentros(UsuarioInteractivo usuario1, UsuarioInteractivo usuario2, Ticket ticket)
	{
		usuario1.sigue(usuario2,ticket);
		
	}

	@Override
	public String diceEstado()
	{
		return "Activo";
		
	}

}
