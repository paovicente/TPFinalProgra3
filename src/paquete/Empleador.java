package paquete;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

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
 *         Clase que representa a un Empleador, hereda estados y comportamientos
 *         de la clase UsuarioInteractivo
 */
public class Empleador extends UsuarioInteractivo implements Runnable
{

	// private boolean juridica;
	// private String rubro;
	private ArrayList<TicketBuscaEmpleado> tickets = new ArrayList<TicketBuscaEmpleado>();
	private Rubro rubro;
	private Persona persona;
	private ListaDelEmpleador elecciones;
	/**
	 * @aggregation composite
	 */
	

	public Empleador(String nombre, String nombreDeUsuario, String contrasenia, int puntaje, Persona persona,
			Rubro rubro)
	{
		super(nombre, nombreDeUsuario, contrasenia, puntaje);
		// this.juridica = juridica;
		this.persona = persona;
		this.rubro = rubro;
	}

	@Override
	public void muestraLista()
	{ // mostrará una lista para cada ticket
		int i = 1;
		Iterator<TicketBuscaEmpleado> iterador = tickets.iterator();
		while (iterador.hasNext())
		{
			System.out.println("Ticket numero " + i + ": ");
			iterador.next().getLista().mostrar();
			i++;
		}
	}

	public ListaDelEmpleador getElecciones()
	{
		return elecciones;
	}

	public void addTicket(TicketBuscaEmpleado ticket)
	{
		this.tickets.add(ticket);
	}

	public boolean isJuridica()
	{
		return persona.juridica();
	}

	public String getRubro()
	{
		return rubro.toString();
	}

	public ArrayList<TicketBuscaEmpleado> getTickets()
	{
		return tickets;
	}

	/**
	 * Muestra los tickets del Empleador
	 */
	public void muestraTickets()
	{
		for (int i = 0; i < this.tickets.size(); i++)
		{
			System.out.println(i + ".");
			System.out.println("Locacion: " + this.getTickets().get(i).getFormulario().getLocacion().diceTipo()
					+ ".  Peso: " + this.getTickets().get(i).getPesos().get(0));
			System.out.println("Remuneracion: " + this.getTickets().get(i).getFormulario().getRemuneracion().diceTipo()
					+ ".  Peso: " + this.getTickets().get(i).getPesos().get(1));
			System.out.println("Carga Horaria: " + this.getTickets().get(i).getFormulario().getCargaHoraria().diceTipo()
					+ ".  Peso: " + this.getTickets().get(i).getPesos().get(2));
			System.out.println("Tipo de puesto: " + this.getTickets().get(i).getFormulario().getTipoPuesto().diceTipo()
					+ ".  Peso: " + this.getTickets().get(i).getPesos().get(3));
			System.out.println("Rango etario: " + this.getTickets().get(i).getFormulario().getRangoEtario().diceTipo()
					+ ".  Peso: " + this.getTickets().get(i).getPesos().get(4));
			System.out.println(
					"Experiencia previa: " + this.getTickets().get(i).getFormulario().getExperiencia().diceTipo()
							+ ".  Peso: " + this.getTickets().get(i).getPesos().get(5));
			System.out.println(
					"Estudios Cursados: " + this.getTickets().get(i).getFormulario().getEstudiosCursados().diceTipo()
							+ ".  Peso: " + this.getTickets().get(i).getPesos().get(6));
		}
	}

	@Override
	public String toString()
	{
		return super.toString() + "Empleador [juridica=" + this.isJuridica() + ", rubro=" + rubro + ", tickets="
				+ tickets + "]";
	}

