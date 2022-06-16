package paquete;


import formularioclases.CargaHoraria;
import formularioclases.EstudiosCursados;
import formularioclases.Experiencia;
import formularioclases.Locacion;
import formularioclases.RangoEtario;
import formularioclases.Remuneracion;
import formularioclases.TipoPuesto;

public class FormularioDeBusqueda
{
    /**
     * @aggregation composite
     */
    private CargaHoraria cargaHoraria;

    /**
     * @aggregation composite
     */
    private EstudiosCursados estudiosCursados;

    /**
     * @aggregation composite
     */
    private Experiencia experiencia;

    /**
     * @aggregation composite
     */
    private Locacion locacion;

    /**
     * @aggregation composite
     */
    private RangoEtario rangoEtario;

    /**
     * @aggregation composite
     */
    private Remuneracion remuneracion;

    /**
     * @aggregation composite
     */
    private TipoPuesto tipoPuesto;
	
	
	
	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}
	public EstudiosCursados getEstudiosCursados() {
		return estudiosCursados;
	}
	public Experiencia getExperiencia() {
		return experiencia;
	}
	public Locacion getLocacion() {
		return locacion;
	}
	public RangoEtario getRangoEtario() {
		return rangoEtario;
	}
	public Remuneracion getRemuneracion() {
		return remuneracion;
	}
	public TipoPuesto getTipoPuesto() {
		return tipoPuesto;
	}
	public void setCargahoraria(CargaHoraria cargahoraria) {
		this.cargaHoraria = cargahoraria;
	}
	public void setEstudiosCursados(EstudiosCursados estudiosCursados) {
		this.estudiosCursados = estudiosCursados;
	}
	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
	public void setLocacion(Locacion locacion) {
		this.locacion =  locacion;
	}
	public void setRangoEtario(RangoEtario rangoEtario) {
		this.rangoEtario = rangoEtario;
	}
	public void setRemuneracion(Remuneracion remuneracion) {
		this.remuneracion = remuneracion;
	}
	public void setTipoPuesto(TipoPuesto tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
	}
	@Override
	public String toString() {
		return "FormularioDeBusqueda [cargahoraria=" + cargaHoraria + ",\n estudiosCursados=" + estudiosCursados
				+ ",\n experiencia=" + experiencia + ",\n locacion=" + locacion + ",\n rangoEtario=" + rangoEtario
				+ ",\n remuneracion=" + remuneracion + ",\n tipoPuesto=" + tipoPuesto + "]";
	}
	
	
	
    
}
