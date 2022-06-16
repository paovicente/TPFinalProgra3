package paquete;

import java.util.ArrayList;
import java.util.Scanner;

import excepciones.ListaNoGeneradaException;

/**
 * @author Usuario <br>
 *         Clase que representa a un administrador, hereda estados y
 *         comportamientos de la clase Usuario
 */
public class AdminAgencia extends Usuario
{

	public AdminAgencia(String nombre, String nombreDeUsuario, String contrasenia)
	{
		super(nombre, nombreDeUsuario, contrasenia);
	}

	/**
	 * Realiza la Ronda de Encuentros Laborales.<br> 
	 * <b>Pre: </b>usuario no es null<br>
	 * <b>Post: </b>Llama a la funcion rondaDeEncuentros de usuario. Si la lista es null propaga una excepcion.<br>
	 * @param usuario: UsuarioInteractivo que realiza la funcion rondaDeEncuentros.
	 * @throws ListaNoGeneradaException: Se lanza cuando la lista es null.
	 */
	public void rondaDeEncuentrosLaborales(UsuarioInteractivo usuario) throws ListaNoGeneradaException
	{
		usuario.rondaEncuentros(); // ejecutará la clase que le corresponda: empleado o empleador.
	}

}
