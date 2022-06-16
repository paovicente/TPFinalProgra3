package paquete;

public abstract class Usuario
{
	protected String nombre;
	protected String nombreDeUsuario;
	protected String contrasenia;

	public Usuario(String nombre, String nombreDeUsuario, String contrasenia) {
		super();
		this.nombre = nombre;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasenia = contrasenia;
	}

	public Usuario() {
		super();
	}

	public String getNombre()
	{
		return nombre;
	}

	public String getNombreDeUsuario()
	{
		return nombreDeUsuario;
	}

	public String getContrasenia()
	{
		return contrasenia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", nombreDeUsuario=" + nombreDeUsuario + ", contrasenia=" + contrasenia
				+ "]";
	}

}
