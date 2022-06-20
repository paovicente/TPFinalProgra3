package state;

import paquete.Ticket;
import paquete.UsuarioInteractivo;

public interface IState
{
    public void gestionarTicket();
    public void rondaEncuentros(UsuarioInteractivo usuario1, UsuarioInteractivo usuario2, Ticket ticket);
    public String diceEstado();
    public void activa();
    public void suspende();
    public void cancela();
    public void finaliza();
}