	/**
	 * Agrega a la lista de elecciones del empleador, los empleados correspondientes
	 * (indicados por el parámetro)<br>
	 * <b>Pre: </b> El arrayList debe tener al menos un elemento <br>
	 * <b>Post: </b> Se insertaron los empleados seleccionados por el empleador a la
	 * lista de elecciones del empleador en cuestión <br>
	 * 
	 * @param indicesElecciones: parámetro que contiene los indices de los empleados
	 *                           que serán agregados a la lista de elecciones del
	 *                           empleador<br>
	 * @param k:                 parámetro que representa el indice del ticket para
	 *                           el cual se hace la rondaElecciones<br>
	 */
	public void rondaElecciones(ArrayList<Integer> indicesElecciones, int k)
	{

		Empleado empleado;
		double puntaje;
		TicketBuscaEmpleado ticketAux;
		ListaDelEmpleador listaAux;

		ticketAux = this.getTickets().get(k);
		listaAux = ticketAux.getLista();
		this.elecciones = new ListaDelEmpleador();

		for (Integer indice : indicesElecciones)
		{
			if (indice < listaAux.getEmpleados().size())
			{ // acá me fijo que sea un indice válido
				empleado = listaAux.getEmpleados().get(indice);
				puntaje = listaAux.getPuntajes().get(indice);

				this.elecciones.insertar(empleado, puntaje);
				System.out.println("Eleccion " + empleado.getNombre() + " insertada");
			}
		}
	}

