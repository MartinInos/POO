package ar.edu.unlu.diezmil;

import java.util.ArrayList;

public interface PartidaObserver {
	
	public void notifyTiro(ArrayList<Dado> tiro);
	public void notifyPuntosTurno(int puntos);
	public void notifyJugadorAgregado(String name, int pos, boolean agregado);
	public void notifyGuardarPuntaje(int turnoActual, int puntosJugador);
	public void notifyTurno(String nombre);
	public void notifyGanador(Jugador jugador);
	public void notifyReset(int cantJ);
	public void notifyAddJugador(boolean masDeDos);
	
}
