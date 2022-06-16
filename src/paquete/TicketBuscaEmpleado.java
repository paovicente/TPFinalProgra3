package paquete;

import java.util.ArrayList;

public class TicketBuscaEmpleado extends Ticket
{
	private ArrayList<Double> pesos = new ArrayList<Double>();
	private int cantEmpSolic;
	private int cantEmpObt;

    /**
     * @aggregation composite
     */
    private ListaDelEmpleador lista;

	public TicketBuscaEmpleado(FormularioDeBusqueda formulario, int cantEmpSolic, ArrayList<Double> pesos)
	{
		super(formulario);
		this.cantEmpObt = 0;
		this.cantEmpSolic = cantEmpSolic;
		this.pesos = pesos;
	}
	
	@Override
	public String toString() {
		return this.getFormulario().toString()+"TicketBuscaEmpleado [cantEmpSolic=" + cantEmpSolic + ", cantEmpObt=" + cantEmpObt + "]";
	}

	public int getCantEmpSolic() {
		return cantEmpSolic;
	}

	public ArrayList<Double> getPesos(){
		return pesos;
	}

	public int getCantEmpObt(){
		return cantEmpObt;
	}

	public void setCantEmpObt(int cantEmpObt){
		this.cantEmpObt = cantEmpObt;
	}

	public ListaDelEmpleador getLista(){
		return this.lista;
	}

	public void setLista(ListaDelEmpleador lista){
		this.lista = lista;
	}
	
}
