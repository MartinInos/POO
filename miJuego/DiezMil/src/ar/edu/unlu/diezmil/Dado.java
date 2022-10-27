package ar.edu.unlu.diezmil;

import java.util.ArrayList;
import java.util.Random;

import ar.edu.unlu.diezmil.vista.VentanaPrincipal;

public class Dado {

	private CaraDado cara;
	private boolean caraFija;
	
	public Dado() {
		this.cara = cara.NULL;
	    this.caraFija = false;
	}
	public void arrojarse() {
		if (!this.caraFija) {
			Random random = new Random();
			int index = random.nextInt(6 + 1) + 1 ;
			cara = cara.valueAt(index);
		}
	}
	public CaraDado getCara() {
		return this.cara;
	}
	public void fijarCara() {
		this.caraFija = true;			
	}
	public boolean isCaraFija() {
		return this.caraFija;
	}
	public void desFijar() {
		this.caraFija = false;	
	}
}
