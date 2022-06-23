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

	@Override
	public void gestionarTicket()
	{
		System.out.println("Tciket ya activado previamente.");
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

	@Override
	public void activa()
	{
		System.out.println("Ticket ya previamente activado.");
		
	}

	@Override
	public void suspende()
	{
		this.ticket.setEstado(new SuspendidoState(this.ticket));
		
	}

	@Override
	public void cancela()
	{
		this.ticket.setEstado(new CanceladoState(this.ticket));
		
	}

	@Override
	public void finaliza()
	{
		this.ticket.setEstado(new FinalizadoState(this.ticket));
		
	}
	

}
