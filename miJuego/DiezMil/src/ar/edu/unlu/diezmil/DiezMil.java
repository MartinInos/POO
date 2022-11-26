package ar.edu.unlu.diezmil;

import java.awt.EventQueue;

import ar.edu.unlu.diezmil.vista.Consola;
import ar.edu.unlu.diezmil.vista.VentanaPrincipal;

public class DiezMil {
	
	

	public static void main(String[] args) {
		Partida juego = new Partida();
		Controller controlador = new Controller(juego);	
		VentanaPrincipal v1 = new VentanaPrincipal(controlador);
		Consola c1 = new Consola(controlador);
		juego.addObserver(v1);
	}
}