	/**
	 * Permite modificar los estados de un ticket, dar de alta, de baja, o modificar
	 * un ticket.<br>
	 * <b>Pre: </b> ---- <br>
	 * <b>Post: </b> El ticket (el empleador eligió el número de ticket) se
	 * modificará de acuerdo a la operación que indique el parámetro <br>
	 * 
	 * @param c: caracter que indica la operación que se realizará en el método<br>
	 */
	@Override
	public void gestionarTicket(char c)
	{ // ya pido la posicion del ticket previo a invocar el metodo
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresame el numero de ticket que deseas modificar.");
		for (int w = 0; w < this.tickets.size(); w++)
			System.out.println("Elemento " + w + ":" + this.tickets.get(w).toString());
		int i = scanner.nextInt();

		switch (c)
		{
		case 's': // suspender
			this.tickets.get(i).suspende();
			break;
		case 'x': // activar
			this.tickets.get(i).gestionarTicket();
		case 'k':
			this.tickets.get(i).cancela();
			break;
		case 'a': // alta de un nuevo ticket. no verifico null porque puedo tener muchos tickets
					// aquí
			FormularioFactory formularioFactory = new FormularioFactory();
			System.out.println("Ahora deberás llenar tu nuevo formulario...");

			System.out.println("Elija una locacion de preferencia");
			System.out.println("1.Home Office      2.Presencial       3.Indistinto");
			int locacion = scanner.nextInt();

			System.out.println("Elija una remuneracion");
			System.out.println("1.V1               2.V2               3.V3");
			int remuneracion = scanner.nextInt();

			System.out.println("Elija una carga horaria");
			System.out.println("1.Media            2.Completa         3.Extendida");
			int cargaHoraria = scanner.nextInt();

			System.out.println("Elija un tipo de puesto");
			System.out.println("1.Senior           2.Junior           3.Management");
			int tipoDePuesto = scanner.nextInt();

			System.out.println("Elija un rango etario");
			System.out.println("1.Menos de 40      2.Entre 40 y 50    3.Más de 50");
			int rangoEtario = scanner.nextInt();

			System.out.println("Elija una experiencia");
			System.out.println("1.Nada             2.Media            3.Mucha");
			int experiencia = scanner.nextInt();

			System.out.println("Elija estudios");
			System.out.println("1.Primario         2.Secundario       3.Terciario");
			int estudios = scanner.nextInt();

			System.out.println("Ingrese cantidad de empleados solicitados");
			int empSolic = scanner.nextInt();

			scanner.nextLine();

			ArrayList<Double> pesos = new ArrayList<Double>();
			System.out.println("Ahora debe ingresar el peso de cada aspecto");
			System.out.print("Locacion: ");
			pesos.add(scanner.nextDouble());
			System.out.print("Remuneracion: ");
			pesos.add(scanner.nextDouble());
			System.out.print("Carga horaria: ");
			pesos.add(scanner.nextDouble());
			System.out.print("Tipo de puesto: ");
			pesos.add(scanner.nextDouble());
			System.out.print("Rango etario: ");
			pesos.add(scanner.nextDouble());
			System.out.print("Experiencia previa: ");
			pesos.add(scanner.nextDouble());
			System.out.print("Estudios cursados: ");
			pesos.add(scanner.nextDouble());
			scanner.nextLine();

			FormularioDeBusqueda form = formularioFactory.getFormularioDeBusqueda(locacion, remuneracion, cargaHoraria,
					tipoDePuesto, rangoEtario, experiencia, estudios);
			this.addTicket(new TicketBuscaEmpleado(form, empSolic, pesos));
			break;
		case 'b': // baja del elemento i
			this.tickets.set(i, null);
			break;
		case 'c': // consulta
			System.out.println(this.tickets.get(i).toString());
			break;
		case 'm': // modifica un valor del formulario
			System.out.println("¿Qué te gustaria modificar del formulario?");
			System.out.println(
					"1. Carga Horaria \n 2.Estudios Cursados \n 3.Experiencia \n 4.Locación \n 5.Rango Etario \n 6. Remuneración \n 7.Tipo de Puesto");
			String aux = scanner.nextLine();
			int k = Integer.parseInt(aux);
			int eleccion;
			switch (k)
			{
			case 1:
				System.out.println("Elija una carga horaria");
				System.out.println("1.Media            2.Completa         3.Extendida");
				eleccion = scanner.nextInt();
				switch (eleccion)
				{
				case 1:
					this.tickets.get(i).getFormulario().setCargahoraria(new CargaMedia());
					break;
				case 2:
					this.tickets.get(i).getFormulario().setCargahoraria(new CargaCompleta());
					break;
				case 3:
					this.tickets.get(i).getFormulario().setCargahoraria(new CargaExtendida());
					break;
				default:
					System.out.println("Valor de carga horaria ingresado incorrento");
				}
				break;
			case 2:
				System.out.println("Elija estudios");
				System.out.println("1.Primario         2.Secundario       3.Terciario");
				eleccion = scanner.nextInt();
				switch (eleccion)
				{
				case 1:
					this.tickets.get(i).getFormulario().setEstudiosCursados(new Primario());
					break;
				case 2:
					this.tickets.get(i).getFormulario().setEstudiosCursados(new Secundario());
					break;
				case 3:
					this.tickets.get(i).getFormulario().setEstudiosCursados(new Terciario());
					break;
				default:
					System.out.println("Valor de estudios ingresado incorrecto");
				}
				break;
			case 3:
				System.out.println("Elija una experiencia");
				System.out.println("1.Nada             2.Media            3.Mucha");
				eleccion = scanner.nextInt();
				switch (eleccion)
				{
				case 1:
					this.tickets.get(i).getFormulario().setExperiencia(new Nada());
					break;
				case 2:
					this.tickets.get(i).getFormulario().setExperiencia(new Media());
					break;
				case 3:
					this.tickets.get(i).getFormulario().setExperiencia(new Mucha());
					break;
				default:
					System.out.println("Valor de experiencia ingresado incorrecto");
				}
				break;
			case 4:
				System.out.println("Elija una locacion de preferencia");
				System.out.println("1.Home Office      2.Presencial       3.Indistinto");
				eleccion = scanner.nextInt();
				switch (eleccion)
				{
				case 1:
					this.tickets.get(i).getFormulario().setLocacion(new HomeOffice());
					break;
				case 2:
					this.tickets.get(i).getFormulario().setLocacion(new Presencial());
					break;
				case 3:
					this.tickets.get(i).getFormulario().setLocacion(new Indistinto());
					break;
				default:
					System.out.println("Valor de Locacion ingresado incorrecto");
				}
				break;
			case 5:
				System.out.println("Elija un rango etario");
				System.out.println("1.Menos de 40      2.Entre 40 y 50    3.Más de 50");
				eleccion = scanner.nextInt();
				switch (eleccion)
				{
				case 1:
					this.tickets.get(i).getFormulario().setRangoEtario(new MenosDe40());
					break;
				case 2:
					this.tickets.get(i).getFormulario().setRangoEtario(new Entre40y50());
					break;
				case 3:
					this.tickets.get(i).getFormulario().setRangoEtario(new MasDe50());
					break;
				default:
					System.out.println("Valor de Rango Etario ingresado incorrecto");
				}
				break;
			case 6:
				System.out.println("Elija una remuneracion");
				System.out.println("1.V1               2.V2               3.V3");
				eleccion = scanner.nextInt();
				switch (eleccion)
				{
				case 1:
					this.tickets.get(i).getFormulario().setRemuneracion(new V1());
					break;
				case 2:
					this.tickets.get(i).getFormulario().setRemuneracion(new V2());
					break;
				case 3:
					this.tickets.get(i).getFormulario().setRemuneracion(new V3());
					break;
				default:
					System.out.println("Valor de Remuneracion ingresado incorrecto");
				}
				break;
			case 7:
				System.out.println("Elija un tipo de puesto");
				System.out.println("1.Senior           2.Junior           3.Management");
				eleccion = scanner.nextInt();
				switch (eleccion)
				{
				case 1:
					this.tickets.get(i).getFormulario().setTipoPuesto(new Junior());
					break;
				case 2:
					this.tickets.get(i).getFormulario().setTipoPuesto(new Senior());
					break;
				case 3:
					this.tickets.get(i).getFormulario().setTipoPuesto(new Management());
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
	 * Genera la lista de asignación del empleador (ListaDelEmpleador) <br>
	 * <b>Pre: </b> El Empleador debe tener al menos un ticket en su ArrayList de
	 * tickets.<br>
	 * El ticket elegido no debe ser null. <br>
	 * <b>Post: </b> Se genera la lista de asignación. Si no se genera, ya sea
	 * porque ningún empleado tenía ticket o porque el ticket de ningún empleado
	 * tenía estado activo, se propaga una excepción <br>
	 */
	@Override
	public void rondaEncuentros() throws ListaNoGeneradaException
	{

		Scanner scanner = new Scanner(System.in);

		Sistema sis = Sistema.getInstancia();
		ArrayList<UsuarioInteractivo> empleados = new ArrayList<UsuarioInteractivo>();
		empleados = sis.getEmpleados();

		System.out.println("Primero debe elegir un ticket");
		this.muestraTickets();
		System.out.println("Ingrese el numero de ticket: ");

		int num = scanner.nextInt();
		if (num >= 0 && num < this.getTickets().size())
		{
			this.getTickets().get(num).setLista(new ListaDelEmpleador());
			double aux = 0;
			int i = 0;
			while (i < empleados.size()) // para todos los empleados disponibles
			{
				if (((Empleado) empleados.get(i)).getTicket().diceEstado().equals("Activo"))
					this.getTickets().get(num).rondaEncuentros(this, empleados.get(i),this.getTickets().get(num));
				i++;
			}

			if (this.getTickets().get(num).getLista().getEmpleados().size() != 0)
			{
				this.getTickets().get(num).getLista().ordenar();

				int k = this.getTickets().get(num).getLista().getEmpleados().size();
				if (k != 0)
				{
					Empleado emple = this.getTickets().get(num).getLista().getEmpleados().get(k - 1); // si está ultimo
					emple.setPuntaje(emple.getPuntaje() - 5);

					Empleado emple2 = this.getTickets().get(num).getLista().getEmpleados().get(0); // si está primero
					emple2.setPuntaje(emple2.getPuntaje() + 5);
				}

				System.out.println("Ejecutando la ronda de elecciones de empleadores... ");
				this.rondaElecciones(this, num);

			} else
				throw new ListaNoGeneradaException(this.getNombreDeUsuario());
		}
	}

	public void sigue(UsuarioInteractivo empleado, Ticket ticket)
	{
		double aux = calculaAspectos((Empleado) empleado, (TicketBuscaEmpleado) ticket);
		ListaDelEmpleador lista = (ListaDelEmpleador) ticket.getLista();
		lista.insertar((Empleado) empleado, aux);
	}

	/**
	 * Determina las elecciones de un empleador.<br>
	 * <b>Pre: </b> El empleador no debe ser null. La lista de tickets del empleado
	 * no debe ser null. La cantidad de elecciones que ingresa el usuario debe ser
	 * mayor a cero<br>
	 * <b>Post: </b> Se genera un ArrayList con los indices de las elecciones que
	 * hizo el empleador <br>
	 * 
	 * @param empleador: parámetro que indica el empleador para el cual se
	 *                   determinarán sus elecciones.
	 * @param k:         parámetro que representa el índice del ticket elegido para
	 *                   la rondaElecciones
	 */
	public void rondaElecciones(Empleador empleador, int k)
	{ // k = indice del ticket elegido
		Scanner scanner = new Scanner(System.in);
		int cantElecciones;
		ArrayList<Integer> indicesElecciones = new ArrayList<Integer>();
		int aux;

		System.out.println("Ahora deberás escoger un empleado de la siguiente lista:");
		empleador.getTickets().get(k).getLista().mostrar();

		System.out.println("Cuantas elecciones quiere hacer?");

		cantElecciones = scanner.nextInt(); // precondicion cantElecciones > 0
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
		empleador.rondaElecciones(indicesElecciones, k); // metodo de clase empleado
	}

	/**
	 * Calcula la comisión en el momento de la contratación. <br>
	 * <b>Pre: </b> El parámetro formulario no debe ser null <br>
	 * <b>Post: </b> Se obtendrá la comisión que cobró el Empleador luego de la
	 * contratación <br>
	 * 
	 * @param formulario: formulario que se tendrá en cuenta para realizar los
	 *                    cálculos <br>
	 */
	public void calcularComision(FormularioDeBusqueda formulario)
	{
		double aux = 0;
		super.calcularComision(formulario);
		aux = this.rubro.persona(this.persona); // double dispatch agregado aca!!

		// este de abajo era el codigo anterior, estaba asi porq no teniamos creadas las
		// clases de los tipos de persona ni los rubros: tuve q crearlas xd

		/*
		 * if (!this.juridica){ if (this.rubro.equalsIgnoreCase("Salud")) aux = 0.6;
		 * else if (this.rubro.equalsIgnoreCase("Comercio local")) aux = 0.7; else if
		 * (this.rubro.equalsIgnoreCase("Comercio internacional")) aux = 0.8; } else {
		 * if (this.rubro.equalsIgnoreCase("Salud")) aux = 0.8; else if
		 * (this.rubro.equalsIgnoreCase("Comercio local")) aux = 0.9; else if
		 * (this.rubro.equalsIgnoreCase("Comercio internacional")) aux = 1.; }
		 */

		System.out.println(aux * formulario.getRemuneracion().getValor() - this.getPuntaje() * 0.01);

	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 3; i++)
		{
			String locacion=null;
			Random r = new Random();
			int num = r.nextInt(3);
			switch (num)
			{
			case 0:
				locacion = "HomeOffice";
			case 1:
				locacion = "Presencial";
			case 2:
				locacion = "Indistinto";
			}
			BolsaDeTrabajo.getInstancia().agregaEmpleo(new TicketSimplificado(this.rubro.toString(),locacion,this));
		}
		
	}

}
