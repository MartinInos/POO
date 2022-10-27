package ar.edu.unlu.diezmil;

import java.util.ArrayList;

public interface PartidaObserver {
	
	public void notifyCantJugadores(int cJugadores);
	public void notifyTiro(ArrayList<Dado> tiro);
	public void notifyPuntosTurno(int puntos);
	public void notifyJugadorAgregado(String name, int pos);
	public void notifyGuardarPuntaje(int turnoActual, int puntosJugador);
	public void notifyTurno(String nombre);
	public void notifyGanador(int puntos, String nombre);
	public void notifyGanador(Jugador jugador);
	


}
