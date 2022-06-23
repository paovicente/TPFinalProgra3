package paquete;

import java.util.ArrayList;

public class BolsaDeTrabajo
{
	private static BolsaDeTrabajo _instancia = null;
	private ArrayList<TicketSimplificado> tickets = new ArrayList<TicketSimplificado>();

	public static BolsaDeTrabajo getInstancia()
	{
		if (_instancia == null)
			_instancia = new BolsaDeTrabajo();

		return _instancia;
	}

	public synchronized TicketSimplificado buscaEmpleo(String nombre, String tipoDeTrabajo)
	{
		TicketSimplificado ticket = null;
		int i = 0;
		while (i < tickets.size() && ticket == null)
		{
			if (tickets.get(i).getTipoDeTrabajo().equals(tipoDeTrabajo))
			{
				ticket = tickets.get(i);
				while (ticket.getEstado().equals("en consulta"))
					try
					{
						System.out.println(nombre + " no consulta el ticket de " + ticket.getEmpleador().getNombre()
								+ " porque ya esta en consulta.\n");
						this.wait();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (!ticket.getEstado().equals("no disponible"))
				{
					ticket.setEstado("en consulta");
					ticket.cambiaEstado(); //esto es para llamar a los metodos de observable
					System.out
							.println(nombre + " esta en proceso de consulta con '" + ticket.getEmpleador().getNombre());
				} else
					ticket = null;
			}
			i++;
		}
		return ticket;
	}

	public synchronized void devuelveTicket(String nombre, TicketSimplificado ticket)
	{
		System.out.println(nombre + " no consigue trabajo porque su locacion no es compatible con la de "
				+ ticket.getEmpleador().getNombre());
		ticket.setEstado("disponible");
		ticket.cambiaEstado(); //esto es para llamar a los metodos de observable
		this.notifyAll();
	}

	public synchronized void noDevuelveTicket(String nombre, TicketSimplificado ticket)
	{
		System.out.println(nombre + " consigue empleo con " + ticket.getEmpleador().getNombre() + ".");
		this.tickets.remove(ticket);
		ticket.setEstado("no disponible");
		ticket.cambiaEstado(); //esto es para llamar a los metodos de observable
		this.notifyAll();
	}

	public synchronized void agregaEmpleo(TicketSimplificado ticket)
	{
		this.tickets.add(ticket);
	}
}