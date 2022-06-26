package paquete;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import excepciones.ListaNoGeneradaException;
import subclasesDeAtributosDeFormulario.CargaCompleta;
import subclasesDeAtributosDeFormulario.CargaExtendida;
import subclasesDeAtributosDeFormulario.CargaMedia;
import subclasesDeAtributosDeFormulario.Entre40y50;
import subclasesDeAtributosDeFormulario.HomeOffice;
import subclasesDeAtributosDeFormulario.Indistinto;
import subclasesDeAtributosDeFormulario.Junior;
import subclasesDeAtributosDeFormulario.Management;
import subclasesDeAtributosDeFormulario.MasDe50;
import subclasesDeAtributosDeFormulario.Media;
import subclasesDeAtributosDeFormulario.MenosDe40;
import subclasesDeAtributosDeFormulario.Mucha;
import subclasesDeAtributosDeFormulario.Nada;
import subclasesDeAtributosDeFormulario.Presencial;
import subclasesDeAtributosDeFormulario.Primario;
import subclasesDeAtributosDeFormulario.Secundario;
import subclasesDeAtributosDeFormulario.Senior;
import subclasesDeAtributosDeFormulario.Terciario;
import subclasesDeAtributosDeFormulario.V1;
import subclasesDeAtributosDeFormulario.V2;
import subclasesDeAtributosDeFormulario.V3;

/**
 * @author Usuario <br>
 *         Clase que representa a un Empleado, hereda estados y comportamientos
 *         de la clase UsuarioInteractivo
 *
 */

public class Empleado extends UsuarioInteractivo implements Runnable
{

	private String apellido;
	private String telefono;
	private int edad;
	private TicketBuscaEmpleo ticket = null;
	private transient Scanner scanner = new Scanner(System.in);   //transient para que no persista
	private ListaDelEmpleado elecciones; // para la ronda de elecciones, tengo que guardar el resultado
	private TicketSimplificado ticketSimplificado;

	public Empleado(String nombre, String nombreDeUsuario, String contrasenia, int puntaje, String apellido,
			String telefono, int edad)
	{
		super(nombre, nombreDeUsuario, contrasenia, puntaje);
		this.apellido = apellido;
		this.telefono = telefono;
		this.edad = edad;
	}

	public ListaDelEmpleado getElecciones()
	{
		return elecciones;
	}

	@Override
	public void muestraLista()
	{
		this.ticket.getLista().mostrar();
	}

	public TicketBuscaEmpleo getTicket()
	{
		return ticket;
	}

	public void setTicket(TicketBuscaEmpleo ticket)
	{
		this.ticket = ticket;
	}

	@Override
	public String toString()
	{
		return super.toString() + "Empleado [apellido=" + apellido + ", telefono=" + telefono + ", edad=" + edad
				+ ", ticket=" + ticket + "]";
	}

	/**
	 * Agrega a la lista de elecciones del empleado, los empleadores
	 * correspondientes (indicados por el parámetro)<br>
	 * <b>Pre: </b> El arrayList debe tener al menos un elemento <br>
	 * <b>Post: </b> Se insertaron los empleadores seleccionados por el empleado a
	 * la lista de elecciones del empleado en cuestión <br>
	 * 
	 * @param indicesElecciones: parámetro que contiene los indices de los
	 *                           empleadores que serán agregados a la lista de
	 *                           elecciones del empleado<br>
	 */
	public void rondaElecciones(ArrayList<Integer> indicesElecciones)
	{// le paso un vector de indices que son las
		// elecciones
		/*
		 * recorro los 3 arraylist de la listaDelEmpleado (que está dentro del ticket),
		 * luego voy guardando los datos de los indices elegidos en la nueva lista de
		 * elecciones
		 */
		Empleador empleador;
		TicketBuscaEmpleado ticket;
		double puntaje;
		ListaDelEmpleado lista = this.getTicket().getLista();
		this.elecciones = new ListaDelEmpleado();

		for (Integer indice : indicesElecciones)
		{
			if (indice < this.getTicket().getLista().getEmpleadores().size())
			{ // acá me fijo que sea un indice válido
				empleador = lista.getEmpleadores().get(indice);
				ticket = lista.getTickets().get(indice);
				puntaje = lista.getPuntajes().get(indice);

				this.elecciones.insertar(empleador, ticket, puntaje);
				System.out.println("Elección " + empleador.getNombre() + " insertada.");
			}
		}
	}

