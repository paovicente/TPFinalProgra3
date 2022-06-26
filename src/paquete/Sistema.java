package paquete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import excepciones.ContraseniaIncorrectaException;
import excepciones.ListaNoGeneradaException;
import excepciones.NombreIncorrectoException;
import persistencia.IPersistencia;
import persistencia.Objeto;
import persistencia.PersistenciaBIN;
import state.FinalizadoState;

/**
 * @author Usuario
 *<br> Clase que representa el Sistema para la gestión de búsquedas laborales. Contiene a todos los usuarios.
 */
public class Sistema
{
	
	
	private static Sistema instancia = null;

    /**
     * @aggregation composite
     */
    private ArrayList<UsuarioInteractivo> empleados = new ArrayList<UsuarioInteractivo>();

    /**
     * @aggregation composite
     */
    private ArrayList<UsuarioInteractivo> empleadores = new ArrayList<UsuarioInteractivo>();

    /**
     * @aggregation composite
     */
    
    private ArrayList<Contrataciones> contrataciones = new ArrayList<Contrataciones>();
    private ArrayList<Usuario> admins = new ArrayList<Usuario>();
	private UsuarioFactory usuarioFactory = new UsuarioFactory();
	private FormularioFactory formularioFactory = new FormularioFactory();
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Agrega un AdminAgencia (administrador) al Sistema.<br> 
	 * <b>Pre: </b> admin no puede ser null.<br>
	 * <b>Post: </b>Se agrega un AdminAgencia a la lista.<br>
	 * @param admin: Usuario de tipo AdminAgencia que se agrega al Sistema.
	 */
	public void addAdmin(AdminAgencia admin)
	{
		this.admins.add(admin);
	}
	
	public void addContratacion(Contrataciones contrataciones) {
		this.contrataciones.add(contrataciones);
	}

	public ArrayList<UsuarioInteractivo> getEmpleados()
	{
		return empleados;
	}

	public ArrayList<UsuarioInteractivo> getEmpleadores()
	{
		return empleadores;
	}

	public Sistema()
	{

	}

	public static Sistema getInstancia()
	{ // patron singleton
		if (instancia == null)
			instancia = new Sistema();
		return instancia;
	}


	/**
	 * Agrega un Empleado al Sistema.<br> 
	 * <b>Pre: </b> empleado no puede ser null.<br>
	 * <b>Post: </b>Se agrega un Empleado a la lista.<br>
	 * @param empleado: Usuario de tipo Empleado que se agrega al Sistema.
	 */
	public void addEmpleado(Empleado empleado)
	{
		this.empleados.add(empleado);
	}

	/**
	 * Agrega un Empleador al Sistema.<br> 
	 * <b>Pre: </b> empleador no puede ser null.<br>
	 * <b>Post: </b>Se agrega un Empleador a la lista.<br>
	 * @param empleador: Usuario de tipo Empleador que se agrega al Sistema.
	 */
	public void addEmpleador(Empleador empleador)
	{
		this.empleadores.add(empleador);
	}

	/**
	 *Crea un formulario con sus preferencias.<br> 
	 * <b>Pre: </b>El Usuario interactivo no es null. No elige una opcion distinta a 1, 2 o 3 en cada aspecto del formulario.<br>
	 * <b>Post: </b>Crea un formulario.<br>
	 */
	private FormularioDeBusqueda creaFormulario()
	{
		FormularioDeBusqueda form;
		System.out.println("Elija una locacion de preferencia");
		System.out.println("1.Home Office      2.Presencial       3.Indistinto");
		int locacion = scanner.nextInt();

		System.out.println("Elija una remuneracion");
		System.out.println("1.$40.000          2.$80.000          3.$120.000");
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
		scanner.nextLine();
		
		form=formularioFactory.getFormularioDeBusqueda(locacion, remuneracion, cargaHoraria,
				tipoDePuesto, rangoEtario, experiencia, estudios);
		
		if (form!=null)
			return form;
		else {
			System.out.println("Ingresaste un valor incorrecto, por favor reingresa.");  
			return this.creaFormulario(); 
		}
	}

