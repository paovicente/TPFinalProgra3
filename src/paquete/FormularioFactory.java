package paquete;
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
 * Crea un formulario.
 *
 */
public class FormularioFactory
{
    /**
     * Crea el formulario con sus aspectos personalizados..<br> 
	 * <b>Pre: </b>Los valores pasados como parametro se encuentran en un rango entre 1 y 3.<br>
	 * <b>Post: </b>Se crea el formulario.<br>
     * @param locacion: numero que representa la locacion seleccionada.
     * @param remuneracion: numero que representa la remuneracion seleccionada.
     * @param cargaHoraria: numero que representa la carga horaria seleccionada.
     * @param tipoPuesto: numero que representa el tipo de puesto seleccionado.
     * @param rangoEtario: numero que representa el rango etario seleccionado.
     * @param experiencia: numero que representa la experiencia seleccionada.
     * @param estudiosCursados: numero que representa los estudios cursados seleccionados.
     * @return Devuelve el formulario personalizado.
     */
    public FormularioDeBusqueda getFormularioDeBusqueda(int locacion, int remuneracion, int cargaHoraria, int tipoPuesto, int rangoEtario, int experiencia, int estudiosCursados) 
    {
    	
    	FormularioDeBusqueda respuesta = new FormularioDeBusqueda();
    	
    	if(locacion == 1)
    	    respuesta.setLocacion(new HomeOffice());
    	else if (locacion == 2)
    	    respuesta.setLocacion(new Indistinto());
    	else if (locacion == 3)
    	    respuesta.setLocacion(new Presencial());
    
    	if (remuneracion == 1) 
    		respuesta.setRemuneracion(new V1());
    	else if (remuneracion == 2)
    		respuesta.setRemuneracion(new V2());
    	else if (remuneracion == 3)
    		respuesta.setRemuneracion(new V3());
    	
    	if (cargaHoraria == 1) 
    		respuesta.setCargahoraria(new CargaMedia());
    	else if (cargaHoraria == 2)
    		respuesta.setCargahoraria(new CargaCompleta());
    	else if (cargaHoraria == 3)
    		respuesta.setCargahoraria(new CargaExtendida());   	

    	if (tipoPuesto == 1) 
    		respuesta.setTipoPuesto(new Junior());
    	else if (tipoPuesto == 2)
    		respuesta.setTipoPuesto(new Senior());
    	else if (tipoPuesto == 3)
    		respuesta.setTipoPuesto(new Management());
    	
    	if (rangoEtario == 1) 
    		respuesta.setRangoEtario(new MenosDe40());
    	else if (rangoEtario == 2)
    		respuesta.setRangoEtario(new Entre40y50());
    	else if (rangoEtario == 3)
    		respuesta.setRangoEtario(new MasDe50());
    	
    	if (experiencia == 1) 
    		respuesta.setExperiencia(new Nada());
    	else if (experiencia == 2)
    		respuesta.setExperiencia(new Media());
    	else if (experiencia == 3)
    		respuesta.setExperiencia(new Mucha());
    	
    	if (estudiosCursados == 1) 
    		respuesta.setEstudiosCursados(new Primario());
    	else if (estudiosCursados == 2)
    		respuesta.setEstudiosCursados(new Secundario());
    	else if (estudiosCursados == 3)
    		respuesta.setEstudiosCursados(new Terciario());
    	
    	return respuesta;
    	
       /* Locacion locacionEncapsulada = new Locacion();
    	 CargaHoraria cargaHorariaEncapsulada = new CargaHoraria();               //esta es otra forma pero creo que es mas eficiente la de arriba porque crea los objetos solo cuando sabe que los usará
    	 EstudiosCursados estudiosCursadosEncapsulado = new EstudiosCursados();
    	 Experiencia experienciaEncapsulada = new Experiencia();
    	 RangoEtario rangoEtarioEncapsulado = new RangoEtario();
    	 Remuneracion remuneracionEncapsulada = new Remuneracion();
    	 TipoPuesto tipoPuestoEncapsulado = new TipoPuesto(); */
    	
    	
    	
    	/*if(locacion.equals("HomeOffice"))
    	    respuesta.setLocacion(new HomeOffice_Locacion_Decorator(locacionEncapsulada));
    	else if (locacion.equals("Indistinto"))
    	    respuesta.setLocacion(new Indistinto_Locacion_Decorator(locacionEncapsulada));
    	else if (locacion.equals("Presencial"))
    	    respuesta.setLocacion(new Presencial_Locacion_Decorator(locacionEncapsulada));
    	
    	if (cargaHoraria.equals("Media")) 
    		respuesta.setCargahoraria(new CargaMediaDecorator(cargaHorariaEncapsulada));
    	else if (cargaHoraria.equals("Completa"))
    		respuesta.setCargahoraria(new CargaCompletaDecorator(cargaHorariaEncapsulada));
    	else if (cargaHoraria.equals("Extendida"))
    		respuesta.setCargahoraria(new CargaExtendidaDecorator(cargaHorariaEncapsulada)); */
    	
    	
    }
}