	/**
	 * Permite modificar los estados de un ticket, dar de alta, de baja, o modificar
	 * un ticket.<br>
	 * <b>Pre: </b> El ticket no debe ser null. Excepto que vaya a dar de alta el
	 * ticket. <br>
	 * <b>Post: </b> El ticket se modificará de acuerdo a la operación que indique
	 * el parámetro <br>
	 * 
	 * @param c: caracter que indica la operación que se realizará en el método<br>
	 */
	@Override
	public void gestionarTicket(char c)
	{
		switch (c)
		{
		case 's':
			this.getTicket().suspende();
			break;
		case 'x': //activar (solo si estaba previamente suspendido)
			this.getTicket().gestionarTicket();
		case 'k':
			this.getTicket().cancela();
			this.setPuntaje(this.getPuntaje() - 1);
			break;
		case 'a': // alta
			if (this.getTicket() == null)
			{
				FormularioFactory formularioFactory = new FormularioFactory();
				System.out.println("Ahora deberás llenar tu nuevo formulario...");
				
				String[] opciones = {"Home Office", "Presencial", "Indistinto"};
				int locacion = JOptionPane.showOptionDialog(null, "Elije una locacion de preferencia", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0])+1;

				
				//System.out.println("Elija una locacion de preferencia");
				//System.out.println("1.Home Office      2.Presencial       3.Indistinto");
				//int locacion = scanner.nextInt();
				
				
				String[] opciones1 = {"V1", "V2", "V3"};
				int remuneracion  = JOptionPane.showOptionDialog(null, "Elija una remuneración", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones1, opciones1[0])+1;
			/*	System.out.println("Elija una remuneracion");
				System.out.println("1.V1               2.V2               3.V3");
				int remuneracion = scanner.nextInt(); */

				
				String[] opciones2 = {"Media", "Completa", "Extendida"};
				int cargaHoraria  = JOptionPane.showOptionDialog(null, "Elija una carga horaria", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones2, opciones2[0])+1;
				
				/*System.out.println("Elija una carga horaria");
				System.out.println("1.Media            2.Completa         3.Extendida");
				int cargaHoraria = scanner.nextInt(); */

				

				String[] opciones3 = {"Senior", "Junior", "Management"};
				int tipoDePuesto  = JOptionPane.showOptionDialog(null, "Elija un tipo de puesto", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones3, opciones3[0])+1;
				
			/*	System.out.println("Elija un tipo de puesto");
				System.out.println("1.Senior           2.Junior           3.Management");
				int tipoDePuesto = scanner.nextInt(); */
				

				String[] opciones4 = {"Menos de 40", "Entre 40 y 50", "Mas de 50"};
				int rangoEtario  = JOptionPane.showOptionDialog(null, "Elije un rango etario", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones4, opciones4[0])+1;

			/*	System.out.println("Elija un rango etario");
				System.out.println("1.Menos de 40      2.Entre 40 y 50    3.Más de 50");
				int rangoEtario = scanner.nextInt(); */

				String[] opciones5 = {"Nada", "Media", "Mucha"};
				int experiencia  = JOptionPane.showOptionDialog(null, "Elija una experiencia", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones5, opciones5[0])+1;
				
				/* System.out.println("Elija una experiencia");
				System.out.println("1.Nada             2.Media            3.Mucha");
				int experiencia = scanner.nextInt(); */

				String[] opciones6 = {"Primario", "Secundario", "Terciario"};
				int estudios  = JOptionPane.showOptionDialog(null, "Elija estudios", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones6, opciones6[0])+1;
				
				/* System.out.println("Elija estudios");
				System.out.println("1.Primario         2.Secundario       3.Terciario");
				int estudios = scanner.nextInt(); */
				
				scanner.nextLine();
				FormularioDeBusqueda formulario = formularioFactory.getFormularioDeBusqueda(locacion, remuneracion,
						cargaHoraria, tipoDePuesto, rangoEtario, experiencia, estudios); // seteo el formulario de
																							// Empleado
				this.setTicket(new TicketBuscaEmpleo(formulario)); // seteo el ticket CON el formulario
			} else
				System.out.println("Ya existe el ticket. Si desea cambiarlo, primero elimine y luego de el alta");
			break;
		case 'b': // baja
			this.ticket = null;
			break;
		case 'c': // consulta
			this.ticket.toString();
			break;
		case 'm': // modifica un valor del formulario
			String[] opcionesModificar = {"Carga Horaria", "Estudios Cursados", "Experiencia","Locación","Rango Etario","Remuneración","Tipo de Puesto"};
			int i = JOptionPane.showOptionDialog(null, "¿Qué elemento deseas modificar?", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesModificar, opcionesModificar[0])+1;
		/*	System.out.println("¿Qué te gustaria modificar del formulario?");
			System.out.println(
					"1. Carga Horaria \n 2.Estudios Cursados \n 3.Experiencia \n 4.Locación \n 5.Rango Etario \n 6. Remuneración \n 7.Tipo de Puesto");
			String aux = scanner.nextLine();
			int i = Integer.parseInt(aux);*/
			int eleccion;
			switch (i)
			{
			case 1:
				String[] opciones2 = {"Media", "Completa", "Extendida"};
				eleccion  = JOptionPane.showOptionDialog(null, "Elija una carga horaria", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones2, opciones2[0])+1;
				
				 /*System.out.println("Elija una carga horaria");
				System.out.println("1.Media            2.Completa         3.Extendida");
				eleccion = scanner.nextInt(); */
				switch (eleccion)
				{
				case 1:
					this.getTicket().getFormulario().setCargahoraria(new CargaMedia());
					break;
				case 2:
					this.getTicket().getFormulario().setCargahoraria(new CargaCompleta());
					break;
				case 3:
					this.getTicket().getFormulario().setCargahoraria(new CargaExtendida());
					break;
				default:
					System.out.println("Valor de carga horaria ingresado incorrento");
				}
				break;
			case 2:
				String[] opciones6 = {"Primario", "Secundario", "Terciario"};
				eleccion  = JOptionPane.showOptionDialog(null, "Elija estudios", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones6, opciones6[0])+1;
				
				/*System.out.println("Elija estudios");
				System.out.println("1.Primario         2.Secundario       3.Terciario");
				eleccion = scanner.nextInt(); */
				switch (eleccion)
				{
				case 1:
					this.getTicket().getFormulario().setEstudiosCursados(new Primario());
					break;
				case 2:
					this.getTicket().getFormulario().setEstudiosCursados(new Secundario());
					break;
				case 3:
					this.getTicket().getFormulario().setEstudiosCursados(new Terciario());
					break;
				default:
					System.out.println("Valor de estudios ingresado incorrecto");
				}
				break;
			case 3:
				
				String[] opciones5 = {"Nada", "Media", "Mucha"};
				eleccion  = JOptionPane.showOptionDialog(null, "Elija una experiencia", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones5, opciones5[0])+1;
				
				/* System.out.println("Elija una experiencia");
				System.out.println("1.Nada             2.Media            3.Mucha");
				eleccion = scanner.nextInt(); */
				switch (eleccion)
				{
				case 1:
					this.getTicket().getFormulario().setExperiencia(new Nada());
					break;
				case 2:
					this.getTicket().getFormulario().setExperiencia(new Media());
					break;
				case 3:
					this.getTicket().getFormulario().setExperiencia(new Mucha());
					break;
				default:
					System.out.println("Valor de experiencia ingresado incorrecto");
				}
				break;
			case 4:
				
				String[] opciones = {"Home Office", "Presencial", "Indistinto"};
				eleccion = JOptionPane.showOptionDialog(null, "Elije una locacion de preferencia", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0])+1;
				
				/* System.out.println("Elija una locacion de preferencia");
				System.out.println("1.Home Office      2.Presencial       3.Indistinto");
				eleccion = scanner.nextInt(); */
				switch (eleccion)
				{
				case 1:
					this.getTicket().getFormulario().setLocacion(new HomeOffice());
					break;
				case 2:
					this.getTicket().getFormulario().setLocacion(new Presencial());
					break;
				case 3:
					this.getTicket().getFormulario().setLocacion(new Indistinto());
					break;
				default:
					System.out.println("Valor de Locacion ingresado incorrecto");
				}
				break;
			case 5:
				String[] opciones4 = {"Menos de 40", "Entre 40 y 50", "Mas de 50"};
				eleccion= JOptionPane.showOptionDialog(null, "Elije un rango etario", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones4, opciones4[0])+1;
				
			/*	System.out.println("Elija un rango etario");
				System.out.println("1.Menos de 40      2.Entre 40 y 50    3.Más de 50");
				eleccion = scanner.nextInt(); */
				switch (eleccion)
				{
				case 1:
					this.getTicket().getFormulario().setRangoEtario(new MenosDe40());
					break;
				case 2:
					this.getTicket().getFormulario().setRangoEtario(new Entre40y50());
					break;
				case 3:
					this.getTicket().getFormulario().setRangoEtario(new MasDe50());
					break;
				default:
					System.out.println("Valor de Rango Etario ingresado incorrecto");
				}
				break;
			case 6:
				String[] opciones1 = {"V1", "V2", "V3"};
				eleccion  = JOptionPane.showOptionDialog(null, "Elija una remuneración", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones1, opciones1[0])+1;
				
			/*	System.out.println("Elija una remuneracion");
				System.out.println("1.V1               2.V2               3.V3");
				eleccion = scanner.nextInt(); */
				switch (eleccion)
				{
				case 1:
					this.getTicket().getFormulario().setRemuneracion(new V1());
					break;
				case 2:
					this.getTicket().getFormulario().setRemuneracion(new V2());
					break;
				case 3:
					this.getTicket().getFormulario().setRemuneracion(new V3());
					break;
				default:
					System.out.println("Valor de Remuneracion ingresado incorrecto");
				}
				break;
			case 7:
				String[] opciones3 = {"Senior", "Junior", "Management"};
				eleccion  = JOptionPane.showOptionDialog(null, "Elija un tipo de puesto", "Clickea una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones3, opciones3[0])+1;

				eleccion = scanner.nextInt();
				switch (eleccion)
				{
				case 1:
					this.getTicket().getFormulario().setTipoPuesto(new Junior());
					break;
				case 2:
					this.getTicket().getFormulario().setTipoPuesto(new Senior());
					break;
				case 3:
					this.getTicket().getFormulario().setTipoPuesto(new Management());
					break;
				default:
					System.out.println("Valor de Tipo de Puesto ingresado incorrecto");
				}
				break;
			default:
				System.out.println("Valor ingresado incorrecto.");
				break;
			}
		}
	}

	/**
	 * Calcula la comisión en el momento de la contratación. <br>
	 * <b>Pre: </b> El parámetro formulario no debe ser null <br>
	 * <b>Post: </b> Se obtendrá la comisión que cobró el Empleado luego de la
	 * contratación <br>
	 * 
	 * @param formulario: formulario que se tendrá en cuenta para realizar los
	 *                    cálculos <br>
	 */
	@Override
	public void calcularComision(FormularioDeBusqueda formulario)
	{
		super.calcularComision(formulario);
		System.out.println(formulario.getTipoPuesto().calcularComision(formulario.getRemuneracion().getValor())
				- this.getPuntaje() * 0.01);
	}

	/**
	 * Genera la lista de asignación del empleado (ListaDelEmpleado) <br>
	 * <b>Pre: </b> El Empleado debe tener un ticket que no debe ser null <br>
	 * <b>Post: </b> Se genera la lista de asignación. Si no se genera, ya sea
	 * porque ningún empleador tenía tickets o porque ningún ticket de ningún
	 * empleador tenía estado activo, se propaga una excepción <br>
	 */
	@Override
	public void rondaEncuentros() throws ListaNoGeneradaException
	{ // throw excepcion

		int i = 0;
		int j;
		double aux = 0;
		Sistema sis = Sistema.getInstancia();
		ArrayList<UsuarioInteractivo> empleadores = new ArrayList<UsuarioInteractivo>();
		empleadores = sis.getEmpleadores();

		ListaDelEmpleado l1 = new ListaDelEmpleado();
		this.getTicket().setLista(l1);
		while (i < empleadores.size()) // para todos los empleadores disponibles
		{
			System.out.println("Recorriendo empleadores");
			j = 0;
			while (j < ((Empleador) empleadores.get(i)).getTickets().size()) // todos los ticket de cada empleador
			{
				if (((Empleador) empleadores.get(i)).getTickets().get(j).diceEstado().equals("Activo"))
					this.getTicket().rondaEncuentros(this, empleadores.get(i),
							((Empleador) empleadores.get(i)).getTickets().get(j));
				j++;
			}
			i++;
		}
		if (this.getTicket().getLista().getEmpleadores().size() != 0)
		{
			this.getTicket().getLista().ordenar();

			int k = this.getTicket().getLista().getEmpleadores().size();
			if (k != 0)
			{
				Empleador empleador = this.getTicket().getLista().getEmpleadores().get(0);
				empleador.setPuntaje(empleador.getPuntaje() + 10);
			}

			System.out.println("Ejecutando la ronda de elecciones de empleados... ");
			this.rondaElecciones(this);
		} else
			throw new ListaNoGeneradaException(this.getNombreDeUsuario());
	}
	
	/**
	 * Termina de calcular la compatibilidad de aspectos de los tickets del empleador y del empleado.<br> 
	 * <b>Pre:</b>El empleador no puede ser null, el ticket no puede ser null y debe estar activo.<br>
	 * <b>Post:</b>Inserta en la lista del ticket del empleado al empleador con su ticket y el puntaje calculado<br>
	 * 
	 * @param empleador: empleador con el que se quiere saber la compatibilidad de su ticket.<br>
	 * @param ticket: ticket del empleador con el que se quiere saber la compatibilidad con el ticket del empleado.<br>
	 */


	public void sigue(UsuarioInteractivo empleador, Ticket ticket)
	{
		System.out.println("Recorriendo tickets de empleador..");
		double aux = calculaAspectos(this, (TicketBuscaEmpleado) ticket); // asigno puntaje
		this.getTicket().getLista().insertar((Empleador) empleador, (TicketBuscaEmpleado) ticket, aux);
	}
	
	/**
	 * Determina las elecciones de un empleado.<br>
	 * <b>Pre: </b> El empleado no debe ser null. El empleado debe tener un ticket
	 * que no debe ser null. La cantidad de elecciones que ingresa el usuario debe
	 * ser mayor a cero<br>
	 * <b>Post: </b> Se genera un ArrayList con los indices de las elecciones que
	 * hizo el empleado <br>
	 * 
	 * @param empleado: parámetro que indica el empleado para el cual se
	 *                  determinarán sus elecciones.
	 */
	

	public void rondaElecciones(Empleado empleado)
	{
		Scanner scanner = new Scanner(System.in);
		int cantElecciones;
		ArrayList<Integer> indicesElecciones = new ArrayList<Integer>();
		int aux;

		System.out.println("Ahora deberás escoger un empleador de la siguiente lista:");
		empleado.getTicket().getLista().mostrar();

		System.out.println("Cuantas elecciones quiere hacer?"); // precondicion>0
		cantElecciones = scanner.nextInt();
		for (int i = 0; i < cantElecciones; i++)
		{
			System.out.println("Ingrese numero de elemento que quiere elegir");
			aux = scanner.nextInt(); // acá guardo el indice de la eleccion
			if (aux >= 0)
				indicesElecciones.add(aux);
			else
			{
				System.out.println("Indice incorrecto");
			}
		}
		empleado.rondaElecciones(indicesElecciones); // metodo de clase empleado
	}
	
	@Override
	public void run()
	{
		int i = 0;
		while (i < 10 && this.ticketSimplificado == null)
		{
			TicketSimplificado ticket;
			String tipoDeTrabajo = null;
			Random r = new Random();
			int num = r.nextInt(3);
			switch (num)
			{
			case 0:
				tipoDeTrabajo = "RubroComercioInternacional";
				break;
			case 1:
				tipoDeTrabajo = "RubroComercioLocal";
				break;
			case 2:
				tipoDeTrabajo = "RubroSalud";
				break;
			}
			ticket = BolsaDeTrabajo.getInstancia().buscaEmpleo(this.getNombre(), tipoDeTrabajo);
			if (ticket != null)
			{
				Util.espera(3000);
				String locEmpl = this.getTicket().getFormulario().getLocacion().diceTipo();
				if (locEmpl.equals(ticket.getLocacion()) || locEmpl.equals("Indistinto")
						|| ticket.getLocacion().equals("Indistinto"))
				{
					this.ticketSimplificado = ticket;
					BolsaDeTrabajo.getInstancia().noDevuelveTicket(this.getNombre(), ticket);
				} else
					BolsaDeTrabajo.getInstancia().devuelveTicket(this.getNombre(), ticket);

			}
			i++;
		}
	}


}
