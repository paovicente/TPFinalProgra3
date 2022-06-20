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

	public TicketSimplificado buscaEmpleo(String nombre, String tipoDeTrabajo)
	{
		synchronized (this.tickets)
		{
			TicketSimplificado ticket = null;
			int i = 0;
			while (i < tickets.size() && ticket == null)
			{
				if (tickets.get(i).getTipoDeTrabajo().equals(tipoDeTrabajo))
				{
					ticket = tickets.get(i);
					while (ticket.getEstado().equals("EnConsulta"))
						try
						{
							System.out.println(nombre + " no consulta el ticket de " + ticket.getEmpleador().getNombre()
									+ " porque ya esta en consulta.\n");
							this.tickets.wait();
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					if (!ticket.getEstado().equals("NoDisponible"))
					{
						ticket.setEstado("EnConsulta");
						System.out.println(
								nombre + " esta en proceso de consulta con '" + ticket.getEmpleador().getNombre());
					} else
						ticket = null;
				}
				i++;
			}

			return ticket;

		}
	}

	public void devuelveTicket(String nombre, TicketSimplificado ticket)
	{
		synchronized (this.tickets)
		{
			System.out.println(nombre + " no consigue trabajo porque su locacion no es compatible con la de "+ticket.getEmpleador().getNombre());
			ticket.setEstado("Disponible");
			this.tickets.notifyAll();
		}
	}

	public void noDevuelveTicket(String nombre, TicketSimplificado ticket)
	{
		synchronized (this.tickets)
		{
			System.out.println(nombre + " consigue empleo con "+ticket.getEmpleador().getNombre()+".");
			this.tickets.remove(ticket);
			ticket.setEstado("NoDisponible");
			this.tickets.notifyAll();
		}
	}

	public void agregaEmpleo(TicketSimplificado ticket)
	{
		synchronized (this.tickets)
		{
			this.tickets.add(ticket);
		}
	}
}