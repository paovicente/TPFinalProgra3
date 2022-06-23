package paquete;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Observador implements Observer
{

	protected ArrayList<TicketSimplificado> observados = new ArrayList<TicketSimplificado>();

	public void agregarObservable(TicketSimplificado ticket)
	{
		ticket.addObserver(this);
		this.observados.add(ticket);
	}

	public void borrarObservable(TicketSimplificado ticket)
	{
		ticket.deleteObserver(this);
		this.observados.remove(ticket);
	}

	@Override
	public void update(Observable o, Object arg)
	{
		TicketSimplificado ticket = (TicketSimplificado) o;
		if (this.observados.contains(o))
		{
			System.out.println("**** Ticket "+ticket.getEstado()+" ****");
		}
		else
			throw new IllegalArgumentException();

	}

}
