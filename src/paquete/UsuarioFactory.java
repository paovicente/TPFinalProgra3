package paquete;

import java.util.Scanner;

import DecoratorRubros.DecoratorComercioInternacional;
import DecoratorRubros.DecoratorComercioLocal;
import DecoratorRubros.DecoratorSalud;
import DecoratorRubros.IPersona;

/**
 * @author Usuario
 *<br>
 *Clase donde se instancian ("fabrican") los diferentes tipos de usuarios
 */
public class UsuarioFactory
{

	private String nombre;
	private String apellido;
	private String telefono;
	private int edad;
	private IPersona persona;
	private Scanner scanner = new Scanner(System.in);

	// funcion para crear ticket y formulario desde aki :)

	/**
	 *Setea los datos que son específicos del Empleador.<br>
	 */
	public void seteaDatosEmpleador()
	{

		IPersona encapsulado = null;
		IPersona respuesta = null;
		System.out.println("Ingrese la razon social (nombre)");
		this.nombre = scanner.nextLine();
		int i = 0;
		while (i != 1 && i != 2)
		{
			System.out.println("Persona física o juridica?\r\n1.Fisica 2.Juridica");

			i = scanner.nextInt(); 
			scanner.nextLine();
			if (i == 1)
				encapsulado=new PersonaFisica();
			else if (i == 2)
				encapsulado=new PersonaJuridica();
			else
				System.out.println("Opcion incorrecta");
		}

		i=0;
		while (i != 1 && i != 2 && i != 3)
		{
			System.out.println("Ingrese su rubro\r\n1.Salud    2.Comercio local    3.Comercio internacional");
			i = scanner.nextInt();
			scanner.nextLine();

			if (i == 1)
				respuesta = new DecoratorSalud(encapsulado);
			else if (i == 2)
				respuesta = new DecoratorComercioLocal(encapsulado);
			else if (i == 3)
				respuesta = new DecoratorComercioInternacional(encapsulado);
			else
				System.out.println("Opcion incorrecta");
		}
		this.persona=respuesta;

	}

	/**
	 * Setea los datos que son específicos del empleado<br>
	 */
	public void seteaDatosEmpleado()
	{
		System.out.println("Ingrese su nombre");
		this.nombre = scanner.nextLine();
		System.out.println("Ingrese su apellido");
		this.apellido = scanner.nextLine();
		System.out.println("Ingrese su teléfono");
		this.telefono = scanner.nextLine();
		System.out.println("Ingrese su edad");
		this.edad = scanner.nextInt();
		scanner.nextLine();
	}
	

	/**
	 * Devuelve un Usuario <br>
	 * <b> Pre: </b> --- <br>
	 * <b> Post: </b> Se obtendrá un usuario <br>
	 * @param tipoUsuario: parámetro que representa la opcion según la cual se instanciará un determinado tipo de Usuario <br>
	 * @param nombreUsuario: parámetro que representa el nombre del usuario a instanciar <br>
	 * @param contrasenia: parámetro que representa la contrasenia del usuario a instanciar <br>
	 * @return Usuario, con sus respectivos atributos seteados <br>
	 */
	public Usuario getUsuario(int tipoUsuario, String nombreUsuario, String contrasenia)
	{
		if (nombreUsuario == null || contrasenia == null) {
			return null;
		} else {
			if (tipoUsuario == 1)
			{
				this.seteaDatosEmpleado();
				return new Empleado(this.nombre, nombreUsuario, contrasenia, 0, this.apellido, this.telefono, this.edad);
			} else if (tipoUsuario == 2)
			{
				this.seteaDatosEmpleador();
				return new Empleador(this.nombre, nombreUsuario, contrasenia, 0, this.persona);
			} else if (tipoUsuario == 70) {  //codigo de admin 70
				System.out.println("Ingresa tu nombre de admin");
				this.nombre = scanner.nextLine();
				return new AdminAgencia(this.nombre, nombreUsuario, contrasenia);
			}
				return null;
		}
	}
}
