package ar.edu.unlu.diezmil.vista;

import java.util.ArrayList;

import ar.edu.unlu.diezmil.Controller;
import ar.edu.unlu.diezmil.Dado;
import ar.edu.unlu.diezmil.PartidaObserver;

public class Consola implements PartidaObserver {
	
	private Controller c;
	
	public Consola(Controller controlador) {
		c = controlador;
		
	}
	
	
	
	
	
// Metodos del observer	
	
	@Override
	public void notifyCantJugadores(int cJugadores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyTiro(ArrayList<Dado> tiro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyPuntosTurno(int puntos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyJugadorAgregado(String name, int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyGuardarPuntaje(int turnoActual, int puntosJugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyTurno(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyGanador(int puntos, String nombre) {
		// TODO Auto-generated method stub
		
	}
	
	

}
