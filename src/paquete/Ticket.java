package paquete;

import java.time.LocalDate;

import state.ActivoState;
import state.IState;

public abstract class Ticket
{
    /**
     * @aggregation composite
     */
    private FormularioDeBusqueda formulario;
	private LocalDate fecha;
	private IState estado;
	private Lista lista;

	public Ticket(FormularioDeBusqueda formulario)
	{
		super();
		this.formulario = formulario;
		this.fecha = LocalDate.now();	//le pone la fecha actual del sistema
		this.estado = new ActivoState(this);
	}

	public FormularioDeBusqueda getFormulario()
	{
		return formulario;
	}

	public void setFormulario(FormularioDeBusqueda formulario)
	{
		this.formulario = formulario;
	}

	public IState getEstado()
	{
		return estado;
	}

	public void setEstado(IState estado)
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