	/**
	 *Registra un usuario.<br> 
	 * <b>Pre: </b>Se ingresa 1 o 0 cuando se propone crear un ticket de búsqueda.<br>
	 * <b>Post: </b>Ingresa al sistema un nuevo usuario con, si es que tiene, su/s ticket/s de búsqueda.<br> 
	 */
	public void registrarse()
	{

		int opcion = 0;
		System.out.println("Bienvenido al sistema de registro.");
		while (opcion != 1 && opcion != 2 && opcion != 70)
		{
			System.out.print("¿Como desea ser registrado?\r\n1.Empleado    2.Empleador\r\n Ingrese un numero:");
			opcion = scanner.nextInt();
			scanner.nextLine();
			if (opcion != 1 && opcion != 2 && opcion != 70)
			{
				System.out.println("Opcion incorrecta.");
			}
		}

		System.out.println("Ingresa tu nombre de usuario");
		String nombreUsuario = scanner.nextLine();
		System.out.println("Ingresa tu contraseña");
		String contrasenia = scanner.nextLine();

		Usuario u = usuarioFactory.getUsuario(opcion, nombreUsuario, contrasenia);

		if (u != null)
		{
			System.out
					.println("Deseas crear un ticket de busqueda ahora? Ingrese 1 para hacerlo, ingrese 0 para salir");
			int i = scanner.nextInt();
			scanner.nextLine();

			if (opcion == 1)
			{
				if (i == 1)
					this.creaTicketBuscaEmpleo((Empleado) u); // casteo xq arraylist es de usuario
				this.addEmpleado((Empleado) u); // casteo porque arraylist es de usuario
			} else if (opcion == 2)
			{
				while (i == 1)
				{
					this.creaTicketBuscaEmpleado((Empleador) u);
					System.out.println(
							"Ingresa 1 para seguir creando tickets de busqueda. Ingresa otra cosa para dejar de crear");
					i = scanner.nextInt();
					scanner.nextLine();
				}
				this.addEmpleador((Empleador) u);
			} else if (opcion == 70)
			{
				System.out.println("Creando Admin!!!");
				this.addAdmin((AdminAgencia) u);
			}
		}

	}

	/**	 
	 *Actualiza el puntaje en el caso especifico en que un empleador no fue elegido por ningún empleado pretenso.<br> 
	 * <b>Pre: </b>La Ronda de Elección de un Empleador ya fue realizada.<br>
	 * <b>Post: </b>Resta 20 puntos al empleador.<br>
	 */
	public void actualizaPuntajes()
	{
		Iterator<UsuarioInteractivo> itEmpleadores = empleadores.iterator();
		while (itEmpleadores.hasNext())
		{
			Empleador empAux = (Empleador) itEmpleadores.next();
			int i = 0;
			boolean bandera = false;
			while (i < this.empleados.size() && bandera == false)
			{
				Empleado empleadoAux = (Empleado) this.empleados.get(i);
				int k = 0;
				while (empleadoAux.getElecciones() != null && k < empleadoAux.getElecciones().getEmpleadores().size()
						&& !empleadoAux.getElecciones().getEmpleadores().get(k).equals(empAux))
				{
					k++;
				}
				if (empleadoAux.getElecciones() != null && k < empleadoAux.getElecciones().getEmpleadores().size())
				{ // si k< no se cayó, o sea que lo encontró
					bandera = true;
				}
				i++;
			}
			if (bandera == false)
			{
				empAux.setPuntaje(empAux.getPuntaje() - 20);
			}
		}

	}

	/**
	 *Calcula la comision que cobra el Sistema a un usuario luego de ser contratado o de contratar.<br> 
	 * <b>Pre: </b>usuario no es null. formulario no es null. Si usuario es Empleado, fue contratado. Si usuario es Empleador, ha contratado a un Empleado.<br>
	 * <b>Post: </b>Calcula la comision dependiendo de la sublase de usuario.<br>
	 * @param usuario: UsuarioInteractivo al que se le calcula la comision a cobrar.
	 * @param formulario: FormularioDeBusqueda con el que ocurrio una contratacion.
	 */
	public void calcularComision(UsuarioInteractivo usuario, FormularioDeBusqueda formulario)
	{
		usuario.calcularComision(formulario);
	}

	/**
	 *Crea un ticket con su respectivo formulario y el peso de cada aspecto y se lo asigna a empleador.<br> 
	 * <b>Pre: </b>empleador no es null. Los pesos ingresados son todos positivos.<br>
	 * <b>Post: </b>Se asigna a empleador el ticket creado.<br>
	 * @param empleador: Empleador al que se le asigna el ticket.
	 */
	private void creaTicketBuscaEmpleado(Empleador empleador)
	{ // este metodo en realidad agrega un ticket, podria
		// cambiarle el nombre
		FormularioDeBusqueda formulario;
		
		System.out.println("Ahora debe ingresar sus preferencias:");
		
		formulario = this.creaFormulario(); 

		System.out.println("Ingresa cuántos empleados solicitarás");
		int cantEmpSolic = scanner.nextInt();
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
		empleador.addTicket(new TicketBuscaEmpleado(formulario, cantEmpSolic, pesos));
	}

