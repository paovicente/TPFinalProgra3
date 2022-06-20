package paquete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Usuario
 * Lista creada luego de la ronda de encuentros laborales. Está formada por el conjunto de empleadores ordenados por el
puntaje que el empleado obtuvo como calificación.
 *
 */
public class ListaDelEmpleado extends Lista implements Serializable
{

    /**
     * @aggregation shared
     */
    ArrayList<Empleador> empleadores = new ArrayList<Empleador>();

    /**
     * @aggregation shared
     */
    ArrayList<TicketBuscaEmpleado> tickets = new ArrayList<TicketBuscaEmpleado>();
	ArrayList<Double> puntajes = new ArrayList<Double>();

	/**
	 * Ordena la lista en base al puntaje obtenido luego de la ronda de encuentros laborales.<br> 
	 * <b>Pre: </b>Se realizó la ronda de encuentros laborales.<br>
	 * <b>Post: </b>Ordena la lista.<br>
	 */
	public void ordenar()
	{
		double auxpuntaje;
		Empleador auxEmpleador;
		TicketBuscaEmpleado auxTicket;

		for (int k = 0; k < puntajes.size(); k++)
		{
			for (int i = 0; i < puntajes.size(); i++)
			{
				for (int f = 0; f < puntajes.size() - 1 - k; f++)
				{
					if (puntajes.get(f) < puntajes.get(f + 1))
					{
						auxpuntaje = puntajes.get(f);
						puntajes.set(f, puntajes.get(f + 1));
						puntajes.set(f + 1, auxpuntaje);

						auxEmpleador = empleadores.get(f);
						empleadores.set(f, empleadores.get(f + 1));
						empleadores.set(f + 1, auxEmpleador);

						auxTicket = tickets.get(f);
						tickets.set(f, tickets.get(f + 1));
						tickets.set(f + 1, auxTicket);
					}
				}
			}
		}
	}

	/**
	 * Muestra el nombre y el puntaje de los empleadores de la lista, con un índice adelante.
	 */
	public void mostrar()
	{
		Iterator<Empleador> itEmpleador = empleadores.iterator();
		Iterator<TicketBuscaEmpleado> itTicket = tickets.iterator();
		Iterator<Double> itPuntajes = puntajes.iterator();
		int i;

		i = 0;
		while (itEmpleador.hasNext() && itPuntajes.hasNext())
		{
			System.out.println("\t Elemento " + i + "\n  Nombre: " + itEmpleador.next().getNombre() + "   Puntaje: "
					+ itPuntajes.next() + "\n \n");
			i++;
		}

	}

	public ListaDelEmpleado()
	{
		super();
	}

	/**
	 * Inserta un empleador con su respectivo ticket y puntaje a la lista.<br> 
	 * <b>Pre: </b>empleador y ticket no son nulos.<br>
	 * <b>Post: </b>Agrega un elemento a la lista.<br> 
	 * @param empleador: Empleador con el que se compara en la Ronda de Encuentros Laborales.
	 * @param ticket: TicketBuscaEmpleado de empleador.
	 * @param puntaje: double que simboliza el puntaje obtenido luego de la Ronda de Encuentros Laborales.
	 */
	public void insertar(Empleador empleador, TicketBuscaEmpleado ticket, double puntaje)
	{
		this.empleadores.add(empleador);
		this.tickets.add(ticket);
		this.puntajes.add(puntaje);
	}

	public ArrayList<Empleador> getEmpleadores()
	{
		return empleadores;
	}

	public ArrayList<TicketBuscaEmpleado> getTickets()
	{
		return tickets;
	}

	public ArrayList<Double> getPuntajes()
	{
		return puntajes;
	}

}
