package paquete;

import java.io.Serializable;
import java.time.LocalDate;

import state.ActivoState;
import state.IState;

public abstract class Ticket implements Serializable
{
    /**
     * @aggregation composite
     */
    private transient FormularioDeBusqueda formulario; //transient para que no lo persista 
	private transient LocalDate fecha;             //si quisiera persistir estos objetos deberia hacerlos serializables junto con todos sus atributos
	private transient IState estado;
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
	
	public void gestionarTicket()
	{
	    this.estado.gestionarTicket();	
	}
    public void rondaEncuentros(UsuarioInteractivo usuario1, UsuarioInteractivo usuario2, Ticket ticket)
    {
    	this.estado.rondaEncuentros(usuario1, usuario2, ticket);
    }
    

    
    public void activa()
    {
    	this.estado.activa();
    }
    
    public void suspende()
    {
    	this.estado.suspende();
    }
    
    public void cancela()
    {
    	this.estado.cancela();
    }
    
    public void finaliza()
    {
    	this.estado.finaliza();
    }
    
    public String diceEstado()
    {
    	return this.estado.diceEstado();
    }

	@Override
	public String toString()
	{
		return "Ticket [" + this.formulario.toString() + ", fecha=" + this.fecha + ", estado=" + this.estado + "]";
	}

}