	/**
	 *Crea un ticket con su respectivo formulario y se lo asigna a empleado.<br> 
	 * <b>Pre: </b>empleador no es null.<br>
	 * <b>Post: </b>Se asigna a empleado el ticket creado.<br>
	 * @param empleado: Empleado al que se le asigna el ticket.
	 */
	private void creaTicketBuscaEmpleo(Empleado empleado)
	{
		FormularioDeBusqueda formulario;
		System.out.println("Ahora deberás llenar tu formulario de busqueda.");
		formulario = this.creaFormulario();
		empleado.setTicket(new TicketBuscaEmpleo(formulario)); 
	}

	/**
	 * Muestra a todos los empleados y Empleadores del sistema con sus respectivos tickets.<br> 
	 * <b>Pre: </b>.<br>
	 * <b>Post: </b>Muestra por pantalla nombre, nombreDeUsuario y contrasenia de las listas de Empleado y Empleador. De cada elemento de la lista de Empleador tambien muestra su lista de Ticket.<br>
	 */
	public void muestraEmpleadosyEmpleadores()
	{ // para probar que registre bien
		Iterator<UsuarioInteractivo> iteradorempleados = empleados.iterator();
		Iterator<UsuarioInteractivo> iteradorempleadores = empleadores.iterator();
		UsuarioInteractivo aux;
		Empleado empleado;
		Empleador empleador;
		Iterator<TicketBuscaEmpleado> ittickets;

		System.out.println("Empleados:");
		while (iteradorempleados.hasNext())
		{
			aux = iteradorempleados.next();
			empleado = (Empleado) aux;
			System.out.println("Nombre: " + empleado.getNombre() + " Nombre de usuario: "
					+ empleado.getNombreDeUsuario() + " Contrasenia:" + empleado.getContrasenia());
			System.out.println("Ticket:" + empleado.getTicket());
		}

		System.out.println("Empleadores: ");
		while (iteradorempleadores.hasNext())
		{
			aux = iteradorempleadores.next();
			empleador = (Empleador) aux;
			System.out.println("Nombre: " + empleador.getNombre() + " Nombre de usuario: "
					+ empleador.getNombreDeUsuario() + " Contrasenia:" + empleador.getContrasenia());
			ittickets = empleador.getTickets().iterator();
			while (ittickets.hasNext())
			{
				System.out.println(ittickets.next().toString());
			}
		}

	}

	/**
	 * Realiza la Ronda de Encuentros Laborales.<br> 
	 * <b>Pre: </b>admin no es null. usuario no es null<br>
	 * <b>Post: </b>Llama a la funcion rondaDeEncuentrosLaborales de admin. Si la lista es null lanza una excepcion.<br>
	 * @param admin: AdminAgencia que realiza la funcion rondaDeEncuentrosLaborales.
	 * @param usuario: UsuarioInteractivo por el cual se crea la Lista de Asignaciones.
	 */
	public void rondaDeEncuentrosLaborales(AdminAgencia admin, UsuarioInteractivo usuario) throws ListaNoGeneradaException
	{
		try{
			admin.rondaDeEncuentrosLaborales(usuario);
		}catch (ListaNoGeneradaException e) {	
			throw new ListaNoGeneradaException(usuario.getNombreDeUsuario());
		}
		
	}

	/**
	 *Se inicia sesion en el sistema.<br> 
	 * <b>Pre: </b>nombredeusuario y contrasenia no son vacios.<br>
	 * <b>Post: </b>Devuelve la instancia de Usuario registrada previamente con la que coinciden nombreDeUsuario y Contrasenia con los parametros ingresados. Si nombredeusuario no coincide lanza una excpecion. Si contrasenia no coincide lanza una excpecion.<br>
	 * @param nombredeusuario: nombre de usuario del usuario con el que se quiere iniciar sesion.
	 * @param contrasenia: contraseña del usuario con la que se quiere iniciar sesion.
	 * @return devuelve el usuario con la que se quiere iniciar sesion.
	 */
	public Usuario login(String nombredeusuario, String contrasenia) throws NombreIncorrectoException, ContraseniaIncorrectaException
	{
		Usuario respuesta = null;
		int i = -1;
		try
		{
			i = this.buscaNombreDeUsuario(nombredeusuario);
			respuesta = this.buscaContrasenia(i, nombredeusuario, contrasenia);
			System.out.println("Ingreso exitoso!");
		} catch (NombreIncorrectoException e){
			throw new NombreIncorrectoException(nombredeusuario);
			//System.out.println("'" + e.getNombreDeUsuario() + "' es un nombre de usuario incorrecto.");
		} catch (ContraseniaIncorrectaException e){
			throw new ContraseniaIncorrectaException(nombredeusuario, contrasenia);
			//String msg = e.getContrasenia();     //pasar esto al main!! throw
			//System.out.println(msg +" es una contraseña incorrecta");
		}
		
		return respuesta;
	}

