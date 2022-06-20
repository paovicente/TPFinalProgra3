package paquete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaDelEmpleador extends Lista implements Serializable
{
    /**
     * @aggregation shared
     */
    ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	ArrayList<Double> puntajes = new ArrayList<Double>();
	
	public ListaDelEmpleador(){
		super();
	}
    
	/**
	 * Inserta un empleado con su respectivo puntaje a la lista.<br> 
	 * <b>Pre: </b>empleado no es nulo.<br>
	 * <b>Post: </b>Agrega un elemento a la lista.<br> 
	 * @param empleado: Empleado con el que se compara en la Ronda de Encuentros Laborales.
	 * @param puntaje: double que simboliza el puntaje obtenido luego de la Ronda de Encuentros Laborales. 
	 */
	public void insertar(Empleado empleado, double puntaje)
	{
		this.empleados.add(empleado);
		this.puntajes.add(puntaje);
	}
	
	/**
	 * Ordena la lista en base al puntaje obtenido luego de la ronda de encuentros laborales.<br> 
	 * <b>Pre: </b>Se realizó la ronda de encuentros laborales.<br>
	 * <b>Post: </b>Ordena la lista.<br>
	 */
	public void ordenar() {
		double auxpuntaje;
		Empleado auxEmpleado;

		for (int k = 0; k < puntajes.size(); k++) {
				for (int f = 0; f < puntajes.size() - 1 - k; f++) {
					if (puntajes.get(f) < puntajes.get(f + 1)) {
						auxpuntaje = puntajes.get(f);
						puntajes.set(f, puntajes.get(f + 1));
						puntajes.set(f + 1, auxpuntaje);

						auxEmpleado = empleados.get(f);
						empleados.set(f, empleados.get(f + 1));
						empleados.set(f + 1, auxEmpleado);
					}
				}
		}
	}
	
	/**
	 * Muestra el nombre y el puntaje de los empleados de la lista, con un índice adelante. 
	 */
	public void mostrar() {   
		
		Iterator<Empleado> itEmpleado = empleados.iterator();
		Iterator<Double> itPuntajes = puntajes.iterator();
		int i;

		i = 0;
		
		while (itEmpleado.hasNext() && itPuntajes.hasNext()) {
			System.out.println("\t Elemento " + i + "\n  Nombre: " + itEmpleado.next().getNombre() + "   Puntaje: "+itPuntajes.next()+"\n \n");
			i++;
		}

		

	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public ArrayList<Double> getPuntajes() {
		return puntajes;
	}

	@Override
	public String toString() {
		return "ListaDelEmpleador [empleados=" + empleados + ", puntajes=" + puntajes + "]";
	}
	
}
