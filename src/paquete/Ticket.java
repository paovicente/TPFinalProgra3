package paquete;

import java.time.LocalDate;

public abstract class Ticket
{
    /**
     * @aggregation composite
     */
    private FormularioDeBusqueda formulario;
	private LocalDate fecha;
	private String estado;
	private Lista lista;

	public Ticket(FormularioDeBusqueda formulario)
	{
		super();
		this.formulario = formulario;
		this.fecha = LocalDate.now();	//le pone la fecha actual del sistema
		this.estado = "activo";
	}

	public FormularioDeBusqueda getFormulario()
	{
		return formulario;
	}

	public void setFormulario(FormularioDeBusqueda formulario)
	{
		this.formulario = formulario;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public abstract Lista getLista();

	public void setLista(Lista lista){
		this.lista = lista;
	}

	@Override
	public String toString()
	{
		return "Ticket [" + this.formulario.toString() + ", fecha=" + this.fecha + ", estado=" + this.estado + "]";
	}

}