	/**
	 *Busca el nombre de usuario pasado como parametro en las listas del sistema.<br> 
	 * <b>Pre: </b>nombredeusuario no es vacio.<br>
	 * <b>Post: </b>Devuelve el indice en la lista del usuario que su nombreDeUsuario coincide con nombredeusuario. Si no lo encuentra lanza una excepcion.<br>
	 * @param nombredeusuario: nombe de usuario que se busca.
	 * @return Devuleve un indice de una lista.
	 * @throws NombreIncorrectoException: Se lanza cuando no se encuentra el nombre de usuario.
	 */
	private int buscaNombreDeUsuario(String nombredeusuario) throws NombreIncorrectoException
	{
		int i = 0;
		int respuesta = -1; // creo q se podria quitar esta variable
		while (i < this.empleados.size() && !(this.empleados.get(i).getNombreDeUsuario().equals(nombredeusuario)))
			i++;
		if (i < this.empleados.size() && this.empleados.size() > 0
				&& this.empleados.get(i).getNombreDeUsuario().equals(nombredeusuario))
			respuesta = i;
		else
		{ // busco en arraylist de empleadores
			i = 0;
			while (i < this.empleadores.size()
					&& !(this.empleadores.get(i).getNombreDeUsuario().equals(nombredeusuario)))
				i++;

			if (i < this.empleadores.size() && this.empleadores.size() > 0
					&& this.empleadores.get(i).getNombreDeUsuario().equals(nombredeusuario))
				respuesta = i;
		}
		if (respuesta != -1)
			return respuesta;
		else
			throw new NombreIncorrectoException(nombredeusuario);
	}

	/**
	 *Busca la contraseña pasada como parametro en las listas del sistema.<br> 
	 * <b>Pre: </b>contrasenia no es vacio. Se busco el nombre de usuario previamente y fue encontrado<br>
	 * <b>Post: </b>Devuelve el Usuario con el que coincide el nombre de usuario y contraseña ingresados en el login. Si no encuentra la contraseña lanza una excepcion.<br>
	 * @param i: indice obtenido en el metodo buscaNombreDeUsuario.
	 * @param nombreDeUsuario: nombre de usuario que se busco previamente
	 * @param contrasenia: contraseña que se busca.
	 * @return Devuleve la el Usuario buscado.
	 * @throws ContraseniaIncorrectaException: Se lanza cuando no se encuentra la contraseña.
	 */
	private Usuario buscaContrasenia(int i, String nombreDeUsuario, String contrasenia) throws ContraseniaIncorrectaException {
		Usuario respuesta = null; // creo q se podria quitar esta variable
		if (i != -1)
			if (i < this.empleadores.size() && this.empleadores.size() > 0
					&& this.empleadores.get(i).getNombreDeUsuario().equals(nombreDeUsuario)
					&& this.empleadores.get(i).getContrasenia().equals(contrasenia)) //
				respuesta = this.empleadores.get(i); // la primera sentencia del if de arriba es por si existe un
														// empleador que tiene la misma contrasenia que el empleado
														// queesta en la misma posicion en el otro arraylist
			else if (i < this.empleados.size() && this.empleados.size() > 0
					&& this.empleados.get(i).getContrasenia().equals(contrasenia))
				respuesta = this.empleados.get(i);

		if (respuesta != null)
			return respuesta;
		else
			throw new ContraseniaIncorrectaException(nombreDeUsuario,contrasenia);
	}

	/**
	 *Muestra la lista (ya sea ListaDelEmpleado o ListaDelEmpleador) del UsuarioInteractivo pasado como parametro.<br> 
	 * <b>Pre: </b>usuario no es null. La lista del usuario no es null. Ya se realizo la Ronda de Encuentros laborales<br>
	 * <b>Post: </b>Llama al metodo muestraLista del UsuarioInteractivo pasado como parametro.<br>
	 * @param usuario: UsuarioInteractivo con el que se llama el metodo muestraLista.
	 */
	public void muestraLista(UsuarioInteractivo usuario)
	{ // muestro para la ronda de elecciones.
		usuario.muestraLista();
	}

