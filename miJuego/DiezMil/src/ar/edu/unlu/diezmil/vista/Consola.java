package ar.edu.unlu.diezmil.vista;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ar.edu.unlu.diezmil.Controller;
import ar.edu.unlu.diezmil.Dado;
import ar.edu.unlu.diezmil.Jugador;
import ar.edu.unlu.diezmil.PartidaObserver;

public class Consola implements PartidaObserver {
	
	private Controller c;
	
	public Consola(Controller controlador) {
		c = controlador;
	}
	public void inicializar() {
		
	}	
// Metodos del observer	
	@Override
	public void notifyTiro(ArrayList<Dado> tiro) {
		System.out.println();
		for (int i = 0; i<tiro.size(); i++) {
			if (tiro.get(i).isCaraFija()) {
				System.out.print("["+tiro.get(i).getCara()+",X]");
			}else {
				System.out.print("["+tiro.get(i).getCara()+"_]");
			}
			System.out.println();	
		}
	}
	@Override
	public void notifyPuntosTurno(int puntos) {
		if (puntos == 0) {
			System.out.println("Has Perdido el Puntaje Acumulado");
			c.terminarTurno(false);
		}else {	
			System.out.println("Puntaje Acumulado : "+puntos);
		}
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
	public void notifyGanador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyReset(int cantJ) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyJugadorAgregado(String name, int pos, boolean agregado) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyAddJugador(boolean masDeDos) {
		Scanner sc = new Scanner(System.in);
		if (masDeDos) {
				System.out.println("Agregar Otro Jugador? (s/n)");
				String input  = sc.next();
			    if (input.equals("s")) {
			    	System.out.println("Enter Name");
			    	sc = new Scanner(System.in);
			    	c.addJugador(sc.next());
			    }	
		}else{
			System.out.println("Enter Name");
	    	sc = new Scanner(System.in);
	    	c.addJugador(sc.next());
		}
		
	}
	
	

}
