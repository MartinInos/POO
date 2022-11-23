package ar.edu.unlu.diezmil;

import java.util.ArrayList;

public class Jugador  {
	
	private String nombre;
	private int puntaje;

	public Jugador(String nombreJugador) {
		this.nombre = nombreJugador;
		this.puntaje = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public int getPuntaje() {
		return puntaje;
	}
	//
	public void sumarPuntos(int nuevosPuntos) {
		if (nuevosPuntos == 10000) {
			this.puntaje = nuevosPuntos;		
		}else {
			this.puntaje+=nuevosPuntos;
		}
	}

	public void resetPuntaje() {
		this.puntaje = 0;
	}
}
	