	/**
	 *Realiza la Ronda de Contrataciones.<br> 
	 * <b>Pre: </b>La Ronda de Elecciones fue realizada.<br>
	 * <b>Post: </b>Muestra el nombre de Empleado contratado y el del Empleador que lo contrató. Actualiza el estado de los tickets. Actualiza el puntaje de los usuarios. Muestra la comisión que cobra el Sistema por cada Ticket de Usuario.<br> 
	 */
	public void rondaContrataciones()
	{
		Iterator<UsuarioInteractivo> itEmpleadores = empleadores.iterator();
		Empleador aux;
		while (itEmpleadores.hasNext())
		{ // recorro empleadores
			aux = (Empleador) itEmpleadores.next();
			for (int i = 0; i < aux.getTickets().size(); i++)
			{ // recorro todos tickets del empleador
				int j = 0;
				while (aux.getTickets().get(i).getLista() != null
						&& j < aux.getTickets().get(i).getLista().getEmpleados().size()
						&& aux.getTickets().get(i).getCantEmpObt() < aux.getTickets().get(i).getCantEmpSolic())
				{
					Empleado empleadoAux = aux.getTickets().get(i).getLista().getEmpleados().get(j);
					int k = 0;
					boolean bandera = false;
					while (empleadoAux.getElecciones() != null
							&& k < empleadoAux.getElecciones().getEmpleadores().size() && bandera == false)
					{

						if (empleadoAux.getElecciones() != null
								&& empleadoAux.getElecciones().getEmpleadores().get(k).equals(aux)
								&& estaEmpleado(aux, empleadoAux))
						{
							empleadoAux.getTicket().finaliza();
							empleadoAux.setPuntaje(empleadoAux.getPuntaje() + 10);
							aux.getTickets().get(i).setCantEmpObt(aux.getTickets().get(i).getCantEmpObt() + 1);
							bandera = true;
							System.out.println(aux.getNombre() + " ha contratado a " + empleadoAux.getNombre());
							this.calcularComision(empleadoAux, empleadoAux.getTicket().getFormulario());
							this.calcularComision(aux, aux.getTickets().get(i).getFormulario());
							this.addContratacion(new Contrataciones(empleadoAux,aux));
						}
						k++;
					}
					j++;
				}
				if (aux.getTickets().get(i).getCantEmpObt() == aux.getTickets().get(i).getCantEmpSolic())
				{
					aux.getTickets().get(i).finaliza();
					aux.setPuntaje(aux.getPuntaje() + 50);
				}
			}
		}
	}
	
	/**
	 * Hace la escritura de la persistencia.<br> 
	 * 
	 */
	
	public void escribirPersistencia() throws IOException{  //catchear excepcion en el main
		Objeto objeto = new Objeto(this.empleados,this.empleadores,this.contrataciones);
		IPersistencia persistencia = new PersistenciaBIN();
		persistencia.abrirOutput("Datos.bin");
		System.out.println("Creando archivo de escritura");
		persistencia.escribir(objeto);
		System.out.println("Datos grabados exitosamente");
		persistencia.cerrarOutput();
		System.out.println("Archivo cerrado");
	}
	
	/**
	 * Hace la lectura de la persistencia.<br> 
	 * 
	 */
	
	public void leerPersistencia() throws ClassNotFoundException, IOException, Exception {
		IPersistencia persistencia = new PersistenciaBIN();
		persistencia.abrirInput("Datos.bin");
		System.out.println("Archivo abierto");
		Objeto objeto = (Objeto) persistencia.leer();
		System.out.println("Datos recuperados");
		persistencia.cerrarInput();
		System.out.println("Archivo cerrado");
		this.empleados = objeto.getEmpleados();
		this.empleadores = objeto.getEmpleadores();
		this.contrataciones = objeto.getContrataciones(); 
		
	} 

	/**
	 * Busca el empleado indicado por el parámetro empleado, en la lista de elecciones del empleador
	 * @param empleador: parámetro que indica el empleador a considerar
	 * @param empleado: parámetro que indica el empleado a considerar en la búsqueda
	 * @return boolean con información acerca de si se encontró o no el empleado en la lista de elecciones del empleador
	 */
	private boolean estaEmpleado(Empleador empleador, Empleado empleado)
	{ // empleador
		int k = 0;
		while (empleador.getElecciones() != null && k < empleador.getElecciones().getEmpleados().size()
				&& !empleador.getElecciones().getEmpleados().get(k).equals(empleado))
		{
			k++;
		}
		return (empleador.getElecciones() != null && k < empleador.getElecciones().getEmpleados().size()
				&& empleador.getElecciones().getEmpleados().get(k).equals(empleado));
	}
	
	
}